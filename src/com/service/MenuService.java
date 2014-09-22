package com.service;

import com.models.Menu;

import java.util.List;

/**
 * Created by Sunny on 4/12/14.
 */
public interface MenuService {
    public void saveMenu(Integer genreId, Menu menu);
//    public void saveMenu(Menu menu, File image);

    public Menu findMenu(Integer menuId);

    public List<Menu> findAllMenu();

    public void updateMenuInfo(Integer menuId, Integer GenreId, String name, String imageURL, String description, Float price);

    public void deleteMenu(Integer menuId);

    public void updateAverage(Integer menuId, Float average);

    public List<Menu> findAllFoodsByGenre(Integer genreId);

    public List<Menu> findThreeFoodsWithouScore();
}
