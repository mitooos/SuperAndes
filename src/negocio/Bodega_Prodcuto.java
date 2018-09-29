package negocio;

public class Bodega_Prodcuto {
	
	private Long idPrducto;

	private Long idBodega;
	
	private Integer cantidad;
	
	/**
	 * constructor por defecto
	 */
	public Bodega_Prodcuto(){
		this.idPrducto = 0L;
		this.idBodega = 0L;
		this.cantidad = 0;
	}
	
	/**
	 * Constructor con valores
	 * @param idProducto0
	 * @param idBodega0
	 * @param cantidad0
	 */
	public Bodega_Prodcuto(Long idProducto0, Long idBodega0, Integer cantidad0) {
		this.idPrducto = idProducto0;
		this.idBodega = idBodega0;
		this.cantidad = cantidad0;
	}
	
	
	public Long getIdPrducto() {
		return idPrducto;
	}

	public void setIdPrducto(Long idPrducto) {
		this.idPrducto = idPrducto;
	}

	public Long getIdBodega() {
		return idBodega;
	}

	public void setIdBodega(Long idBodega) {
		this.idBodega = idBodega;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
