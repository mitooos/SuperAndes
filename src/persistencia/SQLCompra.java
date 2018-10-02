package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLCompra {

	private final static String SQL = SuperAndesPersistence.SQL;
	
	private SuperAndesPersistence sap;
	
	public SQLCompra(SuperAndesPersistence sap) {
		this.sap = sap;
	}
	
	public long agregarCompra(PersistenceManager pm, long id, Integer precioTotal, int pagada, long idCliente, long idSucursal) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + sap.darTablaCompra() + "(id, precio_total, pagada, id_cliente, id_sucursal) "
				+ " values (?,?,?,?,?)");
		q.setParameters(id,precioTotal,pagada, idCliente, idSucursal);
		return (long) q.executeUnique();
	}
	
	public Integer calcularPrecioCompra(PersistenceManager pm, List<Long> idsProductos, List<Integer> cantidades, Long idSede) {
		Integer rta = 0;
		int i = 0;
		while(i<idsProductos.size()) {
			Query q = pm.newQuery(SQL,"SELCT precio FROM " + sap.darTablaSucursalProducto() + "WHERE id_producto = ? AND id_sucursal = ?");
			q.setParameters(idsProductos.get(i), idSede);
			q.setResultClass(Integer.class);
			Integer precio = (Integer) q.executeUnique();
			Integer precioTot = precio * cantidades.get(i);
			rta += precioTot;
			i++;
		}
		return rta;
	}
	
	public long actualizarInventariosDespuesDeCompra(PersistenceManager pm, List<Long> idProductos, List<Integer> cantiddaes, Long idSucursal) {
		long rta = 0L;
		int i = 0;
		while(i<idProductos.size()) {
			Query q = pm.newQuery(SQL, "UPDATE " + sap.darTablaEstanteProducto() + " SET cantidad = cantidad - ? WHERE id_prodcuto = ? AND "
					+ " id_estante = (SELECT id FROM " + sap.darTablaEstante() + " WHERE id_sucursal = ?)");
			q.setParameters(cantiddaes.get(i), idProductos.get(i), idSucursal);
			rta += (long)q.executeUnique();
			i++;
		}
		return rta;
	}
}
