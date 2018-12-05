package com.animais.model.service;

import java.util.List;

import com.animais.model.AnimaisModel;

public interface AnimaisServiceInterface {

public AnimaisModel salvar(AnimaisModel animaisModel);
	
	public void alterar(AnimaisModel animaisModel);
	
	void excluir(AnimaisModel animaisModel);
	
	List<AnimaisModel> getAnimais();
}
