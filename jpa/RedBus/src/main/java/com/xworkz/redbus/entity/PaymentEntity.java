package com.xworkz.redbus.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "payment_info")
@Getter
@Setter
@ToString
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "booking_id")
    private Integer bookingId;

    @Column(name = "name")
    private String name;

    @Column(name = "email_Id")
    private String email;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "payment_date")
    private String paymentDate;
}
