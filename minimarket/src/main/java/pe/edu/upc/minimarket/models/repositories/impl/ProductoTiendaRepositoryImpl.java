package pe.edu.upc.minimarket.models.repositories.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.minimarket.models.entities.ProductoTienda;
import pe.edu.upc.minimarket.models.repositories.ProductoTiendaRepository;


@Named
public class ProductoTiendaRepositoryImpl implements ProductoTiendaRepository, Serializable{

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "MinimarketPU")
	private EntityManager em;

	@Override
	public ProductoTienda save(ProductoTienda entity) throws Exception {
		// TODO Auto-generated method stub
		em.persist(entity);
		return entity;
		
	}

	@Override
	public ProductoTienda update(ProductoTienda entity) throws Exception {
		// TODO Auto-generated method stub
		em.merge(entity);
		return entity;
	}

	@Override
	public void deletedById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Optional<ProductoTienda> optional = findById(id);
		//verificar
		if(optional.isPresent()) {
			em.remove(optional.get());
		}
	}

	@Override
	public Optional<ProductoTienda> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Optional<ProductoTienda> optional = Optional.empty();
		//hace el JPQL
		String qlString = "SELECT pt FROM ProductoTienda pt WHERE pt.id=?1";
		//crear la consulta
		TypedQuery<ProductoTienda> query = em.createQuery(qlString, ProductoTienda.class);
		//establecer parametro
		query.setParameter(1, id);
		//obtener
		ProductoTienda productoTienda = query.getSingleResult();
		//verificar
		if(productoTienda!=null) {
			optional=Optional.of(productoTienda);
		}
		
		return optional;
	}

	@Override
	public List<ProductoTienda> findAll() throws Exception {
		// TODO Auto-generated method stub
		//declarar variable a retornar
		List<ProductoTienda> productoTiendas = new ArrayList<ProductoTienda>();
		//hacer el jpql
		String qlString = "SELECT pt FROM ProductoTienda pt";
		//crear la consulta
		TypedQuery<ProductoTienda> query = em.createQuery(qlString, ProductoTienda.class);
		//obtener
		productoTiendas = query.getResultList();
		
		return productoTiendas;
	}

}
