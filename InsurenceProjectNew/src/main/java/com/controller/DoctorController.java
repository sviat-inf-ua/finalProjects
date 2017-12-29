package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/listNonActiveDoctors")
	public String listNonActiveDoctors(Model theModel) {
		
		// get customers from the service
		List<Doctor> theDoctors = doctorService.getNotActive();
				
		// add the customers to the model
		theModel.addAttribute("doctors", theDoctors);
		
		return "list-doctorActiveNonActive";
	}
	
	@GetMapping("/listActiveDoctors")
	public String listActiveDoctors(Model theModel) {
		
		// get customers from the service
		List<Doctor> theDoctors = doctorService.getActive();
				
		// add the customers to the model
		theModel.addAttribute("doctors", theDoctors);
		
		return "list-doctorActiveNonActive";
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
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("doctorId") int theId,
									Model theModel) {
		
		// get the doctor from our service
		Doctor theDoctor = doctorService.findOne(theId);	
		
		//theModel.addAttribute("doctor", theDoctor);
		
		// set doctor as a model attribute to pre-populate the form
		theModel.addAttribute("doctor", theDoctor);
		
		// send over to our form		
		return "updateDoctor";
	}
		
	
	@GetMapping("/delete")
	public String deleteDoctor(@RequestParam("doctorId") int theId) {
		
		// delete the customer
		doctorService.delete(theId);
		
		return "redirect:/listDoctors";
	}
	
	@GetMapping("/doctorDeactivate")
	public String doctorDeactivate(@RequestParam("doctorId") int theId, Model theModel) {
		
		Doctor theDoctor = doctorService.findOne(theId);	
		theDoctor.setActive(0);
		// delete the customer
		//doctorService.delete(theId);
		doctorService.save(theDoctor);
		
		return "redirect:/listDoctors";
	}
	
	@GetMapping("/doctorActivate")
	public String doctorActivate(@RequestParam("doctorId") int theId, Model theModel) {
		

		Doctor theDoctor = doctorService.findOne(theId);	
		theDoctor.setActive(1);
		// delete the customer
		//doctorService.delete(theId);
		doctorService.save(theDoctor);
		
		return "redirect:/listDoctors";
	}
	
}
