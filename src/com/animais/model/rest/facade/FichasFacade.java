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

import com.animais.model.FichasModel;
import com.animais.model.service.FichasServiceInterface;

@Path("/fichas")
@Produces({MediaType.APPLICATION_JSON,
		MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class FichasFacade {
	
	@Inject 
	private FichasServiceInterface fichasServiceInterface;
	
	@GET
	public List<FichasModel> getFichas(){
		return fichasServiceInterface.getFichas();
	}
	
	@POST
	public FichasModel salvar(FichasModel fichasModel) {
		return fichasServiceInterface.salvar(fichasModel);
	}
	
	@PUT 
	public void atualizar(FichasModel fichasModel) {
		fichasServiceInterface.alterar(fichasModel);
	}
	
	@DELETE
	@Path("/{codigoFicha}")
	public void excluir(@PathParam("codigoFicha") Integer codigoFicha) {
		FichasModel fichasModel = new FichasModel();
		fichasModel.setCodigo(codigoFicha);
		fichasServiceInterface.excluir(fichasModel);
	}
}
