package org.jcapitan.es.ivn.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.jcapitan.es.ivn.dto.AcontecimientoDTO;
import org.jcapitan.es.ivn.mappers.AcontecimientoMappers;
import org.jcapitan.es.ivn.model.Acontecimiento;
import org.jcapitan.es.ivn.model.Viaje;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class AcontecimientoService implements PanacheRepository<Acontecimiento> {

	//metodo devolver todos los acontecimientos
	public List<Acontecimiento> getAll(){
		
		return Acontecimiento.listAll();
	}
	
	//metodo crear acontecimiento
	public boolean createAcon(AcontecimientoDTO acontecimientoDTO) {
		
		Acontecimiento aco = AcontecimientoMappers.acontecimientoDTOtoAcontecimiento(acontecimientoDTO);
		Acontecimiento.persist(aco);
		return true;
		
	}
	
	//metodo borrar un acontecimiento
	public boolean deleteAcon(Long id) {
		return Acontecimiento.deleteById(id);
	}

	
	//metodo acontecimiento paginado
	public List<Acontecimiento> acontecimientoAllPage(int pageIndex, int pageSize) {
		
		List<Acontecimiento> acontecimientos = Acontecimiento.listAll();
		int numItems = acontecimientos.size();
		int from = (pageIndex-1) * pageSize;
		int to = pageIndex * pageSize;
		if (from > numItems - 1) from = numItems - 1;
		if (to > numItems - 1) to = numItems;
		
		List<Acontecimiento> subAcontecimiento  = acontecimientos.subList(from , to);
		
		return subAcontecimiento;
	}
}
