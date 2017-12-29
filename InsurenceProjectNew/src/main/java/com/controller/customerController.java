package com.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.entity.CustomerBills;
import com.entity.InsurancePlan;
import com.entity.Location;
import com.entity.PlanBenefits;
import com.service.ICustomerBillsService;
import com.service.ICustomerService;
import com.service.IInsurancePlanService;
import com.validators.UserValidator;

@Controller
public class customerController {

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private IInsurancePlanService insurancePlanService;

	@Autowired
	private ICustomerBillsService customerBillsService;
	
	@Autowired
	private ICustomerBillsService billsService;

	private HttpSession session;

	@RequestMapping(value = "registerUser", method = RequestMethod.GET)
	public String register(ModelMap model) {
		model.addAttribute("customer", new Customer());
		return "registerUser";
		// return new ModelAndView("registerUser", "customer", new Customer());
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("customer") @Validated Customer customer, BindingResult bindingResult) {
		// ModelAndView model = new ModelAndView();

		if (bindingResult.hasErrors()) {
			return new ModelAndView("registerUser");
		} else {
			Customer customerCompare = customerService.getCustomerByEmail(customer.getEmail());
			if (customerCompare == null) {
				System.out.println(customer);
				customerService.createCustomer(customer);

				return new ModelAndView("login", "msg", "welcome \n you need to login now");
			} else {
				return new ModelAndView("registerUser", "msg", "Email address already exists");
			}
		}
	}

	@RequestMapping(value = "dologin", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("customer") Customer customer, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();

		if (customer.getEmail().equals("admin@admin") && customer.getPswd().equals("123")) {
			model.setViewName("adminPage");
			System.out.println("--------------sdvvg");
			session = request.getSession();
			session.setAttribute("username", customer.getEmail());
		} else {
			Customer cus = customerService.getCustomerByEmail(customer.getEmail());
			if (cus != null) {
				if (cus.getPswd().equals(customer.getPswd())) {
					session = request.getSession();
					session.setAttribute("username", customer.getEmail());
					model.setViewName("home");
					model.addObject("customer", cus);
					if (cus.getPlan() != null) {
						model.addObject("menu1", "Your plan");
						model.addObject("ref1", "plan");
					} else {
						model.addObject("menu1", "Apply");
						model.addObject("ref1", "applyForm");
					}
					model.addObject("menu2", "Your bills");
					model.addObject("menu3", "Details");

					model.addObject("ref2", "customerBill");
				} else {
					model.setViewName("login");
					model.addObject("msg", "Username or password invalid");
				}
			} else {
				model.addObject("msg", "enter a valid username");
				model.setViewName("login");
			}
		}
		return model;
	}

	@RequestMapping("login")
	public String login() {
		return "login";
	}

	@RequestMapping("plan")
	public ModelAndView plan(HttpServletRequest request, ModelMap modelMap) {
		modelMap.addAttribute("plan", new InsurancePlan());
		session = request.getSession(false);
		if (session.getAttribute("username") == null) {
			System.out.println("it came to plan");
			return new ModelAndView("login", "msg", "your need to login first");

		} else {
			Customer cus = customerService.getCustomerByEmail((String) session.getAttribute("username"));
			ModelAndView model = new ModelAndView();
			if (cus.getPlan() == null) {

				List<InsurancePlan> plans = insurancePlanService.getAll();
				List<PlanBenefits> benefits = new ArrayList<PlanBenefits>();
				model.addObject("menu1", "Your plan");
				model.addObject("ref1", "plan");
				model.addObject("menu2", "Your bills");
				model.addObject("ref2", "bills");
				model.addObject("benefits", benefits);
				model.addObject("plans", plans);
				model.addObject("customer", cus);
				model.setViewName("apply");
				return model;

			} else {
				InsurancePlan plan = cus.getPlan();
				List<PlanBenefits> benefits = plan.getPlanBenefits();
				model.addObject("plan", plan);
				model.addObject("benefits", benefits);
				model.setViewName("Plan");
				model.addObject("menu1", "Update your plan");
				model.addObject("ref1", "upgradePlan");
				model.addObject("menu2", "Your bills");
				model.addObject("ref2", "customerBill");

				return model;
			}
		}
	}

