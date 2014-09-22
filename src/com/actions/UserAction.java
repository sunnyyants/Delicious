package com.actions;

import com.models.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.OrdersService;
import com.service.UserService;
import com.service.impl.OrdersServiceImpl;
import com.service.impl.UserServiceImpl;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Sunny on 4/4/14.
 */
public class UserAction extends ActionSupport{
    private Integer id;
    private String username;
    private String password;
    private String rePassword;
    private String address;
    private String zipcode;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private Date registerDate;
    private List<User> listOfUsers;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getRePassword() {
        return rePassword;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getZipcode() {
        return zipcode;
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

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setListOfUsers(List<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public List<User> getListOfUsers() {
        return listOfUsers;
    }

    /**
     * save user
     */

    public String saveUser() throws Exception{
        //TODO Auto_generated method stub
        if(this.username == null || this.username.trim().length() == 0){
            this.addFieldError("userName", this.getText("username cannot be null!"));
            return ERROR;
        }
        if(this.password == null || this.password.trim().length() == 0){
            this.addFieldError("password", this.getText("password cannot be null!"));
            return ERROR;
        }
        UserService userService = new UserServiceImpl();
        if(userService.containUserName(username)){
            this.addFieldError("username",this.getText("username has already existed!"));
            return ERROR;
        }
        if((this.password).equals(this.rePassword)){
            User user = new User();
            user.setUsername(this.username);
            user.setPassword(this.password);
            user.setFirstname(this.firstname);
            user.setLastname(this.lastname);
            user.setAddress(this.address);
            user.setZipcode(this.zipcode);
            user.setPhone(this.phone);
            user.setEmail(this.email);
            Date regeisterDate = new Date(new java.util.Date().getTime());
            user.setRegisterDate(regeisterDate);
            Integer userId = userService.saveUser(user);
            return SUCCESS;
        }else{
            this.addActionError("two password don't match");
            return ERROR;
        }

    }

    /**
     * find user
     */

    public String findUser(){
        UserService userService = new UserServiceImpl();
        User user = userService.findUser(this.id);
        return SUCCESS;
    }

    public String findAllUsers(){
        UserService userService = new UserServiceImpl();
        listOfUsers = userService.findAllUsers();
        return SUCCESS;
    }
    public String userLogin(){
        UserService userService = new UserServiceImpl();
        OrdersService ordersService = new OrdersServiceImpl();

        if(this.username == null || this.username.trim().length() == 0){
            this.addFieldError("userName", this.getText("username cannot be null!"));
            return "USERNAME_NULL";
        }
        if(this.password == null || this.password.trim().length() == 0){
            this.addFieldError("password", this.getText("password cannot be null!"));
            return "PASSWORD_NULL";
        }
        Integer hasUser = userService.loginValidated(this.username, this.password);
        if(hasUser != Integer.MIN_VALUE){
            Integer hasOrderId = ordersService.checkTheUnfinishedOrder(hasUser);
            if(hasOrderId != Integer.MIN_VALUE){
                ActionContext.getContext().getSession().put("orderId",hasOrderId);
                System.out.println(hasOrderId);
            }
            ActionContext.getContext().getSession().put("userId",hasUser);
            ActionContext.getContext().getSession().put("username", username);
            return SUCCESS;
        }else {
            this.addActionError("username or password invalid");
            return ERROR;
        }
    }

    public String updateUserInfo(){
        UserService userService = new UserServiceImpl();
        Integer userId = (Integer) ActionContext.getContext().getSession().get("userId");
        User user = userService.findUser(userId);
        this.username = user.getUsername();
        userService.updateUserInfo(userId,this.firstname,
                this.lastname,this.address,this.zipcode,this.phone,this.email);
        return SUCCESS;
    }

    public String userLogout(){
        Map map = (Map) ActionContext.getContext().getSession();
        if(map.containsKey("userId")){
            map.remove("userId");
            map.remove("username");
            map.remove("orderId");
        }
        return SUCCESS;
    }

    public String deleteUser(){
        UserService userService = new UserServiceImpl();
        Integer userId = (Integer) ActionContext.getContext().getSession().get("userId");
        ActionContext.getContext().getSession().remove("userId");
        userService.deleteUser(userId);
        return SUCCESS;
    }

    public String deleteSelectUser(){
        UserService userService = new UserServiceImpl();
        userService.deleteUser(this.id);
        return SUCCESS;
    }

    public String updateUserPassword(){
        UserService userService = new UserServiceImpl();
        if(this.password != null && this.password.trim().length() != 0 && this.password.equals(this.rePassword)){
            Integer userId = (Integer) ActionContext.getContext().getSession().get("userId");
            userService.updateUserPassword(userId,this.password);
            return SUCCESS;
        }
        if(!this.password.equals(this.rePassword)){
            this.addFieldError("password", this.getText("passwords not match!"));
            return ERROR;
        }else{
            this.addFieldError("password", this.getText("password cannot be null!"));
            return ERROR;
        }
    }
}
