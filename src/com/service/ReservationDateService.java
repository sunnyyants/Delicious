package com.service;

import com.models.ReservationDate;

import java.sql.Date;
import java.util.List;

/**
 * Created by Sunny on 4/24/14.
 */
public interface ReservationDateService {    public void createReservationDate(ReservationDate reservationDate);

    public void updateReservationNumber(int reservationDateId, int maxNum);

    public void deleteReservationDate(int reservationDateId);

    public int findTodayReservationDateIdBy();

    public int findOldReservationDateId();

    public List<ReservationDate> findAllReservationDate();

    public ReservationDate findDate(int rId);

    public void updateReservationAmount(int rId, long amount);


}
