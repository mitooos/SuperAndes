package negocio;

public class Sucursal {

	private Long id;
	
	private String nombre;

	private String ciudad;
	
	private String direccion;
	
	private String segmentoMercado;
	
	/**
	 * Constructor por defecto
	 */
	public Sucursal() {
		this.id=0L;
		this.nombre="";
		this.ciudad="";
		this.direccion="";
		this.segmentoMercado="";
	}
	
	/**
	 * Constructor con valores
	 */
	public Sucursal(Long id0, String nombre0, String ciudad0, String direccion0, String segmentoMercado0) {
		
		this.id = id0;
		this.nombre = nombre0;
		this.ciudad = ciudad0;
		this.direccion = direccion0;
		this.segmentoMercado = segmentoMercado0;
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getSegmentoMercado() {
		return segmentoMercado;
	}

	public void setSegmentoMercado(String segmentoMercado) {
		this.segmentoMercado = segmentoMercado;
	}



} 
