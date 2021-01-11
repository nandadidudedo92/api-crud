package com.example.juniorprogrammer.apicrud.controllers;

import com.example.juniorprogrammer.apicrud.entities.CarEntity;
import com.example.juniorprogrammer.apicrud.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "car")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @GetMapping(value = "checkAPI")
    public String checkApi() {
        return "Hello World";
    }

    @PostMapping(value = "addNewCar")
    public CarEntity addNewCar(@RequestBody CarEntity param) {

        carRepository.save(param);
        return param;
    }

}
