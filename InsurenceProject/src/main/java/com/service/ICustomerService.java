package com.service;

import java.util.List;

import com.entity.Customer;

public interface ICustomerService {
	public void createCustomer(Customer customer);
	public void deleteCustomer(String email);
	public void updateCusomer(String email);
	public Customer getCustomerByEmail(String string);
	public Customer getCustomerById(long id);
	public List<Customer> getAllCustomers();
	public List<Customer> getActiveCustomers(boolean status);
	public List<Customer> getInActiveCustomers(boolean status);
}
