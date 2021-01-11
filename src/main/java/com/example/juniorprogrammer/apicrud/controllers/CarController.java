package com.example.juniorprogrammer.apicrud.controllers;

import com.example.juniorprogrammer.apicrud.entities.CarEntity;
import com.example.juniorprogrammer.apicrud.repositories.CarRepository;
import com.example.juniorprogrammer.apicrud.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "car")
public class CarController {


    @Autowired
    CarService carService;

    @GetMapping(value = "checkAPI")
    public String checkApi() {
        return "Hello World";
    }

    @PostMapping(value = "addNewCar")
    public CarEntity addNewCar(@RequestBody CarEntity param) {

        CarEntity car = carService.addCar(param);

        return car;
    }

    @GetMapping(value = "getAllCar")
    public List<CarEntity> getAllCar(){

        List<CarEntity> carList = carService.getallCar();

        return carList;
    }

    @GetMapping(value = "getById")
    public CarEntity getById(@RequestParam int id) {

        CarEntity car = carService.getCarById(id);

        return car;
    }

    @PostMapping(value = "UpdateCar")
    public CarEntity updateCar(@RequestBody CarEntity param) {

        CarEntity car = carService.updateCar(param);

        return car;
    }

    @GetMapping(value = "deleteCar")
    public List<CarEntity> deleteCar(@RequestParam int id) {

        carService.deleteCar(id);

        List<CarEntity> carList = carService.getallCar();

        return carList;
    }

}
