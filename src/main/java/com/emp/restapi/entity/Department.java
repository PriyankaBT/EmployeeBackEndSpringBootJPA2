package com.emp.restapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component("dept")
@Scope("prototype")
@Table(name = "Department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "deptno")   // pk
	private int deptno;

	@Column(name = "Deptname")
	private String deptname;

	@Column(name = "Location")
	private String location;
	
	public Department() {}
	
	public Department(int deptno, String deptname, String location) {
		super();
		deptno = deptno;
		this.deptname = deptname;
		this.location = location;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		deptno = deptno;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDept_Name(String deptname) {
		this.deptname = deptname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department [deptNo=" + deptno + ", deptName=" + deptname + ", location=" + location + "]";
	}
	
	
	
}
