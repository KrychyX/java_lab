package com.example.demo.controller;


import com.example.demo.service.CarService;
import com.example.demo.thing.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    private final CarService carService;

    @Autowired
    public MainController(CarService carService){
        this.carService = carService;
    }

    @PostMapping(value = "/cars")
    public ResponseEntity<?> addCar(@RequestBody Car car){
        carService.addCar(car);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/Hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping(value ="/cars")
    public ResponseEntity<List<Car>> getAllCars(){
        final List<Car> cars = carService.getCars();
        return cars != null && !cars.isEmpty()
                ? new ResponseEntity<>(cars, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value ="/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable int id){
        final Car car = carService.getCar(id);

        return car != null
                ? new ResponseEntity<>(car, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value ="/cars/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable int id, @RequestBody Car car){
        final boolean exists = carService.getCar(id) != null;

        return exists
                ? new ResponseEntity<>(car, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value ="/cars/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable int id){
        final boolean deleted = carService.deleteCar(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}