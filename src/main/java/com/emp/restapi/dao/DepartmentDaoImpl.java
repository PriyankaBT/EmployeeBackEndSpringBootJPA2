package com.emp.restapi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.emp.restapi.entity.Department;
import com.emp.restapi.entity.Employees;

@Repository("deptDao")
@Scope("singleton")
public class DepartmentDaoImpl implements DepartmentDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Department> readAllDepartments() {
		TypedQuery<Department> depts = em.createQuery("select d from Department d", Department.class);
		return depts.getResultList();
	}



}
