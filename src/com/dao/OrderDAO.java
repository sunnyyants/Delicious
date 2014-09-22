package com.dao;

import com.models.Order;

import java.util.List;
import java.util.Map;

/**
 * Created by Sunny on 4/17/14.
 */
public interface OrderDAO {
    public Integer createOrder(Integer userId, Order order);

    public void deleteOrder(Integer orderId);

    public void updateOrder(Integer orderId, Order order);

    public void updateOrderStatus(Integer orderId, String status);

    public List<Order> findAllOrders();

    public void updateOrdersTotal(Integer orderId, Float total);

    public List<Order> findAllOrdersByUserId(Integer userId);

    public List<Order> findAllOrdersByDate();

    public Long CountOrdersStatus(String status);

    public Double CountTotalIncome();

    public Long CountTodaysNewOrder();

    public Integer checkTheUnfinishedOrder(Integer userId);

    public Order findOrder(Integer orderId);

}
