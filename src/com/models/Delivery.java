package com.models;

/**
 * Created by Sunny on 4/24/14.
 */
public class Delivery {
    private int id;
    private Order orderNeedForDelivery;
    private User userNeedForDelivery;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderNeedForDelivery(Order orderNeedForDelivery) {
        this.orderNeedForDelivery = orderNeedForDelivery;
    }

    public Order getOrderNeedForDelivery() {
        return orderNeedForDelivery;
    }

    public void setUserNeedForDelivery(User userNeedForDelivery) {
        this.userNeedForDelivery = userNeedForDelivery;
    }

    public User getUserNeedForDelivery() {
        return userNeedForDelivery;
    }
}
