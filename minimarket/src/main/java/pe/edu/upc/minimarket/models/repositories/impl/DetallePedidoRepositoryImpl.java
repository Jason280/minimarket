package pe.edu.upc.minimarket.models.repositories.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.minimarket.models.entities.DetallePedido;
import pe.edu.upc.minimarket.models.repositories.DetallePedidoRepository;

@Named
public class DetallePedidoRepositoryImpl implements DetallePedidoRepository, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "MinimarketPU")
	private EntityManager em;

	@Override
	public DetallePedido save(DetallePedido entity) throws Exception {
		// TODO Auto-generated method stub
		em.persist(entity);
		return entity;
	}

	@Override
	public DetallePedido update(DetallePedido entity) throws Exception {
		// TODO Auto-generated method stub
		em.merge(entity);
		return entity;
	}

	@Override
	public void deletedById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Optional<DetallePedido> optional = findById(id);
		//verificar
		if(optional.isPresent()) {
			em.remove(optional.get());
		}
		
		
	}

	@Override
	public Optional<DetallePedido> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		//declarar variable a retornar
				Optional<DetallePedido> optional = Optional.empty();
				//hace el JPQL
				String qlString = "SELECT dp FROM DetallePedido dp WHERE c.id=?1";
				//crear la consulta
				TypedQuery<DetallePedido> query = em.createQuery(qlString, DetallePedido.class);
				//establecer parametro
				query.setParameter(1, id);
				//obtener
				DetallePedido detallePedido = query.getSingleResult();
				//verificar
				if(detallePedido!=null) {
					optional=Optional.of(detallePedido);
				}
				
				return optional;
	}

	@Override
	public List<DetallePedido> findAll() throws Exception {
		// TODO Auto-generated method stub
		//declarar variable a retornar
				List<DetallePedido> detallePedidos = new ArrayList<DetallePedido>();
				//hacer el jpql
				String qlString = "SELECT dp FROM DetallePedido dp";
				//crear la consulta
				TypedQuery<DetallePedido> query = em.createQuery(qlString, DetallePedido.class);
				//obtener
				detallePedidos = query.getResultList();
				
				return detallePedidos;
	}

}
