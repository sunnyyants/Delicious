package com.models;

import java.sql.Date;

/**
 * Created by Sunny on 4/24/14.
 */
public class Message {
    private int id;
    private String title;
    private String message;
    private String status;
    private User userLeftMessage;
    private Date dateOfCreated;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUserLeftMessage(User userLeftMessage) {
        this.userLeftMessage = userLeftMessage;
    }

    public User getUserLeftMessage() {
        return userLeftMessage;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateOfCreated(Date dateOfCreated) {
        this.dateOfCreated = dateOfCreated;
    }

    public Date getDateOfCreated() {
        return dateOfCreated;
    }
}
