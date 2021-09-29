package com.example.juniorprogrammer.apicrud.services;

import com.example.juniorprogrammer.apicrud.entities.CarEntity;
import com.example.juniorprogrammer.apicrud.entities.CarImage;
import com.example.juniorprogrammer.apicrud.wrappers.CarImageWrapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface CarService {

    CarEntity addCar(CarEntity param);

    List<CarEntity> getallCar();

    CarEntity getCarById(int id);

    CarEntity updateCar(CarEntity param);

    void deleteCar(int id);

    CarImage upload(CarImageWrapper carImageWrapper);
}
