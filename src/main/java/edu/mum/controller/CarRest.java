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

// TODO 4 : make class as a Controller Spring Bean
@Controller
public class CarRest {

    private final CarService carService;

    List<Tag> data = new ArrayList<Tag>();

    // TODO 5:  autowiring by Type in constructor argument.
    @Autowired
    CarRest(CarService carservice) {

        this.carService = carservice;

        data.add(new Tag(1, "TOYOTA"));
        data.add(new Tag(2, "AUDIO"));
        data.add(new Tag(3, "FORD"));
        data.add(new Tag(4, "Honda"));
        data.add(new Tag(5, "BMW "));
        data.add(new Tag(6, "Nissan"));
        data.add(new Tag(7, "Lexus"));
        data.add(new Tag(8, "Volvo"));

    }

    @RequestMapping(value = "/getTags", method = RequestMethod.GET)
    // TODO 6 : return the body of the response using @ResponseBody
    public @ResponseBody
    List<Tag> getTags(@RequestParam String tagName) {

        System.out.println("tag name" + tagName );

        return SearchResult(tagName);
    }

    private List<Tag> SearchResult(String tagName) {

        List<Tag> result = new ArrayList<Tag>();

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

    // TODO 7 : Find by any text from database
    @RequestMapping(value = "/rest/cars/list/{modelname}", method = RequestMethod.GET)
    public @ResponseBody String  findByModel(@PathVariable("modelname") String modelname, Model model)
    {
        return  carService.searchCars(modelname).toString();
    }

    @RequestMapping(value="/cars", method=RequestMethod.GET)
    public String getCars(Model model){
        List<Car> list = carService.getAll();
        model.addAttribute("list", list);
        return "cars";
    }


}
