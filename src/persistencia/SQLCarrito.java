package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLCarrito {
	
	private final static String SQL = SuperAndesPersistence.SQL;
	
	private SuperAndesPersistence sap;
	
	public SQLCarrito(SuperAndesPersistence sap) {
		this.sap = sap;
	}
	
	public List<Long> darProductosEnCarrito(PersistenceManager pm, long idCarrito) {
		Query q = pm.newQuery(SQL, "SELECT IDPRODUCTO FROM " + sap.darTablaCarritoProductos() + " WHERE IDCARRITO = ?");
		q.setParameters(idCarrito);
		return q.executeList();
	}
	
	public List<Integer> darCantidadesEnCarrito(PersistenceManager pm, long idCarrito){
		Query q = pm.newQuery(SQL,"SELECT CANTIDAD FROM " + sap.darTablaCarritoProductos() + " WHERE IDCARRITO = ?");
		q.setParameters(idCarrito);
		return q.executeList();
	}
	
	public Integer darCantidadProductoEnCarrito(PersistenceManager pm, long idCarrito, long idProdcuto) {
		Query q = pm.newQuery(SQL, "SELECT CANTIDAD FROM " + sap.darTablaCarritoProductos() + " WHERE IDCARRITO = ? AND IDPRODUCTO = ?");
		q.setParameters(idCarrito, idProdcuto);
		return (Integer) q.executeResultUnique();
	}
	
	public long retirarProductosDeCarritos(PersistenceManager pm, long idCarrito, long idProducto) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + sap.darTablaCarritoProductos() + " WHERE IDCARRITO = ? AND IDPRODUCTO = ?");
		q.setParameters(idCarrito, idProducto);
		return (long) q.execute();
	}

}
