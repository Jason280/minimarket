package pe.edu.upc.minimarket.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.minimarket.models.entities.Producto;
import pe.edu.upc.minimarket.models.repositories.ProductoRepository;
import pe.edu.upc.minimarket.services.ProductoService;

@Named
public class ProductoServiceImpl implements ProductoService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private ProductoRepository productoRepository;
	

	@Override
	public Producto save(Producto entity) throws Exception {
		// TODO Auto-generated method stub
		return productoRepository.save(entity);
	}

	@Override
	public Producto update(Producto entity) throws Exception {
		// TODO Auto-generated method stub
		return productoRepository.update(entity);
	}

	@Override
	public void deletedById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		productoRepository.deletedById(id);
	}

	@Override
	public Optional<Producto> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return productoRepository.findById(id);
	}

	@Override
	public List<Producto> findAll() throws Exception {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public List<Producto> findByNombre(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return productoRepository.findByNombre(nombre);
	}

}
