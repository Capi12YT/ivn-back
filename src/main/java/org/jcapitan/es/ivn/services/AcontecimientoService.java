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

	public List<Acontecimiento> getAll(){
		
		return Acontecimiento.listAll();
	}
	
	public boolean createAcon(AcontecimientoDTO acontecimientoDTO) {
		
		Acontecimiento aco = AcontecimientoMappers.acontecimientoDTOtoAcontecimiento(acontecimientoDTO);
		Acontecimiento.persist(aco);
		return true;
		
	}
	
	public boolean deleteAcon(Long id) {
		return Acontecimiento.deleteById(id);
	}
}
