package com.xworkz.library;

import com.xworkz.library.dto.BookDTO;
import com.xworkz.library.service.BookService;
import com.xworkz.library.service.impl.BookServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class BookRunner {
    public static void main(String[] args) {

      //  BookDTO dto = new BookDTO("Java Programming", "James Gosling", "Programming", 1000.0, 25);
       // BookDTO dto1 = new BookDTO("The Alchemist", "Paulo Coelho", "Fiction", 150.0, 10);

        BookService service = new BookServiceImpl();
      // boolean isSaved = service.validateAndSave(dto1);

       List<BookDTO> bookDTOList = new ArrayList<>();

        bookDTOList.add(new BookDTO("Java Programming", "James Gosling", "Programming", 599.0, 10));
        bookDTOList.add(new BookDTO("Clean Code", "Robert Martin", "Programming", 799.0, 5));
        bookDTOList.add(new BookDTO("Effective Java", "Joshua Bloch", "Programming", 899.0, 8));

        //String savedStatus = service.saveAll(bookDTOList);

        //System.out.println(savedStatus);


        //BookDTO dtoById = service.findBookDTOById(1);
       // System.out.println("Found Dto is : " + dtoById);


       // List<BookDTO> bookDTOList1= service.readAllBookDTO();
      //  bookDTOList1.forEach(a -> System.out.println(a));


       //List<BookDTO> list = service.getBooksByAuthorAndCategory("James Gosling", "Programming");
      //list.forEach(a -> System.out.println(a));


        //List<BookDTO> list1 = service.getBooksByCategoryAndPrice("Programming", 500.0);
       // list1.forEach(a -> System.out.println(a));

       // BookDTO dto1 = service.getBookByTitleAndAuthor("The Alchemist", "Paulo Coelho");
     //  System.out.println("Book DTO : " + dto1);

       // String status = service.updateBookPriceByTitle("Java Programming", 599.0);
      //  System.out.println("Status : " + status);

        String status = service.updateBookQuantityByAuthor("Joshua Bloch", 25);
        System.out.println("Status : " + status);
    }

}
