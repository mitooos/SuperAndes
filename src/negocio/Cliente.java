package negocio;

public class Cliente {
	
	private Long id;
	
	private String tipoIdentificacion;
	
	private String nombre;

	private Long identificacion;
	
	private String correo;
	
	private String direccion;
	
	/**
	 * Constructor por defecto
	 */
	public Cliente() {
		this.id = 0L;
		this.tipoIdentificacion = "";
		this.identificacion = 0L;
		this.nombre = "";
		this.correo = "";
		this.direccion = "";
	}
	
	/**
	 * constructor con valores
	 * @param id0
	 * @param tipoIdentificacion0
	 * @param identificacion0
	 * @param correo0
	 * @param direccion0
	 */
	public Cliente(Long id0, String tipoIdentificacion0, Long identificacion0,String nombre0, String correo0, String direccion0) {
		this.id = id0;
		this.tipoIdentificacion = tipoIdentificacion0;
		this.identificacion = identificacion0;
		this.nombre = 
		this.correo = correo0;
		this.direccion = direccion0;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public Long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


}
