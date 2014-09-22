package com.service.impl;

import com.dao.ReservationDateDAO;
import com.dao.impl.ReservationDateDAOIpml;
import com.models.ReservationDate;
import com.service.ReservationDateService;

import java.util.List;

/**
 * Created by Sunny on 4/24/14.
 */
public class ReservationDateServiceImpl implements ReservationDateService {
    @Override
    public void createReservationDate(ReservationDate reservationDate) {
        ReservationDateDAO reservationDateDAO = new ReservationDateDAOIpml();
        reservationDateDAO.createReservationDate(reservationDate);
    }

    @Override
    public void updateReservationNumber(int reservationDateId, int maxNum) {
        ReservationDateDAO reservationDateDAO = new ReservationDateDAOIpml();
        reservationDateDAO.updateReservationNumber(reservationDateId, maxNum);
    }

    @Override
    public void deleteReservationDate(int reservationDateId) {
        ReservationDateDAO reservationDateDAO = new ReservationDateDAOIpml();
        reservationDateDAO.deleteReservationDate(reservationDateId);
    }

    @Override
    public int findTodayReservationDateIdBy() {
        ReservationDateDAO reservationDateDAO = new ReservationDateDAOIpml();
        return reservationDateDAO.findTodayReservationDateIdBy();
    }

    @Override
    public int findOldReservationDateId() {
        ReservationDateDAO reservationDateDAO = new ReservationDateDAOIpml();
        return reservationDateDAO.findOldReservationDateId();
    }

    @Override
    public List<ReservationDate> findAllReservationDate() {
        ReservationDateDAO reservationDateDAO = new ReservationDateDAOIpml();
        return reservationDateDAO.findAllReservationDate();
    }

    @Override
    public ReservationDate findDate(int rId) {
        ReservationDateDAO reservationDateDAO = new ReservationDateDAOIpml();
        return reservationDateDAO.findDate(rId);
    }

    @Override
    public void updateReservationAmount(int rId, long amount) {
        ReservationDateDAO reservationDateDao = new ReservationDateDAOIpml();
        reservationDateDao.updateReservedAmount(rId, amount);
    }
}
