package com.example.garage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
public class Person {
    private int id;
    private String name;
    private String surname;
    private final List<Car> cars = new ArrayList<>();
}
