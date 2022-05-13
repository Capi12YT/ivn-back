package org.jcapitan.es.ivn.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity(name="viajes")
public class Viaje extends PanacheEntity {
	
	
    @Column(unique = true)
	public String vi_name;
	public String vi_location;
	public String vi_description;
	public boolean vi_estado; //oferta o no
	public float vi_price;
	@Column(columnDefinition = "LONGBLOB")
	public String vi_img;
	
	@OneToMany(mappedBy = "viaje", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Reserva> reservas = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	public Acontecimiento acontecimiento;
}
