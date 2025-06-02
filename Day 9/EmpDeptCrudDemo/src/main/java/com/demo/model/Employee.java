package com.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="emp11")
public class Employee {
	@Id
    private int empno;
    private String ename;
    private double sal;
    @ManyToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name="deptno")
    Department dept;
	public Employee() {
		super();
	}
	public Employee(int empno, String ename, double sal, Department dept) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.dept = dept;
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
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", sal=" + sal + ", dept=" + dept + "]";
	}
    
}
