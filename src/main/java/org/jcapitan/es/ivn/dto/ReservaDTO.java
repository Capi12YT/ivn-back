package org.jcapitan.es.ivn.dto;

import org.jcapitan.es.ivn.model.Usuario;
import org.jcapitan.es.ivn.model.Viaje;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ReservaDTO {
	
	private Long id;
	private Long idViaje;
	private String nombreViaje;
	private String img;
	private Long idUsuario;
	private String nombreUsuario;

	
	
	
	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public String getNombreViaje() {
		return nombreViaje;
	}



	public void setNombreViaje(String nombreViaje) {
		this.nombreViaje = nombreViaje;
	}



	public String getNombreUsuario() {
		return nombreUsuario;
	}



	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}



	private Long cantidad;
	

	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	@JsonIgnore
	public Viaje getViaje() {
		Viaje viaje = Viaje.findById(idViaje);
		return viaje;
	}
	public Long getIdViaje() {
		return this.idViaje;
	}



	public void setIdViaje(Long idViaje) {
		this.idViaje = idViaje;
	}


	@JsonIgnore
	public Usuario getUsuario() {
		Usuario usuario = Usuario.findById(idUsuario);
		return usuario;
	}
	


	public Long getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}



	public Long getCantidad() {
		return cantidad;
	}



	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}



	
}
