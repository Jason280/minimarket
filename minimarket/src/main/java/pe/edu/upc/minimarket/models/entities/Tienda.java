package pe.edu.upc.minimarket.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tiendas")

public class Tienda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nombre", length=15, nullable=false)
	private String nombre;
	
	@Column(name="direccion", length=25, nullable=false)
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name = "distrito_id")
	private Distrito distrito;
	
	@OneToMany(mappedBy = "tienda")
	private List<ProductoTienda> productoTiendas;
	
	@OneToMany(mappedBy = "tienda")
	private List<Pedido> pedidos;
	
	public Tienda() {
		
		productoTiendas = new ArrayList<ProductoTienda>();
		pedidos = new ArrayList<Pedido>();
	}

}
