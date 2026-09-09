package com.xworkz.MovieZone.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieDTO {

    @NotBlank(message = "Title cannot be empty")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;

    @NotBlank(message = "Director cannot be null")
    private String director;

    @NotBlank(message = "Genre cannot be empty")
    private String genre;

    @NotBlank(message = "Language cannot be empty")
    private String language;

    @NotNull(message = "Rating cannot be null")
    @Positive(message = "Rating must be greater than 0")
    private Double rating;

    @NotBlank(message = "Status cannot be empty")
    private String status;

    @PastOrPresent(message = "Release date cannot be a future date")
    private LocalDate releaseDate;

}
