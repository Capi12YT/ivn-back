package org.jcapitan.es.ivn.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jcapitan.es.ivn.dto.AcontecimientoDTO;
import org.jcapitan.es.ivn.dto.AcontecimientoPaginadoDTO;
import org.jcapitan.es.ivn.dto.UsuarioDTO;
import org.jcapitan.es.ivn.dto.ViajeDTOr;
import org.jcapitan.es.ivn.dto.ViajesPaginadoDTO;
import org.jcapitan.es.ivn.mappers.AcontecimientoMappers;
import org.jcapitan.es.ivn.mappers.ViajeMappers;
import org.jcapitan.es.ivn.model.Acontecimiento;
import org.jcapitan.es.ivn.model.Reserva;
import org.jcapitan.es.ivn.model.Viaje;
import org.jcapitan.es.ivn.services.AcontecimientoService;

//declaracion de url del endpoint
@Path("/api/Acontecimiento")
public class AcontecimientoController {
	
	//injeccion del servicio acontecimiento
	@Inject
	AcontecimientoService acontecimientoService;
	
	
	//endpoint devolver todos los acontecimientos
	@GET
	@Path("All")
    @Produces(MediaType.APPLICATION_JSON)
	public List<AcontecimientoDTO> getAll() {
		List<Acontecimiento> acontecimientos = acontecimientoService.getAll();
		
		List<AcontecimientoDTO> acontecimientoDTO = new ArrayList<AcontecimientoDTO>();

		acontecimientoDTO = acontecimientos.stream().map( acont -> AcontecimientoMappers.acontecimientoToAcontecimientoDTO(acont)).collect(Collectors.toList());

		return acontecimientoDTO;
	}
	
	//endpoint acontecimientos paginados
	@GET
	@Path("Pagination")
	@Transactional
	@Produces(MediaType.APPLICATION_JSON)
	public AcontecimientoPaginadoDTO acontecimientoAllPage(@QueryParam("page") @DefaultValue("0") int pageIndex){
		
        int pageSize = 3;
		
		List<Acontecimiento> acontecimientos = acontecimientoService.acontecimientoAllPage(pageIndex,pageSize);
		List<AcontecimientoDTO> acontecimientoDTO = acontecimientos.stream().map( ac -> AcontecimientoMappers.acontecimientoToAcontecimientoDTO(ac)).collect(Collectors.toList());
	
		AcontecimientoPaginadoDTO acontecimientoPaginadoDTO = new AcontecimientoPaginadoDTO(acontecimientoDTO, Acontecimiento.count());
		
		return  acontecimientoPaginadoDTO;
	}
	
	
	//endpoint crear acontecimiento
	@POST
	@Path("Create")
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(AcontecimientoDTO acoDTO) {
		acontecimientoService.createAcon(acoDTO);
		return Response.ok("Acontecimiento creado").status(201).build();
		
	}
	
	
	//endpoint borrar acontecimiento
	@DELETE
	@Path("Delete/{id}")
	@Transactional
	public Response delete(@PathParam("id") Long id ){
		acontecimientoService.deleteAcon(id);
		return Response.ok("Acontecimiento borrado").status(200).build();
	}
}
