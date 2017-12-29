package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ICustomerDao;
import com.entity.Customer;
import com.service.ICustomerService;
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerDao customerDao;

	@Transactional
	public void createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
			customerDao.createCustomer(customer);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Transactional
	public void deleteCustomer(String email) {
		// TODO Auto-generated method stub
		try {
			customerDao.deleteCustomer(email);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Transactional
	public void updateCusomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
		customerDao.updateCusomer(customer);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Transactional
	public Customer getCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		Customer customer =null;
		try {
		customer = customerDao.getCustomerByEmail(email);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return customer;
	}

	@Transactional
	public Customer getCustomerById(long id) {
		
		Customer customer = null;
		try {
			customer = customerDao.getCustomerById(id);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return customer;
	}

	@Transactional
	public List<Customer> getAllCustomers() {
		List<Customer> list = null;
		try {
			list = customerDao.getAllCustomers();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	@Transactional
	public List<Customer> getActiveCustomers(boolean status) {
		List<Customer> list = null;
		try {
			list = customerDao.getActiveCustomers(status);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	@Transactional
	public List<Customer> getInActiveCustomers(boolean status) {
		List<Customer> list = null;
		try {
			list = customerDao.getInActiveCustomers(status);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

}
