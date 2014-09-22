package com.dao;

import com.models.Manager;

import java.util.List;

/**
 * Created by Sunny on 4/16/14.
 */
public interface ManagerDAO {
    public Integer saveManager(Manager manager);

    public Manager findManager(Integer managerId);

    public List<Manager> findAllManager();

    public Integer loginValidated(String managerName,String passWord);

    public void updateManagerInfo(Integer managerId, String firstName, String lastName,
                                  String address, String zipcode, String phone, String email);

    public void deleteManager(Integer managerId);

    public void updateManagerPassword(Integer managerId, String password);
}
