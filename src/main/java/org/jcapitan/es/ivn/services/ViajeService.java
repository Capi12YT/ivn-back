package org.jcapitan.es.ivn.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import org.jcapitan.es.ivn.dto.FiltroViajeDTO;
import org.jcapitan.es.ivn.dto.ViajeDTO;
import org.jcapitan.es.ivn.dto.ViajeDTOe;
import org.jcapitan.es.ivn.mappers.ViajeMappers;
import org.jcapitan.es.ivn.model.Reserva;
import org.jcapitan.es.ivn.model.Viaje;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;

@ApplicationScoped

public class ViajeService implements PanacheRepository<Viaje> {
	//metodo crear viaje
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
	
	//metodo devolver viajes paginados
	public List<Viaje> viajeAllPage(Integer pageIndex,Integer pageSize){
		
		List<Viaje> viajes = Viaje.listAll();
		int numItems = viajes.size();
		int from = (pageIndex-1) * pageSize;
		int to = pageIndex * pageSize;
		if (from > numItems - 1) from = numItems - 1;
		if (to > numItems - 1) to = numItems;
		
		List<Viaje> subViajes  = viajes.subList(from , to);
		
		return subViajes;
	}
	
	//metodo borrar viaje
	public boolean deleteViaje(Long id) {
		Viaje viaje = Viaje.findById(id);
		
		
		viaje.reservas.forEach(reserva -> {
			Reserva.delete("id", reserva.id);
		});
		
		Long numeroViaje= Viaje.delete("id", id);
		if(numeroViaje > 0) {
			return true;			
		}else {
			return false;
		}
	}

	//metodo buscar viaje por id
	public Viaje viajeById(Long id) {
		return Viaje.findById(id);
	}

	//metodo actualizar viaje
	public boolean updateViaje(ViajeDTOe viajeDTO) {
		Viaje viajeBD = Viaje.findById(viajeDTO.getId());
		viajeBD.id=viajeDTO.getId();
		viajeBD.acontecimiento=viajeDTO.getId_acontecimiento();
		viajeBD.vi_description=viajeDTO.getDescription();
		viajeBD.vi_estado=viajeDTO.isEstado();
		if(!viajeDTO.getImg().isEmpty())viajeBD.vi_img=viajeDTO.getImg();
		viajeBD.vi_location=viajeDTO.getLocation();
		viajeBD.vi_name=viajeDTO.getName();
		viajeBD.vi_price=viajeDTO.getPrice();
		Viaje.persist(viajeBD);
		return true;
	}
	
	//metodo de filtrado de viaje por nombre,lozalizacion y estado
	public List<Viaje> viajeFiltre(FiltroViajeDTO filtroViajeDTO){
		
		List<Viaje> viajes = viajeFiltreAcontecimiento(filtroViajeDTO.getAcontecimiento());

		List<Viaje> viajesFiltrados = viajes.stream()
		    .filter(viaje -> filtroViajeDTO.getNombre() == "" || viaje.vi_name.contains(filtroViajeDTO.getNombre()) )
		    .filter(viaje -> filtroViajeDTO.getLocalizacion() == "" || filtroViajeDTO.getLocalizacion().equals(viaje.vi_location) )
		    .filter( viaje -> filtroViajeDTO.isEstado() == false || !(filtroViajeDTO.isEstado() && !viaje.vi_estado) )
		    .collect(Collectors.toList());
		
		return viajesFiltrados;
	}

	//metodo de filtrado de viaje por acontecimiento
	public List<Viaje> viajeFiltreAcontecimiento(String acontecimiento) {
		List<Viaje> viajes = Viaje.listAll();
		List<Viaje> viajesFiltrados = viajes.stream()
			    .filter(viaje -> viaje.acontecimiento.ev_acont_name.equals(acontecimiento) )
			    .collect(Collectors.toList());
		return viajesFiltrados;
	}

	
	
}
