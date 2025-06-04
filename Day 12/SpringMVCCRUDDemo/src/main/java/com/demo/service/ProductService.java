package com.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.demo.model.Product;

public interface ProductService {

	List<Product> getAllProduct();

	void saveProduct(Product product);

	Product getById(int pid);

	void updateProduct(Product product);

	void deleteProduct(int pid);

}
