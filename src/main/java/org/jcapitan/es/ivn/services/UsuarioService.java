package org.jcapitan.es.ivn.services;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.apache.sshd.common.config.keys.loader.openssh.kdf.BCrypt;
import org.jcapitan.es.ivn.dto.UsuarioDTO;
import org.jcapitan.es.ivn.mappers.UsuarioMappers;
import org.jcapitan.es.ivn.model.Usuario;
import org.jcapitan.es.ivn.model.Viaje;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
@ApplicationScoped
public class UsuarioService implements PanacheRepository<Usuario> {
	
	//firma de token
	final String SECRET_KEY = "12321"; 

	//metodo para generar token
	public String getToken(Usuario usuario) {
		JwtBuilder builder = Jwts.builder().setIssuedAt(new Date())
				.setIssuer("IVN")
				.setSubject("")
				.claim("id", usuario.id)
				.claim("name", usuario.us_name)
				.claim("email", usuario.us_email)
				.claim("rol",usuario.us_rol)
				.setExpiration(new Date(System.currentTimeMillis() + 3000 * 60000))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY);
		return builder.compact();
	}
	

	//metodo crear usuario
	public boolean createUsuario(UsuarioDTO usuDTO) {
		Usuario usu = UsuarioMappers.usuariodtoTOUsuario(usuDTO);
		String password = usu.us_password;
		usu.us_password = BCrypt.hashpw(password, BCrypt.gensalt());
		Usuario usuario = Usuario.find("us_email", usuDTO.getEmail()).firstResult();
			if (usuario == null) {
				Usuario.persist(usu);
				return true;
			}
		return false;
	}
	
	//metodo para validar contraseña de usuario
	public boolean validarPassword(UsuarioDTO usuarioDTO) {
		Usuario usuario = Usuario.find("us_email", usuarioDTO.getEmail()).firstResult();
		if (usuario != null) {
			if (BCrypt.checkpw(usuarioDTO.getPassword(), usuario.us_password)!=false) {
				return true;
			}
		}
		return false;
	}
	
	//metodo para devolver todo los usuarios
	public List<Usuario> getAllUsers(){
		return Usuario.listAll();
	}
	
	//metodo para borrar usuario por id
	public boolean deleteUser(Long id) {
		return 	Usuario.deleteById(id);
	}
	
	//metodo para ordenar usuario de forma descendente por id
	public List<Usuario> getSortUsers(){
		return Usuario.listAll(Sort.descending("id"));
	}
	
	//metodo devolver usuarios admin
	public List<Usuario> getSortAdmins(){
		return Usuario.list("us_rol","admin");
	}

	//metodo buscar usuario por id
	public Usuario usuarioById(Long id) {
		return Usuario.findById(id);
	}

	//metodo actualizar usuario
	public boolean updateUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuarioBD = Usuario.findById(usuarioDTO.getId());
		usuarioBD.id=usuarioDTO.getId();
		usuarioBD.us_email=usuarioDTO.getEmail();
		usuarioBD.us_lastname=usuarioDTO.getLastname();
		usuarioBD.us_name=usuarioDTO.getName();
		usuarioBD.us_password=BCrypt.hashpw(usuarioDTO.getPassword(), BCrypt.gensalt());
		Usuario.persist(usuarioBD);
		return true;
	}

	//metodo paginado de usuario
	public List<Usuario> usuarioAllPage(int pageIndex, int pageSize) {
		List<Usuario> usuarios = getSortAdmins();
		int numItems = usuarios.size();
		int from = (pageIndex-1) * pageSize;
		int to = pageIndex * pageSize;
		if (from > numItems - 1) from = numItems - 1;
		if (to > numItems - 1) to = numItems;
		
		List<Usuario> subUsuarios  = usuarios.subList(from , to);
		
		return subUsuarios;
	}
}
