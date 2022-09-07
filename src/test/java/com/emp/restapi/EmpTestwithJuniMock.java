package com.emp.restapi;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;
import com.emp.restapi.entity.Employees;
import com.emp.restapi.service.EmployeeService;
import com.emp.restapi.dao.EmployeeDao123;

@SpringBootTest
class EmpTestwithJuniMock {

			
		@Autowired
		EmployeeService empservice;
		
		@MockBean
		EmployeeDao123 emprepo;

		@Test
		void testGetEmps() {
			Employees e1=new Employees();
			e1.setEmpid(1);
			e1.setName("Priyanka");
			e1.setSalary(50000);
			
			Employees e2=new Employees();
			e1.setEmpid(2);
			e1.setName("Krutika");
			e1.setSalary(50000);
			
			List<Employees> empList = new ArrayList<>();
			empList.add(e1);
			empList.add(e2);
			
			Mockito.when(emprepo.findAll()).thenReturn(empList);
			
			assertThat(empservice.readAllEmployees().equals(empList));
			
		}

		@Test
		void testGetEmpById() {
			Employees e1=new Employees();
			e1.setEmpid(2);
			e1.setName("Krutika");
			e1.setSalary(50000);
			
			Optional<Employees> e2=Optional.of(e1);
			
	   Mockito.when(emprepo.findById(2)).thenReturn(e2);
	   assertThat(empservice.fetchEmployeeById(2)).isEqualTo(e2);
		}

		@Test
		void testCreateEmp() {
			Employees e1=new Employees();
			e1.setEmpid(3);
			e1.setName("Ritika");
			e1.setSalary(50000);
	   Mockito.when(emprepo.save(e1)).thenReturn(e1);
	   assertThat(empservice.saveEmployee(e1)).isEqualTo(e1);
		}

//		@Test
//		void testAddEmps() {
//			Employees e1=new Employees();
//			e1.setEmpid(1);
//			e1.setName("Priyanka");
//			e1.setSalary(50000);
//			
//			Employees e2=new Employees();
//			e1.setEmpid(2);
//			e1.setName("Krutika");
//			e1.setSalary(50000);
//			
//			List<Employees> empList = new ArrayList<>();
//			empList.add(e1);
//			empList.add(e2);
//			
//			Mockito.when(emprepo.saveAll(empList)).thenReturn(empList);
//			
//			assertThat(empservice.addAllEmps(empList)).isEqualTo(empList);
//		}

		@Test
		void testUpdateEmp() throws Exception {
			Employees e1=new Employees();
			e1.setEmpid(4);
			e1.setName("Monika");
			e1.setSalary(50000);
			
			Optional<Employees> e2=Optional.of(e1);
		
			Mockito.when(emprepo.findById(4)).thenReturn(e2);
			e1.setName("Madhulika");
	 
			Mockito.when(emprepo.save(e1)).thenReturn(e1);
	  
			assertThat(empservice.updateEmployee(e1,4)).isEqualTo(e1);
		}

		@Test
		void testDeleteEmp() {
			Employees e1=new Employees();
			e1.setEmpid(5);
			e1.setName("Radhika");
			e1.setSalary(50000);
			
			
			Optional<Employees> e2=Optional.of(e1);
			
			Mockito.when(emprepo.findById(5)).thenReturn(e2);
			
			Mockito.when(emprepo.existsById(e1.getEmpid())).thenReturn(false);
			   assertFalse(emprepo.existsById(e1.getEmpid()));
		}

		/*
		 * @Test void testDeleteEmpById() {
		 * 
		 * }
		 */

	}


