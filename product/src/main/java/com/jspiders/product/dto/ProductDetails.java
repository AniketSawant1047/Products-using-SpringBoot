package com.jspiders.product.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ProductDetails {

	@Id
	private String productType;
	
	private double discount;
	
	private double gst;
	
	private double delivery;
	
}
