package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ICustomerBillsDao;
import com.entity.Customer;
import com.entity.CustomerBills;
import com.service.ICustomerBillsService;
@Service("customerBillsService")
public class CustomerBillsServiceImpl implements ICustomerBillsService {

	@Autowired
	private ICustomerBillsDao customerBillsDao;
	
	@Transactional
	public List<CustomerBills> getAll() {
		List<CustomerBills> bills = new ArrayList<CustomerBills>();
		try {
			bills = customerBillsDao.getAll();
		}catch(Exception ex) {
			System.out.println("bills service not found");
		}
		return bills;
	}
	@Transactional
	public void save(CustomerBills entity) {
		try {
			customerBillsDao.save(entity);
		} catch(Exception ex) {
			System.out.println("bills service not saved");
		}
	}
	@Transactional
	public CustomerBills findOne(Integer id) {
		CustomerBills bill = new CustomerBills();
		try {
			bill = customerBillsDao.findOne(id);
		} catch(Exception ex) {
			System.out.println("bills service not found");
		}
		return bill;
	}
	@Transactional
	public void delete(Integer id) {
		try {
			customerBillsDao.delete(id);
		} catch(Exception ex) {
			System.out.println("bills service not deleted");
		}
		
	}
	@Transactional
	public List<CustomerBills> getPaid(Customer customer) {
		List<CustomerBills> bills = new ArrayList<CustomerBills>();
		try {
			bills = customerBillsDao.getPaid(customer);
		} catch(Exception ex) {
			System.out.println("bills service not found");
		}
		return bills;
	}
	@Transactional
	public List<CustomerBills> getBillByCustomer(Customer customer) {
		List<CustomerBills> bills = new ArrayList<CustomerBills>();
		try {
			bills = customerBillsDao.getBillByCustomer(customer);
		}catch(Exception ex) {
			System.out.println("bills service not found");
		}
		return bills;
	}
	@Transactional
	public List<CustomerBills> getNotPaid(Customer customer) {
		List<CustomerBills> bills = new ArrayList<CustomerBills>();
		try {
			bills = customerBillsDao.getNotPaid(customer);
		}catch(Exception ex) {
			System.out.println("bills service not found");
		}
		return bills;
	}
	
	
}
