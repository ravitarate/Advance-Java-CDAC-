package com.demo.test;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestResourceBundle {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		MessageSource ms=(MessageSource)ctx.getBean("messageSource");
		Scanner sc=new Scanner(System.in);
		System.out.println("1. Marathi\n 2. US English \n3. UK English\n 4. Rassian\n ");
		System.out.println("Choice: ");
		int choice=sc.nextInt();
		Locale locale=null;
		switch(choice) {
		case 1:
			locale=new Locale("my","marathi"); //my_marathi
			
			break;
		case 2:
			locale=Locale.US;
			//System.out.println("Langugae name "+locale.getLanguage()+"City : "+locale.getCountry());
		
			break;
		case 3:
			locale=Locale.UK;
			//System.out.println("Langugae name "+locale.getLanguage()+"City : "+locale.getCountry());
		
			break;
		case 4:
			locale=Locale.FRANCE;
			//System.out.println("Langugae name "+locale.getLanguage()+"City : "+locale.getCountry());
		
			break;
			
		}
		System.out.println("Langugae name "+locale.getLanguage()+"City : "+locale.getCountry());
		String m=ms.getMessage("msg.pay",null, locale);
		String w=ms.getMessage("msg.welcome",new String[] {"Rajan"}, locale);
		String d=ms.getMessage("msg.data",null, locale);
		String currency=ms.getMessage("msg.currency",null, locale);
		System.out.println("Pay : "+m);
		System.out.println("Welcome : "+w);
		System.out.println("data : "+d);
		System.out.println("enter bill amount");
		double amt=sc.nextDouble();		System.out.println("You entered Amount  : "+amt+currency);
	}

}
