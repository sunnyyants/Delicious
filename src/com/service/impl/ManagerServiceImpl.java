package com.service.impl;

import com.dao.ManagerDAO;
import com.dao.impl.ManagerDAOImpl;
import com.models.Manager;
import com.service.ManagerService;

import java.util.List;

/**
 * Created by Sunny on 4/16/14.
 */
public class ManagerServiceImpl implements ManagerService{

    @Override
    public Integer saveManager(Manager manager) {
        ManagerDAO managerDAO = new ManagerDAOImpl();
        return managerDAO.saveManager(manager);
    }

    @Override
    public Manager findManager(Integer managerId) {
        ManagerDAO managerDAO = new ManagerDAOImpl();
        Manager manager = managerDAO.findManager(managerId);
        return manager;
    }

    @Override
    public List<Manager> findAllManagers() {
        ManagerDAO managerDAO = new ManagerDAOImpl();
        List<Manager> listOfManagers = managerDAO.findAllManager();
        return listOfManagers;
    }

    @Override
    public Integer loginValidated(String managerName, String passWord) {
        ManagerDAO managerDAO = new ManagerDAOImpl();
        Integer res = managerDAO.loginValidated(managerName,passWord);
        return res;
    }

    @Override
    public void updateManagerInfo(Integer managerId, String firstName, String lastName,
                                  String address, String zipcode, String phone, String email) {
        ManagerDAO managerDAO = new ManagerDAOImpl();
        managerDAO.updateManagerInfo(managerId,firstName,lastName,address,zipcode,phone,email);
    }

    @Override
    public void deleteManager(Integer managerId) {
        ManagerDAO managerDAO = new ManagerDAOImpl();
        managerDAO.deleteManager(managerId);
    }

    @Override
    public void updateManagerPassword(Integer managerId, String password) {
        ManagerDAO managerDAO = new ManagerDAOImpl();
        managerDAO.updateManagerPassword(managerId,password );
    }
}
