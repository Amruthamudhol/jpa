package com.xworkz.JobBridge.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "job_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "location")
    private String location;

    @Column(name = "job_type")
    private String jobType;

    @Column(name = "salary")
    private Double salary;
}
