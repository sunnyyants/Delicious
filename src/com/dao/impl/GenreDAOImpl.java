package com.dao.impl;

import com.dao.GenreDAO;
import com.models.Genre;
import com.util.HibernateUtil;
import org.hibernate.Query;
import java.util.List;

/**
 * Created by Sunny on 4/17/14.
 */
public class GenreDAOImpl implements GenreDAO{
    @Override
    public void createGenre(Genre genre) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            session.save(genre);
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
    public void deleteGenre(Integer GenreId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            Genre genre = (Genre) session.get(Genre.class, GenreId);
            session.delete(genre);
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
    public List<Genre> listOfGenre() {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        List<Genre> listOfGenre = null;

        try {
            String hql = "From Genre genre order by genre.id";
            Query query = session.createQuery(hql);
            listOfGenre = query.list();
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return listOfGenre;
    }

    @Override
    public Genre GenreById(Integer GenreId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        Genre genre = null;
        try {
            genre = (Genre) session.get(Genre.class, GenreId);
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return genre;
    }

}
