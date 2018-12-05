package com.animais.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.animais.model.FichasModel;

public class FichasDaoImplem implements FichasDaoInterface{

	@PersistenceContext(unitName="AnimaisPersistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public FichasModel salvar(FichasModel fichasModel) {
		entityManager.persist(fichasModel);		
		return fichasModel;
	}

	@Override
	public void alterar(FichasModel fichasModel) {
		FichasModel fichasModelMerge = entityManager.merge(fichasModel);
		entityManager.persist(fichasModelMerge);
	} 

	@Override
	public void excluir(FichasModel fichasModel) {
		FichasModel fichasModelMerge = entityManager.merge(fichasModel);
		entityManager.remove(fichasModelMerge);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<FichasModel> getFichas() {
		Query query = entityManager.createQuery("from FichasModel");
		return query.getResultList();
	}

}
