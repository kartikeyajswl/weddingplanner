package com.wedding.WeddingPlanner.dto;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ClientDto {
    private Long id;

    private String name;

    private String weddingDate;

    private Double budget;



}
