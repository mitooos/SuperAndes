package negocio;

public class Carrito {
	
	private Long id;
	
	private Long idSucursal;
	
	private Long idCliente;
	

	public Carrito() {
		this.id = 0L;
		this.idCliente = 0L;
		this.idSucursal = 0L;
	}
	
	public Carrito(Long id0,Long idSucursal0, Long idCliente0) {
		this.id = id0;
		this.idCliente = idCliente0;
		this.idSucursal = idSucursal0;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(Long idSucursal) {
		this.idSucursal = idSucursal;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
	

}
