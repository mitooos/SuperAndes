package negocio;

public class Producto_Compra {

	private Long idCompra;
	
	private Long idProducto;
	
	private Integer cantidad;
	
	/**
	 * constructor por defecto
	 */
	public Producto_Compra() {
		this.idCompra = 0L;
		this.idProducto = 0L;
		this.cantidad = 0;
	}
	
	/**
	 * constructor con valores
	 * @param idCompra0
	 * @param idProducto0
	 * @param cantidad0
	 */
	public Producto_Compra(Long idCompra0, Long idProducto0, Integer cantidad0) {
		this.idCompra = idCompra0;
		this.idProducto = idProducto0;
		this.cantidad = cantidad0;
	}
	
	public Long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
