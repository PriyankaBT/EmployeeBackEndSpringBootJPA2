package com.emp.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.emp.restapi.dao.DepartmentDao;
import com.emp.restapi.entity.Department;


@Service("deptSer")
@Scope("singleton")
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentDao deptDao;
	
	@Override
	public List<Department> getDepartmentList() {
		
		return deptDao.readAllDepartments();
	}

}
