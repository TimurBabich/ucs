package com.ucs.controller;

import com.ucs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ucs.service.UserService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Timur Babich on 25.10.2017.
 */

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody List<User> getAllUsers(){
        return userService.getUsersList("admin", "admin");
    }

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public ModelAndView validate(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userfromserver", new User());
        modelAndView.setViewName("users_check");
        return modelAndView;
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public @ResponseBody List<User> checkUser(@ModelAttribute("userfromserver") User user){
        List<User> list = userService.getUsersList(user.getLogin(), user.getPassword());
//        if (user.getLogin().equals("admin") && user.getPassword().equals("admin"))
//            return "valid";
//        else
//            return "invalid";
        return list;
    }
}
