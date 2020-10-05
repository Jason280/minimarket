package pe.edu.upc.minimarket.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.minimarket.models.entities.Distrito;
import pe.edu.upc.minimarket.models.repositories.DistritoRepository;
import pe.edu.upc.minimarket.services.DistritoService;


@Named
public class DistritoServiceImpl implements DistritoService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private DistritoRepository distritoRepository;

	@Override
	public Distrito save(Distrito entity) throws Exception {
		// TODO Auto-generated method stub
		return distritoRepository.save(entity);
	}

	@Override
	public Distrito update(Distrito entity) throws Exception {
		// TODO Auto-generated method stub
		return distritoRepository.update(entity);
	}

	@Override
	public void deletedById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		distritoRepository.deletedById(id);
	}

	@Override
	public Optional<Distrito> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return distritoRepository.findById(id);
	}

	@Override
	public List<Distrito> findAll() throws Exception {
		// TODO Auto-generated method stub
		return distritoRepository.findAll();
	}

	@Override
	public List<Distrito> findByNombre(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return distritoRepository.findByNombre(nombre);
	}

}
