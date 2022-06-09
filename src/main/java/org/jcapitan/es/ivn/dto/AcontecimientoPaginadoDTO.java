package org.jcapitan.es.ivn.dto;

import java.util.List;

public class AcontecimientoPaginadoDTO {

	
	private List<AcontecimientoDTO> acontecimientosPaginados;
	private Long numeroAcontecimientos;
	


	public AcontecimientoPaginadoDTO(List<AcontecimientoDTO> acontecimientosPaginados, Long numeroAcontecimientos) {
		super();
		this.acontecimientosPaginados = acontecimientosPaginados;
		this.numeroAcontecimientos = numeroAcontecimientos;
	}

	public List<AcontecimientoDTO> getAcontecimientosPaginados() {
		return acontecimientosPaginados;
	}

	public void setAcontecimientosPaginados(List<AcontecimientoDTO> acontecimientosPaginados) {
		this.acontecimientosPaginados = acontecimientosPaginados;
	}

	public Long getNumeroAcontecimientos() {
		return numeroAcontecimientos;
	}

	public void setNumeroAcontecimientos(Long numeroAcontecimientos) {
		this.numeroAcontecimientos = numeroAcontecimientos;
	}
	
	
}
