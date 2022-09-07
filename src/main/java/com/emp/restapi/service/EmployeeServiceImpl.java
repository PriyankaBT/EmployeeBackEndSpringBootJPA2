package com.emp.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.emp.restapi.dao.EmployeeDao;
import com.emp.restapi.dao.EmployeeDao123;
//import com.emp.restapi.dao.EmployeeDao1;
import com.emp.restapi.entity.Employees;
import com.emp.restapi.exception.EmployeeNotFoundException;
import com.emp.restapi.exception.InvalidIdForDeleteException;
import com.emp.restapi.exception.InvalidIdForUpdateException;

@Service("empSer")
//@Scope("singleton")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao123 empDao;

	@Override
	public Employees fetchEmployeeById(int empId) {
//return empDao.findEmpById(empId);
		return empDao.findById(empId).get();

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Employees saveEmployee(Employees emp) {  // dml

//		int id= empDao.saveEmployee(emp);
//		 return empDao.findEmpById(id);
		return empDao.save(emp);
		
		
	}

	@Override
	public List<Employees> readAllEmployees() {

//		 List<Employees> empList = empDao.findAllEmployees();
//List<Employees> empList = empDao.findAll();
		return empDao.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Employees updateEmployee(Employees emp, int empId) { // dml
		//Optional<Employees> emp1= empDao.findById(empId);
//		if(emp1==null) {
//			throw new InvalidIdForUpdateException("Id not found");
//		}
//	   emp.setEmpid(empId);
//		return empDao.editEmployee(emp, empId);
		
		return empDao.save(emp);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean removeEmployee(int id) {  // dml

// empDao.deleteById(id);
//return empDao.existsById(id);
//		int id1=empDao.deleteEmpById(id);
		empDao.deleteById(id);
		Employees e=empDao.findById(id).get();
		if(e==null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Employees> fetchByDesig(String desig) {
		return empDao.fetchEmpsByDesig(desig);
	}
}
