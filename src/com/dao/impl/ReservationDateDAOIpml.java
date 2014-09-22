package com.dao.impl;

import com.dao.ReservationDateDAO;
import com.models.ReservationDate;
import com.util.HibernateUtil;
import org.hibernate.Query;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Sunny on 4/24/14.
 */
public class ReservationDateDAOIpml implements ReservationDateDAO {
    @Override
    public void createReservationDate(ReservationDate reservationDate) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            session.save(reservationDate);
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
    public void updateReservationNumber(int reservationDateId, int maxNum) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            ReservationDate reservationDate = (ReservationDate) session.get(ReservationDate.class, reservationDateId);
            reservationDate.setMaximumReservations(maxNum);
            session.update(reservationDate);
            tx.commit();
        } catch (Exception e) {
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }

    @Override
    public void deleteReservationDate(int reservationDateId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            ReservationDate reservationDate = (ReservationDate) session.get(ReservationDate.class, reservationDateId);
            session.delete(reservationDate);
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
    public int findTodayReservationDateIdBy() {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        List res = null;
        int num = 0;
        try {
            String hql = "select r.id from ReservationDate r where r.reservationDate<:tomorrow and r.reservationDate>:yesterday";
            Query query = session.createQuery(hql);
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
        } catch (Exception e) {
            if(tx != null){
                if(tx!=null){
                    tx.rollback();
                }
            }
            e.printStackTrace();
        } finally {
            if(res != null && !res.isEmpty() && res.get(0) != null){
                num = (Integer) res.get(0);
            }
            HibernateUtil.closeSession(session);
        }
        return num;
    }

    @Override
    public int findOldReservationDateId() {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        List res = null;
        int num = 0;
        try {
            String hql = "select r.id from ReservationDate r where r.reservationDate<:today and r.reservationDate>:theDayBeforeYesterday";
            Query query = session.createQuery(hql);
            Date today = new Date(new java.util.Date().getTime());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(today);
            calendar.add(Calendar.DATE,-2);
            Date theDayBeforeYesterday = new Date(calendar.getTime().getTime());
            query.setParameter("today",today);
            query.setParameter("theDayBeforeYesterday", theDayBeforeYesterday);
            res = query.list();
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                if(tx!=null){
                    tx.rollback();
                }
            }
            e.printStackTrace();
        } finally {
            if(res != null && !res.isEmpty() && res.get(0) != null){
                num = (Integer) res.get(0);
            }
            HibernateUtil.closeSession(session);
        }
        return num;
    }

    @Override
    public List<ReservationDate> findAllReservationDate() {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        List<ReservationDate> reservationDates = null;

        try {
            String hql = "From ReservationDate rd order by rd.reservationDate asc";
            Query query = session.createQuery(hql);
            reservationDates = query.list();
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
               tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return reservationDates;
    }

    @Override
    public ReservationDate findDate(int rId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        ReservationDate reservationDate = null;
        try {
            reservationDate = (ReservationDate) session.get(ReservationDate.class,rId);
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return  reservationDate;

    }

    @Override
    public void updateReservedAmount(int rId, long amount) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        ReservationDate reservationDate = null;
        try {
            reservationDate = (ReservationDate) session.get(ReservationDate.class, rId);
            reservationDate.setSeatsReserved(amount);
            session.update(reservationDate);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }

}
