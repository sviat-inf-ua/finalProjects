package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.IInsurancePlanDao;
import com.entity.InsurancePlan;
import com.service.IInsurancePlanService;
@Service
@Transactional
public class InsurancePlanServiceImpl implements IInsurancePlanService {

	@Autowired
	private IInsurancePlanDao insurancePlanDao;

	@Transactional
	public List<InsurancePlan> getAll() {
		// TODO Auto-generated method stub
		return insurancePlanDao.getAll();
	}

	@Transactional
	public void save(InsurancePlan entity) {
		insurancePlanDao.save(entity);
	}

	@Transactional
	public InsurancePlan findOne(Integer id) {
		return insurancePlanDao.findOne(id);
	}

	@Transactional
	public void delete(Integer id) {
		insurancePlanDao.delete(id);
	}
	

}
