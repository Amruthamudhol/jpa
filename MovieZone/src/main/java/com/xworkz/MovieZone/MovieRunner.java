package com.xworkz.MovieZone;

import com.xworkz.MovieZone.dto.MovieDTO;
import com.xworkz.MovieZone.service.MovieService;
import com.xworkz.MovieZone.service.impl.MovieServiceImpl;

public class MovieRunner {
    public static void main(String[] args) {
        MovieDTO dto = new MovieDTO("KGF Chapter 1", "Prashanth Neel", "Action", "Kannada", 8.4);
        MovieService service = new MovieServiceImpl();

        boolean isSaved = service.validateAndSave(dto);
    }


}
