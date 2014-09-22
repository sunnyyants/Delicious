package com.models;

import java.sql.Date;
import java.util.Set;

/**
 * Created by Sunny on 4/15/14.
 */
//@Entity
public class User {
    private int id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String address;
    private String zipcode;
    private String phone;
    private String email;
    private Date registerDate;
    private Set<Order> orders;
    private Set<Likes> likes;
    private Set<Reservation> reservations;
    private Set<Message> messages;
    private Set<Delivery> deliveries;

    public User(){};

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public void setLikes(Set<Likes> likes) {
        this.likes = likes;
    }

    public Set<Likes> getLikes() {
        return likes;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setDeliveries(Set<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public Set<Delivery> getDeliveries() {
        return deliveries;
    }
}
