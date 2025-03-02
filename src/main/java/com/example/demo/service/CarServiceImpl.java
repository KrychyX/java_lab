package com.example.demo.service;

import com.example.demo.thing.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CarServiceImpl implements CarService {
    private static final Map<Integer, Car> CAR_MAP = new HashMap<>();

    private static final AtomicInteger ID_HOLDER = new AtomicInteger();

    @Override
    public void addCar(Car car) {
        final int carId = ID_HOLDER.getAndIncrement();
        car.setId(carId);
        CAR_MAP.put(carId, car);
    }

    @Override
    public List<Car> getCars() {
        return new ArrayList<>(CAR_MAP.values());
    }

    @Override
    public Car getCar(int id) {
        return CAR_MAP.get(id);
    }

    @Override
    public boolean deleteCar(int id) {
        return CAR_MAP.remove(id) != null;
    }

    @Override
    public boolean updateCar(Car car, int id) {
        if(CAR_MAP.containsKey(id)){
            car.setId(id);
            CAR_MAP.put(id, car);
            return true;
        }

        return false;
    }
}
