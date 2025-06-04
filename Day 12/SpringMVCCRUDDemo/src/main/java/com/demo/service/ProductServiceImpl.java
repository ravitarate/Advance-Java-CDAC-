package com.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
	ProductDao pdao;

	public List<Product> getAllProduct() {
		return pdao.findAllProduct();
	}

	@Override
	public void saveProduct(@Valid Product product) {
		pdao.insertProduct(product);
		
	}

	@Override
	public Product getById(int pid) {
		return pdao.findById(pid);
	}

	@Override
	public void updateProduct(Product product) {
		pdao.modifyProduct(product);
		
	}

	@Override
	public void deleteProduct(int pid) {
		pdao.removeById(pid);
		
	}
}
