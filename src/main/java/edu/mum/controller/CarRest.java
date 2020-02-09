package edu.mum.controller;

import edu.mum.domain.Car;
import edu.mum.domain.Tag;
import edu.mum.service.CarService;
import edu.mum.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;


// TODO 4 : make class as a Controller Spring Bean
@Controller
public class CarRest {

    private final CarService carService;

    private final TagService tagService;

    List<Tag> data = new ArrayList<Tag>();

    // TODO 5:  autowiring by Type in constructor argument.
    @Autowired
    CarRest(CarService carservice, TagService tagService) {

        this.carService = carservice;
        this.tagService = tagService;

        data =  tagService.getAll();

        if(data.isEmpty())
        {
            data.add(new Tag(1, "TOYOTA"));
            data.add(new Tag(2, "AUDIO"));
            data.add(new Tag(3, "FORD"));
            data.add(new Tag(4, "Honda"));
            data.add(new Tag(5, "BMW "));
            data.add(new Tag(6, "Nissan"));
            data.add(new Tag(7, "Lexus"));
            data.add(new Tag(8, "Volvo"));
        }



    }

    @RequestMapping(value = "/getTags", method = RequestMethod.GET)
    public @ResponseBody  List<Tag> getTags(@RequestParam String tagName) {
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

    // TODO 7 : Find by any text from database
    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    public String  findByModel(@RequestParam("searchtext") String searchtext, Model model)
    {
        List<Car> list;
        if(searchtext.trim().equals(""))
        {
            list = carService.getAll();
        }else
        {
            list =    carService.searchCars(searchtext);;

        }

        model.addAttribute("list", list);

        return "cars";
    }

    @RequestMapping(value="/cars", method=RequestMethod.GET)
    public String getCars(Model model){

        List<Car> list = carService.getAll();
        model.addAttribute("list", list);
        return "cars";
    }


}
