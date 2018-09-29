package negocio;

public class Estante_Producto {

	
	private Long idPrducto;

	private Long idEstante;

	private Integer cantidad;
	
	/**
	 * constructor por defecto
	 */
	public Estante_Producto(){
		this.idPrducto = 0L;
		this.idEstante = 0L;
		this.cantidad = 0;
	}
	
	/**
	 * Constructor con valores
	 * @param idProducto0
	 * @param idEstante0
	 * @param cantidad0
	 */
	public Estante_Producto(Long idProducto0, Long idEstante0, Integer cantidad0) {
		this.idPrducto = idProducto0;
		this.idEstante = idEstante0;
		this.cantidad = cantidad0;
	}
	
	
	public Long getIdPrducto() {
		return idPrducto;
	}

	public void setIdPrducto(Long idPrducto) {
		this.idPrducto = idPrducto;
	}
	
	public Long getIdEstante() {
		return idEstante;
	}

	public void setIdEstante(Long idEstante) {
		this.idEstante = idEstante;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
