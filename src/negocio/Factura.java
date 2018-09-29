package negocio;

public class Factura {
	
	private Long numeroDeSerie;
	
	private String fecha;
	
	private Long idCompra;
	
	/**
	 * constructor por defecto
	 */
	public Factura() {
		this.numeroDeSerie = 0L;
		this.fecha = "";
		this.idCompra = 0L;
	}
	
	/**
	 * Constructor con valores
	 * @param numeroSerie0
	 * @param fecha0
	 * @param idCompra0
	 */
	public Factura(Long numeroSerie0, String fecha0, Long idCompra0) {
		this.numeroDeSerie = numeroSerie0;
		this.fecha = fecha0;
		this.idCompra = idCompra0;
	}
	
	public Long getNumeroDeSerie() {
		return numeroDeSerie;
	}

	public void setNumeroDeSerie(Long numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}

}
