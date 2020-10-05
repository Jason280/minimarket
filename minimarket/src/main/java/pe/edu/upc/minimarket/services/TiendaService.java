package pe.edu.upc.minimarket.services;

import java.util.List;

import pe.edu.upc.minimarket.models.entities.Tienda;

public interface TiendaService extends CrudService<Tienda, Integer> {

	List<Tienda> findByNombre(String nombre) throws Exception;
}
