package persistencia;

import java.math.BigDecimal;
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
	
	public long agregarCompra(PersistenceManager pm, long id, Integer precioTotal, int pagada, long idCliente, long idSucursal) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + sap.darTablaCompra() + "(id, precio_total, pagada,fecha, id_cliente, id_sucursal) "
				+ " values (?,?,?,(SELECT SYSDATE FROM DUAL),?,?)");
		q.setParameters(id,precioTotal,pagada, idCliente, idSucursal);
		return (long) q.executeUnique();
	}
	
	public Integer calcularPrecioCompra(PersistenceManager pm, Long idsProducto, Integer cantidad, Long idSede) {
		Query q1 = pm.newQuery(SQL, "SELECT precio FROM " + sap.darTablaPromociones() + " WHERE ID = (SELECT IDPROMOCION FROM " +sap.darTablaPromocionProducto() + " WHERE IDPRODUCTO = ?) AND (SELECT SYSDATE FROM DUAL) <= FECHAFINAL AND (SELECT SYSDATE FROM DUAL) >= FACHAINICIO");
		Query q = pm.newQuery(SQL,"SELECT precio FROM " + sap.darTablaSucursalProducto() + " WHERE id_producto = ? AND id_sucursal = ?");
		q1.setParameters(idsProducto);
		q1.setResultClass(Integer.class);
		Integer precio = (Integer) q1.executeUnique();
		if(precio==null) {
			q.setParameters(idsProducto, idSede);
			q.setResultClass(Integer.class);
			precio = (Integer) q.executeUnique();
		}
			
			System.out.println("El costo total de la compra es: " + precio*cantidad + "$");
			return precio * cantidad;
	}
	
	public long actualizarEstantesDespuesDeCompra(PersistenceManager pm, Long idProducto, Integer cantidad, Long idSucursal) {

			Query q = pm.newQuery(SQL, "UPDATE " + sap.darTablaEstanteProducto() + " SET cantidad = cantidad - ? WHERE id_producto = ? AND "
					+ " id_estante IN (SELECT id FROM " + sap.darTablaEstante() + " WHERE id_sucursal = ?)");
			q.setParameters(cantidad, idProducto, idSucursal);
			return (long)q.executeUnique();
	}
	
	public VentasSucursalTotales darVentasTotalesPorSucursalEnUnPeriodoDeTiempo(PersistenceManager pm,BigDecimal idSucursal, String fechaInicial, String fechaFinal) {
		Query q = pm.newQuery(SQL, "SELECT id_sucursal, SUM(PRECIO_TOTAL) AS total FROM COMPRA WHERE id_sucursal = ? AND FECHA  BETWEEN ? AND ? GROUP BY id_sucursal");
		q.setParameters(idSucursal,fechaInicial, fechaFinal);
		q.setResultClass(VentasSucursalTotales.class);
		return (VentasSucursalTotales) q.executeUnique();
	}
	
	public List<BigDecimal> darIdsSucursalesDondeHuboVentas(PersistenceManager pm){
		Query q = pm.newQuery(SQL, "SELECT UNIQUE ID_SUCURSAL FROM COMPRA ");
		return q.executeList();
	}
	
	public Long pagarCompra(PersistenceManager pm,Long idCompra, Integer precio) {
		Query q = pm.newQuery(SQL,"ALTER " + sap.darTablaCompra() + " SET PRECIO_TOTAL = ? AND PAGADA = 1 WHERE ID = ?");
		q.setParameters(precio,idCompra);
		return (Long) q.executeUnique();
	}
	
	
}
