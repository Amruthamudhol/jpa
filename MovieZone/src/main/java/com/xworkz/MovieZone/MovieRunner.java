package com.xworkz.MovieZone;

import com.xworkz.MovieZone.dto.MovieDTO;
import com.xworkz.MovieZone.service.MovieService;
import com.xworkz.MovieZone.service.impl.MovieServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class MovieRunner {
    public static void main(String[] args) {
        MovieService service = new MovieServiceImpl();
       // MovieDTO dto = new MovieDTO("KGF Chapter 1", "Prashanth Neel", "Action", "Kannada", 8.4);
       // MovieDTO dto1= new MovieDTO("Toxic","Geetu Mohandas","Action","Multi-language", 8.0);

      //  boolean isSaved = service.validateAndSave(dto1);


        List<MovieDTO> movieDTOList = new ArrayList<>();

        movieDTOList.add(new MovieDTO("KGF", "Prashanth Neel", "Action", "Kannada", 9.0));
        movieDTOList.add(new MovieDTO("RRR", "S. S. Rajamouli", "Action", "Telugu", 8.8));
        movieDTOList.add(new MovieDTO("3 Idiots", "Rajkumar Hirani", "Comedy", "Hindi", 8.4));

       // String savedStatus = service.saveAll(movieDTOList);
       // System.out.println(savedStatus);



        //MovieDTO dtoById = service.findMovieDTOById(1);
        //System.out.println("Found Dto is : " + dtoById);

        //getall
      //  List<MovieDTO> movieDTOList1= service.readAllMovieDTO();
      //  movieDTOList1.forEach(a -> System.out.println(a));

       // List<MovieDTO> list = service.getMoviesByDirectorAndGenre("Rajkumar Hirani", "Comedy");
       // list.forEach(a -> System.out.println(a));


       // List<MovieDTO> list = service.getMoviesByGenreAndLanguage("Action", "Kannada");
       // list.forEach(a -> System.out.println(a));


       // MovieDTO dto2 = service.getMovieByTitleAndLanguage("Toxic", "Multi-language");
       // System.out.println("Movie DTO : " + dto2);



       // MovieDTO dto = service.getMovieByDirectorAndTitle("Geetu Mohandas", "Toxic");
       // System.out.println("Movie DTO : " + dto);

       // String status = service.updateMovieGenreAndRatingByTitle("RRR", "Action", 9.0);
       // System.out.println("Status : " + status);


      //  String status = service.updateMovieLanguageAndRatingByDirector("Rajkumar Hirani", "Kannada", 8.5);
    //    System.out.println("Status : " + status);


        //List<String> titles = service.getTitles();
          //  System.out.println(titles);



        List<Object> languages = service.getLanguages();
        for (Object language : languages) {
            System.out.println(language);
        }


     //   List<Object[]> movies = service.getTitleDirectorAndGenre();
     //   for (Object[] movie : movies) {
    //        System.out.println("Title: " + movie[0]);
     //       System.out.println("Director: " + movie[1]);
     //       System.out.println("Genre: " + movie[2]);
     //   }


        List<List<Object>> movies1 = service.getTitleAndLanguage();
        for (List<Object> movie : movies1) {
            System.out.println("Title: " + movie.get(0));
            System.out.println("Language: " + movie.get(1));
        }
    }


}
