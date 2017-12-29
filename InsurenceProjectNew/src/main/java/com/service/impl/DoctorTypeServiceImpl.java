package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DoctorTypeDao;
import com.entity.DoctorType;
import com.service.DoctorTypeService;

@Service
public class DoctorTypeServiceImpl implements DoctorTypeService {

	@Autowired
	DoctorTypeDao doctorTypeDao;
	
	@Transactional
	public List<DoctorType> getAll() {
		return doctorTypeDao.getAll();
	}
	
	@Transactional
	public void save(DoctorType entity) {
		doctorTypeDao.save(entity);
	}

	@Transactional
	public DoctorType findOne(Integer id) {
		return doctorTypeDao.findOne(id);
	}

	@Transactional
	public void delete(Integer id) {
		doctorTypeDao.delete(id);
	}

}
