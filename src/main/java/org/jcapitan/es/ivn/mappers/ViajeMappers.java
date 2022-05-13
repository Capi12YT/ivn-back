package org.jcapitan.es.ivn.mappers;

import java.awt.font.ImageGraphicAttribute;

import org.jcapitan.es.ivn.dto.ViajeDTO;
import org.jcapitan.es.ivn.dto.ViajeDTOe;
import org.jcapitan.es.ivn.dto.ViajeDTOr;
import org.jcapitan.es.ivn.model.Acontecimiento;
import org.jcapitan.es.ivn.model.Viaje;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

public class ViajeMappers{

	public static Viaje ViajeDtoToViaje(ViajeDTO viajeDTO) {
		Viaje viaje = new Viaje();
		viaje.vi_name = viajeDTO.getName();
		viaje.vi_description = viajeDTO.getDescription();
		viaje.vi_estado = viajeDTO.isEstado();
		viaje.vi_img = viajeDTO.getImg();
		viaje.vi_location = viajeDTO.getLocation();
		viaje.vi_price = viajeDTO.getPrice();
		viaje.acontecimiento = viajeDTO.getId_acontecimiento();
		return viaje;
	}
	
	public static ViajeDTOr viajeToViajeDTO(Viaje viaje) {
		ViajeDTOr viajeDTOr = new ViajeDTOr();

		viajeDTOr.setName_acontecimiento(viaje.acontecimiento.ev_acont_name); 
		viajeDTOr.setFechaInicioDate(viaje.acontecimiento.ev_fecha_inicio);
		viajeDTOr.setFechaFinDate(viaje.acontecimiento.ev_fecha_fin);
		viajeDTOr.setId_acontecimiento(viaje.acontecimiento.id);
		viajeDTOr.setId(viaje.id);
		viajeDTOr.setName(viaje.vi_name);
		viajeDTOr.setDescription(viaje.vi_description);
		viajeDTOr.setEstado(viaje.vi_estado);
		viajeDTOr.setLocation(viaje.vi_location);
		viajeDTOr.setPrice(viaje.vi_price);
		viajeDTOr.setImg(viaje.vi_img);
		return viajeDTOr;
	}
	public static Viaje ViajeDtoeToViaje(ViajeDTOe viajeDTO) {
		Viaje viaje = new Viaje();
		
		viaje.id=viajeDTO.getId();
		viaje.vi_name = viajeDTO.getName();
		viaje.vi_description = viajeDTO.getDescription();
		viaje.vi_estado = viajeDTO.isEstado();
		viaje.vi_img = viajeDTO.getImg();
		viaje.vi_location = viajeDTO.getLocation();
		viaje.vi_price = viajeDTO.getPrice();
		viaje.acontecimiento = viajeDTO.getId_acontecimiento();
		return viaje;
	}
}
