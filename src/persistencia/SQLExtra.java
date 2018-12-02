package persistencia;

import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Producto;
import negocio.Proveedor;
import negocio.RFC12;

public class SQLExtra {
	
private final static String SQL = SuperAndesPersistence.SQL;
	
	private SuperAndesPersistence sap;
	
	public SQLExtra(SuperAndesPersistence sap) {
		this.sap = sap;
	}
	
	public Producto darProductoMenosSolicitadoPorSemana(PersistenceManager pm, Date fechaInic, Date fechaFin) {
		Query q = pm.newQuery(SQL, "SELECT *  FROM PRODUCTOS WHERE ID=(SELECT ID_PRODUCTO FROM (SELECT  MIN(CONT) AS MIN, ID_PRODUCTO, ROW_NUMBER() OVER (ORDER BY MIN(CONT)) AS RN FROM (SELECT ID_PRODUCTO, SUM(CANTIDAD) AS CONT FROM PRODUCTO_COMPRA WHERE ID_COMPRA IN (SELECT ID FROM COMPRA WHERE FECHA >= ? AND FECHA <= ?) GROUP BY ID_PRODUCTO)GROUP BY ID_PRODUCTO) WHERE RN = 1)");
		q.setParameters(fechaInic, fechaFin);
		q.setResultClass(Producto.class);
		return (Producto) q.executeUnique();
	}
	
public Producto darProductoMasSolicitadoPorSemana(PersistenceManager pm, Date fechaInic, Date fechaFin) {
	Query q = pm.newQuery(SQL, "SELECT *  FROM PRODUCTOS WHERE ID=(SELECT ID_PRODUCTO FROM (SELECT  MAX(CONT) AS MIN, ID_PRODUCTO, ROW_NUMBER() OVER (ORDER BY MIN(CONT) DESC) AS RN FROM (SELECT ID_PRODUCTO, SUM(CANTIDAD) AS CONT FROM PRODUCTO_COMPRA WHERE ID_COMPRA IN (SELECT ID FROM COMPRA WHERE FECHA >= ? AND FECHA <= ?) GROUP BY ID_PRODUCTO)GROUP BY ID_PRODUCTO) WHERE RN = 1)");
	q.setParameters(fechaInic, fechaFin);
	q.setResultClass(Producto.class);
	return (Producto) q.executeUnique();
	
}

public Proveedor darProveedorMenosSolicitado(PersistenceManager pm, Date fechaInic, Date fechaFin) {
	Query q = pm.newQuery(SQL, "SELECT PROVEEDOR.* FROM PROVEEDOR ,(SELECT ID_PROVEEDOR, SUM (VOL), ROW_NUMBER() OVER (ORDER BY SUM(VOL)) AS RN FROM ORDEN_DE_COMPRA oc ,(SELECT SUM(VOLUMEN) AS VOL, ID_ORDEN_DE_COMPRA FROM ORDEN_DE_COMPRA_PRODUCTO GROUP BY ID_ORDEN_DE_COMPRA) t WHERE OC.ID = t.ID_ORDEN_DE_COMPRA AND oc.FECHA_ENTREGA >= ? AND oc.FECHA_ENTREGA <= ? GROUP BY oc.ID_PROVEEDOR) x WHERE x.RN = 1 AND PROVEEDOR.NIT = x.ID_PROVEEDOR");
	q.setParameters(fechaInic, fechaFin);
	q.setResultClass(Proveedor.class);
	return (Proveedor) q.executeUnique();
}

public Proveedor darProveedorMasSolicitado(PersistenceManager pm, Date fechaInic, Date fechaFin) {
	Query q = pm.newQuery(SQL, "SELECT PROVEEDOR.* FROM PROVEEDOR ,(SELECT ID_PROVEEDOR, SUM (VOL), ROW_NUMBER() OVER (ORDER BY SUM(VOL) DESC) AS RN FROM ORDEN_DE_COMPRA oc ,(SELECT SUM(VOLUMEN) AS VOL, ID_ORDEN_DE_COMPRA FROM ORDEN_DE_COMPRA_PRODUCTO GROUP BY ID_ORDEN_DE_COMPRA) t WHERE OC.ID = t.ID_ORDEN_DE_COMPRA AND oc.FECHA_ENTREGA >= '01/01/2018' AND oc.FECHA_ENTREGA <= '31/12/2018' GROUP BY oc.ID_PROVEEDOR) x WHERE x.RN = 1 AND PROVEEDOR.NIT = x.ID_PROVEEDOR");
	q.setParameters(fechaInic, fechaFin);
	q.setResultClass(Proveedor.class);
	return (Proveedor) q.executeUnique();
}
	
	

}
