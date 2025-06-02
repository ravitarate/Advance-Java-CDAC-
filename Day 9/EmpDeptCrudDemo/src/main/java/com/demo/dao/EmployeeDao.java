package com.demo.dao;

import java.util.List;

import com.demo.model.Employee;

public interface EmployeeDao {

	void closeConnection();

	void saveEmp(Employee e);

	List<Employee> findAllEmployees();

	List<Employee> sortedEmployees();

	boolean modifyEmployee(int empno, String ename, double sal);

}
