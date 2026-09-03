package com.xworkz.library.dao;

import com.xworkz.library.Entity.BookEntity;

import java.util.List;

public interface BookDAO {
    boolean save(BookEntity entity);
    boolean saveAll(List<BookEntity> entityList);
    BookEntity findBookEntityById(Integer id);
    List<BookEntity> readAllBookEntity();
    List<BookEntity> getBooksByAuthorAndCategory(String author, String category);
    List<BookEntity> getBooksByCategoryAndPrice(String category, Double price);
    BookEntity getBookByTitleAndAuthor(String title, String author);
    Boolean updateBookPriceByTitle(String title, Double price);
    Boolean updateBookQuantityByAuthor(String author, Integer quantity);
    List<String> getAuthors();
    List<Object> getCategories();
}
