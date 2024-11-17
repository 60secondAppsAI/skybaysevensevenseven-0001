package com.skybaysevensevenseven.dao;

import java.util.List;

import com.skybaysevensevenseven.dao.GenericDAO;
import com.skybaysevensevenseven.domain.Airport;





public interface AirportDAO extends GenericDAO<Airport, Integer> {
  
	List<Airport> findAll();
	






}


