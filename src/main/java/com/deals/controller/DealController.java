package com.deals.controller;

import com.deals.model.Category;
import com.deals.model.City;
import com.deals.model.Deal;
import com.deals.model.User;
import com.deals.service.DealService;
import com.deals.service.StaticDataService;
import com.deals.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DealController {

    @Autowired
    DealService dealService;
    @Autowired
    UserService userService;
    @Autowired
    StaticDataService staticDataService;

    @RequestMapping(value={"/","/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();


        if(!(auth instanceof AnonymousAuthenticationToken)){
            User user = userService.findUserByEmail(auth.getName());
            modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
            modelAndView.addObject("userMessage","Content Available Only for authorised Users and Admin");
            modelAndView.addObject("user",user);
        }

        List<Deal> deals= dealService.getAll();
        modelAndView.addObject("deals",deals);



        modelAndView.setViewName("index");
        return modelAndView;
    }


    @RequestMapping(value="/user/deals", method = RequestMethod.GET)
    public ModelAndView userDeals() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("userMessage","Content Available Only for authorised Users and Admin");

        List<Deal> deals= dealService.getAll().stream().filter((e)->e.getUserid()==user.getId()).collect(Collectors.toList());
        modelAndView.addObject("deals",deals);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("/user/deals");
        return modelAndView;
    }

    @RequestMapping(value = {"/user/profile"}, method = RequestMethod.GET)
    public ModelAndView profile() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("user",user);
        modelAndView.setViewName("/user/profile");
        return modelAndView;
    }

    @RequestMapping(value="/user/deals/new", method = RequestMethod.GET)
    public ModelAndView createDeal(){
        ModelAndView modelAndView = new ModelAndView();
        Deal deal = new Deal();
        List<City> cities=staticDataService.getAllCities();
        modelAndView.addObject("cities",cities);

        List<Category> categories=staticDataService.getAllCategories();
        modelAndView.addObject("categories",categories);

        modelAndView.setViewName("deal");
        modelAndView.addObject("deal",deal);
        return modelAndView;
    }
    @RequestMapping(value="/user/deals/new", method = RequestMethod.POST)
    public ModelAndView saveDeal(@Valid Deal deal, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        deal.setCategoryid(1).setUserid(user.getId());
        modelAndView.addObject("successMessage", "Deal has been created successfully");
        modelAndView.addObject("deal", deal);
        modelAndView.setViewName("redirect:/index");
            dealService.saveDeal(deal);
        return modelAndView;
    }

    @RequestMapping(value = "user/deals/edit/{dealid}", method = RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute Deal deal,BindingResult result, @PathVariable Long dealid, Model model) {
        ModelAndView modelAndView=new ModelAndView();
        deal = dealService.findDealById(dealid);

        if (deal == null) {
            result.rejectValue("dealid", "error.deal", "Deal with such id doesn't exist");
        }
        if (result.hasErrors()) {
            modelAndView.setViewName("/deal");
        } else {
            //modelAndView.addObject("deal", deal);
            modelAndView.setViewName("/deal");
            model.addAttribute("deal", deal);
        }
        return modelAndView;

    }

    @RequestMapping(value="/user/deals/delete/{dealid}", method = RequestMethod.GET)
    public ModelAndView deleteDeal(@PathVariable Long dealid) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user/deals");
        dealService.deleteDealById(dealid);
        return modelAndView;
    }


}
