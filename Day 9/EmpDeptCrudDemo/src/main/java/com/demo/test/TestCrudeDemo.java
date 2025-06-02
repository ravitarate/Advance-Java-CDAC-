package com.demo.test;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.demo.model.Department;
import com.demo.model.Employee;
import com.demo.service.DepartmentService;
import com.demo.service.DepartmentServiceImpl;
import com.demo.service.EmployeeService;
import com.demo.service.EmployeeServiceImpl;

public class TestCrudeDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EmployeeService eservice=new EmployeeServiceImpl();
		DepartmentService dservice=new DepartmentServiceImpl();
		int choice=0;
		do {
			System.out.println("1.Add new Employee\n2. Add new Department\n3. Delete Employee\n");
			System.out.println("4.Delete Employee\n5. modify department\n6. modify employee\n");
			System.out.println("7.Display employee by id \n8. Display department by id\n9. Display all departments\n");
			System.out.println("10.Display all Employees\n11. display employees in sorted order\n12. exit\n");
			System.out.println("Choice : ");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				eservice.addNewEmployee();
				break;
			case 2:
				dservice.addNewDepartment();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				System.out.println("enetr departmentno");
				int deptno=sc.nextInt();
				System.out.println("enetr departmentname");
				String dname=sc.next();
				System.out.println("enetr department loc");
				String loc=sc.next();
				boolean status=dservice.updateDepartment(deptno,dname,loc);
				if(status) {
					System.out.println("Department updated");
				}else {
					System.out.println("not found");
				}
		
				break;
			case 6:
				System.out.println("enter empno");
				int empno=sc.nextInt();
				System.out.println("enetr name");
				String ename=sc.next();
				System.out.println("enetr salary");
				double sal=sc.nextDouble();
				 status=eservice.updateEmployee(empno,ename,sal);
				if(status) {
					System.out.println("Employee updated");
				}else {
					System.out.println("not found");
				}
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				List<Department> dset=dservice.getAllDepartments();
				dset.forEach(System.out::println);
				break;
			case 10:
				List<Employee> elist=eservice.getAllEmployees();
				elist.forEach(System.out::println);
				break;
			case 11:
				elist=eservice.sortedEmployees();
				elist.forEach(System.out::println);
				break;
			case 12:
				eservice.closeConnection();
				sc.close();
				System.out.println("Thank you for visiting .....");
				break;
			default:
				System.out.println("wrong choice");
				break;
			}
		}while(choice!=12);

	}

}
