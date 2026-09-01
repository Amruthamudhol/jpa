package com.xworkz.MovieZone.service;

import com.xworkz.MovieZone.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    boolean validateAndSave(MovieDTO dto);
    String saveAll(List<MovieDTO> dtoList);
    List<MovieDTO> readAllMovieDTO();

        MovieDTO findMovieDTOById(Integer id);
    List<MovieDTO> getMoviesByDirectorAndGenre(String director, String genre);
    List<MovieDTO> getMoviesByGenreAndLanguage(String genre, String language);
    MovieDTO getMovieByTitleAndLanguage(String title, String language);
    MovieDTO getMovieByDirectorAndTitle(String director, String title);



}
