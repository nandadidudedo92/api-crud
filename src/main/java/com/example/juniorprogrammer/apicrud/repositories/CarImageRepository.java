package com.example.juniorprogrammer.apicrud.repositories;

import com.example.juniorprogrammer.apicrud.entities.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarImageRepository extends JpaRepository<CarImage, Integer> {
}
