package negocio;

public class OrdenDeCompra_Producto {
	
	private Long idOrdenCompra;	

	private Long idProcducto;
	
	private Integer precioAcordado;
	
	private Integer volumen;
	
	/** 
	 * constructor por defecto
	 */
	public OrdenDeCompra_Producto() {
		this.idOrdenCompra = 0L;
		this.idProcducto = 0L;
		this.precioAcordado = 0;
		this.volumen = 0;
	}
	
	/**
	 * construcor con valores
	 * @param idOrdenCompra0
	 * @param idProdcuto0
	 * @param precioAcordado0
	 * @param volumen0
	 */
	public OrdenDeCompra_Producto(Long idOrdenCompra0, Long idProdcuto0, Integer precioAcordado0, Integer volumen0) {
		this.idOrdenCompra = idOrdenCompra0;
		this.idProcducto = idProdcuto0;
		this.precioAcordado = precioAcordado0;
		this.volumen = volumen0;
	}
	
	public Long getIdOrdenCompra() {
		return idOrdenCompra;
	}

	public void setIdOrdenCompra(Long idOrdenCompra) {
		this.idOrdenCompra = idOrdenCompra;
	}

	public Long getIdProcducto() {
		return idProcducto;
	}

	public void setIdProcducto(Long idProcducto) {
		this.idProcducto = idProcducto;
	}

	public Integer getPrecioAcordado() {
		return precioAcordado;
	}

	public void setPrecioAcordado(Integer precioAcordado) {
		this.precioAcordado = precioAcordado;
	}

	public Integer getVolumen() {
		return volumen;
	}

	public void setVolumen(Integer volumen) {
		this.volumen = volumen;
	}

}
