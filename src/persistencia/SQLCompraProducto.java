package persistencia;

import java.util.LinkedList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLCompraProducto {

	private final static String SQL = SuperAndesPersistence.SQL;
	
	private SuperAndesPersistence sap;
	
	public SQLCompraProducto(SuperAndesPersistence sap) {
		this.sap = sap;
	}
	
	public long registrarProdcutoEnCompra(PersistenceManager pm, Long idCompra, Long idProducto, int cantidad) {
		Query q = pm.newQuery(SQL,"INSERT INTO " + sap.darTablaProdcutoCompra() + " (id_compra, id_producto, cantidad) values (?,?,?)");
		q.setParameters(idCompra, idProducto, cantidad);
		return (long) q.executeUnique();
	}
	
//	public List<Long> darProductosCompra(PersistenceManager pm, Long idCompra) {
//		Query q = pm.newQuery(SQL, "SELECT producto_id FROM " + sap.darTablaProdcutoCompra() + "WHERE id_compra = ?");
//		q.setParameters(idCompra);
//		q.setResultClass(long.class);
//		return (List<Long>) q.execute();
//	}
//	
//	public List<Integer> darCantidadProductosCompra(PersistenceManager pm, Long idCompra, List<Long> idProductos){
//		LinkedList<Integer> rta = new LinkedList<>();
//		int i = 0;
//		while(i<idProductos.size()) {
//			Query q = pm.newQuery(SQL, "SELECT cantidad FROM " + sap.darTablaProdcutoCompra() + "WHERE id_compra = ? AND id_prducto = ?");
//			q.setParameters(idCompra, idProductos.get(i));
//			q.setResultClass(Integer.class);
//			rta.add((Integer) q.executeUnique());
//			i++;
//		}
//		return rta;
//	}
	
	
}
