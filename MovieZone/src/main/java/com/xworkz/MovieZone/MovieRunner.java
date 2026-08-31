package com.xworkz.MovieZone;

import com.xworkz.MovieZone.dto.MovieDTO;
import com.xworkz.MovieZone.service.MovieService;
import com.xworkz.MovieZone.service.impl.MovieServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class MovieRunner {
    public static void main(String[] args) {
        MovieDTO dto = new MovieDTO("KGF Chapter 1", "Prashanth Neel", "Action", "Kannada", 8.4);
        MovieService service = new MovieServiceImpl();

        boolean isSaved = service.validateAndSave(dto);


        List<MovieDTO> movieDTOList = new ArrayList<>();

        movieDTOList.add(new MovieDTO("KGF", "Prashanth Neel", "Action", "Kannada", 9.0));
        movieDTOList.add(new MovieDTO("RRR", "S. S. Rajamouli", "Action", "Telugu", 8.8));
        movieDTOList.add(new MovieDTO("3 Idiots", "Rajkumar Hirani", "Comedy", "Hindi", 8.4));

        String savedStatus = service.saveAll(movieDTOList);
        System.out.println(savedStatus);



        MovieDTO dtoById = service.findMovieDTOById(1);
        System.out.println("Found Dto is : " + dtoById);

        //getall
        List<MovieDTO> movieDTOList1= service.readAllMovieDTO();
        movieDTOList1.forEach(a -> System.out.println(a));
    }


}
