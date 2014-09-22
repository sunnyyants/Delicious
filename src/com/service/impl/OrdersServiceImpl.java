package com.service.impl;

import com.dao.OrderDAO;
import com.dao.impl.OrderDAOImpl;
import com.models.Order;
import com.service.OrdersService;

import java.util.List;
import java.util.Map;

/**
 * Created by Sunny on 4/14/14.
 */
public class OrdersServiceImpl implements OrdersService {


    @Override
    public Integer createOrder(Integer userId, Order order) {
        OrderDAO orderDAO = new OrderDAOImpl();
        return orderDAO.createOrder(userId, order);
    }

    @Override
    public void deleteOrder(Integer orderId) {
        OrderDAO orderDAO = new OrderDAOImpl();
        orderDAO.deleteOrder(orderId);
    }

    @Override
    public void updateOrder(Integer orderId, Order order) {
        OrderDAO orderDAO = new OrderDAOImpl();
        orderDAO.updateOrder(orderId, order);
    }

    @Override
    public void updateOrderStatus(Integer orderId, String status) {
        OrderDAO orderDAO = new OrderDAOImpl();
        orderDAO.updateOrderStatus(orderId, status);
    }

    @Override
    public List<Order> findAllOrders() {
        OrderDAO orderDAO = new OrderDAOImpl();
        List<Order> orders = orderDAO.findAllOrders();
        return orders;
    }

    @Override
    public void updateOrderTotal(Integer orderId, Float total) {
        OrderDAO orderDAO = new OrderDAOImpl();
        orderDAO.updateOrdersTotal(orderId, total);
    }

    @Override
    public List<Order> findAllOrdersByUserId(Integer userId) {
        OrderDAO orderDAO = new OrderDAOImpl();
        List<Order> orders = orderDAO.findAllOrdersByUserId(userId);
        return orders;
    }

    @Override
    public List<Order> findAllOrdersByDate() {
        OrderDAO orderDAO = new OrderDAOImpl();
        List<Order> orders = orderDAO.findAllOrdersByDate();
        return orders;
    }

    @Override
    public Long CountOrdersStatus(String status) {
        OrderDAO orderDAO = new OrderDAOImpl();
        Long statusNum = orderDAO.CountOrdersStatus(status);
        return statusNum;
    }

    @Override
    public Double CountTotalIncome() {
        OrderDAO orderDAO = new OrderDAOImpl();
        Double totalIncome = orderDAO.CountTotalIncome();
        return totalIncome;
    }

    @Override
    public Long CountTodaysNewOrder() {
        OrderDAO orderDAO = new OrderDAOImpl();
        Long numNewOrder = orderDAO.CountTodaysNewOrder();
        return numNewOrder;
    }

    @Override
    public Integer checkTheUnfinishedOrder(Integer userId) {
        OrderDAO orderDAO = new OrderDAOImpl();
        Integer hasOrder = orderDAO.checkTheUnfinishedOrder(userId);
        return hasOrder;
    }
    @Override
    public Order findOrders(Integer orderId) {
        OrderDAO orderDAO = new OrderDAOImpl();
        Order order = orderDAO.findOrder(orderId);
        return order;
    }
}
