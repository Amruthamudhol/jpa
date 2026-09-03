package com.xworkz.library.service;

import com.xworkz.library.dto.BookDTO;

import java.util.List;

public interface BookService {
    boolean validateAndSave(BookDTO dto);
    String saveAll(List<BookDTO> dtoList);
    BookDTO findBookDTOById(Integer id);

    List<BookDTO> readAllBookDTO();
    List<BookDTO> getBooksByAuthorAndCategory(String author, String category);
    List<BookDTO> getBooksByCategoryAndPrice(String category, Double price);
    BookDTO getBookByTitleAndAuthor(String title, String author);

    String updateBookPriceByTitle(String title, Double price);
    String updateBookQuantityByAuthor(String author, Integer quantity);

    List<String> getAuthors();
    List<Object> getCategories();

}
