package pe.edu.upc.minimarket.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.minimarket.models.entities.Tienda;
import pe.edu.upc.minimarket.models.repositories.TiendaRepository;
import pe.edu.upc.minimarket.services.TiendaService;


@Named
public class TiendaServiceImpl implements TiendaService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TiendaRepository tiendaRepository;

	@Override
	public Tienda save(Tienda entity) throws Exception {
		// TODO Auto-generated method stub
		return tiendaRepository.save(entity);
	}

	@Override
	public Tienda update(Tienda entity) throws Exception {
		// TODO Auto-generated method stub
		return tiendaRepository.update(entity);
	}

	@Override
	public void deletedById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		tiendaRepository.deletedById(id);
	}

	@Override
	public Optional<Tienda> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return tiendaRepository.findById(id);
	}

	@Override
	public List<Tienda> findAll() throws Exception {
		// TODO Auto-generated method stub
		return tiendaRepository.findAll();
	}

	@Override
	public List<Tienda> findByNombre(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return tiendaRepository.findByNombre(nombre);
	}

}
