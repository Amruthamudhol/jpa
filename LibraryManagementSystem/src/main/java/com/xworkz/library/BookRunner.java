package com.xworkz.library;

import com.xworkz.library.dto.BookDTO;
import com.xworkz.library.service.BookService;
import com.xworkz.library.service.impl.BookServiceImpl;

public class BookRunner {
    public static void main(String[] args) {

        BookDTO dto = new BookDTO("Java Programming", "James Gosling", "Programming", 1000.0, 25);

        BookService service = new BookServiceImpl();
        boolean isSaved = service.validateAndSave(dto);


    }

}
