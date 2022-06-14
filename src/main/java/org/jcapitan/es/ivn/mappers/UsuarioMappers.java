package org.jcapitan.es.ivn.mappers;

import org.jcapitan.es.ivn.dto.UsuarioDTO;
import org.jcapitan.es.ivn.model.Usuario;

public class UsuarioMappers {

	//metodo para mapear UsuarioDTO mediante Usuario(log in)
	public static UsuarioDTO usuarioToUsuarioDTO(Usuario usuario) {
		UsuarioDTO usuarioDto = new UsuarioDTO();
		usuarioDto.setEmail(usuario.us_email);
		usuarioDto.setPassword("");
		return usuarioDto;
	}
	
	//metodo para mapear Usuario mediante UsuarioDTO
	public static Usuario usuariodtoTOUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		usuario.us_email = usuarioDTO.getEmail();
		usuario.us_password = usuarioDTO.getPassword();
		usuario.us_lastname = usuarioDTO.getLastname();
		usuario.us_name = usuarioDTO.getName();
		usuario.us_rol = usuarioDTO.getRol();
		return usuario;
	}
	
	//metodo para mapear UsuarioDTO mediante Usuario
	public static UsuarioDTO usuarioTOUsuarioDto(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(usuario.id);
		usuarioDTO.setEmail(usuario.us_email);
		usuarioDTO.setPassword(usuarioDTO.getPassword());
		usuarioDTO.setLastname(usuario.us_lastname);
		usuarioDTO.setName(usuario.us_name);
		usuarioDTO.setRol(usuario.us_rol);
		return usuarioDTO;
	}
}
