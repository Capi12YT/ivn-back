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
import org.jcapitan.es.ivn.dto.ReservaDTO;
import org.jcapitan.es.ivn.dto.ReservaPaginadoDTO;
import org.jcapitan.es.ivn.mappers.AcontecimientoMappers;
import org.jcapitan.es.ivn.mappers.ReservaMappers;
import org.jcapitan.es.ivn.model.Acontecimiento;
import org.jcapitan.es.ivn.model.Reserva;
import org.jcapitan.es.ivn.services.ReservaService;


@Path("/api/Reserva")
public class ReservasController {
	@Inject
	ReservaService reservaService;
	
	@GET
	@Path("All")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReservaDTO> reservaAll() {
		List<Reserva> reservas = reservaService.reservaAll();
		List<ReservaDTO> reservaDTO = new ArrayList<ReservaDTO>();
		reservaDTO = reservas.stream().map( rs -> ReservaMappers.reservaToReservaDTO(rs)).collect(Collectors.toList());
		return reservaDTO;
	}
	
	
	@GET
	@Path("Pagination")
	@Transactional
	@Produces(MediaType.APPLICATION_JSON)
	public ReservaPaginadoDTO acontecimientoAllPage(@QueryParam("page") @DefaultValue("0") int pageIndex){
		
        int pageSize = 3;
		
		List<Reserva> reservas = reservaService.reservaAllPage(pageIndex,pageSize);
		List<ReservaDTO> reservaDTO = reservas.stream().map( rs -> ReservaMappers.reservaToReservaDTO(rs)).collect(Collectors.toList());
	
		ReservaPaginadoDTO reservaPaginadoDTO = new ReservaPaginadoDTO(reservaDTO, Reserva.count());
		
		return  reservaPaginadoDTO;
	}
	
	
	
	
	@GET
	@Path("Num/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Integer reservaNum(@PathParam("userId") Long userId) {
		List<Reserva> reservas = reservaService.reservaAll();
		reservas = reservas.stream().filter(reserva -> reserva.usuario.id.equals(userId)).collect(Collectors.toList());
		return reservas.size();
	}
	
	@GET
	@Path("All/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReservaDTO> reservaAllUser(@PathParam("userId") Long userId) {
		List<Reserva> reservas = reservaService.reservaAll();
		reservas = reservas.stream().filter(reserva -> reserva.usuario.id.equals(userId)).collect(Collectors.toList());
		List<ReservaDTO> reservaDTO = new ArrayList<ReservaDTO>();
		reservaDTO = reservas.stream().map( rs -> ReservaMappers.reservaToReservaDTO(rs)).collect(Collectors.toList());
		return reservaDTO;
	}
	
	
	@POST
	@Path("Create")
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createReserva(ReservaDTO reservaDTO) {
		boolean done=reservaService.createReserva(ReservaMappers.reservaDTOtoReserva(reservaDTO));
		List<Reserva> reservas = reservaService.reservaAll().stream().filter(reserva -> reserva.usuario.id.equals(reservaDTO.getIdUsuario())).collect(Collectors.toList());

		return Response.ok(done?"Reserva creada:" + reservas.size():"Reserva no creada").status(done?201:200).build();
		
	}
	
	@DELETE
	@Path("Delete/{reservaId}")
	@Transactional
	public Response deleteReserva(@PathParam("reservaId") Long reservaId) {
		Reserva reservaByid = Reserva.findById(reservaId);
		boolean done=reservaService.deleteReserva(reservaId);
		List<Reserva> reservas = reservaService.reservaAll().stream().filter(reserva -> reserva.usuario.id.equals(reservaByid.usuario.id)).collect(Collectors.toList());

		return Response.ok(done?"Reserva borrada:"+ reservas.size():"Reserva no borrada").status(done?201:200).build();
	}
	
	@DELETE
	@Path("All/Delete/{userId}")
	@Transactional
	public Response deleteAllReserva(@PathParam("userId") Long userId) {
		Long reservas=reservaService.deleteAllReserva(userId);
		return Response.ok(reservas==0?"Reservas borrada:"+ reservas:"Reservas no borrada").status(reservas==0?201:200).build();
	}
	
}
