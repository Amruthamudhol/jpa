package com.xworkz.MediCareHub.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DoctorDTO {
    private String doctorName;
    private String specialization;
    private String email;
    private Long phoneNumber;
    private Integer experience;
}
