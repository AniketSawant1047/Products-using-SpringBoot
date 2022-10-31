package com.jspiders.product.service;

import com.jspiders.product.dto.ProductDetails;
import com.jspiders.product.dto.Products;

public interface ProductServiceInterface {

	Products add(Products product);

	Products get(Products product);

	ProductDetails addProductDetails(ProductDetails productDetails);

	ProductDetails getProductDetails(String pt);

	void remove(Products product);

	Products update(Products product);

	void removeProductDetails(ProductDetails productDetails);

	ProductDetails updateProductDetails(ProductDetails productDetails);

}
