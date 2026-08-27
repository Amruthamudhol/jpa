package com.xworkz.MovieZone.service.impl;

import com.xworkz.MovieZone.dao.MovieDAO;
import com.xworkz.MovieZone.dao.impl.MovieDAOimpl;
import com.xworkz.MovieZone.dto.MovieDTO;
import com.xworkz.MovieZone.entity.MovieEntity;
import com.xworkz.MovieZone.service.MovieService;

import java.util.ArrayList;
import java.util.List;

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
}
