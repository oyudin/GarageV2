package com.example.garage.service;

import com.example.garage.model.Car;
import com.example.garage.model.Person;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class PersonService {
    private final List<Person> persons = new ArrayList<>();
    int personCounter = 1;


    public Person createPerson(Person person) {
        person.setId(personCounter++);
        persons.add(person);
        return person;
    }


    public Person getPerson(int id) {
        for (Person person : persons) {
            if (person.getId() == id)
                return person;
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "User is not found");
    }


    public Person updatePerson(int id, Person person) {
        for (Person person1 : persons) {
            if (person1.getId() == id) {
                person1.setName(person.getName());
                person1.setSurname(person.getName());
                return person1;
            }
        }
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "User is not found");
    }


    public Person deletePerson(int id) {
        for (Person person : persons) {
            if (person.getId() == id)
                persons.remove(person);
            return person;
        }
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "User is not found");
    }



    public Person addCar(int id, int carId) {
        for (Person person : persons) {
            if (person.getId() == id) {
                for (Car car : CarService.cars) {
                    if (car.getId() == carId)
                        person.getCars().add(car);
                }
                return person;
            }
        }
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "User or car is not found");
    }


    public Person removeCar(int id, int carId) {
        for (Person person : persons) {
            if (person.getId() == id) {
                person.getCars().removeIf(car -> car.getId() == carId);
                return person;
            }
        }
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "User or car is not found");
    }
}