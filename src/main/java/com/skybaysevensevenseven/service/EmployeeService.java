package com.skybaysevensevenseven.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skybaysevensevenseven.domain.Employee;
import com.skybaysevensevenseven.dto.EmployeeDTO;
import com.skybaysevensevenseven.dto.EmployeeSearchDTO;
import com.skybaysevensevenseven.dto.EmployeePageDTO;
import com.skybaysevensevenseven.dto.EmployeeConvertCriteriaDTO;
import com.skybaysevensevenseven.service.GenericService;
import com.skybaysevensevenseven.dto.common.RequestDTO;
import com.skybaysevensevenseven.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface EmployeeService extends GenericService<Employee, Integer> {

	List<Employee> findAll();

	ResultDTO addEmployee(EmployeeDTO employeeDTO, RequestDTO requestDTO);

	ResultDTO updateEmployee(EmployeeDTO employeeDTO, RequestDTO requestDTO);

    Page<Employee> getAllEmployees(Pageable pageable);

    Page<Employee> getAllEmployees(Specification<Employee> spec, Pageable pageable);

	ResponseEntity<EmployeePageDTO> getEmployees(EmployeeSearchDTO employeeSearchDTO);
	
	List<EmployeeDTO> convertEmployeesToEmployeeDTOs(List<Employee> employees, EmployeeConvertCriteriaDTO convertCriteria);

	EmployeeDTO getEmployeeDTOById(Integer employeeId);







}





