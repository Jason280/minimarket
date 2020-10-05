package pe.edu.upc.minimarket.models.repositories;

import java.util.List;

import pe.edu.upc.minimarket.models.entities.Tienda;

public interface TiendaRepository extends JpaRepository<Tienda, Integer> {

	List<Tienda> findByNombre(String nombre) throws Exception;
	
}
