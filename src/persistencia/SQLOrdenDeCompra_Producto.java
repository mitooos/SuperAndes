package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.OrdenDeCompra_Producto;
import oracle.net.aso.t;

public class SQLOrdenDeCompra_Producto {

	private final static String SQL =SuperAndesPersistence.SQL;

	private SuperAndesPersistence sap;

	public SQLOrdenDeCompra_Producto(SuperAndesPersistence sap)
	{
		this.sap=sap;
	}

	public Long crearOrdenProducto(PersistenceManager pm,Long idOrdenCompra0, Long idProducto0,Integer precioAcordado0, Integer volumen0)
	{
		Query q= pm.newQuery(SQL, "INSERT INTO " +sap.darTablaOrdenDeCompraProducto() + "(id_Orden_De_Compra, id_Producto, precio_Acordado, volumen)"
				+" values(?,?,?,?)");
		q.setParameters(idOrdenCompra0,idProducto0,precioAcordado0,volumen0);
		return (long) q.executeUnique();
	}
	
	
	public OrdenDeCompra_Producto darOrdenesDeCompraProductos(PersistenceManager pm,  Long idOrdenCompra)
	{
		Query q = pm.newQuery(SQL,"SELECT * FROM " + sap.darTablaOrdenDeCompraProducto() + " WHERE id_orden_de_compra = ?");
		q.setParameters(idOrdenCompra);
		q.setResultClass(OrdenDeCompra_Producto.class);
		return (OrdenDeCompra_Producto) q.executeUnique();
		
	}
}
