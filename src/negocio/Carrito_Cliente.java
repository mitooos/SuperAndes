package negocio;

public class Carrito_Cliente {

	private Long idCarrito;
	
	private Long idCliente;
	
	public Carrito_Cliente() {
		this.idCarrito = 0L;
		this.idCliente = 0L;
	}
	
	public Carrito_Cliente(Long idCarrrito0, Long idCliente0) {
		this.idCarrito = idCarrrito0;
		this.idCliente = idCliente0;
	}

	public Long getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(Long idCarrito) {
		this.idCarrito = idCarrito;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
	
}
