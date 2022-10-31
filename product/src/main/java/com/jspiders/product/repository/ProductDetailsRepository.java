package com.jspiders.product.repository;

import org.springframework.data.repository.CrudRepository;

import com.jspiders.product.dto.ProductDetails;

public interface ProductDetailsRepository extends CrudRepository<ProductDetails, String>{

	ProductDetails findByProductType(String pt);

}
