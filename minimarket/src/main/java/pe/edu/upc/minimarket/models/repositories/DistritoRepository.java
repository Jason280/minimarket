package pe.edu.upc.minimarket.models.repositories;

import java.util.List;


import pe.edu.upc.minimarket.models.entities.Distrito;

public interface DistritoRepository extends JpaRepository<Distrito, Integer>{

	List<Distrito> findByNombre(String nombre) throws Exception;
	
}


