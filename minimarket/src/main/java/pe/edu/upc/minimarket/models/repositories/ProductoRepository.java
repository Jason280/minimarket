package pe.edu.upc.minimarket.models.repositories;

import java.util.List;


import pe.edu.upc.minimarket.models.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	List<Producto> findByNombre(String nombre) throws Exception;
}
