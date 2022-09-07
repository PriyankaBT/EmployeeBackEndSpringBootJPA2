package com.emp.restapi.dao;

import java.util.List;

import com.emp.restapi.entity.Employees;
import com.emp.restapi.exception.EmployeeNotFoundException;
import com.emp.restapi.exception.InvalidIdForUpdateException;

public interface EmployeeDao {

	int saveEmployee(Employees emp);

	Employees findEmpById(int emp_id);

	List<Employees> findAllEmployees();

	Integer deleteEmpById(int id);

	Employees editEmployee(Employees emp, int emp_id);

	

}
