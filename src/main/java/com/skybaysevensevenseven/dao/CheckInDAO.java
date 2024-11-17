package com.skybaysevensevenseven.dao;

import java.util.List;

import com.skybaysevensevenseven.dao.GenericDAO;
import com.skybaysevensevenseven.domain.CheckIn;





public interface CheckInDAO extends GenericDAO<CheckIn, Integer> {
  
	List<CheckIn> findAll();
	






}


