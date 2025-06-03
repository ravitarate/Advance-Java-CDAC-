package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
     private ProductDao pdao;

	public void addnewProduct() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter pid");
		int pid=sc.nextInt();
		System.out.println("enter pname");
		String pname=sc.next();
		System.out.println("enter qty");
		int qty=sc.nextInt();
		System.out.println("enter price");
		double price=sc.nextDouble();
		System.out.println("enter mfg date (dd/MM/yyyy)");
		String dt=sc.next();
		LocalDate ldt=LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Product p=new Product(pid,pname,qty,price,ldt);
		pdao.saveProduct(p);
		
	}

	@Override
	public List<Product> getAllProduct() {
		return pdao.findAllProduct();
	}
}
