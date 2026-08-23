package com.xworkz.redbus.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "signIn_info")
@Getter
@Setter
@ToString
public class SignInEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email_Id")
    private String email;

    @Column(name = "password")
    private String password;
}
