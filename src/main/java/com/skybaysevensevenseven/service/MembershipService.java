package com.skybaysevensevenseven.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skybaysevensevenseven.domain.Membership;
import com.skybaysevensevenseven.dto.MembershipDTO;
import com.skybaysevensevenseven.dto.MembershipSearchDTO;
import com.skybaysevensevenseven.dto.MembershipPageDTO;
import com.skybaysevensevenseven.dto.MembershipConvertCriteriaDTO;
import com.skybaysevensevenseven.service.GenericService;
import com.skybaysevensevenseven.dto.common.RequestDTO;
import com.skybaysevensevenseven.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface MembershipService extends GenericService<Membership, Integer> {

	List<Membership> findAll();

	ResultDTO addMembership(MembershipDTO membershipDTO, RequestDTO requestDTO);

	ResultDTO updateMembership(MembershipDTO membershipDTO, RequestDTO requestDTO);

    Page<Membership> getAllMemberships(Pageable pageable);

    Page<Membership> getAllMemberships(Specification<Membership> spec, Pageable pageable);

	ResponseEntity<MembershipPageDTO> getMemberships(MembershipSearchDTO membershipSearchDTO);
	
	List<MembershipDTO> convertMembershipsToMembershipDTOs(List<Membership> memberships, MembershipConvertCriteriaDTO convertCriteria);

	MembershipDTO getMembershipDTOById(Integer membershipId);







}





