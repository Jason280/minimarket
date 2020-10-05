package pe.edu.upc.minimarket.services;

import java.util.List;

import pe.edu.upc.minimarket.models.entities.Distrito;

public interface DistritoService extends CrudService<Distrito, Integer> {

	List<Distrito> findByNombre(String nombre) throws Exception;
}
