package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.PlanBenefitsDao;
import com.entity.InsurancePlan;
import com.entity.PlanBenefits;
import com.service.IPlanBenefitsService;

@Service
public class PlanServiceImpl implements IPlanBenefitsService {
	@Autowired
	private PlanBenefitsDao planBenefitsDao;

	@Transactional
	public List<PlanBenefits> getAll() {
		return planBenefitsDao.getAll();
	}

	@Transactional
	public void save(PlanBenefits entity) {
		planBenefitsDao.save(entity);
	}

	@Transactional
	public PlanBenefits findOne(Integer id) {
		PlanBenefits planBenefits = planBenefitsDao.findOne(id);
		return planBenefits;
	}

	@Transactional
	public void delete(Integer id) {
		planBenefitsDao.delete(id);		
	}

	@Transactional
	public void save(InsurancePlan plan) {
		planBenefitsDao.save(plan);		
	}

	
	
}
