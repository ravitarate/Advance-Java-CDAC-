package com.demo.dao;

import java.util.List;

import com.demo.model.Product;

public interface ProductDao {

	void saveProduct(Product p);

	List<Product> findAllProduct();

	Product findById(int id);

	List<Product> findByQuantity(int qty);

	List<Product> findAllProductSorted();

	boolean updateById(int id, int qty, double price);

	boolean removeById(int id);

}
