package com.xworkz.MovieZone.service.impl;

import com.xworkz.MovieZone.dao.MovieDAO;
import com.xworkz.MovieZone.dao.impl.MovieDAOimpl;
import com.xworkz.MovieZone.dto.MovieDTO;
import com.xworkz.MovieZone.entity.MovieEntity;
import com.xworkz.MovieZone.service.MovieService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MovieServiceImpl implements MovieService {
    MovieDAO movieDAO = new MovieDAOimpl();

    @Override
    public boolean validateAndSave(MovieDTO dto) {

        System.out.println("Invoking validateAndSave : MovieServiceImpl");

        boolean isSaved = false;

        if (dto != null) {
            MovieEntity entity = new MovieEntity();

            entity.setTitle(dto.getTitle());
            entity.setDirector(dto.getDirector());
            entity.setGenre(dto.getGenre());
            entity.setLanguage(dto.getLanguage());
            entity.setRating(dto.getRating());

            boolean saved = movieDAO.save(entity);

            if (saved) {
                isSaved = true;
                System.out.println("Data Saved");
            } else {
                isSaved = false;
                System.out.println("Data Not Saved");
            }

        } else {
            System.out.println("Data is Empty");
        }

        return isSaved;
    }


    @Override
    public String saveAll(List<MovieDTO> dtoList) {

        System.out.println("Invoking saveAll : MovieServiceImpl");

        String isSaved = null;

        if (dtoList != null) {

            System.out.println("List of DTO : " + dtoList);

            List<MovieEntity> entityList = new ArrayList<>();

            for (MovieDTO dto : dtoList) {

                MovieEntity entity = new MovieEntity();

                entity.setTitle(dto.getTitle());
                entity.setDirector(dto.getDirector());
                entity.setGenre(dto.getGenre());
                entity.setLanguage(dto.getLanguage());
                entity.setRating(dto.getRating());

                entityList.add(entity);
            }

            boolean status = movieDAO.saveAll(entityList);

            if (status) {
                isSaved = "Data Saved in database";
            } else {
                isSaved = "Data Not Saved in database";
            }

        } else {

            isSaved = "Data is Empty";
        }

        return isSaved;
    }


    @Override
    public MovieDTO findMovieDTOById(Integer id) {

        System.out.println("Invoking findMovieDTOById : MovieServiceImpl");
        MovieEntity entity = movieDAO.findMovieEntityById(id);
        if (entity != null) {

            MovieDTO dto = new MovieDTO();
            dto.setTitle(entity.getTitle());
            dto.setDirector(entity.getDirector());
            dto.setGenre(entity.getGenre());
            dto.setLanguage(entity.getLanguage());
            dto.setRating(entity.getRating());

            return dto;
        }

        return null;
    }


    @Override
    public List<MovieDTO> readAllMovieDTO() {

        System.out.println("readAllMovieDTO : MovieServiceImpl");

        List<MovieEntity> entityList = movieDAO.readAllMovieEntity();

        return entityList.stream()
                .map(entity -> new MovieDTO(
                        entity.getTitle(),
                        entity.getDirector(),
                        entity.getGenre(),
                        entity.getLanguage(),
                        entity.getRating()
                ))
                .collect(Collectors.toList());
    }


    @Override
    public List<MovieDTO> getMoviesByDirectorAndGenre(String director, String genre) {

        List<MovieDTO> dtoList = new ArrayList<>();

        List<MovieEntity> entityList = movieDAO.getMoviesByDirectorAndGenre(director, genre);

        for (MovieEntity entity : entityList) {
            MovieDTO dto = new MovieDTO();

            dto.setTitle(entity.getTitle());
            dto.setDirector(entity.getDirector());
            dto.setGenre(entity.getGenre());
            dto.setLanguage(entity.getLanguage());
            dto.setRating(entity.getRating());

            dtoList.add(dto);
        }

        return dtoList;
    }



    @Override
    public List<MovieDTO> getMoviesByGenreAndLanguage(String genre, String language) {

        List<MovieDTO> dtoList = new ArrayList<>();
        List<MovieEntity> entityList = movieDAO.getMoviesByGenreAndLanguage(genre, language);

        for (MovieEntity entity : entityList) {

            MovieDTO dto = new MovieDTO();

            dto.setTitle(entity.getTitle());
            dto.setDirector(entity.getDirector());
            dto.setGenre(entity.getGenre());
            dto.setLanguage(entity.getLanguage());
            dto.setRating(entity.getRating());

            dtoList.add(dto);
        }

        return dtoList;
    }


    @Override
    public MovieDTO getMovieByTitleAndLanguage(String title, String language) {

        MovieEntity entity = movieDAO.getMovieByTitleAndLanguage(title, language);
        MovieDTO dto = null;

        if (entity != null) {

            dto = new MovieDTO();

            dto.setTitle(entity.getTitle());
            dto.setDirector(entity.getDirector());
            dto.setGenre(entity.getGenre());
            dto.setLanguage(entity.getLanguage());
            dto.setRating(entity.getRating());
        }

        return dto;
    }


    @Override
    public MovieDTO getMovieByDirectorAndTitle(String director, String title) {

        MovieEntity entity = movieDAO.getMovieByDirectorAndTitle(director, title);
        MovieDTO dto = null;

        if (entity != null) {
            dto = new MovieDTO();

            dto.setTitle(entity.getTitle());
            dto.setDirector(entity.getDirector());
            dto.setGenre(entity.getGenre());
            dto.setLanguage(entity.getLanguage());
            dto.setRating(entity.getRating());
        }

        return dto;
    }

    @Override
    public String updateMovieGenreAndRatingByTitle(String title, String genre, Double rating) {

        System.out.println("Invoking updateMovieGenreAndRatingByTitle : Service");

        String status = null;

        if (title != null && genre != null && rating != null) {

            Boolean isUpdated = movieDAO.updateMovieGenreAndRatingByTitle(title, genre, rating);

            if (isUpdated) {
                status = "Data Updated";
            } else {
                status = "Data Not Updated";
            }
        }

        return status;
    }


    @Override
    public String updateMovieLanguageAndRatingByDirector(String director, String language, Double rating) {

        System.out.println("Invoking updateMovieLanguageAndRatingByDirector : Service");

        String status = null;
        if (director != null && language != null && rating != null) {

            Boolean isUpdated = movieDAO.updateMovieLanguageAndRatingByDirector(director, language, rating);
            if (isUpdated) {
                status = "Data Updated";
            } else {
                status = "Data Not Updated";
            }
        }

        return status;
    }


    @Override
    public List<String> getTitles() {

        System.out.println("getTitles : Service");
        List<String> titles = movieDAO.getTitles();

        if (titles != null) {
            return titles;
        }

        return Collections.emptyList();
    }

    @Override
    public List<Object> getLanguages() {
        System.out.println("getLanguages : Service");
        List<Object> languages = movieDAO.getLanguages();

        if (languages != null) {
            return languages;
        }

        return Collections.emptyList();
    }


    @Override
    public List<Object[]> getTitleDirectorAndGenre() {
        System.out.println("getTitleDirectorAndGenre : Service");
        List<Object[]> movies = movieDAO.getTitleDirectorAndGenre();
        if (movies != null) {
            return movies;
        }

        return Collections.emptyList();
    }

    @Override
    public List<List<Object>> getTitleAndLanguage() {

        System.out.println("getTitleAndLanguage : Service");
        List<List<Object>> movies = movieDAO.getTitleAndLanguage();
        if (movies != null) {
            return movies;
        }

        return Collections.emptyList();
    }
}
