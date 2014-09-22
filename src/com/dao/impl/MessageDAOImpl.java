package com.dao.impl;

import com.dao.MessageDAO;
import com.models.Message;
import com.models.User;
import com.util.HibernateUtil;
import org.hibernate.Query;


import java.util.List;

/**
 * Created by Sunny on 4/24/14.
 */
public class MessageDAOImpl implements MessageDAO {
    @Override
    public void createMesage(Integer userId,Message message) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            User user = (User) session.get(User.class, userId);
            message.setUserLeftMessage(user);
            session.persist(message);
            user.getMessages().add(message);
            session.update(user);
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
    public List<Message> findAllMessage() {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        List<Message> messages = null;

        try {
            String hql = "From Message m order by m.dateOfCreated desc ,m.status Asc";
            Query query = session.createQuery(hql);
            messages = query.list();
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return messages;
    }

    @Override
    public void updateMesaageStatus(int messageId, String status) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            Message message = (Message) session.get(Message.class, messageId);
            message.setStatus(status);
            session.update(message);
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
    public Long unreadMessage() {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        List res = null;
        Long num = (long)0;
        try {
            String hql = "Select count(m.id) from Message m where m.status=:status";
            Query query = session.createQuery(hql);
            query.setString("status", "Unread");
            res = query.list();
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if(res != null && !res.isEmpty() && res.get(0)!=null){
                num = (Long) res.get(0);
            }
        }
        return num;
    }
}
