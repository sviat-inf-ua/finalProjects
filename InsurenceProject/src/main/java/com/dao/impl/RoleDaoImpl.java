package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.RoleDao;
import com.entity.user.Role;

public class RoleDaoImpl implements RoleDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public List<Role> getAll() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Role> theQuery = currentSession.createQuery("from Role ", Role.class);
		List<Role> roles = theQuery.getResultList();
		return roles;
	}

	public void save(Role entity) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(entity);
	}

	public Role findOne(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Role theRole = currentSession.get(Role.class, id);
		return theRole;
	}

	public void delete(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Role where id=:roleId");
		theQuery.setParameter("roleId", id);
		theQuery.executeUpdate();
	}
}
