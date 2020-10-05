package pe.edu.upc.minimarket.models.repositories.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.minimarket.models.entities.Tienda;
import pe.edu.upc.minimarket.models.repositories.TiendaRepository;


@Named
public class TiendaRepositoryImpl implements TiendaRepository, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "MinimarketPU")
	private EntityManager em;
	
	@Override
	public Tienda save(Tienda entity) throws Exception {
		// TODO Auto-generated method stub
		em.persist(entity);
		return entity;
	}

	@Override
	public Tienda update(Tienda entity) throws Exception {
		// TODO Auto-generated method stub
		em.merge(entity);
		return entity;
	}

	@Override
	public void deletedById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Tienda> optional = findById(id);
		//verificar
		if(optional.isPresent()) {
			em.remove(optional.get());
		}
	}

	@Override
	public Optional<Tienda> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
		//declarar variable a retornar
		Optional<Tienda> optional = Optional.empty();
		//hace el JPQL
		String qlString = "SELECT t FROM Tienda t WHERE p.id=?1";
		//crear la consulta
		TypedQuery<Tienda> query = em.createQuery(qlString, Tienda.class);
		//establecer parametro
		query.setParameter(1, id);
		//obtener
		Tienda tienda = query.getSingleResult();
		//verificar
		if(tienda!=null) {
			optional=Optional.of(tienda);
		}
		
		return optional;
	}

	@Override
	public List<Tienda> findAll() throws Exception {
		// TODO Auto-generated method stub
		//declarar variable a retornar
		List<Tienda> tiendas = new ArrayList<Tienda>();
		//hacer el jpql
		String qlString = "SELECT p FROM Tienda p";
		//crear la consulta
		TypedQuery<Tienda> query = em.createQuery(qlString, Tienda.class);
		//obtener
		tiendas = query.getResultList();
		
		return tiendas;
	}

	@Override
	public List<Tienda> findByNombre(String nombre) throws Exception {
		// TODO Auto-generated method stub
		//crear la variable
				List<Tienda> tiendas = new ArrayList<Tienda>();
				//crear el jpql
				String qlString ="SELECT  from Tienda t WHERE t.nombre LIKE ?1";
				//crear la consulta
				TypedQuery<Tienda> query = em.createQuery(qlString, Tienda.class); 
				//setear
				query.setParameter(1, "%"+nombre.toUpperCase()+"%");
				//obtener
				tiendas = query.getResultList();
				
				// TODO Auto-generated method stub
				return tiendas;
	}

	
}
