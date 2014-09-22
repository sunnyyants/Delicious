package com.dao.impl;

import com.dao.ReservationDAO;
import com.models.Reservation;
import com.models.ReservationDate;
import com.models.User;
import com.util.HibernateUtil;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Sunny on 4/24/14.
 */
public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public void createReservation(Integer userId, int reservationDateId, Reservation reservation) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            ReservationDate reservationDate = (ReservationDate) session.get(ReservationDate.class, reservationDateId);
            User user = (User) session.get(User.class,userId);
            reservation.setReservationDate(reservationDate);
            reservation.setUserReserved(user);
            session.persist(reservation);
            reservationDate.getReservationSet().add(reservation);
            session.update(reservationDate);
            user.getReservations().add(reservation);
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
    public void deleteReservation(Integer reservationId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            Reservation reservation = (Reservation) session.get(Reservation.class, reservationId);
            session.delete(reservation);
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
    public void updateReservation(Integer reservationId, Reservation reservation) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            Reservation oldReservation = (Reservation) session.get(Reservation.class, reservationId);
            oldReservation.setReservationDate(reservation.getReservationDate());
            oldReservation.setTableNumber(reservation.getTableNumber());
            session.update(oldReservation);
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
    public List<Reservation> findAllReservations() {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        List<Reservation> reservations = null;

        try {
            String hql = "From Reservation r order by r.reservationDate.reservationDate asc ";
            Query query = session.createQuery(hql);
            reservations = query.list();
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }

        return reservations;
    }

    @Override
    public Long countReservation(int reseravationDateId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        Long res = (long)0;
        List temp = null;
        try {
            String hql = "SELECT COUNT(r.id) from Reservation r";
            Query query = session.createQuery(hql);
            temp = query.list();
            tx.commit();
        } catch (Exception e) {
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if(temp != null && !temp.isEmpty() && temp.get(0)!=null){
                res = (Long) temp.get(0);
            }
            HibernateUtil.closeSession(session);
        }
        return res;
    }

    public Long countTotalReservedSeatsById(int reseravationDateId) {
        org.hibernate.Session session = HibernateUtil.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        Long res = (long)0;
        List temp = null;
        try {
            String hql = "SELECT SUM(r.tableNumber) from Reservation r where r.reservationDate.id = reservationDate.id";
            Query query = session.createQuery(hql);
            temp = query.list();
            tx.commit();
        } catch (Exception e) {
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if(temp != null && !temp.isEmpty() && temp.get(0)!=null){
                res = (Long) temp.get(0);
            }
            HibernateUtil.closeSession(session);
        }
        return res;
    }

}
