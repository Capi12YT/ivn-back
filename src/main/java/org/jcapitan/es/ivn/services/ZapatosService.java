package org.jcapitan.es.ivn.services;



import java.util.List;

import javax.enterprise.context.ApplicationScoped;


import io.quarkus.hibernate.orm.panache.PanacheRepository;

/*@ApplicationScoped
public class ZapatosService implements PanacheRepository<Zapato> {
		
	
	
	public Zapato getZapato(long id) {
		return	Zapato.findById(id);
		}
	
	public List<Zapato> getAll(){
		return Zapato.listAll();
	}
	
	
	public  List<Zapato> getZapatoByMarca(String marca) {
		return find("marca", marca).list();
	}
	
	public boolean guardarZapato(Zapato zap) {
		Zapato.persist(zap);
		return true;
	}
	public Zapato updateById(Long id,Zapato zapato) {
		Zapato zap = Zapato.findById(id);
		zap.marca=zapato.marca;
		zap.talla=zapato.talla;
		zap.persist();
		return zap;
		
	}
	public boolean deleteZapato(long id) {
		return Zapato.deleteById(id);

		}
}*/
