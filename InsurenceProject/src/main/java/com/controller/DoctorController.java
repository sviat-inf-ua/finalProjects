package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Doctor;
import com.service.DoctorService;

@Controller
@RequestMapping
public class DoctorController {

	@Autowired
	private DoctorService doctorService ;
	
	
	@GetMapping("/listDoctors")
	public String listCustomers(Model theModel) {
		
		// get customers from the service
		List<Doctor> theDoctors = doctorService.getAll();
				
		// add the customers to the model
		theModel.addAttribute("doctors", theDoctors);
		
		return "list-doctors";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Doctor theDoctor = new Doctor();
		
		theModel.addAttribute("doctor", theDoctor);
		
		return "doctor-form";
	}
	
	@PostMapping("/saveDoctor")
	public String saveCustomer(@ModelAttribute("doctor") Doctor theDoctor) {
		
		// save the customer using our service
		doctorService.save(theDoctor);	
		
		return "redirect:/listDoctors";
	}
	
}
