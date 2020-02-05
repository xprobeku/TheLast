
/* *****************************************************************
 * @SID      610575
 * @Author   ERDENEBAYAR CHINBAT
 * @Created  Feb 04, 2020
 ******************************************************************/

package edu.mum.controller;

import edu.mum.domain.Car;
import edu.mum.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CarController {
    @Autowired
    CarService dao;

    @RequestMapping("/carform")
    public String showCars(Model model){
        model.addAttribute("command", new Car());
        return "carform";

    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(@ModelAttribute("cars") Car car){
        dao.save(car);
        return "redirect:/viewcar";
    }

    @RequestMapping(value="/viewcar")
    public String viewCar(Model model){
        List<Car> list = dao.getAll();
        model.addAttribute("list", list);
        return "viewcar";
    }

    @RequestMapping(value="/editcar/{id}")
    public String edit(@PathVariable Long id, Model model){
        Car car = dao.getById(id);
        model.addAttribute("command", car);
        return "careditform";
    }

    @RequestMapping(value="/editsave", method = RequestMethod.POST)
    public String editSave(@ModelAttribute("car")Car car){
        dao.updateCar(car);
        return "redirect:viewcar";
    }

    @RequestMapping(value="/deletecar/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id){
        dao.deleteCarById(id);
        return "redirect:/viewcar";
    }

}
