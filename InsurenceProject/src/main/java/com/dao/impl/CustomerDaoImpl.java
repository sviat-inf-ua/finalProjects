package com.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.ICustomerDao;
import com.entity.Customer;
@Repository("customerDao")
public class CustomerDaoImpl implements ICustomerDao {
	
	@Autowired
	private SessionFactory factory;
	
	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public void createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
//			tx.begin();
			session.saveOrUpdate(customer);
			tx.commit();
			System.out.println("customer created successfully");
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
//			session.flush();
//			session.close();
		}
	}

	@Override
	public void deleteCustomer(String email) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		String sql = "from customer where email = :email";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(sql);
			query.setParameter("email", email);
			int rs = query.executeUpdate();
			if(rs!= 0) {
				tx.commit();
			} else {
				tx.rollback();
			}
//			session.flush();
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
//				session.close();
			}
	}

	@Override
	public void updateCusomer(String email) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
//			tx.begin();
			Customer customer = (Customer) session.get(Customer.class, email);
			session.update(customer);
			tx.commit();
//			session.flush();
			System.out.println("Customer Updated successfully");
		} catch(Exception ex) {
			System.out.println("Customer could not be updated");
			ex.printStackTrace();
		} finally {
//			session.close();
		}
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		Session session = null;
		Transaction tx = null;
		String sql = "from Customer where email = :email";
		Customer customer = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(sql);
			query.setParameter("email", email);
			customer = (Customer) query.getSingleResult();
			tx.commit();
			System.out.println("Custumer found");
		} catch(Exception ex) {
			System.out.println("Customer could not be found");
			ex.printStackTrace();
		} finally {
//			session.flush();
//			session.close();
		}
		return customer;
	}

	@Override
	public Customer getCustomerById(long id) {
		Session session = null;
		Transaction tx = null;
		Customer customer = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
//			tx.begin();
			customer = (Customer)session.get(Customer.class, id);
			tx.commit();
			System.out.println("Customer found");
		} catch(Exception ex) {
			System.out.println("customer could not be found");
			ex.printStackTrace();
		} finally {
//			session.flush();
//			session.close();
		}
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		Session session = null;
		Transaction tx = null;
		List<Customer> list = null;
		String sql = "from Customer";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(sql);
			list = query.getResultList();
			tx.commit();
			System.out.println("All customers found");
			session.flush();
		} catch(Exception ex) {
			System.out.println("no customer found");
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Customer> getActiveCustomers(boolean status) {
		Session session = null;
		Transaction tx = null;
		status = true;
		List<Customer> list = null;
		String sql = "from Customer where status =  :status";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(sql);
			query.setParameter("status", status);
			list = query.getResultList();
			tx.commit();
			System.out.println("All active customers found");
			session.flush();
		} catch(Exception ex) {
			System.out.println("no active customer found");
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Customer> getInActiveCustomers(boolean status) {
		Session session = null;
		Transaction tx = null;
		status = true;
		List<Customer> list = null;
		String sql = "from Customer where status =  :status";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(sql);
			query.setParameter("status", status);
			list = query.getResultList();
			tx.commit();
			System.out.println("All active customers found");
			session.flush();
		} catch(Exception ex) {
			System.out.println("no active customer found");
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

}
