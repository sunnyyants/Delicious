package com.actions;

import com.models.Reservation;
import com.models.ReservationDate;
import com.models.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ReservationDateService;
import com.service.ReservationService;
import com.service.UserService;
import com.service.impl.ReservationDateServiceImpl;
import com.service.impl.ReservationServiceImpl;
import com.service.impl.UserServiceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Sunny on 4/24/14.
 */
public class ReservationAction extends ActionSupport {
    private int id;
    private int tableNumber;
    private int userId;
    private int rdId;
    private List<Reservation> reservations;
    private List<User> users;
    private List<ReservationDate> reservationDates;

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

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setRdId(int rdId) {
        this.rdId = rdId;
    }

    public int getRdId() {
        return rdId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setReservationDates(List<ReservationDate> reservationDates) {
        this.reservationDates = reservationDates;
    }

    public List<ReservationDate> getReservationDates() {
        return reservationDates;
    }

    public String createReservation(){
        ReservationService reservationService = new ReservationServiceImpl();
        ReservationDateService reservationDateService = new ReservationDateServiceImpl();
        Reservation reservation = new Reservation();
        reservation.setTableNumber(this.getTableNumber());
        Map map = ActionContext.getContext().getSession();
        this.userId = (Integer) map.get("userId");
        ReservationDate reservationDate = reservationDateService.findDate(this.rdId);
        long maxReservationNum = reservationDate.getMaximumReservations();
        long seatsBooked = reservationDate.getSeatsReserved();
        long currentReservedAmount = reservationService.countTotalReservedSeatsById(this.rdId);
        if(currentReservedAmount + seatsBooked < maxReservationNum){
            reservationService.createReservation(this.userId,this.rdId,reservation);
            currentReservedAmount = reservationService.countTotalReservedSeatsById(this.rdId);
            reservationDateService.updateReservationAmount(this.rdId,currentReservedAmount);
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

    public String showAllReservations(){
        ReservationDateService reservationDateService = new ReservationDateServiceImpl();
        ReservationService reservationService = new ReservationServiceImpl();
        UserService userService = new UserServiceImpl();
        int OldRd = reservationDateService.findOldReservationDateId();
        if(OldRd != 0){
            reservationDateService.deleteReservationDate(OldRd);
            ReservationDate newReservationDate = new ReservationDate();
            newReservationDate.setMaximumReservations(5);
            newReservationDate.setReservationDate(new Date(new java.util.Date().getTime()));
            reservationDateService.createReservationDate(newReservationDate);
        }
        reservations = reservationService.findAllReservations();
        List<User> tempUser = new ArrayList<User>();
        List<ReservationDate> tempReservatioinDate = new ArrayList<ReservationDate>();
        for(int i = 0; i < this.reservations.size();i++){
            tempUser.add(userService.findUser(reservations.get(i).getUserReserved().getId()));
            tempReservatioinDate.add(reservationDateService.findDate(reservations.get(i).getReservationDate().getId()));
        }
        this.users = tempUser;
        System.out.println(users.size());
        this.reservationDates = tempReservatioinDate;
        System.out.println(tempReservatioinDate.size());
        return SUCCESS;
    }
    public String deleteReservation(){
        ReservationService reservationService = new ReservationServiceImpl();
        reservationService.deleteReservation(this.id);
        return SUCCESS;
    }

}
