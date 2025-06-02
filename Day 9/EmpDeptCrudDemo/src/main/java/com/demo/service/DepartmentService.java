package com.demo.service;

import java.util.List;
import java.util.Set;

import com.demo.model.Department;

public interface DepartmentService {

	void addNewDepartment();

	List<Department> getAllDepartments();

	boolean updateDepartment(int deptno, String dname, String loc);

}
