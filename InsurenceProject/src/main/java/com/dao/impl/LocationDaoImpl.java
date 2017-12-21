package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.LocationDao;
import com.entity.Location;

@Repository
public class LocationDaoImpl implements LocationDao {

	@Autowired
	SessionFactory sessionFactory;

	public List<Location> getAll() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Location> theQuery = currentSession.createQuery("from Location order by city", Location.class);
		List<Location> locations = theQuery.getResultList();
		return locations;
	}

	public void save(Location entity) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(entity);
	}

	public Location findOne(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Location theLocation = currentSession.get(Location.class, id);
		return theLocation;
	}

	public void delete(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from location where id=:locationId");
		theQuery.setParameter("locationId", id);
		theQuery.executeUpdate();
	}
}
