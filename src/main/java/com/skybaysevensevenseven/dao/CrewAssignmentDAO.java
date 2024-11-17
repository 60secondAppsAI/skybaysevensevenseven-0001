package com.skybaysevensevenseven.dao;

import java.util.List;

import com.skybaysevensevenseven.dao.GenericDAO;
import com.skybaysevensevenseven.domain.CrewAssignment;





public interface CrewAssignmentDAO extends GenericDAO<CrewAssignment, Integer> {
  
	List<CrewAssignment> findAll();
	






}


