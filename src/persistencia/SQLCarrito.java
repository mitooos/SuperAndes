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
	
	public long adicionarCarrito(PersistenceManager pm, Long id, Long idCliente, Long idSucursal) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + sap.darTablaCarritos() + " (id,idCliente,idSucursal) values (?,?,?)");
		q.setParameters(id, idCliente, idSucursal);
		return (long) q.executeUnique();
	}
	
	public long registrarProductoEnCarro(PersistenceManager pm, Long idCarrito, Long idProducto, int cantidad) {
		Query q = pm.newQuery(SQL,"INSERT INTO " + sap.darTablaCarritoProductos() + " (idCarrito, idProducto, cantidad) values (?,?,?)");
		q.setParameters(idCarrito, idProducto, cantidad);
		return (long) q.executeUnique();
	}
	
	public long actualizarEstantesDespuesDeCarro(PersistenceManager pm, Long idProducto, Integer cantidad, Long idSucursal) {

		Query q = pm.newQuery(SQL, "UPDATE " + sap.darTablaEstanteProducto() + " SET cantidad = cantidad - ? WHERE id_producto = ? AND "
				+ " id_estante IN (SELECT id FROM " + sap.darTablaEstante() + " WHERE id_sucursal = ?)");
		q.setParameters(cantidad, idProducto, idSucursal);
		return (long)q.executeUnique();
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
	
	public Long eliminarCliente(PersistenceManager pm, Long idCarrito) {
		Query q = pm.newQuery(SQL, "UPDATE " + sap.darTablaCarritos() + " SET IDCLIENTE = NULL WHERE ID = ?");
		q.setParameters(idCarrito);
		return (Long) q.executeUnique();
	}
	
	public Long darSede(PersistenceManager pm, Long idCarrito) {
		Query q = pm.newQuery(SQL, "SELECT IDSUCURSAL FROM " + sap.darTablaCarritos() + "WHERE ID = ?");
		q.setParameters(idCarrito);
		q.setResultClass(Long.class);
		return (Long) q.executeResultUnique();
	}

}
