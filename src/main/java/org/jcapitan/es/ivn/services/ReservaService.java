package org.jcapitan.es.ivn.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.jcapitan.es.ivn.model.Acontecimiento;
import org.jcapitan.es.ivn.model.Reserva;

import io.quarkus.hibernate.orm.panache.PanacheRepository;


@ApplicationScoped
public class ReservaService implements PanacheRepository<Reserva> {

	//metodo devolver todas las reservas
	public List<Reserva> reservaAll(){
		return Reserva.listAll();
	}

	//metodo crear reserva
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

	//metodo borrar reserva de un usuario
	public boolean deleteReserva(Long userId) {
		if (Reserva.delete("id", userId)>0) {
			return true;
		}
		return false;
	}
	
	//metodo borrar todas las reservas de un usuario
	public long deleteAllReserva(Long userId) {
		List<Reserva> reservasByUser = Reserva.list("usuario_id", userId);
		reservasByUser.forEach(reserva -> {
			Reserva.delete("id", reserva.id);
		});
		reservasByUser = Reserva.list("usuario_id", userId);
		return reservasByUser.size();


	}

	//metodo reservas paginadas
	public List<Reserva> reservaAllPage(int pageIndex, int pageSize) {
		List<Reserva> reservas = Reserva.listAll();
		int numItems = reservas.size();
		int from = (pageIndex-1) * pageSize;
		int to = pageIndex * pageSize;
		if (from > numItems - 1) from = numItems - 1;
		if (to > numItems - 1) to = numItems;
		
		List<Reserva> subReserva  = reservas.subList(from , to);
		
		return subReserva;
	}
	
}
