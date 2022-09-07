package com.emp.restapi.dao;

import java.util.List;

import com.emp.restapi.entity.Address;
import com.emp.restapi.entity.Department;

public interface DepartmentDao {

	List<Department> readAllDepartments();

	

}
