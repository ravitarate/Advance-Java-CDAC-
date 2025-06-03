package com.demo.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class MyUser implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,InitializingBean,DisposableBean{
    private int uid;
    private String uname;
    private Address addr;
	public MyUser() {
		super();
	}
	public MyUser(int uid, String uname, Address addr) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.addr = addr;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "MyUser [uid=" + uid + ", uname=" + uname + ", addr=" + addr + "]";
	}
	public void setBeanName(String name) {
		System.out.println("in SetBeanName "+name);
		
	}
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("in setBeanFactory");
		
	}
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("in setApplicationContext method "+applicationContext.getDisplayName());
		
	}
	public void afterPropertiesSet() throws Exception {
		System.out.println("in after properties set");
		
	}
	
	//@PostConstruct
	public void myinit() {
		System.out.println("in myinit method");
	}
	public void destroy() throws Exception {
		System.out.println("in destroy method of disposableBean ");
		
	}
    
	//@PreDestroy
	public void mydestroy() {
		System.out.println("in custom destroy method");
	}
}
