package com.actions;

import com.models.Delivery;
import com.models.Menu;
import com.models.Order;
import com.models.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.DeliveryService;
import com.service.MenuService;
import com.service.OrdersService;
import com.service.UserService;
import com.service.impl.DeliveryServiceImpl;
import com.service.impl.MenuServiceImpl;
import com.service.impl.OrdersServiceImpl;
import com.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Lanshan on 4/17/14.
 */
public class DeliveryAction extends ActionSupport {

    private Integer id;
    private Integer userId;
    private Integer orderId;
    private User user;
    private Order order;
    private List<Delivery> deliveries;
    private List<User> users;
    private List<Order> orders;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() { return userId; }

    public void setUserId(Integer user) { this.userId = user; }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String createDelivery(){
        DeliveryService deliveryService = new DeliveryServiceImpl();
        UserService userService = new UserServiceImpl();
        OrdersService ordersService = new OrdersServiceImpl();
        this.user = userService.findUser(this.userId);
        this.order = ordersService.findOrders(this.orderId);
        Delivery delivery = new Delivery();
        delivery.setUserNeedForDelivery(user);
        delivery.setOrderNeedForDelivery(order);
        deliveryService.createDelivery(delivery);
        return SUCCESS;
    }
    public String deleteDelivery(){
        DeliveryService deliveryService = new DeliveryServiceImpl();
        deliveryService.deleteDelivery(this.id);
        return SUCCESS;
    }

    public String findAllDeliveries(){
        DeliveryService deliveryService = new DeliveryServiceImpl();
        UserService userService = new UserServiceImpl();
        OrdersService ordersService = new OrdersServiceImpl();
        this.deliveries = deliveryService.listOfDelivery();
        List<User> us = new ArrayList<User>();
        List<Order> os = new ArrayList<Order>();
        for(Delivery d: deliveries){
            us.add(userService.findUser(d.getUserNeedForDelivery().getId()));
            os.add(ordersService.findOrders(d.getOrderNeedForDelivery().getId()));
        }
        this.users = us;
        this.orders = os;
        return SUCCESS;
    }

    public String preLoadAllDeliveries(){
        DeliveryService deliveryService = new DeliveryServiceImpl();
        this.deliveries = deliveryService.listOfDelivery();
        return SUCCESS;
    }


}


