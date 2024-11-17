package com.skybaysevensevenseven.dao;

import java.util.List;

import com.skybaysevensevenseven.dao.GenericDAO;
import com.skybaysevensevenseven.domain.Membership;





public interface MembershipDAO extends GenericDAO<Membership, Integer> {
  
	List<Membership> findAll();
	






}


