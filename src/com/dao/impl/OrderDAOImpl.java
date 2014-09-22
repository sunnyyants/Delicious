package com.dao.impl;

import com.dao.OrderDAO;
import com.models.Order;
import com.models.User;
import com.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Sunny on 4/14/14.
 */
public class OrderDAOImpl implements OrderDAO {


    @Override
    public Integer createOrder(Integer userId, Order order) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Integer orderId = 0;
        try {
            User user = (User) session.get(User.class, userId);
            order.setUserOfOrder(user);
            session.persist(order);
            user.getOrders().add(order);
            session.update(user);
            tx.commit();
            orderId = order.getId();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return orderId;
    }

    @Override
    public void deleteOrder(Integer orderId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            Order order = (Order) session.get(Order.class, orderId);
            session.delete(order);
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }

    @Override
    public void updateOrder(Integer orderId, Order order) {
    }

    @Override
    public void updateOrderStatus(Integer orderId, String status) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            Order order = (Order) session.get(Order.class, orderId);
            order.setStatus(status);
            session.update(order);
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }

    @Override
    public List<Order> findAllOrders() {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        List<Order> orders = null;

        try {
            String hql = "From Order orders where orders.status!=:status order by orders.id";
            Query query = session.createQuery(hql);
            query.setString("status","Unfinished");
            orders = query.list();
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return orders;
    }

    @Override
    public void updateOrdersTotal(Integer orderId, Float total) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            Order order = (Order) session.get(Order.class, orderId);
            order.setTotal(total);
            session.update(order);
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }

    @Override
    public List<Order> findAllOrdersByUserId(Integer userId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        List<Order> orders = null;
        try {
            String hql = "From Order orders where orders.userOrdered.id=:userId";
            Query query = session.createQuery(hql);
            query.setInteger("userId",userId);
            orders = query.list();
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return orders;
    }

    @Override
    public List<Order> findAllOrdersByDate() {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        List<Order> orders = null;
        try {
            String hql = "From Order orders Where orders.status!=:status order by" +
                    " orders.dateOfOrder desc, orders.status ASC ";
            Query query = session.createQuery(hql);
            query.setString("status","Unfinished");
            orders = query.list();
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return orders;
    }

    @Override
    public Long CountOrdersStatus(String status) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        Long CountStatus = (long)0;
        List res = null;
        try {
            String hql = "Select count(orders.status) From Order orders where orders.status=:status";
            Query query = session.createQuery(hql);
            query.setString("status", status);
            res = query.list();
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if(res != null && !res.isEmpty()){
                CountStatus = (Long) res.get(0);
            }
            HibernateUtil.closeSession(session);
        }
        return CountStatus;
    }

    @Override
    public Double CountTotalIncome() {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        Double totalIncome = (double)0;
        List res = null;
        try {
            String hql = "Select sum(orders.total) from Order orders where orders.status=:status";
            Query query = session.createQuery(hql);
            query.setString("status","Completed");
            res = query.list();
            tx.commit();
        } catch (Exception e) {
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if(res != null && !res.isEmpty() && res.get(0)!=null){
                double totals = (Double)res.get(0);
                totals = ((int)(totals * 100))/(double)100;
                totalIncome = totals;
            }
            HibernateUtil.closeSession(session);
        }
        return totalIncome;
    }

    @Override
    public Long CountTodaysNewOrder() {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        Long numOfNewOrder = (long)0;
        List res = null;
        try {
            String hql = "SELECT count(orders.id) From Order orders where " +
                    "orders.status=:status and orders.dateOfOrder>:yesterday and " +
                    "orders.dateOfOrder<:tomorrow";
            Query query = session.createQuery(hql);
            query.setString("status","Pending");
            Date today = new Date(new java.util.Date().getTime());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(today);
            calendar.add(Calendar.DATE,1);
            Date tomorrow = new Date(calendar.getTime().getTime());
            calendar.setTime(today);
            calendar.add(Calendar.DATE,-1);
            Date yesterday = new Date(calendar.getTime().getTime());
            query.setParameter("yesterday",yesterday);
            query.setParameter("tomorrow",tomorrow);
            res = query.list();
            tx.commit();
            if(res != null && !res.isEmpty()){
                numOfNewOrder = (Long) res.get(0);
            }
        } catch (Exception e) {
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if(!res.isEmpty()){
                numOfNewOrder = (Long) res.get(0);
            }
            HibernateUtil.closeSession(session);
        }
        return numOfNewOrder;
    }

    @Override
    public Integer checkTheUnfinishedOrder(Integer userId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        Integer orderId = Integer.MIN_VALUE;
        List res = null;
        try {
            String hql = "Select orders.id from Order orders where " +
                    "orders.userOrdered.id=:userId and orders.status=:status";
            Query query = session.createQuery(hql);
            query.setInteger("userId", userId);
            query.setString("status","Unfinished");
            res = query.list();
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if(res != null && !res.isEmpty() && res.get(0)!=null){
                orderId = (Integer) res.get(0);
            }
            HibernateUtil.closeSession(session);
        }
        return orderId;
    }
    @Override
    public Order findOrder(Integer orderId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        Order order = null;
        try {
            order = (Order) session.get(Order.class, orderId);
            session.update(order);
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return order;
    }



}
