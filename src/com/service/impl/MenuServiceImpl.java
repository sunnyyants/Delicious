package com.service.impl;

import com.dao.MenuDAO;
import com.dao.impl.MenuDAOImpl;
import com.models.Menu;
import com.service.MenuService;

import java.util.List;

/**
 * Created by Sunny on 4/12/14.
 */
public class MenuServiceImpl implements MenuService {

    @Override
    public void saveMenu(Integer GenreId, Menu menu) {
        MenuDAO menuDAO = new MenuDAOImpl();
        menuDAO.saveMenu(GenreId,menu);
    }


    @Override
    public Menu findMenu(Integer menuId) {
        MenuDAO menuDAO = new MenuDAOImpl();
        Menu menu = menuDAO.findFood(menuId);
        return menu;
    }

    @Override
    public List<Menu> findAllMenu() {
        MenuDAO menuDAO = new MenuDAOImpl();
        List<Menu> listOfMenu = menuDAO.findAllfoods();
        return listOfMenu;
    }

    @Override
    public void updateMenuInfo(Integer menuId, Integer genreId, String name, String imageURL, String description, Float price) {
        MenuDAO menuDAO = new MenuDAOImpl();
        menuDAO.updateMenuInfo(menuId,genreId, name,imageURL,description,price);
    }

    @Override
    public void deleteMenu(Integer menuId) {
        MenuDAO menuDAO = new MenuDAOImpl();
        menuDAO.deleteFood(menuId);
    }

    @Override
    public void updateAverage(Integer menuId, Float average) {
        MenuDAO menuDAO = new MenuDAOImpl();
        menuDAO.updateAverage(menuId,average);
    }

    @Override
    public List<Menu> findAllFoodsByGenre(Integer genreId) {
        MenuDAO menuDAO = new MenuDAOImpl();
        List<Menu> listOfMenu = menuDAO.findFoodsByGenre(genreId);
        return listOfMenu;
    }

    @Override
    public List<Menu> findThreeFoodsWithouScore() {
        MenuDAO menuDAO = new MenuDAOImpl();
        List<Menu> listOfMenu = menuDAO.findThreeFoodsWithoutScore();
        return listOfMenu;
    }
}
