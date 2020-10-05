package pe.edu.upc.minimarket.services;

import java.util.List;

import pe.edu.upc.minimarket.models.entities.Producto;

public interface ProductoService extends CrudService<Producto, Integer>{

	List<Producto> findByNombre(String nombre) throws Exception;
}
