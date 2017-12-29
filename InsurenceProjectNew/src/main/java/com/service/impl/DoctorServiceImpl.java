package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DoctorDao;
import com.entity.Doctor;
import com.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorDao doctorDao;

	@Transactional
	public List<Doctor> getAll() {
		return doctorDao.getAll();
	}
	
	@Transactional
	public List<Doctor> getActive() {
		return doctorDao.getActive();
	}

	@Transactional
	public List<Doctor> getNotActive() {
		return doctorDao.getNotActive();
	}

	@Transactional
	public void save(Doctor entity) {
		doctorDao.save(entity);
	}

	@Transactional
	public Doctor findOne(Integer id) {
		return doctorDao.findOne(id);
	}

	@Transactional
	public void delete(Integer id) {
		doctorDao.delete(id);
	}

	
}
