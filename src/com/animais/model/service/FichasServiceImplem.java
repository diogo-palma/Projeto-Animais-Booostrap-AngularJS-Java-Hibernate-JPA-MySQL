package com.animais.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.animais.model.FichasModel;
import com.animais.model.dao.FichasDaoInterface;


public class FichasServiceImplem implements FichasServiceInterface{

	@Inject
	private FichasDaoInterface fichasDaoInterface;
	
	@Override
	public List<FichasModel> getFichas() {
		return  fichasDaoInterface.getFichas();
	}
	
	
	@Override
	@Transactional
	public FichasModel salvar(FichasModel fichasModel) {
		return fichasDaoInterface.salvar(fichasModel);
	}

	@Override
	@Transactional
	public void alterar(FichasModel fichasModel) {
		fichasDaoInterface.alterar(fichasModel);
	}

	@Override
	@Transactional
	public void excluir(FichasModel fichasModel) {
		fichasDaoInterface.excluir(fichasModel);
	}

	

}
