package org.jcapitan.es.ivn.controllers;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jcapitan.es.ivn.model.Contadores;
import org.jcapitan.es.ivn.services.ContadorService;

//declaracion de url del endpoint
@Path("/api/Contadores")
public class ContadoresController {

	//injeccion del servicio contador
	@Inject
	ContadorService contadorService;
	
	//endpoint numero de registros de cada tabla
	@GET
	@Path("All")
	@Transactional
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Long> getAll(){
		return contadorService.getContadores();
		
	}
}
