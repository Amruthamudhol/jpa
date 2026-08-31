package com.xworkz.MovieZone.dao;

import com.xworkz.MovieZone.dto.MovieDTO;
import com.xworkz.MovieZone.entity.MovieEntity;

import java.util.List;

public interface MovieDAO {
    boolean save(MovieEntity entity);
    boolean saveAll(List<MovieEntity> entityList);
    MovieEntity findMovieEntityById(Integer id);
    List<MovieEntity> readAllMovieEntity();

}
