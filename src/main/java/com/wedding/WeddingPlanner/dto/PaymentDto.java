package com.wedding.WeddingPlanner.dto;

import com.wedding.WeddingPlanner.entity.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PaymentDto {
    private Long id;


    private String paymentDate;
    private Double amount;
    private  String status;

    private Client client;

}
