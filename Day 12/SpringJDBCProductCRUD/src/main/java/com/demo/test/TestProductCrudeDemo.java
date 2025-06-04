package com.demo.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.model.Product;
import com.demo.service.ProductService;

public class TestProductCrudeDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
        ProductService pservice=(ProductService)ctx.getBean("productServiceImpl");
        int choice=0;
        do {
        	System.out.println("1. add new product\n 2. delete product\n 3. modify product");
        	System.out.println("4. display all product\n 5. display by id\n 6. display by qty");
        	System.out.println("7. display in sorted order\n 8. exit\n choice: ");
        	choice=sc.nextInt();
        	switch(choice) {
        	case 1:
        		pservice.addnewProduct();
        		break;
        	case 2:
        		System.out.println("Enter id to delete product");
        		int id=sc.nextInt();
        		boolean status=pservice.deleteById(id);
        		if(status) {
        			System.out.println("deletion done");
        		}else {
        			System.out.println("not found");
        		}
        		break;
        	case 3:
        		System.out.println("Enter id to modify");
        		id=sc.nextInt();
        		System.out.println("enter new qty");
        		int qty=sc.nextInt();
        		System.out.println("enter new price");
        		double price=sc.nextDouble();
        		status=pservice.modifyById(id,qty,price);
        		if(status) {
        			System.out.println("updation done");
        		}else {
        			System.out.println("not found");
        		}
        		
        		break;
        	case 4:
        		List<Product> plist=pservice.getAllProduct();
        		plist.forEach(System.out::println);
        		break;
        	case 5:
        		System.out.println("Enter id to display");
        		id=sc.nextInt();
        		Product p=pservice.getById(id);
        		if(p!=null) {
        			System.out.println(p);
        		}else {
        			System.out.println("not found");
        		}
        		break;
        	case 6:
        		System.out.println("Enter qty to display");
        		qty=sc.nextInt();
        		plist=pservice.getByQuantity(qty);
        		if(plist!=null) {
        			plist.forEach(System.out::println);
        		}else {
        			System.out.println("not found");
        		}
        		break;
        	case 7:
        		plist=pservice.getAllProductSorted();
        		plist.forEach(System.out::println);
        		break;
        	case 8:
        		sc.close();
        		System.out.println("Thank you for visiting");
        		break;
        	default:
        		System.out.println("Wrong choice");
        	}
        	
        }while(choice!=8);
	}

}
