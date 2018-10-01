package negocio;

public class Producto {
	
	private Long id;
	
	private String nombre;
	
	private Integer tamano;
	
	private String unidades;
	
	private String marca;
	
	private Integer precioUnitario;
	
	private Integer volEmpaque;
	
	private Integer pesoEmpaque;
	
	private Integer hexa;
	
	private String presentacion;
	
	private Integer precioPorUnidad;
	
	private String categoria;
	
	private boolean esPromocion;

	private boolean activa;
	
	private String descripcion;
	
	
	/**
	 * Constructor por defecto
	 */
	public Producto() {
		
		this.id = 0L;
		this.nombre = "";
		this.tamano = 0;
		this.unidades = "";
		this.marca = "";
		this.precioUnitario = 0;
		this.volEmpaque = 0;
		this.pesoEmpaque = 0;
		this.hexa = 0x0;
		this.presentacion = "";
		this.precioPorUnidad = 0;
		this.categoria = "";
		this.esPromocion = false;
		this.activa = false;
		this.descripcion = "";
		
	}
	
	/**
	 * construcor con valores
	 */
	public Producto(Long id0, String nombre0, Integer tamano0, String unidades0, String marca0, Integer precioUnitario0, Integer volEmpaque0,Integer pesoEmpaque0, Integer hexa0, String presentacion0, Integer precioporUnidad0, String categoria0, boolean esPromocion0, boolean activa0, String descripcion0) {
		
		this.id = id0;
		this.nombre = nombre0;
		this.tamano = tamano0;
		this.unidades = unidades0;
		this.marca = marca0;
		this.precioUnitario = precioUnitario0;
		this.volEmpaque = volEmpaque0;
		this.pesoEmpaque = pesoEmpaque0;
		this.hexa = hexa0;
		this.presentacion = presentacion0;
		this.precioPorUnidad = precioporUnidad0;
		this.categoria = categoria0;
		this.esPromocion = esPromocion0;
		this.activa = activa0;
		this.descripcion = descripcion0;
	}
	
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTamano() {
		return tamano;
	}

	public void setTamano(Integer tamano) {
		this.tamano = tamano;
	}

	public String getUnidades() {
		return unidades;
	}

	public void setUnidades(String unidades) {
		this.unidades = unidades;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Integer precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Integer getVolEmpaque() {
		return volEmpaque;
	}

	public void setVolEmpaque(Integer volEmpaque) {
		this.volEmpaque = volEmpaque;
	}

	public Integer getPesoEmpaque() {
		return pesoEmpaque;
	}

	public void setPesoEmpaque(Integer pesoEmpaque) {
		this.pesoEmpaque = pesoEmpaque;
	}

	public Integer getHexa() {
		return hexa;
	}

	public void setHexa(Integer hexa) {
		this.hexa = hexa;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public Integer getPrecioPorUnidad() {
		return precioPorUnidad;
	}

	public void setPrecioPorUnidad(Integer precioPorUnidad) {
		this.precioPorUnidad = precioPorUnidad;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	public boolean isEsPromocion() {
		return esPromocion;
	}

	public void setEsPromocion(boolean esPromocion) {
		this.esPromocion = esPromocion;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




}
