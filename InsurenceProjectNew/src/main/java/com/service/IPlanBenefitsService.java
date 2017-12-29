package com.service;

import java.util.List;

import com.entity.InsurancePlan;
import com.entity.PlanBenefits;



public interface IPlanBenefitsService extends CrudService<PlanBenefits, Integer>{

	void save(InsurancePlan plan);
	
}
