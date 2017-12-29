package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.PlanBenefitsDao;
import com.entity.InsurancePlan;
import com.entity.PlanBenefits;

@Repository("planBenefitsDao")
public class PlanBenefitsDaoImpl implements PlanBenefitsDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<PlanBenefits> getAll() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<PlanBenefits> theQuery = currentSession.createQuery("from PlanBenefits", PlanBenefits.class);
		List<PlanBenefits> planBenefitsList = theQuery.getResultList();
		return planBenefitsList;
	}

	public void save(PlanBenefits entity) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(entity);
	}

	public PlanBenefits findOne(Integer id) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("from PlanBenefits where planBenefit_ID = :id");
		theQuery.setParameter("id", id);
		
		PlanBenefits benefits = (PlanBenefits)theQuery.getSingleResult();
		
		System.out.println("dao plan banef " + benefits);
		
		return benefits;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	//insert into Plan_Benefits (InsurancePlan_ID, planBenefit_ID) values (?, ?)

	public void save(InsurancePlan plan) {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(plan);
	}
	
	

	
}
