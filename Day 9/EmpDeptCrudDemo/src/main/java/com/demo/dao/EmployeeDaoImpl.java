package com.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.model.Department;
import com.demo.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	static SessionFactory sf;
	static {
		sf=HBUtil.getMySessionFactory();
	}

	public void closeConnection() {
		HBUtil.closeMySessionFactory();
		
	}

	public void saveEmp(Employee e) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(e);
		Department d=session.get(Department.class,e.getDept().getDeptno());
		e.setDept(d);
		session.saveOrUpdate(e);
		tr.commit();
		session.close();
		System.out.println("employee saved");
		
		
	}

	@Override
	public List<Employee> findAllEmployees() {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Query q=session.createQuery("from Employee");
		List<Employee> elist=q.getResultList();
		tr.commit();
		session.close();
		return elist;		
	}

	@Override
	public List<Employee> sortedEmployees() {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Query q=session.createQuery("from Employee e order by e.sal desc");
		List<Employee> elist=q.getResultList();
		tr.commit();
		session.close();
		return elist;
	}

	@Override
	public boolean modifyEmployee(int empno, String ename, double sal) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Employee e=session.get(Employee.class, empno);
		//check employee found or not
		if(e!=null) {
			e.setEname(ename);
			e.setSal(sal);
			//session.merge(e);
			//session.saveOrUpdate(e);
			session.update(e);
			tr.commit();
			session.close();
			return true;
			
		}
		session.close();
		return false;
	}

}
