package com.demo.service;

import java.util.List;

import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;
import com.demo.model.Product;

public class ProductServiceImpl implements ProductService{
	private ProductDao pdao;
	public ProductServiceImpl() {
		pdao=new ProductDaoImpl();
	}

	@Override
	public List<Product> getAllProducts() {
		return pdao.findAllProducts();
	}

	@Override
	public boolean addNewProduct(Product p) {
		return pdao.save(p);
	}

	@Override
	public Product getById(int pid) {
		return pdao.findById(pid);
	}

	@Override
	public boolean updateProduct(Product p) {
		return pdao.modifyProduct(p);
	}

	@Override
	public boolean deleteById(int pid) {
		return pdao.removeById(pid);
	}
	
	
	

}
