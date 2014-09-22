package com.actions;

import com.models.Message;
import com.models.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.MessageService;
import com.service.UserService;
import com.service.impl.MessageServiceImpl;
import com.service.impl.UserServiceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Sunny on 4/24/14.
 */
public class MessageAction extends ActionSupport{

    private int id;
    private String status;
    private String message;
    private String title;
    private Date dateOfCreated;
    private List<Message> messages;
    private List<User> users;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Date getDateOfCreated() {
        return dateOfCreated;
    }

    public void setDateOfCreated(Date dateOfCreated) {
        this.dateOfCreated = dateOfCreated;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public String createMessage(){
        MessageService messageService = new MessageServiceImpl();
        Map map = ActionContext.getContext().getSession();
        Message newMessage = new Message();
        newMessage.setTitle(this.title);
        newMessage.setStatus("Unread");
        newMessage.setMessage(this.message);
        Integer userId = (Integer) map.get("userId");
        Date current = new Date(new java.util.Date().getTime());
        newMessage.setDateOfCreated(current);
        this.dateOfCreated = current;
        messageService.createMesage(userId,newMessage);
        return SUCCESS;
    }

    public String findAllMessage(){
        MessageService messageService = new MessageServiceImpl();
        UserService userService = new UserServiceImpl();
        this.messages = messageService.findAllMessage();
        List<User> userList = new ArrayList<User>();
        for(int i = 0; i < this.messages.size(); i++){
            Message m = this.messages.get(i);
            userList.add(userService.findUser(m.getUserLeftMessage().getId()));
        }
        this.users = userList;
        return SUCCESS;
    }

    public String updateMessageStatus(){
        MessageService messageService = new MessageServiceImpl();
        messageService.updateMesaageStatus(this.id, this.status);
        return SUCCESS;
    }
}
