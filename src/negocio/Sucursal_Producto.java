package negocio;

public class Sucursal_Producto {
	
	private Long idSucursal;
	
	private Long idProducto;
	
	private Integer precio;
	
	private Integer nivelReorden;
	
	
	/**
	 * constructor por defecto
	 */
	public Sucursal_Producto() {
		this.idSucursal = 0L;
		this.idProducto = 0L;
		this.precio = 0;
		this.nivelReorden = 0;
	}
	
	/**
	 * Constructor con valores
	 * @param idSucursal0
	 * @param idProdcuto0
	 * @param precio0
	 * @param nivelReorden0
	 */
	public Sucursal_Producto(Long idSucursal0,Long idProdcuto0, Integer precio0, Integer nivelReorden0) {
		this.idSucursal = idSucursal0;
		this.idProducto = idProdcuto0;
		this.precio = precio0;
		this.nivelReorden = nivelReorden0;
	}
	
	public Long getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(Long idSucursal) {
		this.idSucursal = idSucursal;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getNivelReorden() {
		return nivelReorden;
	}

	public void setNivelReorden(Integer nivelReorden) {
		this.nivelReorden = nivelReorden;
	}


}
