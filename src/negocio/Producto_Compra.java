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
}
