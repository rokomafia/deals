package com.deals.controller;

import com.deals.model.Deal;
import com.deals.model.User;
import com.deals.service.DealService;
import com.deals.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class DealController {

    @Autowired
    DealService dealService;

    @Autowired
    UserService userService;

    @RequestMapping(value="/newdeal", method = RequestMethod.GET)
    public ModelAndView createDeal(){
        ModelAndView modelAndView = new ModelAndView();
        Deal deal = new Deal();
        modelAndView.setViewName("newdeal");
        modelAndView.addObject("newDeal",deal);
        return modelAndView;
    }
    @RequestMapping(value="/newdeal", method = RequestMethod.POST)
    public ModelAndView createDeal(@Valid Deal deal, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        deal.setCategoryid(1).setCityid(1).setUserid(user.getId());
            dealService.saveDeal(deal);
            modelAndView.addObject("successMessage", "Deal has been created successfully");
            modelAndView.addObject("deal", new Deal());
            modelAndView.setViewName("redirect:/index");
        return modelAndView;
    }

}