	@RequestMapping(value = "doapply", method = RequestMethod.POST)
	public ModelAndView doapply(@ModelAttribute("plan") @Validated InsurancePlan plan, HttpServletRequest request,
			BindingResult bindingResult) {

		session = request.getSession(false);
		if (session.getAttribute("username").equals(null)) {
			return new ModelAndView("login", "msg", "you need to login first");
		} else {
			Customer customer = customerService.getCustomerByEmail((String) session.getAttribute("username"));
			customer.setPlan(plan);
			InsurancePlan insurancePlan = insurancePlanService.findOne(plan.getId());
			customerService.updateCusomer(customer);
			System.out.println(plan.getId());
			System.out.println(plan);
			ModelAndView model = new ModelAndView();
			model.addObject("menu1", "Your Plan");
			model.addObject("ref1", "plan");
			model.addObject("msg", "thanks for applying for an insuransce plan");
			model.addObject("menu2", "Your bills");
			model.addObject("ref2", "customerBill");
			model.addObject("plan", plan);
			model.setViewName("Plan");
			CustomerBills bill = new CustomerBills();
			bill.setAmount(insurancePlan.getPrice());
			bill.setDateIssued(new Date());
			System.out.println(plan.getPrice());
			bill.setCustomer(customer);
			billsService.save(bill);
			return model;

		}

	}

//	@RequestMapping(value = "bills")
//	public ModelAndView bills(HttpServletRequest request) {
//		session = request.getSession(false);
//		ModelAndView model = new ModelAndView();
//		if (session.getAttribute("username") == null) {
//			model.setViewName("login");
//			model.addObject("msg", "You need to login first");
//			System.out.println("it came here if");
//		} else {
//			Customer customer = customerService.getCustomerByEmail((String) session.getAttribute("username"));
//			List<CustomerBills> bills = customer.getBills();
//			model.addObject("customer", customer);
//			model.addObject("bills", bills);
//			model.addObject("menu1", "Your plan");
//			model.addObject("ref1", "plan");
//			model.addObject("menu2", "Your Bills");
//			model.addObject("ref2", "customerBill");
//			model.setViewName("customerbill");
//			System.out.println("it came here else");
//		}
//		return model;
//	}

	@RequestMapping(value = "logout")
	public String logout() {
		if (session == null) {
			return "../../index";
		} else {
			session.setAttribute("username", null);
			;
			return "../../index";
		}
	}

	@RequestMapping(value = "upgradePlan")
	public ModelAndView upgrade(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		session = request.getSession(false);
		if (session.getAttribute("username").equals(null)) {
			model.addObject("msg", "you need to login first");
			model.setViewName("login");
		} else {
			Customer cus = customerService.getCustomerByEmail((String) session.getAttribute("username"));
			List<InsurancePlan> plans = insurancePlanService.getAll();

			List<PlanBenefits> benefits = new ArrayList<PlanBenefits>();

			model.addObject("plan", new InsurancePlan());
			model.addObject("menu1", "Your plan");
			model.addObject("ref1", "plan");
			model.addObject("menu2", "Your bills");
			model.addObject("ref2", "customerBill");
			model.addObject("benefits", benefits);
			model.addObject("plans", plans);
			model.addObject("customer", cus);
			model.setViewName("apply");

		}
		return model;
	}

	@RequestMapping(value = "applyForm")
	public ModelAndView apply(@ModelAttribute("customer") Customer customer, HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		session = request.getSession(false);
		if (session.getAttribute("username").equals(null)) {
			model.addObject("msg", "you need to login first");
			model.setViewName("login");
		} else {
			model.addObject("menu1", "Back");
			model.addObject("ref1", "home");
			model.addObject("menu2", " ");
			model.addObject("customer", customer);
			model.addObject("ref2", "");
			model.setViewName("applyForm");
		}
		return model;

	}

