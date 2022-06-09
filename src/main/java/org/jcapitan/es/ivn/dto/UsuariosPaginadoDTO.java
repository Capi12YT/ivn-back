package org.jcapitan.es.ivn.dto;

import java.util.List;

public class UsuariosPaginadoDTO {
	private List<UsuarioDTO> usuariosPaginados;
	private Long numeroUsuarios;
	
	public UsuariosPaginadoDTO(List<UsuarioDTO> usuariosPaginados, Long numeroUsuarios) {
		super();
		this.usuariosPaginados = usuariosPaginados;
		this.numeroUsuarios = numeroUsuarios;
	}

	public List<UsuarioDTO> getUsuariosPaginados() {
		return usuariosPaginados;
	}

	public void setUsuariosPaginados(List<UsuarioDTO> usuariosPaginados) {
		this.usuariosPaginados = usuariosPaginados;
	}

	public Long getNumeroUsuarios() {
		return numeroUsuarios;
	}

	public void setNumeroUsuarios(Long numeroUsuarios) {
		this.numeroUsuarios = numeroUsuarios;
	}
	
	
}
