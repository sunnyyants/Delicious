package com.models;

/**
 * Created by Sunny on 4/24/14.
 */
public class Reservation {

    private int id;
    private int tableNumber;
    private ReservationDate reservationDate;
    private User userReserved;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setReservationDate(ReservationDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public ReservationDate getReservationDate() {
        return reservationDate;
    }

    public void setUserReserved(User userReserved) {
        this.userReserved = userReserved;
    }

    public User getUserReserved() {
        return userReserved;
    }
}
