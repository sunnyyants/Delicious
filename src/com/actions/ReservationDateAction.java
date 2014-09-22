package com.actions;

import com.models.ReservationDate;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ReservationDateService;
import com.service.ReservationService;
import com.service.impl.ReservationDateServiceImpl;
import com.service.impl.ReservationServiceImpl;

import java.sql.Date;
import java.util.*;

/**
 * Created by Sunny on 4/24/14.
 */
public class ReservationDateAction extends ActionSupport {
    private int id;
    private Date reservationDate;
    private int maximumReservations;
    private List<ReservationDate> reservationDates;
    private int setDays;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getMaximumReservations() {
        return maximumReservations;
    }

    public void setMaximumReservations(int maximumReservations) {
        this.maximumReservations = maximumReservations;
    }

    public void setReservationDates(List<ReservationDate> reservationDates) {
        this.reservationDates = reservationDates;
    }

    public List<ReservationDate> getReservationDates() {
        return reservationDates;
    }

    public void setSetDays(int setDays) {
        this.setDays = setDays;
    }

    public int getSetDays() {
        return setDays;
    }


    public String createReservationDate(){
        ReservationDateService reservationDateService = new ReservationDateServiceImpl();
        ReservationDate newReservationDate = new ReservationDate();
        newReservationDate.setMaximumReservations(this.maximumReservations);
        newReservationDate.setSeatsReserved(0);
        Date today = new Date(new java.util.Date().getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE,this.setDays);
        Date targetDate = new Date(calendar.getTime().getTime());
        newReservationDate.setReservationDate(targetDate);
        reservationDateService.createReservationDate(newReservationDate);
        return SUCCESS;
    }

    public String preloadAllReservationDateForUser(){
        ReservationDateService reservationDateService = new ReservationDateServiceImpl();
        ReservationService reservationService = new ReservationServiceImpl();
        List<ReservationDate> avaliables = new ArrayList<ReservationDate>();
        Map map = ActionContext.getContext().getSession();
        List<ReservationDate> temp = reservationDateService.findAllReservationDate();
        for(int i = 0; i < temp.size(); i++){
            ReservationDate r = temp.get(i);
            long currentReservationAmount = reservationService.countTotalReservedSeatsById(r.getId());
            if(r.getReservationDate().before(new Date(new java.util.Date().getTime()))){
                reservationDateService.deleteReservationDate(r.getId());
            }
            if(currentReservationAmount < r.getMaximumReservations()){
                avaliables.add(r);
            }
        }
        this.reservationDates = avaliables;
        return SUCCESS;
    }
    public String preloadAllReservationDateForManager(){
        ReservationDateService reservationDateService = new ReservationDateServiceImpl();
        this.reservationDates = reservationDateService.findAllReservationDate();
        return SUCCESS;
    }

    public String updateReservationDate(){
        ReservationDateService reservationDateService = new ReservationDateServiceImpl();
        reservationDateService.updateReservationNumber(this.id,maximumReservations);
        return SUCCESS;
    }

    public String deleteReservationDate(){
        ReservationDateService reservationDateService = new ReservationDateServiceImpl();
        reservationDateService.deleteReservationDate(this.id);
        return SUCCESS;
    }

}
