package com.dao;

import java.util.List;

import com.entity.InsurancePlan;
import com.entity.PlanBenefits;



public interface PlanBenefitsDao extends CrudDao<PlanBenefits, Integer>{

	void save(InsurancePlan plan);
	
}