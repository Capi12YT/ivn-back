package org.jcapitan.es.ivn.controllers;


import java.util.List;

import javax.ws.rs.GET;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import org.jcapitan.es.ivn.services.ZapatosService;

@Path("/Zap")
public class ZapatosController {
	
	/*@Inject
	ZapatosService zapatoService;
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Zapato getzap(@PathParam("id") long id) {
		Zapato zapato = zapatoService.getZapato(id);
		
		return zapato;
	}
	
	@GET
	@Path("marca/{marca}")
	@Produces(MediaType.APPLICATION_JSON)
	public  List<Zapato> getzap(@PathParam("marca") String marca) {
		List<Zapato> zapatos = zapatoService.getZapatoByMarca(marca);
		return zapatos;
	}
	
	@GET
	@Path("todos")
	@Produces(MediaType.APPLICATION_JSON)
	public  List<Zapato> getAll() {
		List<Zapato> zapatos = zapatoService.getAll();
		return zapatos;
	}
	
	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createZap(Zapato zap) {
		zapatoService.guardarZapato(zap);
		return Response.ok(zap).status(201).build();
		
	}
	
	@PUT
	@Path("modificar/{id}")
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Zapato updateZap(@PathParam("id") Long id,Zapato zap){
		Zapato zapato = zapatoService.updateById(id,zap);
		return zapato;
		
	}
	
	
	@DELETE
	@Path("eliminar/{id}")
	@Transactional
	public Response deleteZap(@PathParam("id") Long id){
		boolean done=zapatoService.deleteZapato(id);
		return Response.status(done?200:204).build();
		
	}*/
}
