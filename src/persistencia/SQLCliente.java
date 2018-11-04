package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Cliente;

public class SQLCliente {

	private final static String SQL = SuperAndesPersistence.SQL;
	
	private SuperAndesPersistence sap;
	
	public SQLCliente(SuperAndesPersistence sap) {
		this.sap = sap;
	}
	
	public long adicionarCliente(PersistenceManager pm, Long id, Long identificacion, String nombre, String correo, String direccion) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + sap.darTablaCliente() + " (id,identificacion,nombre,correo,direccion) values (?,?,?,?,?)");
		q.setParameters(id, identificacion,nombre, correo, direccion);
		return (long) q.executeUnique();
	}
	
	public List<Long> darIdsDeClientesFrecuentes(PersistenceManager pm , Long idSucursal, Integer i){
		Query q = pm.newQuery(SQL, "SELECT ID_CLIENTE as id" + 
				" FROM(SELECT ID_CLIENTE, COUNT(ID_CLIENTE) as CUNT" + 
				" FROM COMPRA" + 
				" WHERE FECHA <= LAST_DAY(ADD_MONTHS(sysdate,-?)) AND FECHA > LAST_DAY(ADD_MONTHS(sysdate,-(1+?))) AND ID_SUCURSAL = ?" + 
				" GROUP BY ID_CLIENTE" + 
				" ORDER BY ID_CLIENTE)" + 
				" WHERE CUNT >=2");
		q.setParameters(i,i,idSucursal);
		q.setResultClass(Long.class);
		return q.executeList();
	}
	
	public Cliente darCliente(PersistenceManager pm,Long id) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + sap.darTablaCliente() + " WHERE ID = ?");
		q.setResultClass(Cliente.class);
		q.setParameters(id);
		return (Cliente) q.executeUnique();
	}
}
