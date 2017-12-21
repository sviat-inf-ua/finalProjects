package com.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.entity.Doctor;
import com.entity.DoctorType;
import com.entity.Location;
import com.service.DoctorService;
import com.service.DoctorTypeService;
import com.service.LocationService;

@Controller
//@RequestMapping("/admin")
@SessionAttributes("location")
public class AdminController {

	@Autowired
	private DoctorTypeService doctorTypeService;

	@Autowired
	private LocationService locationService;

	@Autowired
	private DoctorService doctorService;
	
	@ModelAttribute("location")
	public Location getForm() {
		return new Location();
	}
	
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("doctors", doctorService.getAll());
		return "location-form";
	}
	

	@GetMapping("/listDoctorTypes")
	public String listDocType(Model model) {

		List<DoctorType> theDoctorTypes = doctorTypeService.getAll();

		model.addAttribute("doctorTypes", theDoctorTypes);
		return "list-doctorTypes";
	}

	@GetMapping("/showDoctorTypeForm")
	public String addDocTypeForm(Model theModel) {

		// create model attribute to bind form data
		DoctorType theDocType = new DoctorType();

		theModel.addAttribute("doctorType", theDocType);

		return "doctorType-form";
	}

	@RequestMapping("/saveDoctorType")
	public String saveDocType(@ModelAttribute("doctorType") DoctorType theDoctorType) {

		// save the customer using our service
		doctorTypeService.save(theDoctorType);

		return "redirect:/admin/listDoctorTypes";
	}

	@GetMapping("/listLocations")
	public String listlocations(Model model) {

		List<Location> theLocations = locationService.getAll();

		model.addAttribute("locations", theLocations);
		return "list-locations";
	}

	@GetMapping("/showLocationForm")
	public String addLocationForm(Model theModel) {
		
//		@RequestMapping(value="/productlist/addproduct" , method= RequestMethod.POST,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//		public ModelAndView addProdt(@ModelAttribute("prdt") Product p,BindingResult bindingResult)

		// create model attribute to bind form data
		Location theLocation = new Location();
//		Doctor doctor = new Doctor();
	//List<Doctor> doctors = doctorService.getAll();
//		
//		theModel.addAllAttributes(doctors);
	//theModel.addAttribute("doctors", doctors);
		theModel.addAttribute("location", theLocation);
		

		return "location-form";// list of doctors, add as a mode to this location-from.jsp
	}

	@RequestMapping
	public String printDoctors(Model theModel) {

		List<Doctor> theDoctors = doctorService.getAll();

		theModel.addAttribute("doctors", theDoctors);
		
		return "location-form";
	}

	@PostMapping("/saveLocation")
	public String saveLocation(@ModelAttribute("location") Location theLocation, Doctor doctor) {
	//	 Doctor doctor = doctorService.save(entity);
		// doctor.getId();
		// doctor.setId();
		 
	//	 theLocation.setDoctor(doctorService.findOne(theLocation.getDoctor_id()));
		 
		 
		 theLocation.setDoctor(doctorService.findOne(theLocation.getDoctor_id()));
//		 System.out.println(theLocation.getCountry());
		 System.out.println("---------------------------------------");
		 System.out.println(theLocation.getDoctor_id());
		 
		// @GeAttribute
		//
		
	//	doctor.do

		// theLocation.setDoctor(doctor);
		// save the customer using our service
	locationService.save(theLocation);

		return "redirect:/showLocationForm";
	}
}
