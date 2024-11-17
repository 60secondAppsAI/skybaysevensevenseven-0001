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
import com.skybaysevensevenseven.dao.GateDAO;
import com.skybaysevensevenseven.domain.Gate;
import com.skybaysevensevenseven.dto.GateDTO;
import com.skybaysevensevenseven.dto.GateSearchDTO;
import com.skybaysevensevenseven.dto.GatePageDTO;
import com.skybaysevensevenseven.dto.GateConvertCriteriaDTO;
import com.skybaysevensevenseven.dto.common.RequestDTO;
import com.skybaysevensevenseven.dto.common.ResultDTO;
import com.skybaysevensevenseven.service.GateService;
import com.skybaysevensevenseven.util.ControllerUtils;





@Service
public class GateServiceImpl extends GenericServiceImpl<Gate, Integer> implements GateService {

    private final static Logger logger = LoggerFactory.getLogger(GateServiceImpl.class);

	@Autowired
	GateDAO gateDao;

	


	@Override
	public GenericDAO<Gate, Integer> getDAO() {
		return (GenericDAO<Gate, Integer>) gateDao;
	}
	
	public List<Gate> findAll () {
		List<Gate> gates = gateDao.findAll();
		
		return gates;	
		
	}

	public ResultDTO addGate(GateDTO gateDTO, RequestDTO requestDTO) {

		Gate gate = new Gate();

		gate.setGateId(gateDTO.getGateId());


		gate.setNumber(gateDTO.getNumber());


		gate.setTerminal(gateDTO.getTerminal());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		gate = gateDao.save(gate);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<Gate> getAllGates(Pageable pageable) {
		return gateDao.findAll(pageable);
	}

	public Page<Gate> getAllGates(Specification<Gate> spec, Pageable pageable) {
		return gateDao.findAll(spec, pageable);
	}

	public ResponseEntity<GatePageDTO> getGates(GateSearchDTO gateSearchDTO) {
	
			Integer gateId = gateSearchDTO.getGateId(); 
 			String number = gateSearchDTO.getNumber(); 
 			String terminal = gateSearchDTO.getTerminal(); 
 			String sortBy = gateSearchDTO.getSortBy();
			String sortOrder = gateSearchDTO.getSortOrder();
			String searchQuery = gateSearchDTO.getSearchQuery();
			Integer page = gateSearchDTO.getPage();
			Integer size = gateSearchDTO.getSize();

	        Specification<Gate> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, gateId, "gateId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, number, "number"); 
			
			spec = ControllerUtils.andIfNecessary(spec, terminal, "terminal"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("number")), "%" + searchQuery.toLowerCase() + "%") 
             , cb.like(cb.lower(root.get("terminal")), "%" + searchQuery.toLowerCase() + "%") 
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

		Page<Gate> gates = this.getAllGates(spec, pageable);
		
		//System.out.println(String.valueOf(gates.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(gates.getTotalPages()));
		
		List<Gate> gatesList = gates.getContent();
		
		GateConvertCriteriaDTO convertCriteria = new GateConvertCriteriaDTO();
		List<GateDTO> gateDTOs = this.convertGatesToGateDTOs(gatesList,convertCriteria);
		
		GatePageDTO gatePageDTO = new GatePageDTO();
		gatePageDTO.setGates(gateDTOs);
		gatePageDTO.setTotalElements(gates.getTotalElements());
		return ResponseEntity.ok(gatePageDTO);
	}

	public List<GateDTO> convertGatesToGateDTOs(List<Gate> gates, GateConvertCriteriaDTO convertCriteria) {
		
		List<GateDTO> gateDTOs = new ArrayList<GateDTO>();
		
		for (Gate gate : gates) {
			gateDTOs.add(convertGateToGateDTO(gate,convertCriteria));
		}
		
		return gateDTOs;

	}
	
	public GateDTO convertGateToGateDTO(Gate gate, GateConvertCriteriaDTO convertCriteria) {
		
		GateDTO gateDTO = new GateDTO();
		
		gateDTO.setGateId(gate.getGateId());

	
		gateDTO.setNumber(gate.getNumber());

	
		gateDTO.setTerminal(gate.getTerminal());

	

		
		return gateDTO;
	}

	public ResultDTO updateGate(GateDTO gateDTO, RequestDTO requestDTO) {
		
		Gate gate = gateDao.getById(gateDTO.getGateId());

		gate.setGateId(ControllerUtils.setValue(gate.getGateId(), gateDTO.getGateId()));

		gate.setNumber(ControllerUtils.setValue(gate.getNumber(), gateDTO.getNumber()));

		gate.setTerminal(ControllerUtils.setValue(gate.getTerminal(), gateDTO.getTerminal()));



        gate = gateDao.save(gate);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public GateDTO getGateDTOById(Integer gateId) {
	
		Gate gate = gateDao.getById(gateId);
			
		
		GateConvertCriteriaDTO convertCriteria = new GateConvertCriteriaDTO();
		return(this.convertGateToGateDTO(gate,convertCriteria));
	}







}
