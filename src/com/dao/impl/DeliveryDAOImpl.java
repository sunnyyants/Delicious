package com.dao.impl;

import com.dao.DeliveryDAO;
import com.models.Delivery;
import com.util.HibernateUtil;
import org.hibernate.Query;
import java.util.*;

/**
 * Created by lanshan on 4/24/14.
 */
public class DeliveryDAOImpl implements DeliveryDAO {
    @Override
    public void createDelivery(Delivery delivery) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            session.save(delivery);
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
    public void deleteDelivery(Integer DeliveryId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            Delivery delivery = (Delivery) session.get(Delivery.class, DeliveryId);
            session.delete(delivery);
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
    public List<Delivery> listOfDelivery() {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        List<Delivery> listOfDelivery = null;

        try {
            String hql = "From Delivery delivery order by delivery.id";
            Query query = session.createQuery(hql);
            listOfDelivery = query.list();
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return listOfDelivery;
    }

    @Override
    public Delivery DeliveryById(Integer DeliveryId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        Delivery delivery = null;
        try {
            delivery = (Delivery) session.get(Delivery.class, DeliveryId);
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return delivery;
    }

    @Override
    public Long CountDeliveries() {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        Long res = (long)0;
        List<Long> temp = null;

        try {
            String hql = "Select count(delivery.id) From Delivery delivery inner join delivery.orderNeedForDelivery orders where " +
                    "delivery.orderNeedForDelivery.id = orders.id and orders.status !=:status";
            Query query = session.createQuery(hql);
            query.setString("status","Completed");
            temp = query.list();
            tx.commit();
        } catch (Exception e) {
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if(temp != null){
                res = temp.get(0);
            }
            HibernateUtil.closeSession(session);
        }
        return res;
    }
}
