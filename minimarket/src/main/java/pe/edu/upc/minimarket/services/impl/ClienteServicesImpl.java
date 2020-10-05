package pe.edu.upc.minimarket.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.minimarket.models.entities.Cliente;
import pe.edu.upc.minimarket.models.repositories.ClienteRepository;
import pe.edu.upc.minimarket.services.ClienteService;


@Named
@ApplicationScoped
public class ClienteServicesImpl implements ClienteService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private ClienteRepository clienteRepository;

	@Override
	public Cliente save(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.save(entity);
	}

	@Override
	public Cliente update(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.update(entity);
	}

	@Override
	public void deletedById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		clienteRepository.deletedById(id);
		
	}

	@Override
	public Optional<Cliente> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id);
	}

	@Override
	public List<Cliente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	public List<Cliente> findByNombresApellidos(String nombresApellidos) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findByNombresApellidos(nombresApellidos);
	}

	@Override
	public Optional<Cliente> findByNumeroDocumento(String numeroDocumento) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findByNumeroDocumento(numeroDocumento);
	}

}
