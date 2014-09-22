package com.actions;

import com.models.Likes;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.LikesService;
import com.service.impl.LikesServiceImpl;

/**
 * Created by Sunny on 4/16/14.
 */
public class LikeAction extends ActionSupport{

    private Integer Id;
    private String score;
    private Integer userId;
    private Integer menuId;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScore() {
        return score;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String createAndUpdateLike(){
        LikesService likesService = new LikesServiceImpl();
        this.userId = (Integer) ActionContext.getContext().getSession().get("userId");
        int point = Integer.parseInt(score);

        Likes like = likesService.findLike(userId,menuId);
        if(like != null){
            likesService.updateLike(like.getId(),point);
        }else{
            like = new Likes();
            like.setScore(point);
            likesService.createLike(this.userId, this.menuId,like);
        }
        return SUCCESS;
    }

}
