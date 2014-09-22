package com.models;

import java.sql.Date;
import java.util.Set;

/**
 * Created by Sunny on 4/24/14.
 */
public class ReservationDate {
    private int id;
    private Date reservationDate;
    private long maximumReservations;
    private long seatsReserved;
    private Set<Reservation> reservationSet;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setReservationDate(Date reseravationDate) {
        this.reservationDate = reseravationDate;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationSet(Set<Reservation> reservationSet) {
        this.reservationSet = reservationSet;
    }

    public Set<Reservation> getReservationSet() {
        return reservationSet;
    }

    public void setMaximumReservations(long maximumReservations) {
        this.maximumReservations = maximumReservations;
    }

    public long getMaximumReservations() {
        return maximumReservations;
    }

    public void setSeatsReserved(long reservationAmountLeft) {
        this.seatsReserved = reservationAmountLeft;
    }

    public long getSeatsReserved() {
        return seatsReserved;
    }
}
