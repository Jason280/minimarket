package pe.edu.upc.minimarket.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.minimarket.models.entities.Pedido;
import pe.edu.upc.minimarket.models.repositories.PedidoRepository;
import pe.edu.upc.minimarket.services.PedidoService;


@Named
public class PedidoServiceImpl implements PedidoService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private PedidoRepository pedidoRepository;
	
	
	@Override
	public Pedido save(Pedido entity) throws Exception {
		// TODO Auto-generated method stub
		return pedidoRepository.save(entity);
	}

	@Override
	public Pedido update(Pedido entity) throws Exception {
		// TODO Auto-generated method stub
		return pedidoRepository.update(entity);
	}

	@Override
	public void deletedById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		pedidoRepository.deletedById(id);
	}

	@Override
	public Optional<Pedido> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return pedidoRepository.findById(id);
	}

	@Override
	public List<Pedido> findAll() throws Exception {
		// TODO Auto-generated method stub
		return pedidoRepository.findAll();
	}

}
