package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.domain.Contribuyente;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService {
	
	@Autowired
	ContribuyenteDAO contDao;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		return contDao.findAll();
	}

	@Override
	public void insert(Contribuyente contribuyente) throws DataAccessException {
		contDao.insert(contribuyente);
	}
}
