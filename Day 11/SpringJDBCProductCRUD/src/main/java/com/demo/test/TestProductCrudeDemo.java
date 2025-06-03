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
        		break;
        	case 3:
        		break;
        	case 4:
        		List<Product> plist=pservice.getAllProduct();
        		plist.forEach(System.out::println);
        		break;
        	case 5:
        		break;
        	case 6:
        		break;
        	case 7:
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
