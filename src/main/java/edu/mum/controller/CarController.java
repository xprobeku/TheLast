
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class CarController {
    @Autowired
    CarService carService;
    static String saveDirectory = "uploadedFiles";
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
        car.setStatus("PENDING");
        return "carform";
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(@Valid @ModelAttribute("car") Car car, BindingResult result, HttpSession session, HttpServletRequest request)  {
        if(result.hasErrors()){
            return "carform";
        }
        
    	MultipartFile productImage = car.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
				
			if (productImage!=null && !productImage.isEmpty()) {
		       try {
			      	productImage.transferTo(new File(rootDirectory + File.separator  + "resources" + File.separator  
			                   + "images" + File.separator + car.getId() + ".png"));
			      	System.out.println(productImage);
		       } catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
		   }
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

    @RequestMapping(value="/editsave", method = RequestMethod.POST)
    public String editSave(@Valid @ModelAttribute("car")Car car, BindingResult result){
        if(result.hasErrors())
            return "/editcar/{id}";
        //change after session complete * ADMIN can change
        car.setAvailable(true);
        car.setStatus("PENDING");

        carService.updateCar(car);
        return "redirect:/viewcar";
    }

    @RequestMapping(value="/deletecar/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id){
        carService.deleteCarById(id);
        return "viewcar";
    }
}
