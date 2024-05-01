package com.internalreport.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "email")
    private String email;

    @Column(name = "total")
    private Double total;

    @Column(name = "shipping_cost")
    private Double shippingCost;

    @Column(name = "date")
    private String date;

    @Column(name = "tax")
    private Double tax;

    @Column(name = "margin")
    private Double margin;
}
