package com.demo.service;

import java.util.List;

import com.demo.model.Employee;

public interface EmployeeService {

	void closeConnection();

	void addNewEmployee();

	List<Employee> getAllEmployees();

	List<Employee> sortedEmployees();

	boolean updateEmployee(int empno, String ename, double sal);

}
