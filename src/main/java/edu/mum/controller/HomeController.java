package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/index"} , method = RequestMethod.GET)
    public String index() {
        String str = "uya";
        return "welcome";
    }

    @RequestMapping(value = "/cars" , method = RequestMethod.GET)
    public String manageCar() {
        return "cars";
    }

}
