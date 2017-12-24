package com.deals.controller;

import com.deals.model.Deal;
import com.deals.model.User;
import com.deals.service.DealService;
import com.deals.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DealController {

    @Autowired
    DealService dealService;

    @Autowired
    UserService userService;

    @RequestMapping(value="/user/home", method = RequestMethod.GET)
    public ModelAndView userHome() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("userMessage","Content Available Only for authorised Users and Admin");
        Deal deal = dealService.findDealByName("test");
        modelAndView.addObject("dealName", deal.getName());
        modelAndView.addObject("dealPrice", deal.getPrice());
        modelAndView.setViewName("/user/home");
        return modelAndView;
    }
}
