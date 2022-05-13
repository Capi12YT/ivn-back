package org.jcapitan.es.ivn.dto;

import java.util.Date;

public class ViajeDTOr {
	
	private Long id;
	private String name;
	private String location;
	private String description;
	private String name_acontecimiento;
	private Long fechaInicio;
	private Long fechaFin;
	private Long id_acontecimiento;
	private boolean estado; //oferta o no
	private float price;
	private String img;
	
	
	
	//Fecha Inicio default
	public Long getFechaInicio() { return fechaInicio; }
	public void setFechaInicio(Long fechaInicio) { this.fechaInicio = fechaInicio; }
	
	//Fecha Inicio date
	public Date getFechaInicioDate() { return new Date(fechaInicio); }
	public void setFechaInicioDate(Date fechaInicio) { this.fechaInicio = fechaInicio.getTime(); }
	
	//Fecha Fin default
	public Long getFechaFin() {return fechaFin;}
	public void setFechaFin(Long fechaFin) {this.fechaFin = fechaFin;}
	
	//Fecha Fin date
	public Date getFechaFinDate() { return new Date(fechaFin); }
	public void setFechaFinDate(Date fechaFin) { this.fechaFin = fechaFin.getTime(); }
	
	public Long getId_acontecimiento() {
		return id_acontecimiento;
	}
	public void setId_acontecimiento(Long id_acontecimiento) {
		this.id_acontecimiento = id_acontecimiento;
	}
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName_acontecimiento() {
		return name_acontecimiento;
	}
	public void setName_acontecimiento(String name_acontecimiento) {
		this.name_acontecimiento = name_acontecimiento;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}


}
