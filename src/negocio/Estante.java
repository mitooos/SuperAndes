package negocio;

public class Estante extends Almacenamiento{

	private Integer posicion;

	private Integer nivelAbastecimiento;
	
	public Estante() {
		super();
		this.posicion = 0;
		this.nivelAbastecimiento = 0;
	}
	
	/**
	 * Construcor con valores
	 * @param id0
	 * @param capacidadVol0
	 * @param capacidadPeso0
	 * @param categoria0
	 * @param posicion0
	 * @param nivelabastecimiento0
	 */
	public Estante(Long id0, Integer capacidadVol0, Integer capacidadPeso0, String categoria0,Long idSucursal0, Integer posicion0, Integer nivelabastecimiento0) {
		super(id0, capacidadVol0, capacidadPeso0, categoria0, idSucursal0);
		this.posicion = posicion0;
		this.nivelAbastecimiento = nivelabastecimiento0;
	}
	
	
	public Integer getPosicion() {
		return posicion;
	}

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}

	public Integer getNivelAbastecimiento() {
		return nivelAbastecimiento;
	}

	public void setNivelAbastecimiento(Integer nivelAbastecimiento) {
		this.nivelAbastecimiento = nivelAbastecimiento;
	}
}
