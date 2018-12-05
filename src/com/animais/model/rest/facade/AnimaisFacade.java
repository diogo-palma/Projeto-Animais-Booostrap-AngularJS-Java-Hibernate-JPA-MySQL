package com.animais.model.rest.facade;


import java.util.List;

import javax.inject.Inject;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.animais.model.AnimaisModel;
import com.animais.model.service.AnimaisServiceInterface;

@Path("/animais")
@Produces({MediaType.APPLICATION_JSON,
		MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class AnimaisFacade {
	
	@Inject 
	private AnimaisServiceInterface animaisServiceInterface;
	
	@GET
	public List<AnimaisModel> getAnimais(){
		return animaisServiceInterface.getAnimais();
	}
	
	@POST
	public AnimaisModel salvar(AnimaisModel animaisModel) {
		return animaisServiceInterface.salvar(animaisModel);
	}
	
	@PUT 
	public void atualizar(AnimaisModel animaisModel) {
		animaisServiceInterface.alterar(animaisModel);
	}
	
	@DELETE
	@Path("/{codigoAnimal}")
	public void excluir(@PathParam("codigoAnimal") Integer codigoAnimal) {
		AnimaisModel animaisModel = new AnimaisModel();
		animaisModel.setCodigo(codigoAnimal);
		animaisServiceInterface.excluir(animaisModel);
	}
}
