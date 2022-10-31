package com.jspiders.product.responce;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.product.dto.ProductDetails;
import com.jspiders.product.dto.Products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponce {

	Products products;
	
	ProductDetails productDetails;
	
	double discount;

	ArrayList<Double> charge = new ArrayList<Double>();
	

	double finalPrice;

}
