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
	
	
	public  Integer  darIndiceOcupacion(PersistenceManager pm,Long idSucursal, Long idBodega)
	{	
		String sql2 ="SELECT SUM(PRODUCTO.PESO_EMPAQUE) AS PESOACTUAL ,BODEGA_PRODUCTO.ID_BODEGA AS ID";
		sql2 += " FROM "+ sap.darTablaBodegaProducto();
		sql2 += " JOIN " + sap.darTablaProductos() + "ON ID = ID_PRODUCTO";
		sql2 += " GROUP BY ID_BODEGA";
		
		
		String sql1 ="SELECT F.PESOACTUAL/BODEGA.CAPACIDAD_PESO AS INDICE, BODEGA.ID AS ID";
		sql1 += " FROM (" + sql2 + ")f";
		sql1 += " JOIN " + sap.darTablaBodega();
		sql1 += " ON ID = ID";
		sql1 += " WHERE ID_SUCURSAL = ? AND ID = ?";
		Query q = pm.newQuery(SQL, sql1);
		q.setParameters(idSucursal,idBodega);
		return (Integer) q.executeUnique();
	}
	
}
