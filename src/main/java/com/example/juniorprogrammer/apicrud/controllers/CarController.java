package com.example.juniorprogrammer.apicrud.controllers;

import com.example.juniorprogrammer.apicrud.entities.CarEntity;
import com.example.juniorprogrammer.apicrud.repositories.CarRepository;
import com.example.juniorprogrammer.apicrud.response.CommonResponse;
import com.example.juniorprogrammer.apicrud.response.CommonResponseGenerator;
import com.example.juniorprogrammer.apicrud.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "car")
public class CarController {


    @Autowired
    CarService carService;

    @Autowired
    CommonResponseGenerator commonResponseGenerator;

    @GetMapping(value = "checkAPI")
    public CommonResponse<String> checkApi() {
        return commonResponseGenerator.successResponse("Hello World", "Success check api");
    }

    @PostMapping(value = "addNewCar")
    public CommonResponse<CarEntity> addNewCar(@RequestBody CarEntity param) {

        CarEntity car = carService.addCar(param);

        return commonResponseGenerator.successResponse(car, "Success Add New Car");
    }

    @GetMapping(value = "getAllCar")
    public CommonResponse<List<CarEntity>> getAllCar(){

        List<CarEntity> carList = carService.getallCar();

        return commonResponseGenerator.successResponse(carList, "Success Get all Car");
    }

    @GetMapping(value = "getById")
    public CommonResponse<CarEntity> getById(@RequestParam int id) {

        CarEntity car = carService.getCarById(id);

        return commonResponseGenerator.successResponse(car, "Success Get Car By Id: "+id);
    }

    @PostMapping(value = "UpdateCar")
    public CommonResponse<CarEntity> updateCar(@RequestBody CarEntity param) {

        CarEntity car = carService.updateCar(param);

        return commonResponseGenerator.successResponse(car, "Success Update Car id: "+car.getId());
    }

    @GetMapping(value = "deleteCar")
    public CommonResponse<List<CarEntity>> deleteCar(@RequestParam int id) {

        carService.deleteCar(id);

        List<CarEntity> carList = carService.getallCar();

        return commonResponseGenerator.successResponse(carList, "Success Delete Car id: "+id);
    }

}
