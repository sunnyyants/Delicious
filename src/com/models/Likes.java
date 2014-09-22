package com.models;

/**
 * Created by Sunny on 4/16/14.
 */
public class Likes {

    private Integer id;
    private Integer score;
    private User userLike;
    private Menu likedMenu;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public void setUserLike(User userLike) {
        this.userLike = userLike;
    }

    public User getUserLike() {
        return userLike;
    }

    public void setLikedMenu(Menu likedMenu) {
        this.likedMenu = likedMenu;
    }

    public Menu getLikedMenu() {
        return likedMenu;
    }
}
