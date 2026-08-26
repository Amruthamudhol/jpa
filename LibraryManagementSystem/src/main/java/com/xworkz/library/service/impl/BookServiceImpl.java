package com.xworkz.library.service.impl;

import com.xworkz.library.Entity.BookEntity;
import com.xworkz.library.dao.BookDAO;
import com.xworkz.library.dao.impl.BookDAOimpl;
import com.xworkz.library.dto.BookDTO;
import com.xworkz.library.service.BookService;

public class BookServiceImpl implements BookService {
    BookDAO bookDAO = new BookDAOimpl();

    @Override
    public boolean validateAndSave(BookDTO dto) {
        System.out.println("Invoking validateAndSave : BookServiceImpl");
        boolean isSaved = false;
        if (dto != null) {

            // DTO -> Entity
            BookEntity entity = new BookEntity();

            entity.setTitle(dto.getTitle());
            entity.setAuthor(dto.getAuthor());
            entity.setCategory(dto.getCategory());
            entity.setPrice(dto.getPrice());
            entity.setQuantity(dto.getQuantity());

            boolean saved = bookDAO.save(entity);
            if (saved) {
                isSaved = true;
                System.out.println("Data Saved");
            } else {
                isSaved = false;
                System.out.println("Data Not Saved");
            }

        } else {
            System.out.println("Data is Empty");
        }

        return isSaved;
    }

}
