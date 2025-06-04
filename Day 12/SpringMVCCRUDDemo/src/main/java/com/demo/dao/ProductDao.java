package com.demo.dao;

import java.util.List;

import javax.validation.Valid;

import com.demo.model.Product;

public interface ProductDao {

	List<Product> findAllProduct();

	void insertProduct(@Valid Product product);

	Product findById(int pid);

	void modifyProduct(Product product);

	void removeById(int pid);

}
