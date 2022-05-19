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

import org.jboss.logging.annotations.Param;
import org.jcapitan.es.ivn.dto.UsuarioDTO;
import org.jcapitan.es.ivn.dto.ViajeDTOe;
import org.jcapitan.es.ivn.dto.ViajeDTOr;
import org.jcapitan.es.ivn.mappers.UsuarioMappers;
import org.jcapitan.es.ivn.mappers.ViajeMappers;
import org.jcapitan.es.ivn.model.Usuario;
import org.jcapitan.es.ivn.model.Viaje;
import org.jcapitan.es.ivn.services.UsuarioService;


@Path("/api/Users")
public class UsuarioController {

	@Inject
	UsuarioService usuarioService;
	
	//token
	@POST
	@Path("Login")
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(UsuarioDTO usu) {
		Usuario usuario = Usuario.find("us_email", usu.getEmail()).firstResult();
		if (usuarioService.validarPassword(usu)) {
			return Response.ok(usuarioService.getToken(usuario)).status(200).build();
		}
		return Response.ok().status(201).build();
		
	}
	
	@POST
	@Path("Create")
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUsu(UsuarioDTO usu) {
		boolean created = false;
		created = usuarioService.createUsuario(usu);

		return Response.ok(created?"Usuario creado":"Error 1").status(created?201:409).build();
		
	}
	
	@GET
	@Path("All")
	@Transactional
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioDTO> allUsers(){
		List<Usuario> usuarios = usuarioService.getAllUsers();
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		usuariosDTO = usuarios.stream().map(usu -> UsuarioMappers.usuarioTOUsuarioDto(usu)).collect(Collectors.toList());
		return usuariosDTO; 
	}
	
	@GET
	@Path("Sort")
	@Transactional
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioDTO> sortUsers(){
		List<Usuario> usuarios = usuarioService.getSortUsers();
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		usuariosDTO = usuarios.stream().map(usu -> UsuarioMappers.usuarioTOUsuarioDto(usu)).collect(Collectors.toList());
		return usuariosDTO; 
	}
	
	@GET
	@Path("Admin")
	@Transactional
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioDTO> sortAdmins(){
		List<Usuario> usuarios = usuarioService.getSortAdmins();
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		usuariosDTO = usuarios.stream().map(usu -> UsuarioMappers.usuarioTOUsuarioDto(usu)).collect(Collectors.toList());
		return usuariosDTO; 
	}
	
	@GET
	@Path("{id}")
	@Transactional
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioDTO userByid(@PathParam("id") Long id){
		UsuarioDTO usuariodto = UsuarioMappers.usuarioTOUsuarioDto(usuarioService.usuarioById(id));
		return  usuariodto;
	}
	
	@PUT
	@Path("Update")
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(UsuarioDTO UsarioDTO){
		boolean done=usuarioService.updateUsuario(UsarioDTO);
		return Response.ok(done?"Usuario actualizado":"Usuario no actualizado").status(done?200:204).build();
	}
	
	@DELETE
	@Path("Delete/{id}")
	@Transactional
	public Response deleteUser(@PathParam("id") Long id ){
		boolean done=usuarioService.deleteUser(id);
		return Response.status(done?200:204).build();
	}
}
