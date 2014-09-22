package com.dao.impl;

import com.dao.LikesDAO;
import com.models.Likes;
import com.models.Menu;
import com.models.User;
import com.util.HibernateUtil;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Sunny on 4/16/14.
 */
public class LikesDAOImpl implements LikesDAO {

    @Override
    public void createLike(Integer userId, Integer menuId, Likes like) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            User user = (User) session.get(User.class, userId);
            Menu menu = (Menu) session.get(Menu.class, menuId);

            like.setUserLike(user);
            like.setLikedMenu(menu);
            session.persist(like);
            user.getLikes().add(like);
            session.update(user);
            menu.getLikes().add(like);
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
    public void updateLike(Integer likesId, Integer score) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            Likes likes = (Likes) session.get(Likes.class,likesId);
            likes.setScore(score);
            session.update(likes);
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
    public Likes findLike(Integer userId, Integer menuId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        List<Likes> like = null;
        String hql = "From Likes l where l.userLike=:userId and l.likedMenu=:menuId";
        Query query = session.createQuery(hql);
        query.setInteger("userId",userId);
        query.setInteger("menuId",menuId);
        like = query.list();
        if(like.size()>0){
           Likes l = like.get(0);
            return l;
        }
        return null;
    }

    @Override
    public List getAllAverageScore() {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        List listOfAverage = null;

        String hql = "Select new list (l.likedMenu, avg(l.score) as average) from Likes l group by l.likedMenu";

        Query query = session.createQuery(hql);
        listOfAverage = query.list();

        return listOfAverage;
    }

    @Override
    public List getTotalScore() {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        List listOfTotalScores = null;
        String hql = "Select l.likedMenu " +
                "from Likes l group by l.likedMenu order by sum(l.score) desc";
        Query query = session.createQuery(hql);
        query.setMaxResults(3);
        listOfTotalScores = query.list();
        return listOfTotalScores;
    }
}
