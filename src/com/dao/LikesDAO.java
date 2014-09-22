package com.dao;

import com.models.Likes;
import com.models.Menu;

import java.util.List;

/**
 * Created by Sunny on 4/16/14.
 */
public interface LikesDAO {

    public void createLike(Integer userId, Integer menuId, Likes like);

    public void updateLike(Integer likeId, Integer score);

    public Likes findLike(Integer userId, Integer menuId);

    public List getAllAverageScore();

    public List getTotalScore();
}
