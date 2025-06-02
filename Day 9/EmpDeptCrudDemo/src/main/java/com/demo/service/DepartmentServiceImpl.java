package com.demo.service;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.demo.dao.DepartmentDao;
import com.demo.dao.DepartmentDaoImpl;
import com.demo.model.Department;

public class DepartmentServiceImpl implements DepartmentService{
   private DepartmentDao deptdao;

public DepartmentServiceImpl() {
	deptdao=new DepartmentDaoImpl();
}

public void addNewDepartment() {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter deptno");
	int deptno=sc.nextInt();
	System.out.println("enter department name");
	String dname=sc.next();
	System.out.println("enter location");
	String loc=sc.next();
	Department d=new Department(deptno,dname,loc,null);
	deptdao.saveDept(d);
}

@Override
public List<Department> getAllDepartments() {
	return deptdao.findAllDepartments();
}

@Override
public boolean updateDepartment(int deptno, String dname, String loc) {
	return deptdao.modifyDepartment(deptno,dname,loc);
}
   
}
