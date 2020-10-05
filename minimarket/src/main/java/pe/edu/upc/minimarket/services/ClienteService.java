package pe.edu.upc.minimarket.services;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.minimarket.models.entities.Cliente;

public interface ClienteService extends CrudService<Cliente, Integer> {
	
	List<Cliente> findByNombresApellidos(String nombresApellidos) throws Exception;
	Optional<Cliente> findByNumeroDocumento(String numeroDocumento) throws Exception;
}
