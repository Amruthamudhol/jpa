package com.xworkz.redbus.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "feedback_info")
@Getter
@Setter
@ToString
public class FeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email_Id")
    private String email;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "message")
    private String message;
}
