package com.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Course {
	@Value("10")
	private int cid;
	@Value("Java")
	private String cname;
	@Value("100")
	private int duration;
	@Autowired
	private Faculty faculty;
	public Course() {
		super();
	}
	public Course(int cid, String cname, int duration, Faculty f) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.duration = duration;
		this.faculty = f;
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
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty f) {
		this.faculty = f;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", duration=" + duration + ", faculty=" + faculty + "]";
	}
	

}
