package com.service.impl;

import com.dao.GenreDAO;
import com.dao.impl.GenreDAOImpl;
import com.models.Genre;
import com.service.GenreService;

import java.util.List;

/**
 * Created by Sunny on 4/17/14.
 */
public class GenreServiceImpl implements GenreService {
    @Override
    public void createGenre(Genre genre) {
        GenreDAO genreDAO = new GenreDAOImpl();
        genreDAO.createGenre(genre);
    }

    @Override
    public void deleteGenre(Integer GenreId) {
        GenreDAO genreDAO = new GenreDAOImpl();
        genreDAO.deleteGenre(GenreId);
    }

    @Override
    public List<Genre> listOfGenre() {
        GenreDAO genreDAO = new GenreDAOImpl();
        List<Genre> genres = genreDAO.listOfGenre();
        return genres;
    }

    @Override
    public Genre GenreById(Integer GenreId) {
        GenreDAO genreDAO = new GenreDAOImpl();
        Genre genre = genreDAO.GenreById(GenreId);
        return genre;
    }


}
