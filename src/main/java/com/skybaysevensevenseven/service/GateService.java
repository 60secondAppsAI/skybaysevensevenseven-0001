package com.skybaysevensevenseven.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skybaysevensevenseven.domain.Gate;
import com.skybaysevensevenseven.dto.GateDTO;
import com.skybaysevensevenseven.dto.GateSearchDTO;
import com.skybaysevensevenseven.dto.GatePageDTO;
import com.skybaysevensevenseven.dto.GateConvertCriteriaDTO;
import com.skybaysevensevenseven.service.GenericService;
import com.skybaysevensevenseven.dto.common.RequestDTO;
import com.skybaysevensevenseven.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface GateService extends GenericService<Gate, Integer> {

	List<Gate> findAll();

	ResultDTO addGate(GateDTO gateDTO, RequestDTO requestDTO);

	ResultDTO updateGate(GateDTO gateDTO, RequestDTO requestDTO);

    Page<Gate> getAllGates(Pageable pageable);

    Page<Gate> getAllGates(Specification<Gate> spec, Pageable pageable);

	ResponseEntity<GatePageDTO> getGates(GateSearchDTO gateSearchDTO);
	
	List<GateDTO> convertGatesToGateDTOs(List<Gate> gates, GateConvertCriteriaDTO convertCriteria);

	GateDTO getGateDTOById(Integer gateId);







}





