package org.jcapitan.es.ivn.dto;

import java.util.List;

public class ViajesPaginadoDTO {
	
	private List<ViajeDTOr> viajesPaginados;
	private Long numeroTotalViajes;
	
	
	
	public ViajesPaginadoDTO(List<ViajeDTOr> viajesPaginados, Long numeroTotalViajes) {

		this.viajesPaginados = viajesPaginados;
		this.numeroTotalViajes = numeroTotalViajes;
	}



	public List<ViajeDTOr> getViajesPaginados() {
		return viajesPaginados;
	}



	public void setViajesPaginados(List<ViajeDTOr> viajesPaginados) {
		this.viajesPaginados = viajesPaginados;
	}



	public Long getNumeroTotalViajes() {
		return numeroTotalViajes;
	}



	public void setNumeroTotalViajes(Long numeroTotalViajes) {
		this.numeroTotalViajes = numeroTotalViajes;
	}



	
	
}
