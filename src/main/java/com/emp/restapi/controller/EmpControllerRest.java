package com.emp.restapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emp.restapi.entity.Employees;
import com.emp.restapi.exception.EmployeeNotFoundException;
import com.emp.restapi.exception.InvalidIdForDeleteException;
import com.emp.restapi.exception.InvalidIdForUpdateException;
import com.emp.restapi.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/emp", produces = { MediaType.APPLICATION_JSON_VALUE })
public class EmpControllerRest {

	@Autowired
	private EmployeeService empSer;

	@RequestMapping("/")
	public String showHome() {
		return "home";
	}

// http://localhost:8092/emp/employees/104
	@GetMapping(value = "/employees/{emp_id}", produces = "application/json")
	public ResponseEntity<Employees> getEmployeesById(@PathVariable int emp_id) throws EmployeeNotFoundException {
		Employees emp = empSer.fetchEmployeeById(emp_id);
		if (emp == null) {
			// return new ResponseEntity("No Employee found for ID " + emp_id,
			// HttpStatus.NOT_FOUND);
			throw new EmployeeNotFoundException();
		}

		return new ResponseEntity(emp, HttpStatus.OK);
	}

	@PostMapping(value = "/employees", consumes = "application/json")
	public ResponseEntity<Employees> addEmployee(@RequestBody Employees emp) {

		Employees id = empSer.saveEmployee(emp);

		return new ResponseEntity<Employees>(id, HttpStatus.OK);
	}

	@GetMapping(value = "/employees", produces = "application/json")
	public List<Employees> findallEmployees() {

		return empSer.readAllEmployees();
	}

	@PutMapping(value = "/employees/{emp_id}", consumes = "application/json")
	public ResponseEntity update(@RequestBody Employees emp, @PathVariable int emp_id)
			throws InvalidIdForUpdateException {
		Employees emp1 = empSer.updateEmployee(emp, emp_id);
		if (null == emp1) {
			// return new ResponseEntity("No Employee found for ID " + emp_id,
			// HttpStatus.NOT_FOUND);
			throw new InvalidIdForUpdateException("Unable to update!");
		}

		return new ResponseEntity(emp1, HttpStatus.OK);
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity deleteEmployee(@PathVariable int id) throws InvalidIdForUpdateException {

		if (false == empSer.removeEmployee(id)) {
			// return new ResponseEntity("No Employee found for ID " + id,
			// HttpStatus.NOT_FOUND);
			throw new InvalidIdForDeleteException();
		}

		return new ResponseEntity(id, HttpStatus.OK);
	}

	@ExceptionHandler(value = EmployeeNotFoundException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Employee Not Found")
	public void handleFindEmployee() {

	}

	@ExceptionHandler(value = InvalidIdForUpdateException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Update failed due to invalid emplyee id!")
	public void handleUpdateEmployee() {

	}
}
