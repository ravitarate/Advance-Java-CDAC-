package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.model.Course;

public class TestAopDemo {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		Course c=(Course)ctx.getBean("course");
		c.bookCourse("Savita");
		c.buyCourse("Savita");
		c.viewCourse();
         ((ClassPathXmlApplicationContext) ctx).close();
	}

}
