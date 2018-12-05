package com.animais.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.animais.model.AnimaisModel;
import com.animais.model.dao.AnimaisDaoInterface;


public class AnimaisServiceImplem implements AnimaisServiceInterface{

	@Inject
	private AnimaisDaoInterface animaisDaoInterface;
	
	@Override
	public List<AnimaisModel> getAnimais() {
		return  animaisDaoInterface.getAnimais();
	}
	
	
	@Override
	@Transactional
	public AnimaisModel salvar(AnimaisModel animaisModel) {
		return animaisDaoInterface.salvar(animaisModel);
	}

	@Override
	@Transactional
	public void alterar(AnimaisModel animaisModel) {
		animaisDaoInterface.alterar(animaisModel);
	}

	@Override
	@Transactional
	public void excluir(AnimaisModel animaisModel) {
		animaisDaoInterface.excluir(animaisModel);
	}

	

}
