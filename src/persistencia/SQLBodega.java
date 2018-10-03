package persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLBodega 
{

private final static String SQL = SuperAndesPersistence.SQL;
	
	private SuperAndesPersistence sap;
	
	public SQLBodega(SuperAndesPersistence sap) {
		this.sap = sap;
	}
	
	public long adicionarBodega(PersistenceManager pm,Long id, Integer capacidadVol, Integer capacidadPeso, String categoria, Long idSucursal) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + sap.darTablaBodega() + " (id,capacidad_vol,capacidad_peso,categoria,id_sucursal) values(?,?,?,?,?)");
		q.setParameters(id, capacidadVol, capacidadPeso, categoria, idSucursal);
		return (long) q.executeUnique();	
	}
}
