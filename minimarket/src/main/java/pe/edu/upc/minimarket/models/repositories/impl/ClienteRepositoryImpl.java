package pe.edu.upc.minimarket.models.repositories.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.minimarket.models.entities.Cliente;
import pe.edu.upc.minimarket.models.repositories.ClienteRepository;


@Named
@ApplicationScoped
public class ClienteRepositoryImpl implements ClienteRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "MinimarketPU")
	private EntityManager em;

	@Override
	public Cliente save(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		em.persist(entity);
		return entity;
	}

	@Override
	public Cliente update(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		
		em.merge(entity);
		return entity;
	}

	@Override
	public void deletedById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		//crear variable
		Optional<Cliente> optional = findById(id);
		//verificar
		if(optional.isPresent()) {
			em.remove(optional.get());
		}
		
	}

	@Override
	public Optional<Cliente> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		//declarar variable a retornar
		Optional<Cliente> optional = Optional.empty();
		//hace el JPQL
		String qlString = "SELECT c FROM Cliente c WHERE c.id=?1";
		//crear la consulta
		TypedQuery<Cliente> query = em.createQuery(qlString, Cliente.class);
		//establecer parametro
		query.setParameter(1, id);
		//obtener
		Cliente cliente = query.getSingleResult();
		//verificar
		if(cliente!=null) {
			optional=Optional.of(cliente);
		}
		
		return optional;
	}

	@Override
	public List<Cliente> findAll() throws Exception {
		// TODO Auto-generated method stub
		//declarar variable a retornar
		List<Cliente> clientes = new ArrayList<Cliente>();
		//hacer el jpql
		String qlString = "SELECT c FROM Cliente c";
		//crear la consulta
		TypedQuery<Cliente> query = em.createQuery(qlString, Cliente.class);
		//obtener
		clientes = query.getResultList();
		
		return clientes;
	}

	@Override
	public List<Cliente> findByNombresApellidos(String nombresApellidos) throws Exception {
		//crear la variable
		List<Cliente> clientes = new ArrayList<Cliente>();
		//crear el jpql
		String qlString ="SELECT c from Cliente c WHERE c.nombresApellidos LIKE ?1";
		//crear la consulta
		TypedQuery<Cliente> query = em.createQuery(qlString, Cliente.class); 
		//setear
		query.setParameter(1, "%"+nombresApellidos.toUpperCase()+"%");
		//obtener
		clientes = query.getResultList();
		
		// TODO Auto-generated method stub
		return clientes;
	}

	@Override
	public Optional<Cliente> findByNumeroDocumento(String numeroDocumento) throws Exception {
		// TODO Auto-generated method stub
		//declarar variable
		Optional<Cliente> optional= Optional.empty();
		//hacer el jpql
		String qlString = "SELECT c from Cliente c WHERE c.numeroDocumento LIKE ?1";
		//crear la consulta
		TypedQuery<Cliente> query = em.createQuery(qlString, Cliente.class);
		//obtener
		Cliente cliente = query.getResultList().stream().findFirst().orElse(null);
		//verificar
		if(cliente!=null) {
			optional = Optional.of(cliente);
		}
		
		return optional;
	}

}
