package com.example.juniorprogrammer.apicrud.services;

import com.example.juniorprogrammer.apicrud.entities.CarEntity;
import com.example.juniorprogrammer.apicrud.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public CarEntity addCar(CarEntity param) {

        return carRepository.save(param);
    }

    @Override
    public List<CarEntity> getallCar() {
        return carRepository.findAll();
    }

    @Override
    public CarEntity getCarById(int id) {
        return carRepository.findById(id).get();
    }

    @Override
    public CarEntity updateCar(CarEntity param) {

        CarEntity findCar = carRepository.findById(param.getId()).get();
        findCar.setCarName(param.getCarName());
        findCar.setColor(param.getColor());
        findCar.setNumber(param.getNumber());
        findCar.setType(param.getType());

        return carRepository.save(findCar);
    }

    @Override
    public void deleteCar(int id) {
        carRepository.deleteById(id);

    }
}
