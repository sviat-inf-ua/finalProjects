package com.dao;

import java.util.List;

import com.entity.Customer;

public interface ICustomerDao {
	public void createCustomer(Customer customer);
	public void deleteCustomer(String email);
	public void updateCusomer(String email);
	public Customer getCustomerByEmail(String email);
	public Customer getCustomerById(long id);
	public List<Customer> getAllCustomers();
	public List<Customer> getActiveCustomers(boolean status);
	public List<Customer> getInActiveCustomers(boolean status);
}
