package persistencia;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.OrdenDeCompra;

public class SQLOrdenDeCompra {
	
	private final static String SQL =SuperAndesPersistence.SQL;
	
	private SuperAndesPersistence sap;
	
	public SQLOrdenDeCompra(SuperAndesPersistence sap)
	{
		this.sap=sap;
	}
	
	public Long crearOrden(PersistenceManager pm, Long id0, String fechaEstimadaEntrega0, int entregado0, Integer calificacion0, String fechaEntregado0, Long idProveedor0, Long idSucursal0)
	{
		Query q = pm.newQuery(SQL ,"INSERT INTO "+ sap.darTablaOrdenDeCompra() + "(id, fecha_Estimada_Entrega, entregado, calificacion, fecha_Entrega, id_Proveedor,id_sucursal)"
				  +" values (?,?,?,?,?,?,?)");
		q.setParameters(id0,fechaEstimadaEntrega0,entregado0,calificacion0,fechaEntregado0,idProveedor0, idSucursal0);
		return (Long) q.executeUnique();
	}
	
	public OrdenDeCompra darOrdenPorId(PersistenceManager pm, long id0)
	{
		Query q= pm.newQuery(SQL, "SELECT * FROM "+ sap.darTablaOrdenDeCompra()+ " WHERE id= ?");
		q.setResultClass(OrdenDeCompra.class);
		q.setParameters(id0);
		return (OrdenDeCompra) q.executeUnique();
	}
	
	public OrdenDeCompra darOrdenSinEntregarProveedor(PersistenceManager pm, long idProveedor0)
	{
		Query q= pm.newQuery(SQL, "SELECT * FROM "+ sap.darTablaOrdenDeCompra()+ " WHERE id_Proveedor= ? AND entregado = 0");
		q.setResultClass(OrdenDeCompra.class);
		q.setParameters(idProveedor0);
		return (OrdenDeCompra) q.executeUnique();
	}
	
	
	
	
	public long registrarLLegadaOrden(PersistenceManager pm ,Long id, Integer calificacion)
	{
		String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

		Query q = pm.newQuery(SQL, "UPDATE "+ sap.darTablaOrdenDeCompra()+ " SET entregado = 1, calificacion = ?,  fecha_entrega= ? WHERE id=?");
		q.setParameters(calificacion,date, id);
		return (long) q.executeUnique();
	}
	
	
	
	public long actualizarInventarioDespuesDeOrden(PersistenceManager pm, Long idProducto, Integer cantidad, Long idSucursal)
	{
		Query q= pm.newQuery(SQL, "UPDATE " + sap.darTablaBodegaProducto() + " SET cantidad = cantidad + ? WHERE id_producto = ? AND "
				 + " id_Bodega IN (SELECT id FROM "+ sap.darTablaBodega() +" WHERE id_sucursal = ?)");
		q.setParameters(cantidad, idProducto ,idSucursal);
		return (long) q.executeUnique();
	}
	
	public List<OrdenDeCompra> darOrdenesALosProveedores(PersistenceManager pm){
		Query q = pm.newQuery(SQL, "SELECT * FROM " + sap.darTablaOrdenDeCompra() + " WHERE ENTREGADO = 1 ORDER BY ID_PROVEEDOR");
		q.setResultClass(OrdenDeCompra.class);
		return q.executeList();
	}
	
	public List<BigDecimal> darProductosEnOrdenCompra(PersistenceManager pm, Long idOrden){
		Query q = pm.newQuery(SQL, "SELECT ID_PRODUCTO FROM " + sap.darTablaOrdenDeCompraProducto() + " WHERE ID_ORDEN_DE_COMPRA = ?");
		q.setParameters(idOrden);
		return q.executeList();
	}

}

