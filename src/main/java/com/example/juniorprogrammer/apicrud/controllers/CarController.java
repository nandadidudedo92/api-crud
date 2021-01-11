package com.example.juniorprogrammer.apicrud.controllers;

import com.example.juniorprogrammer.apicrud.entities.CarEntity;
import com.example.juniorprogrammer.apicrud.repositories.CarRepository;
import com.example.juniorprogrammer.apicrud.response.CommonResponse;
import com.example.juniorprogrammer.apicrud.response.CommonResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "car")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CommonResponseGenerator commonResponseGenerator;

    @GetMapping(value = "checkAPI")
    public CommonResponse<String> checkApi() {
        return commonResponseGenerator.successResponse("Hello Kakak","Success check API");
    }

    @PostMapping(value = "addNewCar")
    public CarEntity addNewCar(@RequestBody CarEntity param) {

        carRepository.save(param);
        return param;
    }

    @GetMapping(value = "getAllCar")
    public List<CarEntity> getAllCar(){
        return carRepository.findAll();
    }

    @GetMapping(value = "getById")
    public CarEntity getById(@RequestParam int id) {
        return carRepository.findById(id).get();
    }

    @PostMapping(value = "UpdateCar")
    public CarEntity updateCar(@RequestBody CarEntity param) {
        return carRepository.save(param);
    }

    @GetMapping(value = "deleteCar")
    public List<CarEntity> deleteCar(@RequestParam int id) {
        carRepository.deleteById(id);

        List<CarEntity> carList = carRepository.findAll();

        return carList;
    }

}
