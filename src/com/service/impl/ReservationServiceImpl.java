package com.service.impl;

import com.dao.ReservationDAO;
import com.dao.impl.ReservationDAOImpl;
import com.models.Reservation;
import com.service.ReservationService;

import java.util.List;

/**
 * Created by Sunny on 4/24/14.
 */
public class ReservationServiceImpl implements ReservationService {
    @Override
    public void createReservation(Integer userId,int ReservationDateId, Reservation reservation) {
        ReservationDAO reservationDAO = new ReservationDAOImpl();
        reservationDAO.createReservation(userId,ReservationDateId,reservation);
    }

    @Override
    public void deleteReservation(Integer reservationId) {
        ReservationDAO reservationDAO = new ReservationDAOImpl();
        reservationDAO.deleteReservation(reservationId);
    }

    @Override
    public void updateReservation(Integer reservationId, Reservation reservation) {
        ReservationDAO reservationDAO = new ReservationDAOImpl();
        reservationDAO.updateReservation(reservationId,reservation);
    }

    @Override
    public List<Reservation> findAllReservations() {
        ReservationDAO reservationDAO = new ReservationDAOImpl();
        return reservationDAO.findAllReservations();
    }

    @Override
    public Long countReservation(int reservationDateId) {
        ReservationDAO reservationDAO = new ReservationDAOImpl();
        return reservationDAO.countReservation(reservationDateId);
    }

    @Override
    public Long countTotalReservedSeatsById(int reseravationDateId) {
        ReservationDAO reservationDAO = new ReservationDAOImpl();
        return reservationDAO.countTotalReservedSeatsById(reseravationDateId);
    }

}
