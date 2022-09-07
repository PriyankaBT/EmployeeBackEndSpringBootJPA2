package com.emp.restapi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emp.restapi.entity.Address;
import com.emp.restapi.entity.Employees;

@Repository("empDao")
//@Scope("singleton")
public class EmployeeDaoImpl implements EmployeeDao {
	@PersistenceContext
	private EntityManager em;

	@Override

	public int saveEmployee(Employees emp) {

		Address address = emp.getAddress();

		em.persist(address);

		emp.setAddress(address);
		em.persist(emp);
		return emp.getEmpid();

	}

	@Override
	public Employees findEmpById(int emp_id) {
		return em.find(Employees.class, emp_id);

	}

	@Override
	public List<Employees> findAllEmployees() {

		// em.find(entityClass, primaryKey)
		// em.persist(entity);
		// em.merge(entity)
		// em.remove(entity);

		String strQuery = "select e from Employees e"; // JPQL
		TypedQuery<Employees> emptqury = em.createQuery(strQuery, Employees.class);
		return emptqury.getResultList();
	}

	@Override
	@Transactional
	public Employees editEmployee(Employees emp, int emp_id) {

		Employees emp1 = em.find(Employees.class, emp_id);

		if (emp1 != null) {
			// em.merge(emp);
			emp1.setAge(emp.getAge());
			emp1.setDesignation(emp.getDesignation());
			emp1.setJoindate(emp.getJoindate());
			emp1.setMaritalstatus(emp.getMaritalstatus());
			emp1.setName(emp.getName());
			emp1.setSalary(emp.getSalary());
			emp1.setAddress(emp.getAddress());
			emp1.setDepartment(emp.getDepartment());
			return emp1;
		} else {
			return null;
		}

	}

	@Override
	@Transactional
	public Integer deleteEmpById(int empId) {
		Employees e = em.find(Employees.class, empId);
		if (e != null) {
			em.remove(e);
			return empId;

			// return e.getEmpid();
		} else {
			return null;
		}

	}

}
