package com.dao;

import java.util.List;

import com.entity.Customer;
import com.entity.CustomerBills;

public interface ICustomerBillsDao extends CrudDao<CustomerBills, Integer>{

	List<CustomerBills> getPaid(Customer customer);
	List<CustomerBills> getBillByCustomer(Customer customer);
	List<CustomerBills> getNotPaid(Customer customer);
}
