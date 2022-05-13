package org.jcapitan.es.ivn.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import org.jcapitan.es.ivn.model.Acontecimiento;
import org.jcapitan.es.ivn.model.Contadores;
import org.jcapitan.es.ivn.model.Reserva;
import org.jcapitan.es.ivn.model.Usuario;
import org.jcapitan.es.ivn.model.Viaje;

@ApplicationScoped
public class ContadorService {

	
	public Map<String, Long> getContadores(){
		Map<String, Long> map = new HashMap<String, Long>();
        map.put("Usuarios", Usuario.count());
		map.put("Reservas", Reserva.count());
		map.put("Viajes", Viaje.count());
		map.put("Acontecimientos", Acontecimiento.count());
		return map;
		
	}
}
