package com.demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAopClass {
	
	@Before("execution (* com.demo.model.*.b*(..))")
	public void beforemethod() {
		System.out.println("It should be called before all pointcuts");
	}
	
	
	@After("execution (* com.demo.model.*.b*(..))")
	public void aftermethod() {
		System.out.println("It should be called after all pointcuts");
	}
	
	@Around("execution (* com.demo.model.*.b*(..))")
	public Object aroundAdvice(ProceedingJoinPoint jpoint) throws Throwable {
		System.out.println("in ----around advice before method call");
		Object obj=jpoint.proceed();
		System.out.println("in ----around advice after method call");
		return obj;
	}

}
