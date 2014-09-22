package com.actions;

import com.models.Manager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ManagerService;
import com.service.OrdersService;
import com.service.impl.ManagerServiceImpl;
import com.service.impl.OrdersServiceImpl;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Sunny on 4/16/14.
 */
public class ManagerAction extends ActionSupport {
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
    private String verification;
    private List<Manager> managerList;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    public String getVerification() {
        return verification;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setManagerList(List<Manager> managerList) {
        this.managerList = managerList;
    }

    public List<Manager> getManagerList() {
        return managerList;
    }

    public String saveManager() throws Exception{
        //TODO Auto_generated method stub

        if(this.username == null || this.username.trim().length() == 0){
            this.addFieldError("userName", this.getText("username cannot be null!"));
            return ERROR;
        }
        if(this.password == null || this.password.trim().length() == 0){
            this.addFieldError("password", this.getText("password cannot be null!"));
            return ERROR;
        }

        if(this.verification == null || this.verification.trim().length() == 0 || !this.verification.equals("NEU")){
            this.addFieldError("authorization",this.getText("You are not authorized to sign up as manager"));
            return ERROR;
        }

        if((this.password).equals(this.rePassword)){
            Manager manager = new Manager();
            manager.setUsername(this.username);
            manager.setPassword(this.password);
            manager.setFirstname(this.firstname);
            manager.setLastname(this.lastname);
            manager.setAddress(this.address);
            manager.setZipcode(this.zipcode);
            manager.setPhone(this.phone);
            manager.setEmail(this.email);
            Date regeisterDate = new Date(new java.util.Date().getTime());
            manager.setRegisterDate(regeisterDate);

            ManagerService managerService = new ManagerServiceImpl();
            managerService.saveManager(manager);


            return SUCCESS;
        }else{
            this.addFieldError("passwordNotMatch", getText("two password don't match"));
            return ERROR;
        }
    }

    public String findManger(){
        ManagerService managerService = new ManagerServiceImpl();
        Manager manager = managerService.findManager(this.id);
        return SUCCESS;
    }

    public String findAllManagers(){
        ManagerService managerService = new ManagerServiceImpl();
        managerList = managerService.findAllManagers();
        return SUCCESS;
    }
    public String managerLogin(){
        ManagerService managerService = new ManagerServiceImpl();
        Integer hasManager = managerService.loginValidated(this.username, this.password);
        if(this.username == null || this.username.trim().length() == 0){
            this.addFieldError("managerName", this.getText("managername cannot be null!"));
            return "USERNAME_NULL";
        }
        if(this.password == null || this.password.trim().length() == 0){
            this.addFieldError("password", this.getText("password cannot be null!"));
            return "PASSWORD_NULL";
        }
        if(hasManager != Integer.MIN_VALUE){
            Map map = ActionContext.getContext().getSession();
            map.put("managerId", hasManager);
            map.put("managerName", username);
            return SUCCESS;
        }else {
            this.addFieldError("NoManager",getText("managerName or password invalid"));
            return ERROR;
        }
    }


    public String updateManagerInfo(){
        ManagerService managerService = new ManagerServiceImpl();
        Integer managerId = (Integer) ActionContext.getContext().getSession().get("managerId");
        Manager manager = managerService.findManager(managerId);
        this.username = manager.getUsername();
        managerService.updateManagerInfo(managerId, this.firstname,
                this.lastname, this.address, this.zipcode, this.phone, this.email);
        return SUCCESS;
    }

    public String managerLogout(){
        Map map = (Map) ActionContext.getContext().getSession();
        if(map.containsKey("managerId")){
            map.remove("managerId");
            map.remove("managerName");
            map.remove("numberOfPending");
            map.remove("numberOfRFP");
            map.remove("totalIncome");
            map.remove("numberOfTodayOrder");
            map.remove("numberOfUnreadMessages");
            map.remove("numberOfDeliveries");
        }
        return SUCCESS;
    }

    public String deleteManager(){
        ManagerService managerService = new ManagerServiceImpl();
        Integer managerId = (Integer) ActionContext.getContext().getSession().get("managerId");
        ActionContext.getContext().getSession().remove("managerId");
        ActionContext.getContext().getSession().remove("managerName");
        managerService.deleteManager(managerId);
        return SUCCESS;
    }

    public String updateManagerPassword(){
        ManagerService managerService = new ManagerServiceImpl();
        if(this.password != null && this.password.trim().length() != 0 && this.password.equals(this.rePassword)){
            Integer userId = (Integer) ActionContext.getContext().getSession().get("managerId");
            managerService.updateManagerPassword(userId, this.password);
//            System.out.println("here");
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
