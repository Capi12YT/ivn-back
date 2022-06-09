package org.jcapitan.es.ivn.dto;

import java.util.List;

public class ReservaPaginadoDTO {
	private List<ReservaDTO> reservasPaginados;
	private Long numeroReservas;
	
	public ReservaPaginadoDTO(List<ReservaDTO> reservasPaginados, Long numeroReserva) {
		super();
		this.reservasPaginados = reservasPaginados;
		this.numeroReservas = numeroReserva;
	}

	public List<ReservaDTO> getReservasPaginados() {
		return reservasPaginados;
	}

	public void setReservasPaginados(List<ReservaDTO> reservasPaginados) {
		this.reservasPaginados = reservasPaginados;
	}

	public Long getNumeroReserva() {
		return numeroReservas;
	}

	public void setNumeroReserva(Long numeroReserva) {
		this.numeroReservas = numeroReserva;
	}
	
	
	
}
