package com.dao.impl;

import com.dao.MenuDAO;
import com.models.Genre;
import com.models.Menu;
import com.sun.tools.javac.jvm.Gen;
import com.util.HibernateUtil;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Sunny on 4/12/14.
 */
public class MenuDAOImpl implements MenuDAO{

    @Override
    public void saveMenu(Integer GenreId, Menu menu) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            Genre genre = (Genre) session.get(Genre.class, GenreId);
            menu.setGenre(genre);
            session.persist(menu);
            genre.getMenuSet().add(menu);
            session.update(genre);
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
    public Menu findFood(Integer MenuId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Menu menu = null;

        try {
            menu = (Menu) session.get(Menu.class, MenuId);
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return menu;
    }

    @Override
    public List<Menu> findAllfoods() {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        List<Menu> listOfFoods = null;
        try {
            String hql = "FROM Menu as menu order by menu.id";
            Query query = session.createQuery(hql);
            listOfFoods = query.list();
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return listOfFoods;
    }

    @Override
    public void updateMenuInfo(Integer menuId, Integer genreId, String name, String imageURL, String description, Float price) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            Menu menu = (Menu) session.get(Menu.class, menuId);
            if(name != null && name.trim().length() != 0){
                menu.setName(name);
            }else{
                menu.setName(menu.getName());
            }
            if(imageURL != null && imageURL.trim().length() != 0){
                menu.setImageURL(imageURL);
            }else{
                menu.setImageURL(menu.getImageURL());
            }
            if(description != null && description.trim().length() != 0){
                menu.setDescription(description);
            }else{
                menu.setDescription(menu.getDescription());
            }
            if(price != null && price > 0){
                menu.setPrice(price);
            }else{
                menu.setPrice(menu.getPrice());
            }
            if(genreId != null){
                Genre genre = (Genre) session.get(Genre.class, genreId);
                menu.setGenre(genre);
                session.persist(menu);
                genre.getMenuSet().add(menu);
                session.update(genre);
            }else{
                session.update(menu);
            }
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
    public void deleteFood(Integer menuId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            Menu menu = (Menu) session.get(Menu.class, menuId);
            session.delete(menu);
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
    public void updateAverage(Integer menuId, Float average) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            Menu menu = (Menu) session.get(Menu.class, menuId);
            menu.setAverage(average);
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
    public List<Menu> findFoodsByGenre(Integer genreId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        List<Menu> listOfMenu = null;

        try {
            String hql = "From Menu menu where menu.genre.id=:genreId";
            Query query = session.createQuery(hql);
            query.setInteger("genreId",genreId);
            listOfMenu = query.list();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return listOfMenu;
    }

    @Override
    public List<Menu> findThreeFoodsWithoutScore() {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        List<Menu> listOfMenu = null;

        try {
            String hql = "From Menu menu where menu.average>=:score order by menu.average asc";
            Query query = session.createQuery(hql);
            query.setFloat("score", ((float)(0.1)));
            query.setMaxResults(3);
            listOfMenu = query.list();
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return listOfMenu;
    }
}
