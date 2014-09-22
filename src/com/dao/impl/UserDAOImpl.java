package com.dao.impl;

import com.dao.UserDAO;
import com.models.User;
import com.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Sunny on 4/4/14.
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public Integer saveUser(User user) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Integer userId = -1;
        try {
            session.save(user);
            tx.commit();
            userId = user.getId();
        } catch (HibernateException e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();

        } finally {
            HibernateUtil.closeSession(session);
        }
        return userId;
    }

    @Override
    public User findUser(Integer userId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        User user = null;
        try {
            user = (User) session.get(User.class, userId);
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();

        } finally {
            HibernateUtil.closeSession(session);
        }
        return user;
    }


    @Override
    public List<User> findAllUsers() {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        List<User> list = null;
        try {
            String hql = "from User as user order by user.id";
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
        return list;
    }

    @Override
    public Integer loginValidated(String userName, String passWord) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        List<User> list = null;
        Integer res = Integer.MIN_VALUE;
        try {
            String hql = "select user from User as user where user.username = ? and user.password = ?";
            Query query = session.createQuery(hql);
            query.setString(0,userName);
            query.setString(1,passWord);
            list = query.list();
            if(list == null || list.size() == 0)res = Integer.MIN_VALUE;
            else {
                User user = list.get(0);
                res = user.getId();
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
    public void updateUserInfo(Integer userId,  String firstName, String lastName,
                               String address, String zipcode, String phone, String email) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            User user = (User) session.get(User.class, userId);
            if(firstName != null && firstName.trim().length() != 0){
                user.setFirstname(firstName);
            }else{
                user.setFirstname(user.getFirstname());
            }
            if(lastName != null && lastName.trim().length() != 0){
                user.setLastname(lastName);
            }else{
                user.setLastname(user.getLastname());
            }
            if(address != null && address.trim().length() != 0){
                user.setAddress(address);
            }else{
                user.setAddress(user.getAddress());
            }
            if(zipcode != null && zipcode.trim().length() != 0){
                user.setZipcode(zipcode);
            }else{
                user.setZipcode(user.getZipcode());
            }
            if(phone != null && phone.trim().length() != 0){
                user.setPhone(phone);
            }else{
                user.setPhone(user.getPhone());
            }
            if(email != null && email.trim().length() != 0){
                user.setEmail(email);
            }else{
                user.setEmail(user.getEmail());
            }
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
    public void deleteUser(Integer userId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            User user = (User) session.get(User.class, userId);
            session.delete(user);
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
    public void updateUserPassword(Integer userId, String password) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            User user = (User) session.get(User.class, userId);
            user.setPassword(password);
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
    public boolean containUserName(String username) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        boolean res = true;
        List temp = null;
        try {
            String hql = "From User user where user.username=:username";
            Query query = session.createQuery(hql);
            query.setString("username",username);
            temp = query.list();
            tx.commit();
        } catch (Exception e) {
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if(temp == null || temp.size() == 0 || temp.get(0) == null){
                res = false;
            }
            HibernateUtil.closeSession(session);
        }
        return res;
    }
}