	@RequestMapping(value = "address", method = RequestMethod.POST)
	public ModelAndView addresst(@ModelAttribute("customer") Customer customer, HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		session = request.getSession(false);
		if (session.getAttribute("username").equals(null)) {
			model.addObject("msg", "you need to login first");
			model.setViewName("login");
		} else {
			Customer cus = customerService.getCustomerByEmail((String) session.getAttribute("username"));
			cus.setStreet(customer.getStreet());
			cus.setApt(customer.getApt());
			cus.setCity(customer.getCity());
			cus.setState(customer.getState());
			cus.setZip(customer.getZip());
			customerService.updateCusomer(cus);
			model.addObject("menu1", "Back");
			model.addObject("ref1", "applyForm");
			model.addObject("menu2", " ");
			model.addObject("customer", cus);
			model.addObject("ref2", "");
			model.setViewName("physicalInf");
		}
		return model;
	}

	@RequestMapping(value = "physicalInf", method = RequestMethod.POST)
	public ModelAndView physicalInf(@ModelAttribute("customer") Customer customer, HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		session = request.getSession(false);
		if (session.getAttribute("username").equals(null)) {
			model.addObject("msg", "you need to login first");
			model.setViewName("login");
		} else {
			Customer cus = customerService.getCustomerByEmail((String) session.getAttribute("username"));
			cus.setHeight(customer.getHeight());
			cus.setWeight(customer.getWeight());
			cus.setAllergies(customer.getAllergies());
			cus.setAsma(customer.isAsma());
			cus.setAnnualIncome(customer.getAnnualIncome());
			customerService.updateCusomer(cus);
			ModelMap map = new ModelMap();
			model = plan(request, map);
			model.addObject("plan", new InsurancePlan());
		}
		return model;
	}
	@RequestMapping("customerBill")
	public ModelAndView customerBiil(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		session = request.getSession(false);
		if (session.getAttribute("username").equals(null)) {
			model.addObject("msg", "you need to login first");
			model.setViewName("login");
		} else {
			Customer customer = customerService.getCustomerByEmail((String)session.getAttribute("username"));
			List<CustomerBills> bills = billsService.getBillByCustomer(customer);
			model.addObject("customer", customer);
			model.addObject("menu1", "Your Plan");
			model.addObject("ref1", "plan");
			model.addObject("menu2", "Bills paid");
			model.addObject("ref2", "billpaid");
			model.addObject("menu3", "Bills Not paid");
			model.addObject("ref3", "billNotpaid");
			model.addObject("bills", bills);
			model.setViewName("customerbill");
		}
		return model;
	}
	@RequestMapping("billNotpaid")
	public ModelAndView billNotpaid(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		session = request.getSession(false);
		if (session.getAttribute("username").equals(null)) {
			model.addObject("msg", "you need to login first");
			model.setViewName("login");
		} else {
			Customer customer = customerService.getCustomerByEmail((String)session.getAttribute("username"));
			List<CustomerBills> bills = billsService.getPaid(customer);
			model.addObject("customer", customer);
			model.addObject("menu1", "Your Plan");
			model.addObject("ref1", "plan");
			model.addObject("menu2", "Bills paid");
			model.addObject("ref2", "billpaid");
			model.addObject("menu3", "Bills Not paid");
			model.addObject("ref3", "billNotpaid");
			model.addObject("bills", bills);
			model.setViewName("customerbill");
			System.out.println(bills);
		}
		return model;
	}
	@RequestMapping("billpaid")
	public ModelAndView billpaid(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		session = request.getSession(false);
		if (session.getAttribute("username").equals(null)) {
			model.addObject("msg", "you need to login first");
			model.setViewName("login");
		} else {
			Customer customer = customerService.getCustomerByEmail((String)session.getAttribute("username"));
			List<CustomerBills> bills = billsService.getNotPaid(customer);
			model.addObject("customer", customer);
			model.addObject("menu1", "Your Plan");
			model.addObject("ref1", "plan");
			model.addObject("menu2", "Bills paid");
			model.addObject("ref2", "billpaid");
			model.addObject("menu3", "Bills Not paid");
			model.addObject("ref3", "billNotpaid");
			model.addObject("bills", bills);
			model.setViewName("customerbill");
		}
		return model;
	}
}
