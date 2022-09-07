package com.emp.restapi.service;

import java.util.List;
import java.util.Optional;

import com.emp.restapi.entity.Employees;
import com.emp.restapi.exception.EmployeeNotFoundException;
import com.emp.restapi.exception.InvalidIdForDeleteException;
import com.emp.restapi.exception.InvalidIdForUpdateException;

public interface EmployeeService {

	Employees fetchEmployeeById(int empId);

	Employees saveEmployee(Employees emp);

	List<Employees> readAllEmployees();

	Employees updateEmployee(Employees emp, int empId);

	boolean removeEmployee(int id);
	
	List<Employees> fetchByDesig(String desig);

}
