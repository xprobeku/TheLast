package edu.mum.service;


import edu.mum.domain.Car;

import java.io.IOException;
import java.util.List;

public interface CarService {
    List<Car> getAll();
    List<Car> getAllCarByOwner(long userId);
    Car getById(Long id);
    void save(Car car);
    void updateCar(Car car);
    void deleteCarById(Long carId);
    List<String> getBrands();
    List<Car> searchCars(String searchString);

}
