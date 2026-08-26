package com.xworkz.MovieZone.service.impl;

import com.xworkz.MovieZone.dao.MovieDAO;
import com.xworkz.MovieZone.dao.impl.MovieDAOimpl;
import com.xworkz.MovieZone.dto.MovieDTO;
import com.xworkz.MovieZone.entity.MovieEntity;
import com.xworkz.MovieZone.service.MovieService;

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
}
