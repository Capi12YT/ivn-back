package org.jcapitan.es.ivn.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;


import org.jcapitan.es.ivn.model.Reserva;

import io.quarkus.hibernate.orm.panache.PanacheRepository;


@ApplicationScoped
public class ReservaService implements PanacheRepository<Reserva> {

	public List<Reserva> reservaAll(){
		return Reserva.listAll();
	}

	public boolean createReserva(Reserva reserva) {
		Reserva reservaFind = Reserva.find("usuario_id = ?1 and viaje_id = ?2", reserva.usuario.id, reserva.viaje.id).firstResult();
		if(reservaFind == null) {
			if (!reserva.isPersistent()) {
				Reserva.persist(reserva);
				return true;
			}
		}else {
			reservaFind.rv_cantidad+=1;
			Reserva.persist(reservaFind);
			return true;
		}
		return false;
	}

	public boolean deleteReserva(Long userId) {
		if (Reserva.delete("id", userId)>0) {
			return true;
		}
		return false;
	}
	
}
