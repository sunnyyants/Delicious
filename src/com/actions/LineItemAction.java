package com.actions;

import com.models.LineItem;
import com.models.Menu;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.LineItemService;
import com.service.MenuService;
import com.service.impl.LineItemServiceImpl;
import com.service.impl.MenuServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sunny on 4/18/14.
 */
public class LineItemAction extends ActionSupport {
    private Integer id;
    private Integer quantity;
    private Integer orderId;
    private Integer menuId;
    private List<Menu> listOfMenus;
    private List<Integer> quantities;
    private List<Integer> itemIds;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }



    public void setListOfMenus(List<Menu> listOfMenus) {
        this.listOfMenus = listOfMenus;
    }

    public List<Menu> getListOfMenus() {
        return listOfMenus;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<Integer> quantities) {
        this.quantities = quantities;
    }

    public void setItemIds(List<Integer> itemIds) {
        this.itemIds = itemIds;
    }

    public List<Integer> getItemIds() {
        return itemIds;
    }

    public String findAllItems(){
        LineItemService lineItemService = new LineItemServiceImpl();
        MenuService menuService = new MenuServiceImpl();
        Integer orderId = (Integer) ActionContext.getContext().getSession().get("orderId");
        List<LineItem> items = lineItemService.findAllOrderByOrder(orderId);
        List<Integer> q = new ArrayList<Integer>();
        List<Menu> menus = new ArrayList<Menu>();
        List<Integer> Ids = new ArrayList<Integer>();
        for(int i = 0; i < items.size(); i++){
            LineItem lineItem = items.get(i);
            Menu menu = menuService.findMenu(lineItem.getMenu().getId());
            menus.add(menu);
            q.add(lineItem.getQuantity());
            Ids.add(lineItem.getId());
//            System.out.println(lineItem.getQuantity());
        }
        this.itemIds = Ids;
        this.quantities = q;
        this.listOfMenus = menus;
        return SUCCESS;
    }

    public String updateItemQuantity(){
        LineItemService lineItemService = new LineItemServiceImpl();
        lineItemService.updateItemQuantitiy(this.id,this.quantity);
        return SUCCESS;
    }

    public String deleteItem(){
        LineItemService lineItemService = new LineItemServiceImpl();
        lineItemService.deleteItem(this.id);
        return SUCCESS;
    }

}
