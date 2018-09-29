package negocio;

public class Compra {
	
	private Long id;
	
	private Integer precioTotal;
	
	private boolean pagada;
	
	private Long idCliente;
	


	/**
	 * constructor por defecto
	 */
	public Compra() {
		this.id = 0L;
		this.precioTotal = 0;
		this.pagada = false;
		this.idCliente = 0L;
	}
	
	/**
	 * constructor con valores
	 * @param id0
	 * @param precioTotal0
	 * @param pagada0
	 */
	public Compra(Long id0, Integer precioTotal0, boolean pagada0, Long idCliente0) {
		this.id = id0;
		this.precioTotal = precioTotal0;
		this.pagada = pagada0;
		this.idCliente = idCliente0;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Integer precioTotal) {
		this.precioTotal = precioTotal;
	}

	public boolean isPagada() {
		return pagada;
	}

	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}
	
	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

}
