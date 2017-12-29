package com.dao;

import java.util.List;

import com.entity.Doctor;

public interface DoctorDao extends CrudDao<Doctor, Integer>{
	
	 List<Doctor> getActive();
	 List<Doctor> getNotActive();
}
