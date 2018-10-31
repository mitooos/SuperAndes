package negocio;

public class Promocion {
	
	private Long id;
	
	private String descripcion;
	
	public Promocion() {
		this.id = 0L;
		this.descripcion = "";
	}
	
	public Promocion(Long id0, String descripcion0) {
		this.id = id0;
		this.descripcion = descripcion0;
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
	
	

}
