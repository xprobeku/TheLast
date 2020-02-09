
/* *****************************************************************
 * @SID      610575
 * @Author   ERDENEBAYAR CHINBAT
 * @Created  Feb 04, 2020
 ******************************************************************/

package edu.mum.controller;

import edu.mum.domain.Car;
import edu.mum.domain.User;
import edu.mum.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class CarController {
    @Autowired
    CarService carService;

    @RequestMapping("/carform")
    public String showCars(@ModelAttribute("car")Car car, Model model){
        model.addAttribute("brandList", carService.getBrands());
        car.setAvailable(true);
        car.setStatus("PENDING");
        return "carform";
    }

    @RequestMapping("/approvecar")
    public String approvecar(@ModelAttribute("car")Car car, Model model){
        model.addAttribute("brandList", carService.getBrands());
        car.setAvailable(true);
        car.setStatus("ACTIVE");
        return "carform";
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(@Valid @ModelAttribute("car") Car car, BindingResult result, HttpSession session){
        if(result.hasErrors()){
            return "carform";
        }

        car.setOwner((User)session.getAttribute("user"));
        car.setAvailable(true);
        car.setStatus("PENDING");
        carService.save(car);
        return "redirect:/viewcar";
    }

    @RequestMapping(value="/viewcar", method=RequestMethod.GET)
    public String viewCar(Model model){
        List<Car> list = carService.getAll();
        model.addAttribute("list", list);
        return "viewcar";
    }

    @RequestMapping(value="/viewapprovecar", method=RequestMethod.GET)
    public String viewapproveCar(Model model){
        List<Car> list = carService.getAll();
        model.addAttribute("list", list);
        return "approvecar";
    }

    @RequestMapping(value="/editcar/{id}", method=RequestMethod.GET)
    public String edit(@PathVariable Long id, Model model){
        Car car = carService.getById(id);
        model.addAttribute("car", car);
        model.addAttribute("brandList", carService.getBrands());
        model.addAttribute("command", car);
        return "careditform";
    }

    @RequestMapping(value="/editcar/editsave", method = RequestMethod.POST)
    public String editSave(@Valid @ModelAttribute("car")Car car, BindingResult result, HttpSession session){
        if(result.hasErrors())
            return "careditform";
        //change after session complete * ADMIN can change
        car.setAvailable(true);
        car.setStatus("PENDING");

        carService.updateCar(car);
        return "redirect:/viewcar";
    }

    @RequestMapping(value="/approve/{id}", method = RequestMethod.GET)
    public String editSave( @ModelAttribute("car")Car car, BindingResult result){
        if(result.hasErrors())
            return "careditform";
        //change after session complete * ADMIN can change
        car.setAvailable(true);
        car.setStatus("ACTIVE");

//        carService.updateCar(car);
        return "viewapprovecar";
    }

    @RequestMapping(value="/deletecar/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id){
        carService.deleteCarById(id);
        return "viewcar";
    }
}
