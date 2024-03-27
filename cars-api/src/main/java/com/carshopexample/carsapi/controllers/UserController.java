package com.carshopexample.carsapi.controllers;

import com.carshopexample.carsapi.model.Car;
import com.carshopexample.carsapi.model.User;
import com.carshopexample.carsapi.repos.CarRepository;
import com.carshopexample.carsapi.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.List;



@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private CarRepository carRepository;

    // Create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {

        // A jelszó hash eredményét tároljuk mindig biztonsági okokból.
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        return userRepository.save(user);
    }

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
    }

    // Update a user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
        user.setName(userDetails.getName());
        return userRepository.save(user);
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }

    // Get all cars for a specific user
    @GetMapping("/{id}/cars")
    public List<Car> getCarsByUser(@PathVariable Long id) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
        return user.getCars();
    }

    @DeleteMapping("/{userId}/cars/{carId}")
    public ResponseEntity<?> deleteCarByUser(@PathVariable Long userId, @PathVariable Long carId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("User not found"));
        Car car = carRepository.findById(carId).orElseThrow(() -> new Exception("Car not found"));

        if (!user.getCars().contains(car)) {
            throw new Exception("This car does not belong to the user");
        }

        carRepository.delete(car);
        return ResponseEntity.ok().build();
    }


}
