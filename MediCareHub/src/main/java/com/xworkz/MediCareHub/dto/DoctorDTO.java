package com.xworkz.MediCareHub.dto;

import lombok.*;
import javax.validation.constraints.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DoctorDTO {
    @NotBlank(message = "Doctor Name is Required")
    @Size(min = 3, max = 25, message = "Doctor Name should be between 3 and 25 characters")
    private String doctorName;

    @NotBlank(message = "Specialization is Required")
    private String specialization;

    @NotBlank(message = "Email is Required")
    @Email(message = "Enter proper mail Id")
    private String email;

    @NotNull(message = "Phone Number is Required")
    private Long phoneNumber;

    @NotNull(message = "Experience is Required")
    private Integer experience;


    private String status;
}
