package edu.mum.controller;


import edu.mum.domain.User;
import edu.mum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String  getAllUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "userList";
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String getByUserId(@PathVariable long userId, Model model) {
        model.addAttribute(userService.getByUserId(userId));
        return "user";
    }

    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    public String updateUserStatus(@ModelAttribute("newUser") User user, Model model) {
        userService.updateUserStatus(user);
        model.addAttribute("user",user);
        return "userList";
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.POST)
    public String deleteUserById(@PathVariable long userId, Model model) {
        userService.deleteUserById(userId);
        return "userList";
    }

}
