package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.DoctorTypeDao;
import com.entity.DoctorType;

@Repository
public class DoctorTypeDaoImpl implements DoctorTypeDao {

	@Autowired
	SessionFactory sessionFactory;


	public List<DoctorType> getAll() {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Query<DoctorType> theQuery = currentSession.createQuery("from DoctorType order by doctorType",
				DoctorType.class);

		List<DoctorType> doctorTypes = theQuery.getResultList();
		return doctorTypes;

	}

	public void save(DoctorType entity) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(entity);
	}

	public DoctorType findOne(Integer id) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		DoctorType doctorType = currentSession.get(DoctorType.class, id);
		return doctorType;
	}

	public void delete(Integer id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from DoctorType where id=:doctorTypeId");
		theQuery.setParameter("doctorTypeId", id);
		theQuery.executeUpdate();
	}

}
