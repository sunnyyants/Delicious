package com.dao;

import com.models.Reservation;
import com.models.ReservationDate;

import java.sql.Date;
import java.util.List;

/**
 * Created by Sunny on 4/24/14.
 */
public interface ReservationDateDAO {

    public void createReservationDate(ReservationDate reservationDate);

    public void updateReservationNumber(int reservationDateId, int maxNum);

    public void deleteReservationDate(int reservationDateId);

    public int findTodayReservationDateIdBy();

    public int findOldReservationDateId();

    public List<ReservationDate> findAllReservationDate();

    public ReservationDate findDate(int rId);

    public void updateReservedAmount(int rId, long mount);

}
