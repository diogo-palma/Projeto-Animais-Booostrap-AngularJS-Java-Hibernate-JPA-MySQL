package com.animais.model.dao;

import java.util.List;

import com.animais.model.FichasModel;

public interface FichasDaoInterface {
	
	public FichasModel salvar(FichasModel fichasModel);
	
	public void alterar(FichasModel fichasModel);
	
	void excluir(FichasModel fichasModel);
	
	List<FichasModel> getFichas();
	
}
