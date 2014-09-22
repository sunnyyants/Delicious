package com.service.impl;

import com.dao.LikesDAO;
import com.dao.impl.LikesDAOImpl;
import com.models.Likes;
import com.service.LikesService;

import java.util.List;

/**
 * Created by Sunny on 4/16/14.
 */
public class LikesServiceImpl implements LikesService {
    @Override
    public void createLike(Integer userId, Integer menuId, Likes like) {
        LikesDAO likesDAO = new LikesDAOImpl();
        likesDAO.createLike(userId, menuId, like);
    }

    @Override
    public void updateLike(Integer likeId, Integer score) {
        LikesDAO likesDAO = new LikesDAOImpl();
        likesDAO.updateLike(likeId,score);
    }

    @Override
    public Likes findLike(Integer userId, Integer menuId) {
        LikesDAO likesDAO = new LikesDAOImpl();
        Likes like = likesDAO.findLike(userId, menuId);
        return like;
    }

    @Override
    public List getAllAverageScore() {
        LikesDAO likesDAO = new LikesDAOImpl();
        List topThree = likesDAO.getAllAverageScore();
        return topThree;
    }

    @Override
    public List getTotalScore() {
        LikesDAO likesDAO = new LikesDAOImpl();
        List listOfTotalScore = likesDAO.getTotalScore();
        return listOfTotalScore;
    }
}
