package com.skybaysevensevenseven.dao;

import java.util.List;

import com.skybaysevensevenseven.dao.GenericDAO;
import com.skybaysevensevenseven.domain.Feedback;





public interface FeedbackDAO extends GenericDAO<Feedback, Integer> {
  
	List<Feedback> findAll();
	






}


