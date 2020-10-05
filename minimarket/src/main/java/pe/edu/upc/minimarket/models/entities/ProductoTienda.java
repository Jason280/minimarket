package pe.edu.upc.minimarket.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto_tiendas")
@IdClass(ProductoTiendaId.class)
public class ProductoTienda {
	
	@Id
	@ManyToOne
	@JoinColumn(name="producto_id")
	private Producto producto;
	
	@Id
	@ManyToOne
	@JoinColumn(name="tienda_id")
	private Tienda tienda;
	
	@Column(name="stock", nullable=false)
	private Integer stock;
	
	@Column(name="costo", nullable=false)
	private Float costo;

}
