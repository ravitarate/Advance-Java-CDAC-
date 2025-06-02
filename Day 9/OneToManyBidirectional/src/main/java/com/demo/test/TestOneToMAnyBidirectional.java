package com.demo.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Department;
import com.demo.model.Employee;


public class TestOneToMAnyBidirectional {

	public static void main(String[] args) {
		Department d1=new Department(10,"admin","Pune",null);
		Department d2=new Department(11,"HR","Pune",null);
		Employee e1=new Employee(100,"Ashwini",34567,d1);
		Employee e2=new Employee(101,"Deepali",34545,d1);
		Employee e3=new Employee(102,"Snageeta",44444,d1);
		Employee e4=new Employee(103,"Kedar",34567,d2);
		Employee e5=new Employee(104,"Prasanna",34545,d2);
		Set<Employee> set1=new HashSet<>();
		set1.add(e1);
		set1.add(e2);
		set1.add(e3);
		d1.setElist(set1);
		Set<Employee> set2=new HashSet<>();
		set2.add(e4);
		set2.add(e5);
		d2.setElist(set2);
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(d1);
		sess.save(d2);
		sess.save(e1);
		sess.save(e2);
		sess.save(e3);
		sess.save(e4);
		sess.save(e5);
		
		tr.commit();
		sess.close();
		sf.close();
		
		
		
		

	}

}
