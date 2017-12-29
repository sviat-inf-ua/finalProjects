package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.ICustomerBillsDao;
import com.entity.Customer;
import com.entity.CustomerBills;
@Repository("customerBillsDao")
public class CustomerBillsDaoImpl implements ICustomerBillsDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List getAll() {
		Session session = null;
		List<CustomerBills> list = new ArrayList<CustomerBills>();
		try {
			session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CustomerBills");
			list = query.getResultList();
		} catch(Exception ex) {
			System.out.println("bills could not be found");
			ex.printStackTrace();
		}
		return list;
	}

	public void save(CustomerBills entity) {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(entity);
		} catch(Exception ex) {
			System.out.println("bill could not be saved");
			ex.printStackTrace();
		}
		
	}

	public CustomerBills findOne(Integer id) {
		Session session = null;
		CustomerBills bill = null;
		try {
			session = sessionFactory.getCurrentSession();
			bill = session.get(CustomerBills.class, id);
			
		} catch(Exception ex) {
			System.out.println("bill could not be found");
		}
		return bill;
	}

	public void delete(CustomerBills id) {
		// TODO Auto-generated method stub
		
	}

	public List<CustomerBills> getPaid(Customer customer) {
		Session session = null;
		List<CustomerBills> list = new ArrayList<CustomerBills>();
		try {
			session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CustomerBills where customer_id = :id and status = :status");
			query.setParameter("id", customer.getId());
			query.setParameter("status", true);
			list = query.getResultList();
			System.out.println("bills found");
		} catch(Exception ex) {
			System.out.println("bills could not be found");
		}
		return list;
	}

	public List<CustomerBills> getBillByCustomer(Integer customer) {
		Session session = null;
		List<CustomerBills> list = new ArrayList<CustomerBills>();
		try {
			session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CustomerBills where customer_id = :id");
			list = query.getResultList();
		} catch(Exception ex) {
			System.out.println("bills could not be found");
			ex.printStackTrace();
		}
		return list;
	}

	public void delete(Integer id) {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			CustomerBills bill = session.get(CustomerBills.class, id);
			session.delete(bill);
			System.out.println("bill deleted");
			
		} catch(Exception ex) {
			System.out.println("bill not deleted");
			ex.printStackTrace();
		}
	}

	public List<CustomerBills> getBillByCustomer(Customer customer) {
		Session session = null;
		List<CustomerBills> list = new ArrayList<CustomerBills>();
		try {
			session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CustomerBills where customer_id = :id");
			query.setParameter("id", customer.getId());
			list = query.getResultList();
		} catch(Exception ex) {
			System.out.println("bills could not be found");
			ex.printStackTrace();
		}
		return list;
	}

	public List<CustomerBills> getNotPaid(Customer customer) {
		Session session = null;
		List<CustomerBills> list = new ArrayList<CustomerBills>();
		try {
			session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CustomerBills where customer_id = :id and status = 0");
			query.setParameter("id", customer.getId());
			list = query.getResultList();
		} catch(Exception ex) {
			System.out.println("bills not found");
			ex.printStackTrace();
		}
		return list;
	}
}
