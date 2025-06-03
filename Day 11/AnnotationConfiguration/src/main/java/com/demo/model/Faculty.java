package com.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Faculty {
	@Value("23")
	private int fid;
	@Value("Rama")
	private String fname;
	@Value("Java")
	private String skill;
	public Faculty() {
		super();
	}
	public Faculty(int fid, String fname, String skill) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.skill = skill;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fname=" + fname + ", skill=" + skill + "]";
	}
	

}
