package com.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ICustomerDao;
import com.entity.Customer;
import com.service.ICustomerService;
import com.validators.UserValidator;

@Controller
public class customerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private UserValidator customerValidator; 
	
	@RequestMapping(value="registerUser", method=RequestMethod.GET)
	public String register(ModelMap model) {
		model.addAttribute("customer", new Customer());
		return "registerUser";
//		return  new ModelAndView("registerUser", "customer", new Customer());
	}
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("customer")@Validated Customer customer, BindingResult bindingResult) {
//		ModelAndView model = new ModelAndView();
		
		if (bindingResult.hasErrors()) {
			return new ModelAndView("registerUser");
		} else {
		Customer customerCompare = customerService.getCustomerByEmail(customer.getEmail());
		if(customerCompare == null) {
			System.out.println(customer);
			customerService.createCustomer(customer);
			
			return new ModelAndView("login", "msg", "welcome \n you need to login now");
		} else {
			return new ModelAndView("registerUser", "msg", "Email address already exists");
		}
		}
	}
	
	@RequestMapping(value="dologin", method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("customer")Customer customer) {
		Customer cus = customerService.getCustomerByEmail(customer.getEmail());
		ModelAndView model = new ModelAndView();
		if(cus!=null) {
			System.out.println("-------");
			System.out.println(cus.getPswd());
			System.out.println("-------");
			System.out.println(customer.getPswd());
			System.out.println("-------");
			if(cus.getPswd().equals(customer.getPswd())) {
				model.setViewName("home");
				model.addObject("customer", cus);
			} else {
				model.setViewName("login");
				model.addObject("msg", "Username or password invalid");
			}
		} else {
			model.addObject("msg", "enter a valid username");
			model.setViewName("login");
		}
		return model;
	}
	@RequestMapping("login")
	public String login() {
		return "login";
	}
}
