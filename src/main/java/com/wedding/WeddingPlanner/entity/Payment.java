package com.wedding.WeddingPlanner.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    private String paymentDate;
    private Double amount;
    private  String status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
