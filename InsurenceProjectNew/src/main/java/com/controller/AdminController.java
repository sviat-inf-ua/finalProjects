package com.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Customer;
import com.entity.Doctor;
import com.entity.DoctorType;
import com.entity.InsurancePlan;
import com.entity.Location;
import com.entity.PlanBenefits;
import com.service.DoctorService;
import com.service.DoctorTypeService;
import com.service.ICustomerService;
import com.service.IInsurancePlanService;
import com.service.IPlanBenefitsService;
import com.service.LocationService;

@Controller
public class AdminController {

	private HttpSession session;

	@Autowired
	SessionFactory factory;

	@Autowired
	private DoctorTypeService doctorTypeService;

	@Autowired
	private LocationService locationService;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private IInsurancePlanService insurancePlanService;

	@Autowired
	private IPlanBenefitsService planBenefitsService;

	@Autowired
	private ICustomerService customerService;

	@RequestMapping("/contactUs")
	public String contactUs() {

		return "contactUs";
	}

	@GetMapping("/admin")
	public String adminPage(Model theModel, HttpServletRequest request) {

		session = request.getSession(false);
		System.out.println("session.getAttribute(\"username\") " + session.getAttribute("username"));
		String username = (String) session.getAttribute("username");
		if (session.getAttribute("username") == null) {
			theModel.addAttribute("msg", "Login first");
			return "login";
		} else if (!username.equals("admin@admin")) {
			theModel.addAttribute("msg", "Login as Admin");
			return "login";
		} else {

			List<Doctor> theDoctorsNAc = doctorService.getNotActive();
			List<Doctor> theDoctorsAc = doctorService.getActive();

			// add the customers to the model
			theModel.addAttribute("doctorsNAc", theDoctorsNAc);
			// add the customers to the model
			theModel.addAttribute("doctorsAc", theDoctorsAc);

			return "adminPage";
		}
	}

	@GetMapping("/showInsurancePlanForm")
	public String showInsurancePlanForm(Model theModel, HttpServletRequest request) {

		session = request.getSession(false);
		System.out.println("session.getAttribute(\"username\") " + session.getAttribute("username"));
		if (!session.getAttribute("username").equals("admin@admin")) {
			theModel.addAttribute("msg", "Login as Admin");
			return "login";
		} else {
			theModel.addAttribute("plan", new InsurancePlan());
			List<InsurancePlan> list = insurancePlanService.getAll();
			theModel.addAttribute("plans", list);
			return "plan-form";
		}
	}

	@GetMapping("/showPlanBenefitForm")
	public String showPlanBenefitForm(Model theModel, HttpServletRequest request) {
		session = request.getSession(false);
		System.out.println("session.getAttribute(\"username\") " + session.getAttribute("username"));
		if (!session.getAttribute("username").equals("admin@admin")) {
			theModel.addAttribute("msg", "Login as Admin");
			return "login";
		} else {
			List<InsurancePlan> list = insurancePlanService.getAll();
			List<PlanBenefits> list2 = planBenefitsService.getAll();
			theModel.addAttribute("list2", list2);
			theModel.addAttribute("plan", new InsurancePlan());
			theModel.addAttribute("list", list);
			// System.out.println(list2);
			// System.out.println(list);
			return "planbenefitForm";
		}
	}

	@PostMapping("/savePlanBenefit")
	public String saveBenefitsForm(@ModelAttribute("plan") InsurancePlan insurancePlan, Model theModel,
			ModelAndView model, HttpServletRequest request, @RequestParam("benefitId") int theId) {

		session = request.getSession(false);
		System.out.println("session.getAttribute(\"username\") " + session.getAttribute("username"));

		if (!session.getAttribute("username").equals("admin@admin")) {
			theModel.addAttribute("msg", "Login as Admin");
			return "login";
		} else {

			System.out.println("insurancePlan: " + insurancePlan);
			InsurancePlan plan = insurancePlanService.findOne(insurancePlan.getId());
			String[] Listbenefit = request.getParameterValues("benefitId");
			// System.out.println("array "+Listbenefit[0]);

			List<PlanBenefits> benefits = new ArrayList<PlanBenefits>();

			for (int i = 0; i < Listbenefit.length; i++) {
				System.out.println(" loop : " + Listbenefit[i]);

				System.out.println(planBenefitsService.findOne(Integer.parseInt(Listbenefit[i])));

				benefits.add(planBenefitsService.findOne(Integer.parseInt(Listbenefit[i])));
			}
			// System.out.println("the value is: "+theId);
			// System.out.println(planBenefitsService.getPlanBenefitById(theId));

			// benefits.add((planBenefitsService.getPlanBenefitById(theId)));
			System.out.println("bensffefits: " + benefits);

			/*
			 * List<PlanBenefits> benefits = new ArrayList<PlanBenefits>(); String[]
			 * Listbenefit = request.getParameterValues("benefits"); for (int i=0;
			 * i<Listbenefit.length; i++) {
			 * 
			 * int id = Integer.parseInt( request.getParameterValues("benefits")[i]);
			 * PlanBenefits benefit = planBenefitsService.getPlanBenefitById(id);
			 * benefits.add(benefit);
			 * 
			 * 
			 * }
			 */
			plan.setPlanBenefits(benefits);
			planBenefitsService.save(plan);

			// isu

			model.addObject("msg", "it was updated");
			model.setViewName("planbenefitForm");
			System.out.println("benefits: " + benefits);
			System.out.println("plan: " + plan);
			return "list-doctorTypes";
		}
	}

