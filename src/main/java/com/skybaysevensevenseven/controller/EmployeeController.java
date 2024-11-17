package com.skybaysevensevenseven.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;


import com.skybaysevensevenseven.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;

import com.skybaysevensevenseven.domain.Employee;
import com.skybaysevensevenseven.dto.EmployeeDTO;
import com.skybaysevensevenseven.dto.EmployeeSearchDTO;
import com.skybaysevensevenseven.dto.EmployeePageDTO;
import com.skybaysevensevenseven.service.EmployeeService;
import com.skybaysevensevenseven.dto.common.RequestDTO;
import com.skybaysevensevenseven.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/employee")
@RestController
public class EmployeeController {

	private final static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Employee> getAll() {

		List<Employee> employees = employeeService.findAll();
		
		return employees;	
	}

	@GetMapping(value = "/{employeeId}")
	@ResponseBody
	public EmployeeDTO getEmployee(@PathVariable Integer employeeId) {
		
		return (employeeService.getEmployeeDTOById(employeeId));
	}

 	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeDTO employeeDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = employeeService.addEmployee(employeeDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/employees")
	public ResponseEntity<EmployeePageDTO> getEmployees(EmployeeSearchDTO employeeSearchDTO) {
 
		return employeeService.getEmployees(employeeSearchDTO);
	}	

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDTO employeeDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = employeeService.updateEmployee(employeeDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
