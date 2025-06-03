package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.model.MyUser;

public class TestLifeCycleMethods {
   public static void main(String[] args) {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
	System.out.println("before getbean");
	MyUser u11=(MyUser)ctx.getBean("u1");
	System.out.println(u11);
	((ClassPathXmlApplicationContext) ctx).close();
}
}
