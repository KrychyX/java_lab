package com.example.demo.controller;

import com.example.demo.service.CarService;
import com.example.demo.thing.Car;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для управления автомобилями.
 * Предоставляет REST API для добавления, получения, обновления и удаления автомобилей.
 */
@RestController
public class MainController {

    private final CarService carService;

    /**
     * Конструктор с внедрением зависимости сервиса автомобилей.
     *
     * @param carService сервис для работы с автомобилями
     */
    @Autowired
    public MainController(CarService carService) {
        this.carService = carService;
    }

    /**
     * Добавляет новый автомобиль.
     *
     * @param car объект автомобиля для добавления
     * @return ответ с HTTP-статусом CREATED
     */
    @PostMapping("/cars")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        carService.addCar(car);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Возвращает список всех автомобилей.
     *
     * @return ответ со списком автомобилей и HTTP-статусом OK, если список не пуст,
     *         иначе ответ с HTTP-статусом NOT_FOUND
     */
    @GetMapping(value = "/cars")
    public ResponseEntity<List<Car>> getAllCars() {
        final List<Car> cars = carService.getCars();
        return cars != null && !cars.isEmpty()
                ? new ResponseEntity<>(cars, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Возвращает автомобиль по его идентификатору.
     *
     * @param id идентификатор автомобиля
     * @return ответ с объектом автомобиля и HTTP-статусом OK, если автомобиль найден,
     *         иначе ответ с HTTP-статусом NOT_FOUND
     */
    @GetMapping(value = "/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable int id) {
        final Car car = carService.getCar(id);
        return car != null
                ? new ResponseEntity<>(car, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Обновляет информацию об автомобиле по его идентификатору.
     *
     * @param id идентификатор автомобиля
     * @param car объект автомобиля с обновленными данными
     * @return ответ с HTTP-статусом OK, если автомобиль обновлен,
     *         иначе ответ с HTTP-статусом NOT_MODIFIED
     */
    @PutMapping("/cars/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable int id, @RequestBody Car car) {
        final boolean exists = carService.getCar(id) != null;
        return exists
                ? new ResponseEntity<>(car, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаляет автомобиль по его идентификатору.
     *
     * @param id идентификатор автомобиля
     * @return ответ с HTTP-статусом OK, если автомобиль удален,
     *         иначе ответ с HTTP-статусом NOT_MODIFIED
     */
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable int id) {
        final boolean deleted = carService.deleteCar(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}