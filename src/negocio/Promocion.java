package negocio;

public class Promocion extends Producto {

	
	private String descripcion;
	
	/**
	 * Constructor por defecto
	 */
	public Promocion(){
		super();
		this.descripcion = "";
	}
	
	/**
	 * constructor con valores
	 */
	public Promocion(Long id0, String nombre0, Integer tamano0, String unidades0, String marca0, Integer precioUnitario0, Integer volEmpaque0,Integer pesoEmpaque0, Integer hexa0, String presentacion0, Integer precioporUnidad0, String categoria0, String descripcion0) {
		super(id0,nombre0,tamano0,unidades0,marca0,precioUnitario0,volEmpaque0,pesoEmpaque0,hexa0,presentacion0,precioporUnidad0,categoria0);
		this.descripcion = descripcion0;
	}
	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	
}
