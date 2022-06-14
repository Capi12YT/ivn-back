package org.jcapitan.es.ivn.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

//declaracion de entidad
@Entity(name="acontecimientos")
public class Acontecimiento extends PanacheEntity {

	public String ev_acont_name;
	
	public Date ev_fecha_inicio;
	
	public Date ev_fecha_fin;
	
	//declaracion de relacion uno a muchos
	@OneToMany(mappedBy = "acontecimiento", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Viaje> viaje= new ArrayList<>();
}
