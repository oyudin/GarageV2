package com.example.garage.service;

import com.example.garage.model.Car;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
public class CarService {

    public static List<Car> cars = new ArrayList<>();

    @Autowired
    public CarService(List<Car> cars) {
        CarService.cars = cars;
    }

    int carCounter = 1;

    public Car createCar(Car car) {
        car.setId(carCounter++);
        cars.add(car);
        return car;
    }

    public Car getCar(int id) {
        for (Car car : cars) {
            if (car.getId() == id)
                return car;
        }
        return null; // ???
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public Car updateCar(int id, Car car) {
        for (Car car1 : cars) {
            if (car1.getId() == id) {
                car1.setBrand(car.getBrand());
                car1.setColor(car.getColor());
                car1.setModel(car.getModel());
                car1.setNumber(car.getNumber());
                return car1;
            }
        }
        return null;
    }

    public List<Car> removeCar(int id) {
        cars.removeIf(car -> car.getId() == id);
        return cars;
    }
}
