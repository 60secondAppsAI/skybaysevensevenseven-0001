package com.skybaysevensevenseven.dao;

import java.util.List;

import com.skybaysevensevenseven.dao.GenericDAO;
import com.skybaysevensevenseven.domain.Maintenance;





public interface MaintenanceDAO extends GenericDAO<Maintenance, Integer> {
  
	List<Maintenance> findAll();
	






}


