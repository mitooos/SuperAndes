package negocio;

public class Almacenamiento {
	
	private Long id;
	
	private Integer capacidadVol;
	
	private Integer capacidadPeso;
	
	private String categoria;
	
	private Long idSucursal;
	

	/**
	 * constructor por defecto
	 */
	public Almacenamiento() {
		this.id = 0L;
		this.capacidadVol = 0;
		this.capacidadPeso = 0;
		this.categoria = "";
		this.idSucursal = 0L;
	}
	
	/**
	 * Constructor con valores
	 */
	public Almacenamiento(Long id0, Integer capacidadVol0, Integer capacidadPeso0, String categoria0, Long idSucursal0) {
		this.id = id0;
		this.capacidadVol = capacidadVol0;
		this.capacidadPeso = capacidadPeso0;
		this.categoria = categoria0;
		this.idSucursal = idSucursal0;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCapacidadVol() {
		return capacidadVol;
	}

	public void setCapacidadVol(Integer capacidadVol) {
		this.capacidadVol = capacidadVol;
	}

	public Integer getCapacidadPeso() {
		return capacidadPeso;
	}

	public void setCapacidadPeso(Integer capacidadPeso) {
		this.capacidadPeso = capacidadPeso;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public Long getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(Long idSucursal) {
		this.idSucursal = idSucursal;
	}



}
