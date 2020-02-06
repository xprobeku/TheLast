package edu.mum.controller;

import edu.mum.domain.Car;
import edu.mum.domain.Tag;
import edu.mum.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
 public class CarRest {

    @Autowired
    CarService carService;

    List<Tag> data = new ArrayList<Tag>();

    CarRest() {
        // init data for testing
        data.add(new Tag(1, "ruby"));
        data.add(new Tag(2, "rails"));
        data.add(new Tag(3, "c / c++"));
        data.add(new Tag(4, ".net"));
        data.add(new Tag(5, "python"));
        data.add(new Tag(6, "java"));
        data.add(new Tag(7, "javascript"));
        data.add(new Tag(8, "jscript"));

    }

    @RequestMapping(value = "/getTags", method = RequestMethod.GET)
    public @ResponseBody
    List<Tag> getTags(@RequestParam String tagName) {

        System.out.println(tagName + "((((((((((((((((((((");

        return simulateSearchResult(tagName);
    }

    private List<Tag> simulateSearchResult(String tagName) {

        List<Tag> result = new ArrayList<Tag>();

        // iterate a list and filter by tagName
        for (Tag tag : data) {
            if (tag.getTagName().contains(tagName)) {
                result.add(tag);
            }
        }

        return result;
    }


    @RequestMapping(method=RequestMethod.POST)
    public String post(String q, Model model) {
        model.addAttribute("queryParam", q);
        return "listsearch";
    }

    @RequestMapping(value = "/rest/cars/list", method = RequestMethod.GET)
    public @ResponseBody String  listAll(Model model)
    {
        System.out.println("GET ---- lIST");
        System.out.println(carService.getAll().size());
        return  carService.getAll().toString();
  }
//    @RequestMapping(value = "/rest/cars/list", method = RequestMethod.GET)
//    public @ResponseBody List<Car>  listAll(Model model)
//    {
//        System.out.println("GET ---- lIST");
//        System.out.println(carService.getAll().size());
//        return  carService.getAll();
//    }


    @RequestMapping(value="/cars", method=RequestMethod.GET)
    public String getCars(Model model){
        List<Car> list = carService.getAll();
        model.addAttribute("list", list);
        return "cars";
    }

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
