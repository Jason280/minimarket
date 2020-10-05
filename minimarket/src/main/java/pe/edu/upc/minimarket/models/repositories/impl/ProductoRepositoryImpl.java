package pe.edu.upc.minimarket.models.repositories.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pe.edu.upc.minimarket.models.entities.Producto;
import pe.edu.upc.minimarket.models.repositories.ProductoRepository;


@Named
public class ProductoRepositoryImpl implements ProductoRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "MinimarketPU")
	private EntityManager em;
	
	@Override
	public Producto save(Producto entity) throws Exception {
		// TODO Auto-generated method stub
		em.persist(entity);
		return entity;
	}

	@Override
	public Producto update(Producto entity) throws Exception {
		// TODO Auto-generated method stub
		em.merge(entity);
		return entity;
	}

	@Override
	public void deletedById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Producto> optional = findById(id);
		//verificar
		if(optional.isPresent()) {
			em.remove(optional.get());
		}
	}

	@Override
	public Optional<Producto> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		//declarar variable a retornar
				Optional<Producto> optional = Optional.empty();
				//hace el JPQL
				String qlString = "SELECT p FROM Producto p WHERE p.id=?1";
				//crear la consulta
				TypedQuery<Producto> query = em.createQuery(qlString, Producto.class);
				//establecer parametro
				query.setParameter(1, id);
				//obtener
				Producto producto = query.getSingleResult();
				//verificar
				if(producto!=null) {
					optional=Optional.of(producto);
				}
				
				return optional;
	}

	@Override
	public List<Producto> findAll() throws Exception {
		// TODO Auto-generated method stub
		//declarar variable a retornar
				List<Producto> productos = new ArrayList<Producto>();
				//hacer el jpql
				String qlString = "SELECT p FROM Producto p";
				//crear la consulta
				TypedQuery<Producto> query = em.createQuery(qlString, Producto.class);
				//obtener
				productos = query.getResultList();
				
				return productos;
	}

	@Override
	public List<Producto> findByNombre(String nombre) throws Exception {
		// TODO Auto-generated method stub
		//crear la variable
		List<Producto> productos = new ArrayList<Producto>();
		//crear el jpql
		String qlString ="SELECT  from Producto p WHERE p.nombre LIKE ?1";
		//crear la consulta
		TypedQuery<Producto> query = em.createQuery(qlString, Producto.class); 
		//setear
		query.setParameter(1, "%"+nombre.toUpperCase()+"%");
		//obtener
		productos = query.getResultList();
		
		// TODO Auto-generated method stub
		return productos;
	}

	
	
}
