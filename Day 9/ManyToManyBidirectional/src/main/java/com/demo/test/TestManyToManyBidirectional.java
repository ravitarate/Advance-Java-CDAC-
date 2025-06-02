package com.demo.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Employee;
import com.demo.model.Project;

public class TestManyToManyBidirectional {
public static void main(String[] args) {
	Employee e1=new Employee(100,"Ashwini",34567,null);
	Employee e2=new Employee(101,"Deepali",35567,null);
	Employee e3=new Employee(102,"Sangeeta",36567,null);
	Employee e4=new Employee(104,"prassana",34567,null);
	Set<Employee> set1=new HashSet<>();
	set1.add(e1);
	set1.add(e2);
	set1.add(e3);
	Set<Employee> set2=new HashSet<>();
	set2.add(e1);
	set2.add(e2);
	set2.add(e4);
	Project proj1=new Project(11,"project1",345,set1);
	Project proj2=new Project(12,"project2",456,set2);
	Set<Project> pset1=new HashSet<>();
	pset1.add(proj1);
	pset1.add(proj2);
	Set<Project> pset2=new HashSet<>();
	pset2.add(proj1);
	Set<Project> pset3=new HashSet<>();
	pset3.add(proj2);
	e1.setPlist(pset1);
	e2.setPlist(pset1);
	e3.setPlist(pset2);
	e4.setPlist(pset3);
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session sess=sf.openSession();
	Transaction tr=sess.beginTransaction();
	sess.save(proj1);
	sess.save(proj2);
	sess.save(e1);
	sess.save(e2);
	sess.save(e3);
	sess.save(e4);
	tr.commit();
	sess.close();
	sf.close();
}
}
