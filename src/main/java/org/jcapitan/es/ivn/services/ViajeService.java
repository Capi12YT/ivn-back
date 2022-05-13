package org.jcapitan.es.ivn.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.jcapitan.es.ivn.dto.ViajeDTO;
import org.jcapitan.es.ivn.dto.ViajeDTOe;
import org.jcapitan.es.ivn.mappers.ViajeMappers;
import org.jcapitan.es.ivn.model.Usuario;
import org.jcapitan.es.ivn.model.Viaje;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped

public class ViajeService implements PanacheRepository<Viaje> {

	public boolean createViaje(ViajeDTO viajeDTO) {
		Viaje vj = ViajeMappers.ViajeDtoToViaje(viajeDTO);
		
		Viaje viaje = Viaje.find("vi_name", viajeDTO.getName()).firstResult();
		
		if (viaje == null) {
			Viaje.persist(vj);
			return true;
		}
		return false;
	}

	public List<Viaje> viajeAll(){
		return Viaje.listAll();
	}

	public boolean deleteViaje(Long id) {
		Long numeroViaje= Viaje.delete("id", id);
		if(numeroViaje > 0) {
			return true;			
		}else {
			return false;
		}
		
	}

	public Viaje viajeById(Long id) {
		return Viaje.findById(id);
	}

	public boolean updateViaje(ViajeDTOe viajeDTO) {
		Viaje viajeBD = Viaje.findById(viajeDTO.getId());
		viajeBD.id=viajeDTO.getId();
		viajeBD.acontecimiento=viajeDTO.getId_acontecimiento();
		viajeBD.vi_description=viajeDTO.getDescription();
		viajeBD.vi_estado=viajeDTO.isEstado();
		viajeBD.vi_img=viajeDTO.getImg();
		viajeBD.vi_location=viajeDTO.getLocation();
		viajeBD.vi_name=viajeDTO.getName();
		viajeBD.vi_price=viajeDTO.getPrice();
		Viaje.persist(viajeBD);
		return true;
	}
	
}
