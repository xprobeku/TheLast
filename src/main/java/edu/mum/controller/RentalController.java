package edu.mum.controller;

import edu.mum.domain.Car;
import edu.mum.domain.Rental;
import edu.mum.domain.User;
import edu.mum.service.CarService;
import edu.mum.service.RentalService;
import edu.mum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RentalController {

    @Autowired
    RentalService rentalService;
    @Autowired
    CarService carService;

    //login in user id is needed in the session
    @RequestMapping(value="/rent/{id}")
    public String saveRent(@PathVariable("id") Long carId, Rental rental, Model model){
        rentalService.createRental(rental, carId);
        model.addAttribute("rental", rental);
        return "rental";
    }

    @RequestMapping(value = "/viewAllRentals")
    public String viewRentals(Model model,HttpSession session){
        User user = (User) session.getAttribute("user");

        List<Rental> rentals = rentalService.getAll();
        model.addAttribute("rentals", rentals);
        return "rentals";
    }

    @RequestMapping(value = "/rental/approve/{rentalId}")
    public String approveRental(@PathVariable Long rentalId, Rental rental)
    {
        rentalService.rentalApprove(rentalId);
        return "redirect:/viewAllRentals";
    }
    @RequestMapping(value = "/rental/decline/{rentalId}")
    public String declineRental(@PathVariable Long rentalId, Rental rental)
    {
        rentalService.rentalReject(rentalId, "Rent is not accepted");
        return "redirect:/viewAllRentals";
    }

    @RequestMapping(value = "/rental/returned/{rentalId}")
    public String returnedRental(@PathVariable Long rentalId, Rental rental)
    {
        rentalService.rentalFinish(rentalId);
        return "redirect:/viewAllRentals";
    }

}
