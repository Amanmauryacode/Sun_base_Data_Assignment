package com.sunbase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunbase.entity.Customer;
import com.sunbase.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sunbase/portal/api/assignment")
@RequiredArgsConstructor
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/create-customer")
	public ResponseEntity<String> createCustomer(@RequestParam("cmd") String cmd,@RequestBody(required = false) Customer customer){
		System.out.println(customer);
		if(cmd.equals("create")) {
			if(customer == null) {
				return new ResponseEntity<String>("Body is Null",HttpStatus.BAD_REQUEST);
			}
			if(customer.getFirstName() !=null && customer.getLastName() !=null && !(customer.getFirstName().equals("") || customer.getLastName().equals("")) ) {
				String res = customerService.createCustomer(customer);
				return new ResponseEntity<>(res,HttpStatus.CREATED);
			}else {
				return new ResponseEntity<>("First Name or Last Name is missing",HttpStatus.BAD_REQUEST);
			}
		}else {
			return new ResponseEntity<>("Invalid Command",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-customers")
	public ResponseEntity<List<Customer>> getAllCustomerList(){
		List<Customer> customers = customerService.getAllCustomer();
		return new ResponseEntity<>(customers,HttpStatus.OK);
	}
	
	@PostMapping("/customer")
	public ResponseEntity<String> deleteCustomer(@RequestParam("cmd") String cmd,@RequestParam("uuid") Integer uuid,@RequestBody(required = false) Customer customer){
		
		String resp = "Invalid Command";
		if(cmd.equals("delete")) {
			resp = customerService.deleteCustomer(uuid);
			if(resp.equals("UUID not found")) {
				return new ResponseEntity<String>(resp,HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<String>(resp,HttpStatus.OK);
			}
		}else if(cmd.equals("update")) {
			resp = customerService.updateCustomer(uuid, customer);
			System.out.println(resp);
			if(resp.equals("UUID not found")) {
				return new ResponseEntity<String>(resp,HttpStatus.INTERNAL_SERVER_ERROR);
			}else if(resp.equals("Body is Null")) {
				return new ResponseEntity<String>("Body is Null",HttpStatus.BAD_REQUEST);
			}else {
				
				return new ResponseEntity<String>(resp,HttpStatus.OK);
	
			}
		}else {
			return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	
	
}
