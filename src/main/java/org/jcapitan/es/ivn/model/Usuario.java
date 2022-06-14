package org.jcapitan.es.ivn.model;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
//declaracion de entidad 
@Entity(name="usuarios")
@Table(name = "usuarios", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Usuario extends PanacheEntity  {
    
	@Username 
	public String us_name;
    
    @Password
	public String us_password;
    
    //declaracion de atributo unico
    @Column(unique = true)
	public String us_email;
	public String us_lastname;
	public String us_rol;
	
    //declaracion de uno a muchos
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Reserva> reservas = new ArrayList<>();
}
