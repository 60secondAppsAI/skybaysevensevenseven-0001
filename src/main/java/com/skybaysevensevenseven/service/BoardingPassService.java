package com.skybaysevensevenseven.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skybaysevensevenseven.domain.BoardingPass;
import com.skybaysevensevenseven.dto.BoardingPassDTO;
import com.skybaysevensevenseven.dto.BoardingPassSearchDTO;
import com.skybaysevensevenseven.dto.BoardingPassPageDTO;
import com.skybaysevensevenseven.dto.BoardingPassConvertCriteriaDTO;
import com.skybaysevensevenseven.service.GenericService;
import com.skybaysevensevenseven.dto.common.RequestDTO;
import com.skybaysevensevenseven.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface BoardingPassService extends GenericService<BoardingPass, Integer> {

	List<BoardingPass> findAll();

	ResultDTO addBoardingPass(BoardingPassDTO boardingPassDTO, RequestDTO requestDTO);

	ResultDTO updateBoardingPass(BoardingPassDTO boardingPassDTO, RequestDTO requestDTO);

    Page<BoardingPass> getAllBoardingPasss(Pageable pageable);

    Page<BoardingPass> getAllBoardingPasss(Specification<BoardingPass> spec, Pageable pageable);

	ResponseEntity<BoardingPassPageDTO> getBoardingPasss(BoardingPassSearchDTO boardingPassSearchDTO);
	
	List<BoardingPassDTO> convertBoardingPasssToBoardingPassDTOs(List<BoardingPass> boardingPasss, BoardingPassConvertCriteriaDTO convertCriteria);

	BoardingPassDTO getBoardingPassDTOById(Integer boardingPassId);







}





