package com.skybaysevensevenseven.dao;

import java.util.List;

import com.skybaysevensevenseven.dao.GenericDAO;
import com.skybaysevensevenseven.domain.Aircraft;





public interface AircraftDAO extends GenericDAO<Aircraft, Integer> {
  
	List<Aircraft> findAll();
	






}


