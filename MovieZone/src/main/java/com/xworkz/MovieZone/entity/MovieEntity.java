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
