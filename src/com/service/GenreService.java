package com.service;

import com.models.Genre;

import java.util.List;

/**
 * Created by Sunny on 4/17/14.
 */
public interface GenreService {

    public void createGenre(Genre genre);

    public void deleteGenre(Integer GenreId);

    public List<Genre> listOfGenre();

    public Genre GenreById(Integer GenreId);

}
