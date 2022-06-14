package org.jcapitan.es.ivn.mappers;

import org.jcapitan.es.ivn.dto.ReservaDTO;
import org.jcapitan.es.ivn.model.Reserva;

public class ReservaMappers {
	
	//metodo para mapear reservaDTO mediante Reserva
	public static ReservaDTO reservaToReservaDTO(Reserva reserva) {
		ReservaDTO reservaDTO = new ReservaDTO();
		
		reservaDTO.setId(reserva.id);
		reservaDTO.setIdUsuario(reserva.usuario.id);
		reservaDTO.setNombreUsuario(reserva.usuario.us_name);
		reservaDTO.setIdViaje(reserva.viaje.id);
		reservaDTO.setNombreViaje(reserva.viaje.vi_name);
		reservaDTO.setImg(reserva.viaje.vi_img);
		reservaDTO.setCantidad(reserva.rv_cantidad);
		
		return reservaDTO;
	}
	
	//metodo para mapear Reserva mediante ReservaDTO
	public static Reserva reservaDTOtoReserva(ReservaDTO reservaDTO) {
		Reserva reserva =  new Reserva();
		
		reserva.usuario=reservaDTO.getUsuario();
		reserva.viaje=reservaDTO.getViaje();
		reserva.rv_cantidad=reservaDTO.getCantidad();
		return reserva;
		
	}
}
