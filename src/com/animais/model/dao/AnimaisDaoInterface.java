package com.animais.model.dao;

import java.util.List;

import com.animais.model.AnimaisModel;

public interface AnimaisDaoInterface {
	
	public AnimaisModel salvar(AnimaisModel animaisModel);
	
	public void alterar(AnimaisModel animaisModel);
	
	void excluir(AnimaisModel animaisModel);
	
	List<AnimaisModel> getAnimais();
	
}
