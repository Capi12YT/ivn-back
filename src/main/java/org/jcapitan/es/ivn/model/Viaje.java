package org.jcapitan.es.ivn.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


//declaracion de entidad
@Entity(name="viajes")
public class Viaje extends PanacheEntity {
	
	//declaracion de atributo tipo unico
    @Column(unique = true)
	public String vi_name;
	public String vi_location;
	public String vi_description;
	public boolean vi_estado; //oferta o no
	public float vi_price;

	//declaracion de atributo tipo text
	@Column(columnDefinition="TEXT")
	public String vi_img;
	
	//declaracion de relacion uno a muchos
	@OneToMany(mappedBy = "viaje", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Reserva> reservas = new ArrayList<>();
	
	//declaracion de relacion muchos a uno
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	public Acontecimiento acontecimiento;
}
