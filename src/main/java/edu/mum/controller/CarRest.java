package edu.mum.controller;

import edu.mum.domain.Car;
import edu.mum.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
 public class CarRest {

    @Autowired
    CarService carService;

    @RequestMapping(value = "/rest/cars/list", method = RequestMethod.GET)
    public @ResponseBody String  listAll(Model model)
    {
        System.out.println("GET ---- lIST");
        System.out.println(carService.getAll().size());
        return  carService.getAll().toString();
  }

//    @RequestMapping(value = "/list/{carnumber}", method = RequestMethod.GET)
//    public Car changeInformationPerson(@PathVariable("username") String username) {
//        List<Car> cars = carService.findByEmail(username);
//        Car car = cars != null && cars.size() > 0 ?
//                cars.get(0) : null;
//        return car;
//    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateCar(@Valid @RequestBody Car car) {
        carService.updateCar(car);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void saveCar(@Valid @RequestBody Car car) {
        carService.save(car);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void savePerson(@Valid @RequestBody Car car) {
        carService.deleteCarById(car.getId());
    }

}
