package persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLSucursal 
{
	private final static String SQL = SuperAndesPersistence.SQL;
	
	private SuperAndesPersistence sap;
	
	public SQLSucursal(SuperAndesPersistence sap) {
		this.sap = sap;
	}
	
	public long adicionarSucursal(PersistenceManager pm,Long id, String nombre, String ciudad, String direccion, String mercado) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + sap.darTablaSucursal() + " (id,nombre,ciudad,direccion,segmento_mercado) values(?,?,?,?,?)");
		q.setParameters(id, nombre, ciudad, direccion, mercado);
		return (long) q.executeUnique();	
	}
}
