package com.example.demo.thing;


/**
 * Класс, представляющий автомобиль.
 * Содержит информацию о идентификаторе, скорости, годе выпуска и марке автомобиля.
 */
public class Car {

    private Integer id;
    private int speed;
    private int year;
    private String mark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
