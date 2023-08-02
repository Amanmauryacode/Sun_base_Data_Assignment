package com.sunbase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbase.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
