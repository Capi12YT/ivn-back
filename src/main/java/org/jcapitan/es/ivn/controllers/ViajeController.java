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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jcapitan.es.ivn.dto.AcontecimientoDTO;
import org.jcapitan.es.ivn.dto.UsuarioDTO;
import org.jcapitan.es.ivn.dto.ViajeDTO;
import org.jcapitan.es.ivn.dto.ViajeDTOe;
import org.jcapitan.es.ivn.dto.ViajeDTOr;
import org.jcapitan.es.ivn.mappers.AcontecimientoMappers;
import org.jcapitan.es.ivn.mappers.ViajeMappers;
import org.jcapitan.es.ivn.model.Acontecimiento;
import org.jcapitan.es.ivn.model.Viaje;
import org.jcapitan.es.ivn.services.ViajeService;

@Path("/api/Viaje")
public class ViajeController {
	   
		@Inject
		ViajeService viajeService;
		
		
		@POST
		@Path("Create")
		@Transactional
		@Consumes(MediaType.APPLICATION_JSON)
		public Response createZap(ViajeDTO viaje) {
			boolean created = false;
			created = viajeService.createViaje(viaje);

			return Response.ok(created?"Viaje creado":"Error 1").status(created?201:409).build();
			
		}
		
		
		@GET
		@Path("All")
		@Transactional
		@Produces(MediaType.APPLICATION_JSON)
		public List<ViajeDTOr> viajeAll(){
			List<Viaje> viajes = viajeService.viajeAll();
			List<ViajeDTOr> viajeDTOr = new ArrayList<ViajeDTOr>();
			viajeDTOr = viajes.stream().map( vj -> ViajeMappers.viajeToViajeDTO(vj)).collect(Collectors.toList());
			return  viajeDTOr;
		}
		
		@GET
		@Path("Last")
		@Transactional
		@Produces(MediaType.APPLICATION_JSON)
		public List<ViajeDTOr> viajeLast(){
			List<Viaje> viajes = viajeService.viajeAll();
			int numViajes = viajes.size();
			List<Viaje> lastViajes = new ArrayList<Viaje>();
			if (numViajes > 0 ) lastViajes.add(viajes.get(numViajes-1));
			if (numViajes > 1 ) lastViajes.add(viajes.get(numViajes-2));
			if (numViajes > 2 ) lastViajes.add(viajes.get(numViajes-3));
			List<ViajeDTOr> viajeDTOr = new ArrayList<ViajeDTOr>();
			viajeDTOr = lastViajes.stream().map( vj -> ViajeMappers.viajeToViajeDTO(vj)).collect(Collectors.toList());
			return  viajeDTOr;
		}
		
		@DELETE
		@Path("Delete/{id}")
		@Transactional
		public Response deleteViaje(@PathParam("id") Long id ){
			boolean done=viajeService.deleteViaje(id);
			return Response.ok(done?"Viaje borrado":"Viaje no existe").status(done?200:205).build();
		}
		
		@PUT
		@Path("Update")
		@Transactional
		@Consumes(MediaType.APPLICATION_JSON)
		public Response updateViaje(ViajeDTOe viajeDTO){
			boolean done=viajeService.updateViaje(viajeDTO);
			return Response.ok(done?"Viaje actualizado":"Viaje no actualizado").status(done?200:204).build();
		}
		
		@GET
		@Path("{id}")
		@Transactional
		@Produces(MediaType.APPLICATION_JSON)
		public ViajeDTOr viajeByid(@PathParam("id") Long id){
			Viaje viaje = viajeService.viajeById(id);
			ViajeDTOr viajeDTOr = ViajeMappers.viajeToViajeDTO(viaje);
			return  viajeDTOr;
		}
	}

