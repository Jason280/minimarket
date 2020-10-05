package pe.edu.upc.minimarket.models.repositories.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.minimarket.models.entities.Distrito;
import pe.edu.upc.minimarket.models.repositories.DistritoRepository;


@Named
public class DistritoRepositoryImpl implements DistritoRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "MinimarketPU")
	private EntityManager em;

	@Override
	public Distrito save(Distrito entity) throws Exception {
		// TODO Auto-generated method stub
		em.persist(entity);
		return entity;
	}

	@Override
	public Distrito update(Distrito entity) throws Exception {
		// TODO Auto-generated method stub
		em.merge(entity);
		return entity;
		
	}

	@Override
	public void deletedById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Distrito> optional = findById(id);
		//verificar
		if(optional.isPresent()) {
			em.remove(optional.get());
		}
		
		
	}

	@Override
	public Optional<Distrito> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		//declarar variable a retornar
		Optional<Distrito> optional = Optional.empty();
		//hace el JPQL
		String qlString = "SELECT d FROM Distrito d WHERE d.id=?1";
		//crear la consulta
		TypedQuery<Distrito> query = em.createQuery(qlString, Distrito.class);
		//establecer parametro
		query.setParameter(1, id);
		//obtener
		Distrito distrito = query.getSingleResult();
		//verificar
		if(distrito!=null) {
			optional=Optional.of(distrito);
		}
		
		return optional;
	}

	@Override
	public List<Distrito> findAll() throws Exception {
		// TODO Auto-generated method stub
		//declarar variable a retornar
		List<Distrito> distritos = new ArrayList<Distrito>();
		//hacer el jpql
		String qlString = "SELECT d FROM Distrito d";
		//crear la consulta
		TypedQuery<Distrito> query = em.createQuery(qlString, Distrito.class);
		//obtener
		distritos = query.getResultList();
		
		return distritos;
	}

	@Override
	public List<Distrito> findByNombre(String nombre) throws Exception {
		// TODO Auto-generated method stub
		//crear la variable
		List<Distrito> distritos = new ArrayList<Distrito>();
		//crear el jpql
		String qlString ="SELECT d from Distrito d WHERE d.nombre LIKE ?1";
		//crear la consulta
		TypedQuery<Distrito> query = em.createQuery(qlString, Distrito.class); 
		//setear
		query.setParameter(1, "%"+nombre.toUpperCase()+"%");
		//obtener
		distritos = query.getResultList();
		
		// TODO Auto-generated method stub
		return distritos;
		
	}

	
}
