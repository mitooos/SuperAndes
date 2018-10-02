package persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLOrdenDeCompra {
	
	private final static String SQL =SuperAndesPersistence.SQL;
	
	private SuperAndesPersistence sap;
	
	public SQLOrdenDeCompra(SuperAndesPersistence sap)
	{
		this.sap=sap;
	}
	
	public long crearOrden(PersistenceManager pm, Long id0, String fechaEstimadaEntrega0, boolean entregado0, Integer calificacion0, String fechaEntregado0, Long idProveedor0)
	{
		Query q = pm.newQuery(SQL ,"INSERT INTO "+ sap.darTablaOrdenDeCompra() + "(id, fecha_Estimada_Entrega, entregado, calificacion, fecha_Entregado, id_Proveedor"
				  +" values (?,?,?,?,?,?)");
		q.setParameters(id0,fechaEstimadaEntrega0,entregado0,calificacion0,fechaEntregado0,idProveedor0);
		return (long) q.executeUnique();
	}
	
	public long registrarCompra()
	{
		return 0;
		
	}
}