	@GetMapping("/showBenefitsForm")
	public String showBenefitsForm(Model theModel, HttpServletRequest request) {
		session = request.getSession(false);
		System.out.println("session.getAttribute(\"username\") " + session.getAttribute("username"));
		if (!session.getAttribute("username").equals("admin@admin")) {
			theModel.addAttribute("msg", "Login as Admin");
			return "login";
		} else {
			theModel.addAttribute("benefit", new PlanBenefits());
			return "benefits-form";
		}
	}

	@PostMapping("/saveInsurancePlanForm")
	public ModelAndView showInsurancePlanForm(@ModelAttribute("plan") InsurancePlan insurancePlan,
			HttpServletRequest request, Model theModel) {
		session = request.getSession(false);
		System.out.println("session.getAttribute(\"username\") " + session.getAttribute("username"));
		if (!session.getAttribute("username").equals("admin@admin")) {
			// theModel.addAttribute("msg", "Login as Admin");
			return new ModelAndView("login", "msg", "Login as Admin");
		} else {
			ModelAndView model = new ModelAndView();
			insurancePlanService.save(insurancePlan);
			model.addObject("plan", insurancePlan);
			model.setViewName("plan-form");
			return model;
		}
	}

	@PostMapping("/saveBenefits")
	public ModelAndView saveBenefitsForm(@ModelAttribute("benefit") PlanBenefits benefits, ModelAndView model,
			Model theModel, HttpServletRequest request) {
		session = request.getSession(false);
		System.out.println("session.getAttribute(\"username\") " + session.getAttribute("username"));
		if (!session.getAttribute("username").equals("admin@admin")) {
			// theModel.addAttribute();
			return new ModelAndView("login", "msg", "Login as Admin");
		} else {
			planBenefitsService.save(benefits);
			model.addObject("benefit", benefits);
			model.setViewName("benefits-form");
			return model;
		}
	}

	@PostMapping("/savePlanAndBenefits")
	public ModelAndView addplan(@ModelAttribute("benefit") PlanBenefits planBenefits, HttpServletRequest request) {
		session = request.getSession(false);
		System.out.println("session.getAttribute(\"username\") " + session.getAttribute("username"));
		if (!session.getAttribute("username").equals("admin@admin")) {
			// theModel.addAttribute();
			return new ModelAndView("login", "msg", "Login as Admin");
		} else {
			InsurancePlan insurancePlan = insurancePlanService.findOne(1);
			System.out.println(insurancePlan.getId());
			PlanBenefits plan = planBenefitsService.findOne(3);
			List<InsurancePlan> list = new ArrayList<InsurancePlan>();
			list.add(insurancePlan);
			plan.setPlan(list);
			planBenefitsService.save(plan);
			System.out.println(insurancePlan.getPlanBenefits());
			return new ModelAndView("planAndBenefits-form", "msg", "Benefit created");
		}
	}

	@GetMapping("/listCustomers")
	public String listCustomers(Model model, HttpServletRequest request) {
		session = request.getSession(false);
		System.out.println("session.getAttribute(\"username\") " + session.getAttribute("username"));
		if (!session.getAttribute("username").equals("admin@admin")) {
			model.addAttribute("msg", "Login as Admin");
			return "login";
		} else {
			List<Customer> theCustomers = customerService.getAllCustomers();
			model.addAttribute("customers", theCustomers);
			return "listCustomers";
		}
	}

