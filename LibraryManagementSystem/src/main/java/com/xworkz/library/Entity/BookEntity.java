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
@NamedQuery(name = "getBooksByAuthorAndCategory", query = "SELECT e FROM BookEntity e WHERE e.author = :author AND e.category = :category")
@NamedQuery(name = "getBooksByCategoryAndPrice", query = "SELECT e FROM BookEntity e WHERE e.category = :category AND e.price <= :price")
@NamedQuery(name = "getBookByTitleAndAuthor", query = "SELECT e FROM BookEntity e WHERE e.title = :title AND e.author = :author")

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
