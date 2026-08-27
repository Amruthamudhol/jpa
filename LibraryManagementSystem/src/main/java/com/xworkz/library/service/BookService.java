package com.xworkz.library.service;

import com.xworkz.library.dto.BookDTO;

import java.util.List;

public interface BookService {
    boolean validateAndSave(BookDTO dto);
    String saveAll(List<BookDTO> dtoList);
    BookDTO findBookDTOById(Integer id);
}
