package persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLCliente {

	private final static String SQL = SuperAndesPersistence.SQL;
	
	private SuperAndesPersistence sap;
	
	public SQLCliente(SuperAndesPersistence sap) {
		this.sap = sap;
	}
	
	public long adicionarCliente(PersistenceManager pm, Long id, Long identificacion, String nombre, String correo, String direccion) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + sap.darTablaCliente() + " (id, tipo_identificacion,identificacion,nombre,correo,direccion) values (?,?,?,?,?)");
		q.setParameters(id, identificacion,nombre, correo, direccion);
		return (long) q.executeUnique();
	}
}
