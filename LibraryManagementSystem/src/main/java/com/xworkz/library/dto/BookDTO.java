package com.xworkz.library.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookDTO {

        private Integer id;
        private String title;
        private String author;
        private String category;
        private Double price;
        private Integer quantity;

        public BookDTO(String title, String author, String category, double price, int quantity) {

                this.title = title;
                this.author = author;
                this.category = category;
                this.price = price;
                this.quantity = quantity;
        }
    }

