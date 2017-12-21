package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.DoctorDao;
import com.entity.Doctor;

@Repository
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	SessionFactory sessionFactory;

	public List<Doctor> getAll() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Doctor> theQuery = currentSession.createQuery("from Doctor order by lastName", Doctor.class);
		List<Doctor> doctors = theQuery.getResultList();
		return doctors;
	}

	public void save(Doctor entity) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(entity);
	}

	public Doctor findOne(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Doctor theDoctor = currentSession.get(Doctor.class, id);
		return theDoctor;
	}

	public void delete(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("delete from doctor where id=:doctorId");
		theQuery.setParameter("doctorId", id);
		theQuery.executeUpdate();
	}
}
