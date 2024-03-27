package com.carshopexample.carsapi.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String email;

    @Setter
    @Getter
    private String password;

    @Getter
    @OneToMany(mappedBy = "user")
    private List<Car> cars;

    // getters and setters
}