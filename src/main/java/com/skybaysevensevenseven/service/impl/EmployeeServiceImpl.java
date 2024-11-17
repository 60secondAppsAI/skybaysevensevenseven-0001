package com.skybaysevensevenseven.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



import com.skybaysevensevenseven.dao.GenericDAO;
import com.skybaysevensevenseven.service.GenericService;
import com.skybaysevensevenseven.service.impl.GenericServiceImpl;
import com.skybaysevensevenseven.dao.EmployeeDAO;
import com.skybaysevensevenseven.domain.Employee;
import com.skybaysevensevenseven.dto.EmployeeDTO;
import com.skybaysevensevenseven.dto.EmployeeSearchDTO;
import com.skybaysevensevenseven.dto.EmployeePageDTO;
import com.skybaysevensevenseven.dto.EmployeeConvertCriteriaDTO;
import com.skybaysevensevenseven.dto.common.RequestDTO;
import com.skybaysevensevenseven.dto.common.ResultDTO;
import com.skybaysevensevenseven.service.EmployeeService;
import com.skybaysevensevenseven.util.ControllerUtils;





@Service
public class EmployeeServiceImpl extends GenericServiceImpl<Employee, Integer> implements EmployeeService {

    private final static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeDAO employeeDao;

	


	@Override
	public GenericDAO<Employee, Integer> getDAO() {
		return (GenericDAO<Employee, Integer>) employeeDao;
	}
	
	public List<Employee> findAll () {
		List<Employee> employees = employeeDao.findAll();
		
		return employees;	
		
	}

	public ResultDTO addEmployee(EmployeeDTO employeeDTO, RequestDTO requestDTO) {

		Employee employee = new Employee();

		employee.setEmployeeId(employeeDTO.getEmployeeId());


		employee.setName(employeeDTO.getName());


		employee.setPosition(employeeDTO.getPosition());


		employee.setHireDate(employeeDTO.getHireDate());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		employee = employeeDao.save(employee);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<Employee> getAllEmployees(Pageable pageable) {
		return employeeDao.findAll(pageable);
	}

	public Page<Employee> getAllEmployees(Specification<Employee> spec, Pageable pageable) {
		return employeeDao.findAll(spec, pageable);
	}

	public ResponseEntity<EmployeePageDTO> getEmployees(EmployeeSearchDTO employeeSearchDTO) {
	
			Integer employeeId = employeeSearchDTO.getEmployeeId(); 
 			String name = employeeSearchDTO.getName(); 
 			String position = employeeSearchDTO.getPosition(); 
   			String sortBy = employeeSearchDTO.getSortBy();
			String sortOrder = employeeSearchDTO.getSortOrder();
			String searchQuery = employeeSearchDTO.getSearchQuery();
			Integer page = employeeSearchDTO.getPage();
			Integer size = employeeSearchDTO.getSize();

	        Specification<Employee> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, employeeId, "employeeId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, name, "name"); 
			
			spec = ControllerUtils.andIfNecessary(spec, position, "position"); 
			
 			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("name")), "%" + searchQuery.toLowerCase() + "%") 
             , cb.like(cb.lower(root.get("position")), "%" + searchQuery.toLowerCase() + "%") 
		));}
		
		Sort sort = Sort.unsorted();
		if (sortBy != null && !sortBy.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {
			if (sortOrder.equalsIgnoreCase("asc")) {
				sort = Sort.by(sortBy).ascending();
			} else if (sortOrder.equalsIgnoreCase("desc")) {
				sort = Sort.by(sortBy).descending();
			}
		}
		Pageable pageable = PageRequest.of(page, size, sort);

		Page<Employee> employees = this.getAllEmployees(spec, pageable);
		
		//System.out.println(String.valueOf(employees.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(employees.getTotalPages()));
		
		List<Employee> employeesList = employees.getContent();
		
		EmployeeConvertCriteriaDTO convertCriteria = new EmployeeConvertCriteriaDTO();
		List<EmployeeDTO> employeeDTOs = this.convertEmployeesToEmployeeDTOs(employeesList,convertCriteria);
		
		EmployeePageDTO employeePageDTO = new EmployeePageDTO();
		employeePageDTO.setEmployees(employeeDTOs);
		employeePageDTO.setTotalElements(employees.getTotalElements());
		return ResponseEntity.ok(employeePageDTO);
	}

	public List<EmployeeDTO> convertEmployeesToEmployeeDTOs(List<Employee> employees, EmployeeConvertCriteriaDTO convertCriteria) {
		
		List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		
		for (Employee employee : employees) {
			employeeDTOs.add(convertEmployeeToEmployeeDTO(employee,convertCriteria));
		}
		
		return employeeDTOs;

	}
	
	public EmployeeDTO convertEmployeeToEmployeeDTO(Employee employee, EmployeeConvertCriteriaDTO convertCriteria) {
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		employeeDTO.setEmployeeId(employee.getEmployeeId());

	
		employeeDTO.setName(employee.getName());

	
		employeeDTO.setPosition(employee.getPosition());

	
		employeeDTO.setHireDate(employee.getHireDate());

	

		
		return employeeDTO;
	}

	public ResultDTO updateEmployee(EmployeeDTO employeeDTO, RequestDTO requestDTO) {
		
		Employee employee = employeeDao.getById(employeeDTO.getEmployeeId());

		employee.setEmployeeId(ControllerUtils.setValue(employee.getEmployeeId(), employeeDTO.getEmployeeId()));

		employee.setName(ControllerUtils.setValue(employee.getName(), employeeDTO.getName()));

		employee.setPosition(ControllerUtils.setValue(employee.getPosition(), employeeDTO.getPosition()));

		employee.setHireDate(ControllerUtils.setValue(employee.getHireDate(), employeeDTO.getHireDate()));



        employee = employeeDao.save(employee);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public EmployeeDTO getEmployeeDTOById(Integer employeeId) {
	
		Employee employee = employeeDao.getById(employeeId);
			
		
		EmployeeConvertCriteriaDTO convertCriteria = new EmployeeConvertCriteriaDTO();
		return(this.convertEmployeeToEmployeeDTO(employee,convertCriteria));
	}







}
