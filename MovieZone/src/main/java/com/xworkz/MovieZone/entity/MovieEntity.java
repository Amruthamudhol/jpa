package com.xworkz.MovieZone.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "movie_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@NamedQuery(name = "findAllMovie", query = "select m from MovieEntity m")
@NamedQuery(name = "findByTitle", query = "select m from MovieEntity m where m.title = :title")
@NamedQuery(name = "findByDirector", query = "select m from MovieEntity m where m.director = :director")
@NamedQuery(name = "findByGenre", query = "select m from MovieEntity m where m.genre = :genre")
@NamedQuery(name = "findByLanguage", query = "select m from MovieEntity m where m.language = :language")

//update
@NamedQuery(name = "updateMovieTitle", query = "update MovieEntity m set m.title = :title where m.id = :id")
@NamedQuery(name = "updateMovieDirector", query = "update MovieEntity m set m.director = :director where m.id = :id")
@NamedQuery(name = "updateMovieRating", query = "update MovieEntity m set m.rating = :rating where m.id = :id")

//delete
@NamedQuery(name = "deleteMovie", query = "delete from MovieEntity m where m.id = :id")
@NamedQuery(name = "deleteMovieByGenre", query = "delete from MovieEntity m where m.genre = :genre")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "director")
    private String director;

    @Column(name = "genre")
    private String genre;

    @Column(name = "language")
    private String language;

    @Column(name = "rating")
    private Double rating;
}
