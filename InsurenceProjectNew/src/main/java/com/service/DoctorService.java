package com.service;

import java.util.List;

import com.entity.Doctor;

public interface DoctorService extends CrudService<Doctor, Integer> {
	
	 List<Doctor> getActive();
	 List<Doctor> getNotActive();
}
