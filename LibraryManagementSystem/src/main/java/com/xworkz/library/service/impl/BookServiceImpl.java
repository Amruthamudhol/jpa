package com.xworkz.library.service.impl;

import com.xworkz.library.Entity.BookEntity;
import com.xworkz.library.dao.BookDAO;
import com.xworkz.library.dao.impl.BookDAOimpl;
import com.xworkz.library.dto.BookDTO;
import com.xworkz.library.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


    @Override
    public String saveAll(List<BookDTO> dtoList) {

        System.out.println("Invoking saveAll : BookServiceImpl");

        String isSaved = null;

        if (dtoList != null) {

            System.out.println("List of DTO : " + dtoList);

            List<BookEntity> entityList = new ArrayList<>();
            for (BookDTO dto : dtoList) {

                BookEntity entity = new BookEntity();
                entity.setTitle(dto.getTitle());
                entity.setAuthor(dto.getAuthor());
                entity.setCategory(dto.getCategory());
                entity.setPrice(dto.getPrice());
                entity.setQuantity(dto.getQuantity());

                entityList.add(entity);
            }

            boolean status = bookDAO.saveAll(entityList);

            if (status) {
                isSaved = "Data Saved in database";
            } else {
                isSaved = "Data Not Saved in database";
            }

        } else {

            isSaved = "Data is Empty";
        }

        return isSaved;
    }

    @Override
    public BookDTO findBookDTOById(Integer id) {

        System.out.println("Invoking findBookDTOById : BookServiceImpl");
        if (id != null) {

            BookEntity entity = bookDAO.findBookEntityById(id);
            if (entity != null) {
                BookDTO dto = new BookDTO();

                dto.setId(entity.getId());
                dto.setTitle(entity.getTitle());
                dto.setAuthor(entity.getAuthor());
                dto.setCategory(entity.getCategory());
                dto.setPrice(entity.getPrice());
                dto.setQuantity(entity.getQuantity());

                return dto;
            }
        }
        return null;
    }


    @Override
    public List<BookDTO> readAllBookDTO() {

        System.out.println("readAllBookDTO : BookServiceImpl");

        List<BookEntity> entityList = bookDAO.readAllBookEntity();

        List<BookDTO> dtoList = entityList.stream()
                .map(entity -> {
                    BookDTO dto = new BookDTO();

                    dto.setId(entity.getId());
                    dto.setTitle(entity.getTitle());
                    dto.setAuthor(entity.getAuthor());
                    dto.setCategory(entity.getCategory());
                    dto.setPrice(entity.getPrice());
                    dto.setQuantity(entity.getQuantity());

                    return dto;
                })
                .collect(Collectors.toList());
        return dtoList;
    }


    @Override
    public List<BookDTO> getBooksByAuthorAndCategory(String author, String category) {

        List<BookDTO> dtoList = new ArrayList<>();

        List<BookEntity> entityList = bookDAO.getBooksByAuthorAndCategory(author, category);

        for (BookEntity entity : entityList) {

            BookDTO dto = new BookDTO();

            dto.setTitle(entity.getTitle());
            dto.setAuthor(entity.getAuthor());
            dto.setCategory(entity.getCategory());
            dto.setPrice(entity.getPrice());
            dto.setQuantity(entity.getQuantity());

            dtoList.add(dto);
        }

        return dtoList;
    }


    @Override
    public List<BookDTO> getBooksByCategoryAndPrice(String category, Double price) {

        List<BookDTO> dtoList = new ArrayList<>();
        List<BookEntity> entityList = bookDAO.getBooksByCategoryAndPrice(category, price);

        for (BookEntity entity : entityList) {

            BookDTO dto = new BookDTO();

            dto.setTitle(entity.getTitle());
            dto.setAuthor(entity.getAuthor());
            dto.setCategory(entity.getCategory());
            dto.setPrice(entity.getPrice());
            dto.setQuantity(entity.getQuantity());

            dtoList.add(dto);
        }

        return dtoList;
    }


    @Override
    public BookDTO getBookByTitleAndAuthor(String title, String author) {

        BookEntity entity = bookDAO.getBookByTitleAndAuthor(title, author);

        BookDTO dto = null;

        if (entity != null) {

            dto = new BookDTO();

            dto.setTitle(entity.getTitle());
            dto.setAuthor(entity.getAuthor());
            dto.setCategory(entity.getCategory());
            dto.setPrice(entity.getPrice());
            dto.setQuantity(entity.getQuantity());
        }

        return dto;
    }

    @Override
    public String updateBookPriceByTitle(String title, Double price) {

        System.out.println("Invoking updateBookPriceByTitle : Service");

        String status = null;
        if (title != null && price != null) {

            Boolean isUpdated = bookDAO.updateBookPriceByTitle(title, price);
            if (isUpdated) {
                status = "Data Updated";
            } else {
                status = "Data Not Updated";
            }
        }

        return status;
    }


    @Override
    public String updateBookQuantityByAuthor(String author, Integer quantity) {
        System.out.println("Invoking updateBookQuantityByAuthor : Service");

        String status = null;

        if (author != null && quantity != null) {
            Boolean isUpdated = bookDAO.updateBookQuantityByAuthor(author, quantity);
            if (isUpdated) {
                status = "Data Updated";
            } else {
                status = "Data Not Updated";
            }
        }

        return status;
    }
}
