package com.carshopexample.carsapi.repos;

import com.carshopexample.carsapi.model.Car;
import com.carshopexample.carsapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
