package org.jcapitan.es.ivn.dto;

import org.jcapitan.es.ivn.model.Acontecimiento;

public class ViajeDTOe {
	private Long id;
	private String name;
	private String location;
	private String description;
	private Long id_acontecimiento;
	private boolean estado; //oferta o no
	private float price;
	private String img;
	
	
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
	public Acontecimiento getId_acontecimiento() {
		Acontecimiento acontecimiento = Acontecimiento.findById(id_acontecimiento);
		return acontecimiento;
	}
	public void setId_acontecimiento(Long id_acontecimiento) {
		this.id_acontecimiento = id_acontecimiento;
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
