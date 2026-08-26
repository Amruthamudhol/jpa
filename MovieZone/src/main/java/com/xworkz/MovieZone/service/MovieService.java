package com.xworkz.MovieZone.service;

import com.xworkz.MovieZone.dto.MovieDTO;

public interface MovieService {
    boolean validateAndSave(MovieDTO dto);
}
