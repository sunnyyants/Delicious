package com.dao.impl;

import com.dao.ManagerDAO;
import com.models.Manager;
import com.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.util.List;


/**
 * Created by Sunny on 4/16/14.
 */
public class ManagerDAOImpl implements ManagerDAO {

    @Override
    public Integer saveManager(Manager manager) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        Integer managerId = 0;
        try {
            session.save(manager);
//            session.flush();
            tx.commit();
            managerId = manager.getId();
        } catch (HibernateException e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return managerId;
    }

    @Override
    public Manager findManager(Integer managerId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Manager manager = null;
        try {
            manager = (Manager) session.get(Manager.class, managerId);
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();

        } finally {
            HibernateUtil.closeSession(session);
        }
        return manager;
    }

    @Override
    public List<Manager> findAllManager() {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        List<Manager> list = null;
        try {
            String hql = "from Manager as manager order by manager.id";
            Query query = session.createQuery(hql);
            list = query.list();
            tx.commit();
        } catch (Exception e) {
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return list;    }

    @Override
    public Integer loginValidated(String managerName, String passWord) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        List<Manager> list = null;
//        boolean res = true;
        Integer res = Integer.MIN_VALUE;
        try {
            String hql = "select manager from Manager as manager where manager.username = ? and manager.password = ?";
            Query query = session.createQuery(hql);
            query.setString(0,managerName);
            query.setString(1,passWord);
            list = query.list();
            if(list == null || list.size() == 0){
                res = Integer.MIN_VALUE;
            }
            else {
                Manager manager = list.get(0);
                res = manager.getId();
            }
            tx.commit();
        } catch (Exception e) {
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return res;
    }

    @Override
    public void updateManagerInfo(Integer managerId, String firstName, String lastName, String address, String zipcode, String phone, String email) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            Manager manager = (Manager) session.get(Manager.class, managerId);
            if(firstName != null && firstName.trim().length() != 0){
                manager.setFirstname(firstName);
            }else{
                manager.setFirstname(manager.getFirstname());
            }
            if(lastName != null && lastName.trim().length() != 0){
                manager.setLastname(lastName);
            }else{
                manager.setLastname(manager.getLastname());
            }
            if(address != null && address.trim().length() != 0){
                manager.setAddress(address);
            }else{
                manager.setAddress(manager.getAddress());
            }
            if(zipcode != null && zipcode.trim().length() != 0){
                manager.setZipcode(zipcode);
            }else{
                manager.setZipcode(manager.getZipcode());
            }
            if(phone != null && phone.trim().length() != 0){
                manager.setPhone(phone);
            }else{
                manager.setPhone(manager.getPhone());
            }
            if(email != null && email.trim().length() != 0){
                manager.setEmail(email);
            }else{
                manager.setEmail(manager.getEmail());
            }
            session.update(manager);
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
    public void deleteManager(Integer managerId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            Manager manager = (Manager) session.get(Manager.class, managerId);
            session.delete(manager);
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
    public void updateManagerPassword(Integer managerId, String password) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            Manager manager = (Manager) session.get(Manager.class, managerId);
            manager.setPassword(password);
            session.update(manager);
            tx.commit();
        } catch (Exception e) {
            if(tx != null)
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }
}
