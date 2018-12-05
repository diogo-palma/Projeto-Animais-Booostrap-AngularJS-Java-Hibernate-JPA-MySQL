package com.animais.model.service;

import java.util.List;

import com.animais.model.FichasModel;

public interface FichasServiceInterface {

public FichasModel salvar(FichasModel fichasModel);
	
	public void alterar(FichasModel fichasModel);
	
	void excluir(FichasModel fichasModel);
	
	List<FichasModel> getFichas();
}
