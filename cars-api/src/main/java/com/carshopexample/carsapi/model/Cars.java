package com.carshopexample.carsapi.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;


@Entity
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    private String brand;
    @Setter
    @Getter
    private String type;
    @Setter
    @Getter
    private String descri;
    @Setter
    @Getter
    private int price;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private Users user;


    // getters and setters
}