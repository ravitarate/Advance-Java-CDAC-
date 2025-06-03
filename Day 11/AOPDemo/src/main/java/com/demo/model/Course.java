package com.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Course {
	@Value("11")
	private int cid;
	@Value("Java")
	private String cname;
	
	public Course() {
		super();
	}
	public Course(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public void bookCourse(String name) {
		System.out.println("Course is booked "+name);
	}
	
	public void buyCourse(String name) {
		System.out.println("Course is purchased"+name);
	}
	
	public void viewCourse() {
		System.out.println("Course is displayed ");
	}
	
	

}
