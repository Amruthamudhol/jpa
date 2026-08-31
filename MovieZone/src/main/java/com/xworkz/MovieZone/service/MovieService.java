package com.xworkz.MovieZone.service;

import com.xworkz.MovieZone.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    boolean validateAndSave(MovieDTO dto);
    String saveAll(List<MovieDTO> dtoList);
    List<MovieDTO> readAllMovieDTO();

        MovieDTO findMovieDTOById(Integer id);


}
