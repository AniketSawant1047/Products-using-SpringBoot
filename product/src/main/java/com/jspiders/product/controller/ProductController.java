package com.jspiders.product.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.product.dto.ProductDetails;
import com.jspiders.product.dto.Products;
import com.jspiders.product.responce.ProductResponce;
import com.jspiders.product.service.ProductService;

@RestController
public class ProductController {

	@Autowired 
	ProductService service;
	
	@PostMapping("/addProduct")
	public ResponseEntity<ProductResponce> add(@RequestBody Products product){
		if (product != null) {
			Products addedProduct = service.add(product);
			return new ResponseEntity<ProductResponce>(new ProductResponce(addedProduct,null,0.0,null,0.0),HttpStatus.ACCEPTED);
		}
		return null;	
	}
	@GetMapping("/remove")
	public ResponseEntity<ProductResponce> remove(@RequestBody Products products){
		if (products != null) {
			service.remove(products);
			return new ResponseEntity<ProductResponce>(new ProductResponce(null, null, 0.0, null, 0.0),HttpStatus.ACCEPTED);
		}
		return null;
	}
	
	@GetMapping("/update")
	public ResponseEntity<ProductResponce> update(@RequestBody Products product){
		if (product != null) {
			Products update = service.update(product);
			return new ResponseEntity<ProductResponce>(new ProductResponce(update, null, 0.0, null, 0.0),HttpStatus.ACCEPTED);
		}
		return null;
	}
	
	@PostMapping("/addProductDetails")
	public ResponseEntity<ProductResponce> add(@RequestBody ProductDetails productDetails){
		if (productDetails != null) {
			ProductDetails addedProductDetails = service.addProductDetails(productDetails);
			return new ResponseEntity<ProductResponce>(new ProductResponce(null, addedProductDetails,0.0, null, 0.0),HttpStatus.ACCEPTED);
		}
		return null;	
	}
	@GetMapping("/removeProductDetails")
	public ResponseEntity<ProductResponce> removeProductDetails(@RequestBody ProductDetails productDetails){
		if (productDetails != null) {
			service.removeProductDetails(productDetails);
			return new ResponseEntity<ProductResponce>(new ProductResponce(null, null, 0.0, null, 0.0),HttpStatus.ACCEPTED);
		}
		return null;
	}
	@GetMapping("/updateProductDetails")
	public ResponseEntity<ProductResponce> updateProductDetails(@RequestBody ProductDetails productDetails){
		if (productDetails != null) {
			ProductDetails updatedProductDetails = service.updateProductDetails(productDetails);
			return new ResponseEntity<ProductResponce>(new ProductResponce(null, updatedProductDetails, 0.0, null, 0.0),HttpStatus.ACCEPTED);
		}
		return null;
		
	}
	@GetMapping("/getProduct")
	public ResponseEntity<ProductResponce> get(@RequestBody Products product){
		if (product != null) {
			Products getProduct = service.get(product);
			String pt = getProduct.getCatogory();
			ProductDetails productDetails = service.getProductDetails(pt);
			double discount = product.getPrice()*(productDetails.getDiscount()/100);
			ArrayList< Double> charge = new ArrayList<>();
			charge.add(productDetails.getDelivery());
			charge.add((productDetails.getGst()/100)*(product.getPrice()-discount));
			double finalPrice = product.getPrice()-discount +(charge.get(0)+charge.get(1));
			return new ResponseEntity<ProductResponce>(new ProductResponce(product, null, discount, charge, finalPrice),HttpStatus.ACCEPTED);
		}
		return null;
	}
}
