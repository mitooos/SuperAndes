package negocio;

public class Promocion_Producto {
	
	private Long idPromocion;
	
	private Long idProducto;
	
	public Promocion_Producto() {
		this.idProducto = 0L;
		this.idPromocion = 0L;
	}
	
	public Promocion_Producto(Long idPromocion0, Long idProducto0) {
		this.idPromocion = idPromocion0;
		this.idProducto = idProducto0;
	}

	public Long getIdPromocion() {
		return idPromocion;
	}

	public void setIdPromocion(Long idPromocion) {
		this.idPromocion = idPromocion;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	
	
}
