package com.xworkz.library.service;

import com.xworkz.library.dto.BookDTO;

public interface BookService {
    boolean validateAndSave(BookDTO dto);
}
