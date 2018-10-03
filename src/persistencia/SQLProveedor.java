package persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLProveedor {

	private final static String SQL = SuperAndesPersistence.SQL;
	
	private SuperAndesPersistence sap;
	
	public SQLProveedor(SuperAndesPersistence sap) {
		this.sap = sap;
	}
	
	public long adicionarProveedor(PersistenceManager pm,Long nit, String nombre, int calificacion) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + sap.darTablaProveedores() + " (nit,nombre,calificacion) values(?,?,?)");
		q.setParameters(nit, nombre, calificacion);
		return (long) q.executeUnique();	
	}
}
