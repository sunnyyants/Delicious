package com.models;

import java.sql.Date;
import java.util.Set;

/**
 * Created by Sunny on 4/16/14.
 */
public class Manager {
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

        public Manager(){};

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

}
