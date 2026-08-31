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
@NamedQuery(name = "findJobByCompanyName", query = "SELECT j FROM JobEntity j WHERE j.companyName = :companyName")
@NamedQuery(name = "findJobByLocation", query = "SELECT j FROM JobEntity j WHERE j.location = :location")
@NamedQuery(name = "findJobByJobType", query = "SELECT j FROM JobEntity j WHERE j.jobType = :jobType")
@NamedQuery(name = "findJobBySalary", query = "SELECT j FROM JobEntity j WHERE j.salary = :salary")

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
