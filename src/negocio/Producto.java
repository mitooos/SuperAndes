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
	}

	/**
	 * construcor con valores
	 */
	public Producto(Long id, String nombre, Integer tamano, String unidades, String marca, Integer precio_unitario, Integer vol_empaque,Integer peso_empaque, Integer hexa, String presentacion, Integer precio_por_unidad, String categoria, int esPromocion, int activa, String descripcion) {

		this.id = id;
		this.nombre = nombre;
		this.tamano = tamano;
		this.unidades = unidades;
		this.marca = marca;
		this.precioUnitario = precio_unitario;
		this.volEmpaque = vol_empaque;
		this.pesoEmpaque = peso_empaque;
		this.hexa = hexa;
		this.presentacion = presentacion;
		this.precioPorUnidad = precio_por_unidad;
		this.categoria = categoria;

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

	public Integer getPrecio_Unitario() {
		return precioUnitario;
	}

	public void setPrecio_Unitario(Integer precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public void setPRECIO_UNITARIO(Integer precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Integer getVolEmpaque() {
		return volEmpaque;
	}

	public void setVOL_EMPAQUE(Integer volEmpaque) {
		this.volEmpaque = volEmpaque;
	}

	public Integer getPesoEmpaque() {
		return pesoEmpaque;
	}

	public void setPESO_EMPAQUE(Integer pesoEmpaque) {
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

	public void setPRECIO_POR_UNIDAD(Integer precioPorUnidad) {
		this.precioPorUnidad = precioPorUnidad;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


}
