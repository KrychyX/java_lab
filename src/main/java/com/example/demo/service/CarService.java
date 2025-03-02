package com.example.demo.service;

import com.example.demo.thing.Car;

import java.util.List;

public interface CarService {

    void addCar(Car car);

    List<Car> getCars();

    Car getCar(int id);

    boolean deleteCar(int id);

    boolean updateCar(Car car, int id);
}
