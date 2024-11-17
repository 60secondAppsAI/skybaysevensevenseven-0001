package com.skybaysevensevenseven.dao;

import java.util.List;

import com.skybaysevensevenseven.dao.GenericDAO;
import com.skybaysevensevenseven.domain.Route;





public interface RouteDAO extends GenericDAO<Route, Integer> {
  
	List<Route> findAll();
	






}


