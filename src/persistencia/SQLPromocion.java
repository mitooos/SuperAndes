package persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLPromocion {
	
	private final static String SQL = SuperAndesPersistence.SQL;
	
	private SuperAndesPersistence sap;
	
	public SQLPromocion(SuperAndesPersistence sap) {
		this.sap = sap;
	}
	
	public Long agregarPromcocion(PersistenceManager pm, Long id, String descripcion,String fechaInicio, String fechaFinal, Integer precio) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + sap.darTablaPromociones() +  " VALUES(?,?,TO_DATE(?,'DD/MM/YYYY'),TO_DATE(?,'DD/MM/YYYY'),?)");
		q.setParameters(id,descripcion, fechaInicio, fechaFinal, precio);
		return (long)q.executeUnique();
	}
	
	public Long agregarProductoAPromocion(PersistenceManager pm, Long idPromo, Long idProducto) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + sap.darTablaPromocionProducto() + " VALUES (?,?)");
		q.setParameters(idPromo, idProducto);
		return (long)q.executeUnique();
	}
	
	public Long finalizarPromocion(PersistenceManager pm, Long idPromo, String fechaFin) {
		Query q = pm.newQuery(SQL, "UPDATE " + sap.darTablaPromociones() + " SET FECHAFINAL = TO_DATE(?,'DD/MM/YYYY') WHERE ID = ?");
		q.setParameters(fechaFin , idPromo);
		return (long) q.executeUnique();
	}

}
