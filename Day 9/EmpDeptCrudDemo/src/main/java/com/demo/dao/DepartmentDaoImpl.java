package com.demo.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.model.Department;
import com.demo.model.Employee;

public class DepartmentDaoImpl implements DepartmentDao{
	static SessionFactory sf;
	static {
		sf=HBUtil.getMySessionFactory();
	}
	public void closeConnection() {
		HBUtil.closeMySessionFactory();
		
	}
	public void saveDept(Department d) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(d);
		tr.commit();
		session.close();
		
		
	}
	@Override
	public List<Department> findAllDepartments() {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Query q=session.createQuery("from Department");
		List<Department> dlist=q.getResultList();
		tr.commit();
		session.close();
		return dlist;
	}
	@Override
	public boolean modifyDepartment(int deptno, String dname, String loc) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Department d=session.get(Department.class, deptno);
		//check employee found or not
		if(d!=null) {
			d.setDname(dname);
			d.setDloc(loc);
			//session.merge(d);
			//session.saveOrUpdate(d);
			session.update(d);
			tr.commit();
			session.close();
			return true;
			
		}
		session.close();
		return false;
	}
}
