package negocio;

public class Proveedor {
	
	private Long nit;

	private String nombre;
	
	private Integer calificacion;
	
	/**
	 * constructor por defecto
	 */
	public Proveedor() {
		this.nit = 0L;
		this.nombre = "";
		this.calificacion = 0;
	}
	
	/**
	 * Constructor con valores
	 * @param nit0
	 * @param nombre0
	 * @param calificacion0
	 */
	public Proveedor(Long nit0, String nombre0, Integer calificacion0) {
		this.nit = nit0;
		this.nombre = nombre0;
		this.calificacion = calificacion0;
	}
	
	
	public Long getNit() {
		return nit;
	}

	public void setNit(Long nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}
	
	@Override
	public String toString() {
		return "Nit: "+ this.nit + ", Nombre: " + this.nombre;
	}

}
