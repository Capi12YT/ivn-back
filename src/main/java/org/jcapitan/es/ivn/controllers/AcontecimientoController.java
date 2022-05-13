package org.jcapitan.es.ivn.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jcapitan.es.ivn.dto.AcontecimientoDTO;
import org.jcapitan.es.ivn.dto.UsuarioDTO;
import org.jcapitan.es.ivn.mappers.AcontecimientoMappers;
import org.jcapitan.es.ivn.model.Acontecimiento;
import org.jcapitan.es.ivn.model.Reserva;
import org.jcapitan.es.ivn.services.AcontecimientoService;

@Path("/Acontecimiento")
public class AcontecimientoController {
	@Inject
	AcontecimientoService acontecimientoService;
	
	
	
	@GET
	@Path("All")
    @Produces(MediaType.APPLICATION_JSON)
	public List<AcontecimientoDTO> getAll() {
		List<Acontecimiento> acontecimientos = acontecimientoService.getAll();
		
		List<AcontecimientoDTO> acontecimientoDTO = new ArrayList<AcontecimientoDTO>();

		acontecimientoDTO = acontecimientos.stream().map( acont -> AcontecimientoMappers.acontecimientoToAcontecimientoDTO(acont)).collect(Collectors.toList());

		return acontecimientoDTO;
	}
	
	@POST
	@Path("Create")
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(AcontecimientoDTO acoDTO) {
		acontecimientoService.createAcon(acoDTO);
		return Response.ok("Acontecimiento creado").status(201).build();
		
	}
	@DELETE
	@Path("Delete/{id}")
	@Transactional
	public Response delete(@PathParam("id") Long id ){
		acontecimientoService.deleteAcon(id);
		return Response.ok("Acontecimiento borrado").status(200).build();
	}
}
