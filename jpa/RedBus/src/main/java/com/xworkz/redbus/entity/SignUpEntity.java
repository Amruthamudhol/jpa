package com.xworkz.redbus.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@Entity
@ToString
@Table(name = "signUp_info")
public class SignUpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email_Id")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private Long phoneNumber;
}