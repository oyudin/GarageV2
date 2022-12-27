package com.example.garage.controller;

import com.example.garage.model.Person;
import com.example.garage.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/Persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PutMapping
    public @ResponseBody Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @GetMapping("/{id}")
    public @ResponseBody Person getPerson(@PathVariable int id) {
        return personService.getPerson(id);
    }

    @GetMapping("/garage")
    public String getAll(Model model) {
        model.addAttribute("persons", personService.getPersons());
        return "garage";
    }

    @PostMapping("/{id}")
    public @ResponseBody Person updatePerson(@PathVariable int id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody Person deletePerson(@PathVariable int id) {
        return personService.deletePerson(id);
    }


    @PostMapping("/{id}/addCar/{carId}")
    public @ResponseBody Person addCar(@PathVariable int id, @PathVariable int carId) {
        return personService.addCar(id, carId);
    }

    @DeleteMapping("{id}/deleteCar/{carId}")
    public @ResponseBody Person deleteCar(@PathVariable int id, @PathVariable int carId) {
        return personService.removeCar(id, carId);
    }
}
