package com.carshopexample.carsapi.repos;

import com.carshopexample.carsapi.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Cars, Long> {
}
