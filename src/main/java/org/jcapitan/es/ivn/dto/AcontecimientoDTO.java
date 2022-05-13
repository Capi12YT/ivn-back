package org.jcapitan.es.ivn.dto;

import java.util.Date;

public class AcontecimientoDTO {
	
	private Long id;
	private String name;
	private Long fechaInicio;
	private Long fechaFin;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public Long getFechaInicio() { return fechaInicio; }
	public void setFechaInicio(Long fechaInicio) { this.fechaInicio = fechaInicio; }
	
	public Date getFechaInicioDate() { return new Date(fechaInicio); }
	public void setFechaInicioDate(Date fechaInicio) { this.fechaInicio = fechaInicio.getTime(); }
	
	
	
	public Long getFechaFin() {return fechaFin;}
	public void setFechaFin(Long fechaFin) {this.fechaFin = fechaFin;}
	
	public Date getFechaFinDate() { return new Date(fechaFin); }
	public void setFechaFinDate(Date fechaFin) { this.fechaFin = fechaFin.getTime(); }
	
	
}
