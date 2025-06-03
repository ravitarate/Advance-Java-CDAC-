package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.model.Course;

public class TestAnnotationConfiguration {
public static void main(String[] args) {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
	Course c11=(Course)ctx.getBean("course");
	System.out.println(c11);
	((ClassPathXmlApplicationContext) ctx).close();
}
}
