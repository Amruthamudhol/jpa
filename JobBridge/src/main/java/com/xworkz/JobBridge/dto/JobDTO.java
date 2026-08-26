package com.xworkz.JobBridge.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JobDTO {
    private String jobTitle;
    private String companyName;
    private String location;
    private String jobType;
    private Double salary;
}
