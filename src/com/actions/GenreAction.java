package com.actions;

import com.models.Genre;
import com.models.Menu;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.GenreService;
import com.service.MenuService;
import com.service.impl.GenreServiceImpl;
import com.service.impl.MenuServiceImpl;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sunny on 4/17/14.
 */
public class GenreAction extends ActionSupport {

    private Integer id;
    private String name;
    private List<Genre> genres;
    private List<Menu> menus;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public String createGenre(){
        GenreService genreService = new GenreServiceImpl();
        Genre genre = new Genre();
        genre.setName(this.name);
        genreService.createGenre(genre);
        return SUCCESS;
    }
    public String deleteGenre(){
        GenreService genreService = new GenreServiceImpl();
        genreService.deleteGenre(this.id);
        return SUCCESS;
    }

    public String findAllGenres(){
        GenreService genreService = new GenreServiceImpl();
        this.genres = genreService.listOfGenre();
        return SUCCESS;
    }

    public String preLoadAllGenres(){
        GenreService genreService = new GenreServiceImpl();
        this.genres = genreService.listOfGenre();
        return SUCCESS;
    }


}


