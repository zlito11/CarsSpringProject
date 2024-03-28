package com.carshopexample.carsapi.controllers;

import java.util.List;

import com.carshopexample.carsapi.model.Cars;
import com.carshopexample.carsapi.model.Users;
import com.carshopexample.carsapi.repos.CarRepository;
import com.carshopexample.carsapi.repos.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarRepository carRepository;
    private final UserRepository userRepository;

    public CarController(CarRepository carRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    // Create a new car
    @PostMapping("/{userId}")
    public Cars createCar(@PathVariable Long userId, @RequestBody Cars car) throws Exception {
        Users user = userRepository.findById(userId).orElseThrow(() -> new Exception("User not found"));
        car.setUser(user);
        return carRepository.save(car);
    }

    // Get all cars
    @GetMapping
    public List<Cars> getAllCars() {
        return carRepository.findAll();
    }

    // Get a car by id
    @GetMapping("/{id}")
    public Cars getCarById(@PathVariable Long id) throws Exception {
        return carRepository.findById(id).orElseThrow(() -> new Exception("Car not found"));
    }

    // Update a car
    @PutMapping("/{id}")
    public Cars updateCar(@PathVariable Long id, @RequestBody Cars carDetails) throws Exception {
        Cars car = carRepository.findById(id).orElseThrow(() -> new Exception("Car not found"));

        car.setBrand(carDetails.getBrand());
        car.setType(carDetails.getType());
        car.setDescri(carDetails.getDescri());
        car.setPrice(carDetails.getPrice());

        return carRepository.save(car);
    }


    // Delete a car
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id) throws Exception {
        Cars car = carRepository.findById(id).orElseThrow(() -> new Exception("Car not found"));
        carRepository.delete(car);
        return ResponseEntity.ok().build();
    }
}
