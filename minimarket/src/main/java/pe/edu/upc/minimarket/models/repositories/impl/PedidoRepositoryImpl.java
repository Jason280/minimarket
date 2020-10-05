package pe.edu.upc.minimarket.models.repositories.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pe.edu.upc.minimarket.models.entities.Pedido;
import pe.edu.upc.minimarket.models.repositories.PedidoRepository;



@Named
public class PedidoRepositoryImpl implements PedidoRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "MinimarketPU")
	private EntityManager em;

	@Override
	public Pedido save(Pedido entity) throws Exception {
		// TODO Auto-generated method stub
		em.persist(entity);
		return entity;
	}

	@Override
	public Pedido update(Pedido entity) throws Exception {
		// TODO Auto-generated method stub
		em.merge(entity);
		return entity;
	}

	@Override
	public void deletedById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Pedido> optional = findById(id);
		//verificar
		if(optional.isPresent()) {
			em.remove(optional.get());
		}
	}

	@Override
	public Optional<Pedido> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		//declarar variable a retornar
				Optional<Pedido> optional = Optional.empty();
				//hace el JPQL
				String qlString = "SELECT p FROM Pedido p WHERE p.id=?1";
				//crear la consulta
				TypedQuery<Pedido> query = em.createQuery(qlString, Pedido.class);
				//establecer parametro
				query.setParameter(1, id);
				//obtener
				Pedido pedido = query.getSingleResult();
				//verificar
				if(pedido!=null) {
					optional=Optional.of(pedido);
				}
				
				return optional;
	}

	@Override
	public List<Pedido> findAll() throws Exception {
		// TODO Auto-generated method stub
		//declarar variable a retornar
				List<Pedido> pedidos = new ArrayList<Pedido>();
				//hacer el jpql
				String qlString = "SELECT p FROM Pedido p";
				//crear la consulta
				TypedQuery<Pedido> query = em.createQuery(qlString, Pedido.class);
				//obtener
				pedidos = query.getResultList();
				
				return pedidos;
	}

}
