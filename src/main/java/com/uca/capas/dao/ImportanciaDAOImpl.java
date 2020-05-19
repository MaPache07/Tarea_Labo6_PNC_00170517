package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;

@Repository
public class ImportanciaDAOImpl implements ImportanciaDAO{
	
	@PersistenceContext(unitName="capas")
	private EntityManager em;
	
	@Override
	public List<Importancia> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.importancia");
		Query query = em.createNativeQuery(sb.toString(), Importancia.class);
		List<Importancia> res = query.getResultList();
		return res;
	}
}
