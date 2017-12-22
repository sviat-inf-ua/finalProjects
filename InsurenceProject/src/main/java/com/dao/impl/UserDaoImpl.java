package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.entity.user.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public List<User> getAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> theQuery = currentSession.createQuery("from User", User.class);
		List<User> users = theQuery.getResultList();
		return users;
	}

	public void save(User entity) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(entity);
	}

	public User findOne(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(User.class, id);
	}

	public void delete(Integer id) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("delete from User where id=:userId");
		theQuery.setParameter("userId", id);
		theQuery.executeUpdate();
	}

	@Override
	public User findByUsername(String username) {
	
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(User.class, username);
	}

}
