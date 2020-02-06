package edu.mum.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Role;
import edu.mum.domain.User;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import java.util.List;

@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/index","/welcome"} , method = RequestMethod.GET)
    public String index() {
        return "welcome";
    }

    @RequestMapping(value = {"/login"} , method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"/signup"} , method = RequestMethod.GET)
    public String signUp(@ModelAttribute("userSignup") User user, Model model) {
        List<Role> roles = new ArrayList<>();
        roles.add(Role.ADMIN);
        roles.add(Role.OWNER);
        roles.add(Role.RENTER);
        model.addAttribute("roles", roles);
        return "signup";
    }

    @RequestMapping(value = {"/dashboard123 "} , method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView dashboard(HttpSession session) {
        return new ModelAndView("dashboard");
    }
}
