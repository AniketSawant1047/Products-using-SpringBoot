package com.jspiders.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.product.dto.ProductDetails;
import com.jspiders.product.dto.Products;
import com.jspiders.product.repository.ProductDetailsRepository;
import com.jspiders.product.repository.ProductRepository;

@Service
public class ProductService implements ProductServiceInterface {

	@Autowired
	ProductRepository repository;
	
	@Autowired
	ProductDetailsRepository details;

	@Override
	public Products add(Products product) {
		Products add = repository.save(product);
		return add;
	}

	@Override
	public Products get(Products product) {
		Optional<Products> getProduct = repository.findById(product.getProductId());
		return getProduct.get();
	}

	@Override
	public ProductDetails addProductDetails(ProductDetails productDetails) {
		ProductDetails add = details.save(productDetails);
		return add;
	}

	@Override
	public ProductDetails getProductDetails(String pt) {
		ProductDetails get = details.findByProductType(pt);
		return get;
	}
	@Override
	public void remove(Products product) {
		repository.delete(product);
	}

	@Override
	public Products update(Products product) {
		repository.delete(product);
		Products update = repository.save(product);
		return update;
	}

	@Override
	public void removeProductDetails(ProductDetails productDetails) {
		details.delete(productDetails);	
	}

	@Override
	public ProductDetails updateProductDetails(ProductDetails productDetails) {
		details.delete(productDetails);
		ProductDetails updatedProductDetails = details.save(productDetails);
		return updatedProductDetails;
	}
}
