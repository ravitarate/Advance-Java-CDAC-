package com.demo.dao;

import java.util.List;
import java.util.Set;

import com.demo.model.Department;

public interface DepartmentDao {
	public void closeConnection();

	public void saveDept(Department d);

	public List<Department> findAllDepartments();

	public boolean modifyDepartment(int deptno, String dname, String loc);
}
