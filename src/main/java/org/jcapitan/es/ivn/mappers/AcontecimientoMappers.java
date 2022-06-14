package org.jcapitan.es.ivn.mappers;

import java.util.Arrays;
import java.util.List;

import org.jcapitan.es.ivn.dto.AcontecimientoDTO;
import org.jcapitan.es.ivn.model.Acontecimiento;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import net.bytebuddy.description.method.MethodDescription.TypeToken;

public class AcontecimientoMappers {
	
	//metodo para mapear Acontecimiento mediante AcontecimientoDTO
	public static Acontecimiento acontecimientoDTOtoAcontecimiento(AcontecimientoDTO acontecimientoDTO) {
		
		Acontecimiento acontecimiento = new Acontecimiento();
		
		acontecimiento.ev_acont_name = acontecimientoDTO.getName();
		acontecimiento.ev_fecha_inicio = acontecimientoDTO.getFechaInicioDate();
		acontecimiento.ev_fecha_fin = acontecimientoDTO.getFechaFinDate();
		return acontecimiento;
	}
	
	//metodo para mapear AcontecimientoDTO mediante Acontecimiento
	public static AcontecimientoDTO acontecimientoToAcontecimientoDTO(Acontecimiento acontecimiento) {
		AcontecimientoDTO acontecimientoDTO = new AcontecimientoDTO();
		acontecimientoDTO.setId(acontecimiento.id);
		acontecimientoDTO.setName(acontecimiento.ev_acont_name);
		acontecimientoDTO.setFechaFin(acontecimiento.ev_fecha_fin.getTime());
		acontecimientoDTO.setFechaInicio(acontecimiento.ev_fecha_inicio.getTime());
		return acontecimientoDTO;
	}
	
	

	
}
