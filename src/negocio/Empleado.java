package negocio;

public class Empleado {

private Long id;
	
	private String tipoIdentificacion;
	
	private String nombre;

	private Long identificacion;
	
	private String correo;
	
	private String direccion;
	
	private Long idSucursal;
	
	/**
	 * Constructor por defecto
	 */
	public Empleado() {
		this.id = 0L;
		this.tipoIdentificacion = "";
		this.identificacion = 0L;
		this.nombre = "";
		this.correo = "";
		this.direccion = "";
		this.idSucursal = 0L;
	}
	
	/**
	 * constructor con valores
	 * @param id0
	 * @param tipoIdentificacion0
	 * @param identificacion0
	 * @param correo0
	 * @param direccion0
	 */
	public Empleado(Long id0, String tipoIdentificacion0, Long identificacion0,String nombre0, String correo0, String direccion0, Long idSucursal0) {
		this.id = id0;
		this.tipoIdentificacion = tipoIdentificacion0;
		this.identificacion = identificacion0;
		this.nombre = 
		this.correo = correo0;
		this.direccion = direccion0;
		this.idSucursal = idSucursal0;
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

	public Long getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(Long idSucursal) {
		this.idSucursal = idSucursal;
	}



}
