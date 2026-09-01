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

//read
@NamedQuery(name = "findAllJobEntity", query = "select j from JobEntity j")
@NamedQuery(name = "findJobByJobTitle", query = "SELECT j FROM JobEntity j WHERE j.jobTitle = :jobTitle")
@NamedQuery(name = "getJobsByCompanyAndLocation", query = "SELECT e FROM JobEntity e WHERE e.companyName = :companyName AND e.location = :location")
@NamedQuery(name = "getJobsByTypeAndLocation", query = "SELECT e FROM JobEntity e WHERE e.jobType = :jobType AND e.location = :location")
@NamedQuery(name = "getJobByTitleAndCompany", query = "SELECT e FROM JobEntity e WHERE e.jobTitle = :jobTitle AND e.companyName = :companyName")
@NamedQuery(name = "getJobByCompanyTypeLocation", query = "SELECT e FROM JobEntity e WHERE e.companyName = :companyName AND e.jobType = :jobType AND e.location = :location")
//update
@NamedQuery(name = "updateJobByJobTitle", query = "UPDATE JobEntity j SET j.jobTitle = :jobTitle WHERE j.id = :id")
@NamedQuery(name = "updateJobByCompanyName", query = "UPDATE JobEntity j SET j.companyName = :companyName WHERE j.id = :id")
@NamedQuery(name = "updateJobByLocation", query = "UPDATE JobEntity j SET j.location = :location WHERE j.id = :id")

//delete
@NamedQuery(name = "deleteJobByJobTitle", query = "DELETE FROM JobEntity j WHERE j.jobTitle = :jobTitle")
@NamedQuery(name = "deleteJobByCompanyName", query = "DELETE FROM JobEntity j WHERE j.companyName = :companyName")


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
