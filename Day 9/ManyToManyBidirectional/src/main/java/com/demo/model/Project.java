package com.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="project33")
public class Project {
	@Id
   private int pid;
   private String projname;
   private int duration;
   @ManyToMany(mappedBy="plist")
   Set<Employee> eset;
public Project() {
	super();
}
public Project(int pid, String projname, int duration, Set<Employee> eset) {
	super();
	this.pid = pid;
	this.projname = projname;
	this.duration = duration;
	this.eset = eset;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getProjname() {
	return projname;
}
public void setProjname(String projname) {
	this.projname = projname;
}
public int getDuration() {
	return duration;
}
public void setDuration(int duration) {
	this.duration = duration;
}
public Set<Employee> getEset() {
	return eset;
}
public void setEset(Set<Employee> eset) {
	this.eset = eset;
}
@Override
public String toString() {
	return "Project [pid=" + pid + ", projname=" + projname + ", duration=" + duration + ", eset=" + eset + "]";
}
   
}
