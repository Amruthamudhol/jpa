package com.xworkz.MovieZone.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieDTO {
    private String title;
    private String director;
    private String genre;
    private String language;
    private Double rating;
}
