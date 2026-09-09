package com.xworkz.MovieZone.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "movie_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@NamedQuery(name = "findAllMovie", query = "select m from MovieEntity m")
@NamedQuery(name = "findByTitle", query = "select m from MovieEntity m where m.title = :title")
@NamedQuery(name = "getMoviesByDirectorAndGenre", query = "SELECT e FROM MovieEntity e WHERE e.director = :director AND e.genre = :genre")
@NamedQuery(name = "getMoviesByGenreAndLanguage", query = "SELECT e FROM MovieEntity e WHERE e.genre = :genre AND e.language = :language")
@NamedQuery(name = "getMovieByTitleAndLanguage", query = "SELECT e FROM MovieEntity e WHERE e.title = :title AND e.language = :language")
@NamedQuery(name = "getMovieByDirectorAndTitle", query = "SELECT e FROM MovieEntity e WHERE e.director = :director AND e.title = :title")

@NamedQuery(name = "updateMovieGenreAndRatingByTitle", query = "UPDATE MovieEntity m " + "SET m.genre = :genre, m.rating = :rating " + "WHERE m.title = :title")
@NamedQuery(name = "updateMovieLanguageAndRatingByDirector", query = "UPDATE MovieEntity m " +"SET m.language = :language, m.rating = :rating " + "WHERE m.director = :director")
//delete
@NamedQuery(name = "deleteMovie", query = "delete from MovieEntity m where m.id = :id")
@NamedQuery(name = "deleteMovieByGenre", query = "delete from MovieEntity m where m.genre = :genre")
@NamedQuery(name = "getAllEntityToUpdateStatus", query = "SELECT e FROM MovieEntity e")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name = "title")
    private String title;

    @Column(name = "director")
    private String director;

    @Column(name = "genre")
    private String genre;

    @NonNull
    @Column(name = "language")
    private String language;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "status")
    private String status;

    @Column(name = "release_date")
    private LocalDate releaseDate;

}
