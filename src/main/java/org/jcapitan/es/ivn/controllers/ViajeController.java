package org.jcapitan.es.ivn.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jcapitan.es.ivn.dto.FiltroViajeDTO;
import org.jcapitan.es.ivn.dto.ViajeDTO;
import org.jcapitan.es.ivn.dto.ViajeDTOe;
import org.jcapitan.es.ivn.dto.ViajeDTOr;
import org.jcapitan.es.ivn.dto.ViajesPaginadoDTO;
import org.jcapitan.es.ivn.mappers.ViajeMappers;
import org.jcapitan.es.ivn.model.Viaje;
import org.jcapitan.es.ivn.services.ViajeService;

import io.quarkus.panache.common.Page;

//declaracion de url del endpoint
@Path("/api/Viaje")
public class ViajeController {
	   
		@Inject
		ViajeService viajeService;
		
		//endpoint crear viaje
		@POST
		@Path("Create")
		@Transactional
		@Consumes(MediaType.APPLICATION_JSON)
		public Response createViaje(ViajeDTO viaje) {
			boolean created = false;
			created = viajeService.createViaje(viaje);

			return Response.ok(created?"Viaje creado":"Error 1").status(created?201:409).build();
			
		}
		
		//endpoint devolver todos los viajes
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
		
		
		//endpoint devolver viajes paginados
		@GET
		@Path("Pagination")
		@Transactional
		@Produces(MediaType.APPLICATION_JSON)
		public ViajesPaginadoDTO viajeAllPage(@QueryParam("page") @DefaultValue("0") int pageIndex){
			
	        int pageSize = 3;
			
			List<Viaje> viajes = viajeService.viajeAllPage(pageIndex,pageSize);
			List<ViajeDTOr> viajeDTOr = viajes.stream().map( vj -> ViajeMappers.viajeToViajeDTO(vj)).collect(Collectors.toList());
		
			ViajesPaginadoDTO viajesPaginadoDTO = new ViajesPaginadoDTO(viajeDTOr, Viaje.count());
			
			return  viajesPaginadoDTO;
		}
		

		//endpoint devolver los ultimos 3 viajes
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
		
		
		//endpoint borrar viaje
		@DELETE
		@Path("Delete/{id}")
		@Transactional
		public Response deleteViaje(@PathParam("id") Long id ){
			boolean done=viajeService.deleteViaje(id);
			return Response.ok(done?"Viaje borrado":"Viaje no existe").status(done?200:205).build();
		}
		
		//endpoint modificar viaje
		@PUT
		@Path("Update")
		@Transactional
		@Consumes(MediaType.APPLICATION_JSON)
		public Response updateViaje(ViajeDTOe viajeDTO){
			boolean done=viajeService.updateViaje(viajeDTO);
			return Response.ok(done?"Viaje actualizado":"Viaje no actualizado").status(done?200:204).build();
		}
		
		//endpoint buscar viaje
		@GET
		@Path("{id}")
		@Transactional
		@Produces(MediaType.APPLICATION_JSON)
		public ViajeDTOr viajeByid(@PathParam("id") Long id){
			Viaje viaje = viajeService.viajeById(id);
			ViajeDTOr viajeDTOr = ViajeMappers.viajeToViajeDTO(viaje);
			return  viajeDTOr;
		}
		
		//endpoint filtrar viajes(nombre,ubicacion,estado) 
		@POST
		@Path("Filter")
		@Transactional
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public List<ViajeDTOr> filtreViaje(FiltroViajeDTO filtroViajeDTO) {
			List<Viaje> viajesFiltrados = viajeService.viajeFiltre(filtroViajeDTO);
			List<ViajeDTOr> viajeDTOr = viajesFiltrados.stream().map( vj -> ViajeMappers.viajeToViajeDTO(vj)).collect(Collectors.toList());
			return  viajeDTOr;
		}
		
		//endpoint filtrar viajes por acontecimiento
		@POST
		@Path("Filter/Acontecimiento")
		@Transactional
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public List<ViajeDTOr> filtreAcontecimientoViaje(FiltroViajeDTO filtroViajeDTO) {
			List<Viaje> viajesFiltrados = viajeService.viajeFiltreAcontecimiento(filtroViajeDTO.getAcontecimiento());
			List<ViajeDTOr> viajesDTOr = viajesFiltrados.stream().map( vj -> ViajeMappers.viajeToViajeDTO(vj)).collect(Collectors.toList());
			return  viajesDTOr;
		}
		
		
	}

