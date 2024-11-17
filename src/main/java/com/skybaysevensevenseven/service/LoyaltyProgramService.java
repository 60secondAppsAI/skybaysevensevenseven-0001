package com.skybaysevensevenseven.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skybaysevensevenseven.domain.LoyaltyProgram;
import com.skybaysevensevenseven.dto.LoyaltyProgramDTO;
import com.skybaysevensevenseven.dto.LoyaltyProgramSearchDTO;
import com.skybaysevensevenseven.dto.LoyaltyProgramPageDTO;
import com.skybaysevensevenseven.dto.LoyaltyProgramConvertCriteriaDTO;
import com.skybaysevensevenseven.service.GenericService;
import com.skybaysevensevenseven.dto.common.RequestDTO;
import com.skybaysevensevenseven.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface LoyaltyProgramService extends GenericService<LoyaltyProgram, Integer> {

	List<LoyaltyProgram> findAll();

	ResultDTO addLoyaltyProgram(LoyaltyProgramDTO loyaltyProgramDTO, RequestDTO requestDTO);

	ResultDTO updateLoyaltyProgram(LoyaltyProgramDTO loyaltyProgramDTO, RequestDTO requestDTO);

    Page<LoyaltyProgram> getAllLoyaltyPrograms(Pageable pageable);

    Page<LoyaltyProgram> getAllLoyaltyPrograms(Specification<LoyaltyProgram> spec, Pageable pageable);

	ResponseEntity<LoyaltyProgramPageDTO> getLoyaltyPrograms(LoyaltyProgramSearchDTO loyaltyProgramSearchDTO);
	
	List<LoyaltyProgramDTO> convertLoyaltyProgramsToLoyaltyProgramDTOs(List<LoyaltyProgram> loyaltyPrograms, LoyaltyProgramConvertCriteriaDTO convertCriteria);

	LoyaltyProgramDTO getLoyaltyProgramDTOById(Integer loyaltyProgramId);







}





