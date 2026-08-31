package com.xworkz.library.dao;

import com.xworkz.library.Entity.BookEntity;

import java.util.List;

public interface BookDAO {
    boolean save(BookEntity entity);
    boolean saveAll(List<BookEntity> entityList);
    BookEntity findBookEntityById(Integer id);
    List<BookEntity> readAllBookEntity();
}
