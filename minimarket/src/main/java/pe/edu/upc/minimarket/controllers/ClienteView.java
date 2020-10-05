package pe.edu.upc.minimarket.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.minimarket.models.entities.Cliente;
import pe.edu.upc.minimarket.services.ClienteService;


@Named("clienteView")//clienteview
@ViewScoped//faces view para alcance dle html
public class ClienteView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//para inyectar a la bd
	@Inject
	private ClienteService clienteService;//objeto 
	
	//lista de clientes
	private List<Cliente> clientes;
	
	
	//cargar la lista de los clientes
	@PostConstruct// se ejecuta antes de la inyeccion, se carga antes que todo
	public void init() {
		this.loadClientes();
	}
	
	
	public void loadClientes() {
		
		
		try {
			this.clientes = clienteService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());//para obtener mensaje del error
		}
	}

//generar los getters
	public ClienteService getClienteService() {
		return clienteService;
	}


	public List<Cliente> getClientes() {
		return clientes;
	}
	
	
	
	
}
