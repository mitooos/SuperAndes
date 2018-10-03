package persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLEstante {

private final static String SQL = SuperAndesPersistence.SQL;
	
	private SuperAndesPersistence sap;
	
	public SQLEstante(SuperAndesPersistence sap) {
		this.sap = sap;
	}
	
	public long adicionarEstante(PersistenceManager pm,Long id, Integer capacidadVol, Integer capacidadPeso, String categoria, Integer posicion, Integer nivelAbastecimiento, Long idSucursal) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + sap.darTablaEstante() + " (id,capacidad_vol,capacidad_peso,categoria, posicion, nivel_abastecimiento,id_sucursal) values(?,?,?,?,?)");
		q.setParameters(id, capacidadVol, capacidadPeso, categoria,posicion,nivelAbastecimiento, idSucursal);
		return (long) q.executeUnique();	
	}
}