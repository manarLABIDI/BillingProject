package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Product;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {

}
