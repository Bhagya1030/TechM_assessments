package com.aits.E_Commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aits.E_Commerce.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
