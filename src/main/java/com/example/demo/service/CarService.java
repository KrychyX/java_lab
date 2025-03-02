package com.example.demo.service;

import com.example.demo.thing.Car;
import java.util.List;

/**
 * Интерфейс, предоставляющий методы для управления автомобилями.
 * Включает операции добавления, получения, обновления и удаления автомобилей.
 */
public interface CarService {

    /**
     * Добавляет новый автомобиль в систему.
     */
    void addCar(Car car);

    /**
     * Возвращает список всех автомобилей.
     */
    List<Car> getCars();

    /**
     * Возвращает автомобиль по его идентификатору.
     */
    Car getCar(int id);

    /**
     * Удаляет автомобиль по его идентификатору.
     */
    boolean deleteCar(int id);

    /**
     * Обновляет информацию об автомобиле по его идентификатору.
     */
    boolean updateCar(Car car, int id);
}