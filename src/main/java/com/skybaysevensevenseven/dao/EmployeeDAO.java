package com.skybaysevensevenseven.dao;

import java.util.List;

import com.skybaysevensevenseven.dao.GenericDAO;
import com.skybaysevensevenseven.domain.Employee;





public interface EmployeeDAO extends GenericDAO<Employee, Integer> {
  
	List<Employee> findAll();
	






}


