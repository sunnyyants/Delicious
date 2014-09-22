package com.actions;

        import com.models.*;
        import com.opensymphony.xwork2.ActionContext;
        import com.opensymphony.xwork2.ActionSupport;
        import com.service.*;
        import com.service.impl.*;

        import java.sql.Date;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Map;

/**
 * Created by Sunny on 4/17/14.
 */
public class OrderAction extends ActionSupport {
    private Integer id;
    private Integer orderId;
    private Date dateOfOrder;
    private String status;
    private Integer userId;
    private Float total;
    private List<Float> subTotals;
    private List<Menu> listOfMenus;
    private List<Integer> quantities;
    private List<Order> orders;
    private List<User> users;
    private boolean deliver;

    // important mark
    private Integer menuId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public String getStatus() {
        System.out.println(this.status);
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        System.out.println(this.status);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public void setSubTotals(List<Float> subTotals) {
        this.subTotals = subTotals;
    }

    public List<Float> getSubTotals() {
        return subTotals;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }

    public List<Menu> getListOfMenus() {
        return listOfMenus;
    }

    public void setListOfMenus(List<Menu> listOfMenus) {
        this.listOfMenus = listOfMenus;
    }


    public void setQuantities(List<Integer> quantities) {
        this.quantities = quantities;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setDeliver(boolean deliver) {
        this.deliver = deliver;
    }

    public boolean isDeliver() {
        return deliver;
    }

    public String createOrder(){
        OrdersService ordersService = new OrdersServiceImpl();
        Map map = ActionContext.getContext().getSession();
        if(!map.containsKey("orderId")){
            Order order = new Order();
            order.setStatus("Unfinished");
            Date regeisterDate = new Date(new java.util.Date().getTime());
            order.setDateOfOrder(regeisterDate);
            this.userId = (Integer) ActionContext.getContext().getSession().get("userId");
            order.setTotal((float)0);
            Integer orderId = ordersService.createOrder(this.userId,order);
            ActionContext.getContext().getSession().put("orderId", orderId);
        }
        //TODO double check here...
        ActionContext.getContext().getSession().put("menuId", menuId);
        return SUCCESS;
    }

    public String deleteOrder(){
        OrdersService ordersService = new OrdersServiceImpl();
        Map map = ActionContext.getContext().getSession();
        if(map.containsKey("orderId")){
            this.id = (Integer) map.get("orderId");
            map.remove("orderId");
        }
        ordersService.deleteOrder(this.id);
        return SUCCESS;
    }

    public String checkOut(){
        Map map = ActionContext.getContext().getSession();
        LineItemService lineItemService = new LineItemServiceImpl();
        UserService userService = new UserServiceImpl();
        MenuService menuService = new MenuServiceImpl();
        OrdersService ordersService = new OrdersServiceImpl();
        DeliveryService deliveryService = new DeliveryServiceImpl();
        Integer orderId = (Integer) map.get("orderId");
        System.out.println("order" + orderId);
        List<LineItem> items = lineItemService.findAllOrderByOrder(orderId);
        List<Integer> q = new ArrayList<Integer>();
        List<Menu> menus = new ArrayList<Menu>();
        List<Float> temp = new ArrayList<Float>();
        float total = 0;
        for(int i = 0; i < items.size(); i++){
            Integer quantity = items.get(i).getQuantity();
            LineItem lineItem = items.get(i);
            Menu menu = menuService.findMenu(lineItem.getMenu().getId());
            Float price = menu.getPrice();
            if(price == null){
                price = (float)0;
            }
            Float subTotal = (float)(quantity * price);
            temp.add(subTotal);
            total += subTotal;
            menus.add(menu);
            q.add(lineItem.getQuantity());
        }

        if(this.deliver){
            Integer userId = (Integer)map.get("userId");
            User user = userService.findUser(userId);
            Order order = ordersService.findOrders(orderId);
            Delivery delivery = new Delivery();
            delivery.setUserNeedForDelivery(user);
            delivery.setOrderNeedForDelivery(order);
            deliveryService.createDelivery(delivery);
            map.put("delivery", "true");
        }
        else
            map.put("delivery", "false");
        this.subTotals = temp;
        this.total = total;
        this.quantities = q;
        this.listOfMenus = menus;
        ordersService.updateOrderTotal(orderId,total);
        ordersService.updateOrderStatus(orderId,"Pending");
        if(map.containsKey("orderId")){
            map.remove("orderId");
        }
        return SUCCESS;
    }

    public String ManagerCheckOrders(){
        OrdersService ordersService = new OrdersServiceImpl();
        UserService userService = new UserServiceImpl();
        this.orders = ordersService.findAllOrdersByDate();
        List<User> listOfUser = new ArrayList<User>();
        for(int i = 0; i < this.orders.size(); i++){
            Order order = this.orders.get(i);
            User user = userService.findUser(order.getUserOfOrder().getId());
            listOfUser.add(user);
        }
        this.users = listOfUser;
        return SUCCESS;
    }

    public String UserCheckOrders(){
        OrdersService ordersService = new OrdersServiceImpl();
        Map map = ActionContext.getContext().getSession();
        Integer userId = (Integer) map.get("userId");
        this.orders = ordersService.findAllOrdersByUserId(userId);
        return SUCCESS;
    }

    public String updateOrderStatus(){
        OrdersService ordersService = new OrdersServiceImpl();
        ordersService.updateOrderStatus(this.orderId, this.status);
        return SUCCESS;
    }

    public String controlPannelPreload(){
        OrdersService ordersService = new OrdersServiceImpl();
        MessageService messageService = new MessageServiceImpl();
        ReservationDateService reservationDateService = new ReservationDateServiceImpl();
        ReservationService reservationService = new ReservationServiceImpl();
        DeliveryService deliveryService = new DeliveryServiceImpl();
        Map map = ActionContext.getContext().getSession();
        Double totalIncome = ordersService.CountTotalIncome();
        Long numberOfPending = ordersService.CountOrdersStatus("Pending");
        Long numberOfRFP = ordersService.CountOrdersStatus("Ready for pick up");
        Long numberOfTodayOrder = ordersService.CountTodaysNewOrder();
        Long numberOfUnreadMessage = messageService.unreadMessage();
        Long numberOfReservation = reservationService.countReservation(1);
        Long numberOfDeliveries = deliveryService.countDeliveries();
        map.put("numberOfPending",numberOfPending);
        map.put("numberOfRFP",numberOfRFP);
        map.put("totalIncome",totalIncome);
        map.put("numberOfTodayOrder",numberOfTodayOrder);
        map.put("numberOfUnreadMessages",numberOfUnreadMessage);
        map.put("numberOfTotalReservations",numberOfReservation);
        map.put("numberOfDeliveries",numberOfDeliveries);
        int OldRd = reservationDateService.findOldReservationDateId();
        if(OldRd != 0){
            reservationDateService.deleteReservationDate(OldRd);
            ReservationDate newReservationDate = new ReservationDate();
            newReservationDate.setMaximumReservations(5);
            newReservationDate.setReservationDate(new Date(new java.util.Date().getTime()));
            reservationDateService.createReservationDate(newReservationDate);
        }

        return SUCCESS;
    }

    public String managerDeleteOrder(){
        OrdersService ordersService = new OrdersServiceImpl();
        System.out.println(this.id);
        ordersService.deleteOrder(this.id);
        return SUCCESS;
    }
}
