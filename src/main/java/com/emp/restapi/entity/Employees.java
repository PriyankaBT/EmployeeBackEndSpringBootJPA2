package com.emp.restapi.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
//@Component("emp1")
//@Scope("prototype")
@Table(name = "Employees")
public class Employees {

	@Id
	@Column(name = "Empid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empid;

	@Column(name = "Name")
	private String name;

	@Column(name = "Age")
	private int age;

	@Column(name = "Designation")
	private String designation;

	@Column(name = "Salary")
	private float salary;

	@Column(name = "Joindate")
	@Temporal(TemporalType.DATE)
	private Date joindate;

	@Column(name = "Maritalstatus")
	private String maritalstatus;

	public Employees() {
		// System.out.println("No Args");
	}

	public Employees(int empid, String name, int age, String designation, float salary, Date joindate,
			String maritalstatus, Address address) {

		this.empid = empid;
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.salary = salary;
		this.joindate = joindate;
		this.maritalstatus = maritalstatus;
		this.address = address;
	}

	@OneToOne
	@JoinColumn(name = "Addressid", referencedColumnName = "Addid")
	private Address address;

	// private int addressid; fk

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Autowired
	@ManyToOne
	@JoinColumn(name = "Deptno", referencedColumnName = "Deptno")
	private Department dept;

	public Department getDepartment() {
		return dept;
	}

	public void setDepartment(Department dept) {
		this.dept = dept;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int id) {
		this.empid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public String getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	@Override
	public String toString() {
		return "Employees [empid=" + empid + ", name=" + name + ", age=" + age + ", designation=" + designation
				+ ", salary=" + salary + ", joindate=" + joindate + ", marital_Status=" + maritalstatus + ", address="
				+ address + ", dept=" + dept + "]";
	}

	

}
