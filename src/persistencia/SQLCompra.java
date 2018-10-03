package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.VentasSucursalTotales;

public class SQLCompra {

	private final static String SQL = SuperAndesPersistence.SQL;
	
	private SuperAndesPersistence sap;
	
	public SQLCompra(SuperAndesPersistence sap) {
		this.sap = sap;
	}
	
	public long agregarCompra(PersistenceManager pm, long id, Integer precioTotal, int pagada,String fecha, long idCliente, long idSucursal) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + sap.darTablaCompra() + "(id, precio_total, pagada,fecha, id_cliente, id_sucursal) "
				+ " values (?,?,?,TO_DATE(?,'DD/MM/YY'),?,?)");
		q.setParameters(id,precioTotal,pagada,fecha, idCliente, idSucursal);
		return (long) q.executeUnique();
	}
	
	public Integer calcularPrecioCompra(PersistenceManager pm, Long idsProducto, Integer cantidad, Long idSede) {
		System.out.println(sap.darTablaSucursalProducto());	
		Query q = pm.newQuery(SQL,"SELECT precio FROM " + sap.darTablaSucursalProducto() + " WHERE id_producto = ? AND id_sucursal = ?");
			q.setParameters(idsProducto, idSede);
			q.setResultClass(Integer.class);
			Integer precio = (Integer) q.executeUnique();
			System.out.println("El costo total de la compra es: " + precio*cantidad + "$");
			return precio * cantidad;
	}
	
	public long actualizarInventariosDespuesDeCompra(PersistenceManager pm, Long idProducto, Integer cantidad, Long idSucursal) {

			Query q = pm.newQuery(SQL, "UPDATE " + sap.darTablaEstanteProducto() + " SET cantidad = cantidad - ? WHERE id_producto = ? AND "
					+ " id_estante IN (SELECT id FROM " + sap.darTablaEstante() + " WHERE id_sucursal = ?)");
			q.setParameters(cantidad, idProducto, idSucursal);
			return (long)q.executeUnique();

	}
	
	public List<VentasSucursalTotales> darVentasTotalesPorSucursalEnUnPeriodoDeTiempo(PersistenceManager pm,Long idSucursal, String fechaInicial, String fechaFinal) {
		Query q = pm.newQuery(SQL, "SELECT id_sucursal SUM(PRECIO_TOTAL) AS total FROM COMPRA WHERE id_sucursal = ? AND FECHA  BETWEEN ? AND ? GROUP BY ID_SUCURSAL");
		q.setParameters(idSucursal,fechaInicial, fechaFinal);
		q.setResultClass(VentasSucursalTotales.class);
		return (List<VentasSucursalTotales>) q.executeResultUnique();
	}
}
