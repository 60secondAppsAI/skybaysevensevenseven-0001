package com.skybaysevensevenseven.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skybaysevensevenseven.domain.Baggage;
import com.skybaysevensevenseven.dto.BaggageDTO;
import com.skybaysevensevenseven.dto.BaggageSearchDTO;
import com.skybaysevensevenseven.dto.BaggagePageDTO;
import com.skybaysevensevenseven.dto.BaggageConvertCriteriaDTO;
import com.skybaysevensevenseven.service.GenericService;
import com.skybaysevensevenseven.dto.common.RequestDTO;
import com.skybaysevensevenseven.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface BaggageService extends GenericService<Baggage, Integer> {

	List<Baggage> findAll();

	ResultDTO addBaggage(BaggageDTO baggageDTO, RequestDTO requestDTO);

	ResultDTO updateBaggage(BaggageDTO baggageDTO, RequestDTO requestDTO);

    Page<Baggage> getAllBaggages(Pageable pageable);

    Page<Baggage> getAllBaggages(Specification<Baggage> spec, Pageable pageable);

	ResponseEntity<BaggagePageDTO> getBaggages(BaggageSearchDTO baggageSearchDTO);
	
	List<BaggageDTO> convertBaggagesToBaggageDTOs(List<Baggage> baggages, BaggageConvertCriteriaDTO convertCriteria);

	BaggageDTO getBaggageDTOById(Integer baggageId);







}





