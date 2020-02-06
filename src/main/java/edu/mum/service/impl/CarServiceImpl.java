package edu.mum.service.impl;


import edu.mum.domain.Car;
import edu.mum.repository.CarRepository;
import edu.mum.service.CarService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAll() {
        return (List<Car> )carRepository.findAll();
    }

    @Override
    public List<Car> getAllCarByOwner(long userId) {
        return carRepository.findByOwnerId(userId);
    }

    @Override
    public Car getById(Long id) {
        return carRepository.getById(id);
    }

    @Override
    public void updateCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void save(Car car) {
            carRepository.save(car);
    }


    @Override
    public void deleteCarById(Long carId) {
        carRepository.delete(carId);
    }

    @Override
    public List<String> getBrands() {
        List<String> brandList = new ArrayList<String>();
        brandList.add("BMW");
        brandList.add("BENZ");
        brandList.add("FORD");
        brandList.add("HYUNDAI");
        brandList.add("LEXUS");
        brandList.add("NISSAN");
        brandList.add("TOYOTA");
        brandList.add("VOLKSWAGEN");
        return brandList;
    }

//    @Override
//    public List<Car> searchCars(String searchString) {
//        return carRepository.findAllByCarBrandContainingOrModelContainingOrDescriptionContainingOrderByDescription(searchString);
//    }


}
