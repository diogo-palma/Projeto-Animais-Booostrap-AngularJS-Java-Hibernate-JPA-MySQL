package com.animais.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.animais.model.AnimaisModel;

public class AnimaisDaoImplem implements AnimaisDaoInterface{

	@PersistenceContext(unitName="AnimaisPersistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public AnimaisModel salvar(AnimaisModel animaisModel) {
		entityManager.persist(animaisModel);		
		return animaisModel;
	}

	@Override
	public void alterar(AnimaisModel animaisModel) {
		AnimaisModel animaisModelMerge = entityManager.merge(animaisModel);
		entityManager.persist(animaisModelMerge);
	} 

	@Override
	public void excluir(AnimaisModel animaisModel) {
		AnimaisModel animaisModelMerge = entityManager.merge(animaisModel);
		entityManager.remove(animaisModelMerge);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AnimaisModel> getAnimais() {
		Query query = entityManager.createQuery("from AnimaisModel");
		return query.getResultList();
	}

	
}
