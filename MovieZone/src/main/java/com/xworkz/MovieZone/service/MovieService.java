package com.xworkz.MovieZone.service;

import com.xworkz.MovieZone.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    boolean validateAndSave(MovieDTO dto);
    String saveAll(List<MovieDTO> dtoList);


        MovieDTO findMovieDTOById(Integer id);


}
