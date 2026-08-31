package com.xworkz.library.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "book_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

//select
@NamedQuery(name = "findAllBook", query = "select b from BookEntity b")
@NamedQuery(name = "findByTitle", query = "select b from BookEntity b where b.title = :title")
@NamedQuery(name = "findByAuthor", query = "select b from BookEntity b where b.author = :author")
@NamedQuery(name = "findByCategory", query = "select b from BookEntity b where b.category = :category")
@NamedQuery(name = "findByPrice", query = "select b from BookEntity b where b.price = :price")

//update
@NamedQuery(name = "updateBookTitle", query = "update BookEntity b set b.title = :title where b.id = :id")
@NamedQuery(name = "updateBookPrice", query = "update BookEntity b set b.price = :price where b.id = :id")
@NamedQuery(name = "updateBookQuantity", query = "update BookEntity b set b.quantity = :quantity where b.id = :id")

//delete
@NamedQuery(name = "deleteBook", query = "delete from BookEntity b where b.id = :id")
@NamedQuery(name = "updateBookPrice", query = "update BookEntity b set b.price = :price where b.id = :id")


public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Integer quantity;
}
