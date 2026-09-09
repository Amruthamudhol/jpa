package com.xworkz.library.dto;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookDTO {

        private Integer id;
        @NotBlank(message = "Title cannot be empty")
        @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
        private String title;

        @NotBlank(message = "Author cannot be empty")
        @Size(min = 2, max = 50, message = "Author must be between 2 and 50 characters")
        private String author;

        @NotBlank(message = "Category cannot be empty")
        private String category;

        @NotNull(message = "Price cannot be null")
        @Positive(message = "Price must be greater than 0")
        private Double price;

        @NotNull(message = "Quantity cannot be null")
        @Min(value = 1, message = "Quantity must be at least 1")
        private Integer quantity;

        public BookDTO(String title, String author, String category, double price, int quantity) {

                this.title = title;
                this.author = author;
                this.category = category;
                this.price = price;
                this.quantity = quantity;
        }
    }

