package com.dao;

import com.models.Reservation;

import java.util.List;

/**
 * Created by Sunny on 4/24/14.
 */
public interface ReservationDAO {

    public void createReservation(Integer userId, int ReservationDateId,Reservation reservation);

    public void deleteReservation(Integer reservationId);

    public void updateReservation(Integer reservationId, Reservation reservation);

    public List<Reservation> findAllReservations();

    public Long countReservation(int reservationDateId);

    public Long countTotalReservedSeatsById(int reservationDateId);

}
