package org.jcapitan.es.ivn.dto;

public class FiltroViajeDTO {

	private String nombre;
	private String localizacion;
	private String acontecimiento;
	private boolean estado;
	
	

	public String getAcontecimiento() {
		return acontecimiento;
	}
	public void setAcontecimiento(String acontecimiento) {
		this.acontecimiento = acontecimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