	@GetMapping("/listDoctorTypes")
	public String listDocType(Model model, HttpServletRequest request) {
		session = request.getSession(false);
		System.out.println("session.getAttribute(\"username\") " + session.getAttribute("username"));
		if (!session.getAttribute("username").equals("admin@admin")) {
			model.addAttribute("msg", "Login as Admin");
			return "login";
		} else {
			List<DoctorType> theDoctorTypes = doctorTypeService.getAll();

			model.addAttribute("doctorTypes", theDoctorTypes);
			return "list-doctorTypes";
		}
	}

	@GetMapping("/showDoctorTypeForm")
	public String addDocTypeForm(Model theModel, HttpServletRequest request) {
		session = request.getSession(false);
		System.out.println("session.getAttribute(\"username\") " + session.getAttribute("username"));
		if (!session.getAttribute("username").equals("admin@admin")) {
			theModel.addAttribute("msg", "Login as Admin");
			return "login";
		} else {
			DoctorType theDoctorType = new DoctorType();
			List<Doctor> doctors = doctorService.getAll();
			theModel.addAttribute("doctors", doctors);
			theModel.addAttribute("doctorType", theDoctorType);

			return "doctorType-form";
		}
	}

	@PostMapping("/saveDoctorType")
	public String saveDocType(/* @RequestParam("doctorId") int theId, */ @ModelAttribute("doctorType") DoctorType theDoctorType,
			Doctor doctor, HttpServletRequest request, Model theModel) {
		session = request.getSession(false);
		System.out.println("session.getAttribute(\"username\") " + session.getAttribute("username"));
		if (!session.getAttribute("username").equals("admin@admin")) {
			theModel.addAttribute("msg", "Login as Admin");
			return "login";
		} else {
		// System.out.println("DOCtor TYPE1 :" + theDoctorType.getDoctortype());

		DoctorType doctorType = new DoctorType();
		doctor = doctorService.findOne(theDoctorType.getId());

		// theDoctorType = doctorService.findOne(theId);
		doctorType.setDoctor(doctor);
		doctorType.setDoctortype(theDoctorType.getDoctortype());

		// System.out.println("DOCTOR TYPE2 : " + doctorType);

		doctorTypeService.save(doctorType);
		return "redirect:listDoctorTypes";
		}
	}

	@GetMapping("/listLocations")
	public String listlocations(Model model, HttpServletRequest request) {
		session = request.getSession(false);
		System.out.println("session.getAttribute(\"username\") " + session.getAttribute("username"));
		if (!session.getAttribute("username").equals("admin@admin")) {
			model.addAttribute("msg", "Login as Admin");
			return "login";
		} else {
			List<Location> theLocations = locationService.getAll();

			model.addAttribute("locations", theLocations);
			return "list-locations";
		}
	}

	@GetMapping("/showLocationForm")
	public String addLocationForm(Model theModel, HttpServletRequest request) {
		session = request.getSession(false);
		System.out.println("session.getAttribute(\"username\") " + session.getAttribute("username"));
		if (!session.getAttribute("username").equals("admin@admin")) {
			theModel.addAttribute("msg", "Login as Admin");
			return "login";
		} else {
			Location theLocation = new Location();
			List<Doctor> doctors = doctorService.getAll();

			theModel.addAttribute("doctors", doctors);
			theModel.addAttribute("location", theLocation);

			return "location-form";// list of doctors, add as a mode to this location-from.jsp
		}
	}

	@PostMapping("/saveLocation")
	public String saveLocation(
			/* @RequestParam("doctorId") int theId, */ @ModelAttribute("location") Location theLocation, Doctor doctor,
			HttpServletRequest request, Model theModel) {
		session = request.getSession(false);
		System.out.println("session.getAttribute(\"username\") " + session.getAttribute("username"));
		if (!session.getAttribute("username").equals("admin@admin")) {
			theModel.addAttribute("msg", "Login as Admin");
			return "login";
		} else {
			// System.out.println("the location : " + theLocation.getDoctor());
			Location location = new Location();
			//
			doctor = doctorService.findOne(theLocation.getId());
			//
			//
			// System.out.println("DOCTOR : " + doctor);
			//
			// //doctor = doctorService.findOne(theId);

			// location = theLocation;
			location.setDoctor(doctor);
			location.setCountry(theLocation.getCountry());
			location.setCity(theLocation.getCity());
			location.setStreet(theLocation.getStreet());
			location.setApt(theLocation.getApt());

			// location = (Location) locationService.getAll();

			//
			// location.
			// theLocation.setDoctor(doctor);

			locationService.save(location);

			return "redirect:listLocations";
		}
	}

}
