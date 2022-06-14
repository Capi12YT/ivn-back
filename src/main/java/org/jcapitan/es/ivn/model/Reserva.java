package org.jcapitan.es.ivn.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;




import com.fasterxml.jackson.annotation.JsonIgnore;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

//declaracion de entidad
@Entity(name="reservas")
public class Reserva extends PanacheEntity {
	
	//declaracion relacion muchos a uno
	@ManyToOne
	@JsonIgnore
	public Usuario usuario;
	
	//declaracion relacion muchos a uno
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	public Viaje viaje;
	
	public Long rv_cantidad;
	
	
	
}
