package com.meruvia.facturation.repository;

import org.springframework.data.repository.CrudRepository;

import com.meruvia.facturation.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
