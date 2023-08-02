package com.sunbase.service;

import java.util.List;

import com.sunbase.entity.Customer;

public interface CustomerService {

	public String createCustomer(Customer customer);
	
	public List<Customer> getAllCustomer();
	
	public String deleteCustomer(Integer uuid);
	
	public String updateCustomer(Integer uuid,Customer customer);
}
