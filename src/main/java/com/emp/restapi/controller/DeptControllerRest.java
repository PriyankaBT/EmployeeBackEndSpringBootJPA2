package com.emp.restapi.controller;

import java.util.List;
import org.springframework.http.MediaType;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.restapi.entity.Department;
import com.emp.restapi.entity.Employees;
import com.emp.restapi.service.DepartmentService;
import com.emp.restapi.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/dept", produces = { MediaType.APPLICATION_JSON_VALUE })
public class DeptControllerRest {

	@Autowired
	private DepartmentService deptSer;

	

	@GetMapping(value = "/departments", produces = "application/json")
	@ResponseBody
	public List<Department> findallDepartments() {
		
		return deptSer.getDepartmentList();
	}

	
}
