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
    public CommonResponse<CarEntity> addNewCar(@RequestBody CarEntity param) {

        carRepository.save(param);
        return commonResponseGenerator.successResponse(param, "Success add new data");
    }

    @GetMapping(value = "getAllCar")
    public CommonResponse<List<CarEntity>> getAllCar(){
        return commonResponseGenerator.successResponse(carRepository.findAll(), "Success get all data");
    }

    @GetMapping(value = "getById")
    public CommonResponse<CarEntity> getById(@RequestParam int id) {
        return commonResponseGenerator.successResponse(carRepository.findById(id).get(), "Success get data by id: "+id);
    }

    @PostMapping(value = "UpdateCar")
    public CommonResponse<CarEntity> updateCar(@RequestBody CarEntity param) {
        return commonResponseGenerator.successResponse(carRepository.save(param), "Success Update car");
    }

    @GetMapping(value = "deleteCar")
    public CommonResponse<List<CarEntity>> deleteCar(@RequestParam int id) {
        carRepository.deleteById(id);

        List<CarEntity> carList = carRepository.findAll();

        return commonResponseGenerator.successResponse(carList, "Success delete car id: "+id);
    }

}
