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

    @GetMapping(value = "test")
    public CommonResponse<String> checkApi() {
        return commonResponseGenerator.successResponse("Hello World", "Success check api");
    }

    @PostMapping(value = "addNewCar")
    public CommonResponse<CarEntity> addNewCar(@RequestBody CarEntity param) {
        try {
            CarEntity car = carService.addCar(param);
            return commonResponseGenerator.successResponse(car, "Success Add New Car");
        } catch (Exception e) {
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "getall")
    public CommonResponse<List<CarEntity>> getAllCar() {
        try {
            List<CarEntity> carList = carService.getallCar();
            return commonResponseGenerator.successResponse(carList, "Success Get all Car");
        } catch (Exception e) {
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "getById")
    public CommonResponse<CarEntity> getById(@RequestParam int id) {
        try {
            CarEntity car = carService.getCarById(id);
            return commonResponseGenerator.successResponse(car, "Success Get Car By Id: " + id);
        } catch (Exception e)  {
            return  commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @PostMapping(value = "updateCar")
    public CommonResponse<CarEntity> updateCar(@RequestBody CarEntity param) {
        try {
            CarEntity car = carService.updateCar(param);
            return commonResponseGenerator.successResponse(car, "Success Update Car id: " + car.getId());
        } catch (Exception e) {
            return commonResponseGenerator.failedResponse(e.getMessage()+" for id: "+param.getId());
        }
    }

    @GetMapping(value = "deleteCar")
    public CommonResponse<List<CarEntity>> deleteCar(@RequestParam int id) {
        try {
            carService.deleteCar(id);
            List<CarEntity> carList = carService.getallCar();
            return commonResponseGenerator.successResponse(carList, "Success Delete Car id: " + id);
        } catch (Exception e) {
            return  commonResponseGenerator.failedResponse(e.getMessage());
        }


    }

}
