package negocio;

public class Proveedor_Producto {

	private Long idProveedor;

	private Long idProdcuto;
	
	/**
	 * constructor por defecto
	 */
	public Proveedor_Producto() {
		this.idProveedor = 0L;
		this.idProdcuto = 0L;
	}
	
	/**
	 * constructor con valores
	 * @param idProveedor0
	 * @param idProducto0
	 */
	public Proveedor_Producto(Long idProveedor0, Long idProducto0) {
		this.idProveedor = idProveedor0;
		this.idProdcuto = idProducto0;
	}
	
	
	public Long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	public Long getIdProdcuto() {
		return idProdcuto;
	}

	public void setIdProdcuto(Long idProdcuto) {
		this.idProdcuto = idProdcuto;
	}

}
