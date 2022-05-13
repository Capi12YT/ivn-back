package org.jcapitan.es.ivn.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;




import com.fasterxml.jackson.annotation.JsonIgnore;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity(name="reservas")
public class Reserva extends PanacheEntity {
	
	@ManyToOne
	@JsonIgnore
	public Usuario usuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	public Viaje viaje;
	
	public Long rv_cantidad;
	
	
	
}
