package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;
import com.demo.model.Department;
import com.demo.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{
   private EmployeeDao empdao;

public EmployeeServiceImpl() {
	empdao=new EmployeeDaoImpl();
}

public void closeConnection() {
	empdao.closeConnection();
	
}

public void addNewEmployee() {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter empno");
	int empno=sc.nextInt();
	System.out.println("enetr name");
	String ename=sc.next();
	System.out.println("enter salary");
	double sal=sc.nextDouble();
	System.out.println("enetr department no");
	int deptno=sc.nextInt();
	Employee e=new Employee(empno,ename,sal,new Department(deptno));
	empdao.saveEmp(e);
	
	
}

@Override
public List<Employee> getAllEmployees() {
	return empdao.findAllEmployees();
	
}

@Override
public List<Employee> sortedEmployees() {
	return empdao.sortedEmployees();
}

@Override
public boolean updateEmployee(int empno, String ename, double sal) {
	return empdao.modifyEmployee(empno,ename,sal);
}
   
}
