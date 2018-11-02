package negocio;

public class Promocion {
	
	private Long id;
	
	private String descripcion;
	
	private String fechaInicio;
	
	private String fechaFinal;
	
	private Integer precio;
	
	public Promocion() {
		this.id = 0L;
		this.descripcion = "";
		this.fechaInicio = "";
		this.fechaFinal = "";
		this.precio = 0;
	}
	
	public Promocion(Long id0, String descripcion0, String fechaInicion0, String fechaFinal0, Integer precio0) {
		this.id = id0;
		this.descripcion = descripcion0;
		this.fechaInicio = fechaInicion0;
		this.fechaFinal = fechaFinal0;
		this.precio = precio0;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	
	

}
