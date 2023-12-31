package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Customer;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
