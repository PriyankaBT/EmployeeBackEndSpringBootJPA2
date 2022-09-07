package com.emp.restapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emp.restapi.entity.Employees;

@Repository
public interface EmployeeDao123 extends JpaRepository<Employees, Integer>{

	@Query("Select emp From Employees emp where emp.designation=?1")
	public List<Employees> fetchEmpsByDesig(@Param("desig") String desig);

}
