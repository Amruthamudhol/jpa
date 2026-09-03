package com.xworkz.MovieZone.dao;

import com.xworkz.MovieZone.dto.MovieDTO;
import com.xworkz.MovieZone.entity.MovieEntity;

import java.util.List;

public interface MovieDAO {
    boolean save(MovieEntity entity);
    boolean saveAll(List<MovieEntity> entityList);

    MovieEntity findMovieEntityById(Integer id);
    List<MovieEntity> readAllMovieEntity();
    List<MovieEntity> getMoviesByDirectorAndGenre(String director, String genre);

    List<MovieEntity> getMoviesByGenreAndLanguage(String genre, String language);
    MovieEntity getMovieByTitleAndLanguage(String title, String language);
    MovieEntity getMovieByDirectorAndTitle(String director, String title);

    Boolean updateMovieGenreAndRatingByTitle(String title, String genre, Double rating);
    Boolean updateMovieLanguageAndRatingByDirector(String director, String language, Double rating);

    List<String> getTitles();
    List<Object> getLanguages();

}
