package com.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="emp22")
public class Employee {
	@Id
	private int empno;
	private String ename;
	private double salary;
	@ManyToMany
	@JoinTable(name="emp_proj",joinColumns = {@JoinColumn(name="empno")},
	inverseJoinColumns = {@JoinColumn(name="pid")} )
	Set<Project> plist;
	public Employee() {
		super();
	}
	public Employee(int empno, String ename, double salary, Set<Project> plist) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.salary = salary;
		this.plist = plist;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Set<Project> getPlist() {
		return plist;
	}
	public void setPlist(Set<Project> plist) {
		this.plist = plist;
	}
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", salary=" + salary + ", plist=" + plist + "]";
	}

}
