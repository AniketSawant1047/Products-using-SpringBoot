package com.jspiders.product.repository;

import org.springframework.data.repository.CrudRepository;

import com.jspiders.product.dto.Products;

public interface ProductRepository extends CrudRepository<Products, Integer>{

}
