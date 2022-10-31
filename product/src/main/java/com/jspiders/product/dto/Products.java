package com.jspiders.product.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Products {

	@Id
	private int productId;
	
	private String name;
	
	private String productType;
	
	private String catogory;
	
	private double price;
}
