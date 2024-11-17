package com.skybaysevensevenseven.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skybaysevensevenseven.domain.Maintenance;
import com.skybaysevensevenseven.dto.MaintenanceDTO;
import com.skybaysevensevenseven.dto.MaintenanceSearchDTO;
import com.skybaysevensevenseven.dto.MaintenancePageDTO;
import com.skybaysevensevenseven.dto.MaintenanceConvertCriteriaDTO;
import com.skybaysevensevenseven.service.GenericService;
import com.skybaysevensevenseven.dto.common.RequestDTO;
import com.skybaysevensevenseven.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface MaintenanceService extends GenericService<Maintenance, Integer> {

	List<Maintenance> findAll();

	ResultDTO addMaintenance(MaintenanceDTO maintenanceDTO, RequestDTO requestDTO);

	ResultDTO updateMaintenance(MaintenanceDTO maintenanceDTO, RequestDTO requestDTO);

    Page<Maintenance> getAllMaintenances(Pageable pageable);

    Page<Maintenance> getAllMaintenances(Specification<Maintenance> spec, Pageable pageable);

	ResponseEntity<MaintenancePageDTO> getMaintenances(MaintenanceSearchDTO maintenanceSearchDTO);
	
	List<MaintenanceDTO> convertMaintenancesToMaintenanceDTOs(List<Maintenance> maintenances, MaintenanceConvertCriteriaDTO convertCriteria);

	MaintenanceDTO getMaintenanceDTOById(Integer maintenanceId);







}





