package com.models;

import java.sql.Date;
import java.util.Set;

/**
 * Created by Sunny on 4/15/14.
 */

public class Order {

    private Integer id;
    private Date dateOfOrder;
    private String status;
    private Float total;
    private Set<LineItem> lineItems;
    private Set<Delivery> deliveries;

    private User userOrdered;

    public Order(){};

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public User getUserOrdered() {
        return userOrdered;
    }

    public void setUserOrdered(User userOrdered) {
        this.userOrdered = userOrdered;
    }

    public User getUserOfOrder() {
        return userOrdered;
    }

    public void setUserOfOrder(User userOrdered) {
        this.userOrdered = userOrdered;
    }

    public Set<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(Set<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getTotal() {
        return total;
    }

    public Set<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(Set<Delivery> deliveries) {
        this.deliveries = deliveries;
    }
}
