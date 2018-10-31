package negocio;

public class Carrito_Producto {

	private Long idCarrito;
	
	private Long idProducto;
	
	public Carrito_Producto() {
		this.idCarrito = 0L;
		this.idProducto = 0L;
	}
	
	public Carrito_Producto(Long idCarrito0, Long idProducto0) {
		this.idCarrito = idCarrito0;
		this.idProducto = idProducto0;
	}
	
	public Long getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(Long idCarrito) {
		this.idCarrito = idCarrito;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	
	
}
