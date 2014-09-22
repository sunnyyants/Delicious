package com.dao.impl;

import com.dao.LineItemDAO;
import com.models.LineItem;
import com.models.Menu;
import com.models.Order;
import com.util.HibernateUtil;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Sunny on 4/17/14.
 */
public class LineItemDAOImpl implements LineItemDAO {

    @Override
    public void createLineItem(Integer orderId, Integer menuId, LineItem lineItem) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            Order order = (Order) session.get(Order.class, orderId);
            Menu menu = (Menu) session.get(Menu.class, menuId);
            lineItem.setMenu(menu);
            lineItem.setOrder(order);
            session.persist(lineItem);
            order.getLineItems().add(lineItem);
            session.update(order);
            menu.getLineItems().add(lineItem);
            session.update(menu);
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
    public void updateLineItemQuantity(Integer lineItemId, Integer quantity) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            LineItem lineItem = (LineItem) session.get(LineItem.class, lineItemId);
            lineItem.setQuantity(quantity);
            session.update(lineItem);
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
    public void deleteLineItem(Integer lineItemId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            LineItem item = (LineItem) session.get(LineItem.class, lineItemId);
            session.delete(item);
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
    public List<LineItem> findAllOrderByOrder(Integer orderId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        List<LineItem> lineItems = null;

        try {
            String hql = "From LineItem li where li.order.id=:orderId";
            Query query = session.createQuery(hql);
            query.setInteger("orderId", orderId);
            lineItems = query.list();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return lineItems;
    }
}
