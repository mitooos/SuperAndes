package negocio;

public class Bodega extends Almacenamiento{

	/**
	 * constructor por defecto
	 */
	public Bodega() {
		super();
	}
	
	/**
	 * consructor con valores
	 * @param id0
	 * @param capacidadVol0
	 * @param capacidadPeso0
	 * @param categoria0
	 */
	public Bodega(Long id0, Integer capacidadVol0, Integer capacidadPeso0, String categoria0,Long idSucursal0) {
		super(id0, capacidadVol0, capacidadPeso0, categoria0, idSucursal0);
	}
	
}
