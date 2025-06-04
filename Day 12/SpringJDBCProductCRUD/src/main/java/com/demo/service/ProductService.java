package com.demo.service;

import java.util.List;

import com.demo.model.Product;

public interface ProductService {

	void addnewProduct();

	List<Product> getAllProduct();

	Product getById(int id);

	List<Product> getByQuantity(int qty);

	List<Product> getAllProductSorted();

	boolean modifyById(int id, int qty, double price);

	boolean deleteById(int id);

}
