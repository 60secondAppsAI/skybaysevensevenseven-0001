package com.skybaysevensevenseven.service;

import com.skybaysevensevenseven.dao.GenericDAO;

public interface GenericService<T, ID> {

    abstract GenericDAO<T, ID> getDAO();

    T getById(Integer id) ;

}