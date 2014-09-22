package com.dao;

import com.models.Menu;

import java.util.List;

/**
 * Created by Sunny on 4/12/14.
 */
public interface MenuDAO {
    public void saveMenu(Integer GenreId,Menu menu);
//    public void saveMenu(Menu menu, File image);

    public Menu findFood(Integer MenuId);

    public List<Menu> findAllfoods();

    public void updateMenuInfo(Integer menuId, Integer GenreId, String name, String imageURL, String description, Float price);

    public void deleteFood(Integer menuId);

    public void updateAverage(Integer menuId, Float average);

    public List<Menu> findFoodsByGenre(Integer genreId);

    public List<Menu> findThreeFoodsWithoutScore();
}
