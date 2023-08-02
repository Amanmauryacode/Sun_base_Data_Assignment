package com.sunbase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbase.entity.Customer;
import com.sunbase.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public String createCustomer(Customer customer) {
		
		customerRepo.save(customer);
		return "Successfully Created";
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepo.findAll();
	}

	@Override
	public String deleteCustomer(Integer uuid) {
		Optional<Customer> opt = customerRepo.findById(uuid);
		if(opt.isEmpty())return "UUID not found";
		customerRepo.delete(opt.get());
		return "Successfully deleted";
	}

	@Override
	public String updateCustomer(Integer uuid, Customer customer) {
		Optional<Customer> opt = customerRepo.findById(uuid);
		if(opt.isEmpty())return "UUID not found";
		if(customer == null)return "Body is Empty";
		customerRepo.save(customer);
		return "Successfully Updated";
	}

}
