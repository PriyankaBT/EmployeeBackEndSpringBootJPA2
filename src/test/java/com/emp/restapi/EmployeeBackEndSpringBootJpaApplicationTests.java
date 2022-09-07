package com.emp.restapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.emp.restapi.entity.Employees;
import com.emp.restapi.exception.EmployeeNotFoundException;
import com.emp.restapi.exception.InvalidIdForUpdateException;
import com.emp.restapi.service.EmployeeService;


@SpringBootTest
class EmployeeBackEndSpringBootJpaApplicationTests {

	@Autowired
	private EmployeeService service;
	
	@Test
	void testFetchEmployeeById() throws EmployeeNotFoundException{
		
		Employees result = service.fetchEmployeeById(104);
		System.out.println(result);
		assertEquals("PREM", result.getName());
		assertEquals(25, result.getAge());
		assertEquals("100", result.getAddress().getHouseno());
	
	}
	
	
	@Test
	void testDeleteEmployeeShouldThrowInvalidIdForDeleteException() {
		assertNull(service.removeEmployee(-1));
	}
	
	
	@Test
	void testUpdateEmployeeShouldThrowInvalidIdForUpdateException() {
		assertNull(service.updateEmployee(new Employees(),-1));
	}
	
}
