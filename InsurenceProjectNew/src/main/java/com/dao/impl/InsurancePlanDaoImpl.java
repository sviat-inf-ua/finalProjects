package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.IInsurancePlanDao;
import com.entity.InsurancePlan;
@Repository
public class InsurancePlanDaoImpl implements IInsurancePlanDao {

	@Autowired
	SessionFactory sessionFactory;

	public List<InsurancePlan> getAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<InsurancePlan> theQuery = currentSession.createQuery("from InsurancePlan",
				InsurancePlan.class);

		List<InsurancePlan> insurancePlans = theQuery.getResultList();
		return insurancePlans;

		
	}

	public void save(InsurancePlan entity) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(entity);
		
	}

	public InsurancePlan findOne(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();
		InsurancePlan insurancePlan = currentSession.get(InsurancePlan.class, id);
		
		return insurancePlan;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	

}
