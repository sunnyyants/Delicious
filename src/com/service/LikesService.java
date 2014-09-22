package com.service;

import com.models.Likes;

import java.util.List;

/**
 * Created by Sunny on 4/16/14.
 */
public interface LikesService {

    public void createLike(Integer userId, Integer menuId, Likes like);

    public void updateLike(Integer likeId, Integer score);

    public Likes findLike(Integer userId, Integer menuId);

    public List getAllAverageScore();

    public List getTotalScore();


}
