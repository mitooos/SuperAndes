package persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Producto;

public class SQLProducto {

	private final static String SQL = SuperAndesPersistence.SQL;
	
	private SuperAndesPersistence sap;
	
	public SQLProducto(SuperAndesPersistence sap) {
		this.sap = sap;
	}
	
	public long adicionarProducto(PersistenceManager pm,Long id0, String nombre0, Integer tamano0, String unidades0, String marca0, Integer precioUnitario0, Integer volEmpaque0,Integer pesoEmpaque0, String hexa0, String presentacion0, Integer precioporUnidad0, String categoria0, int prom, int activa, String descripcion0) {
		Query q = pm.newQuery(SQL,"INSERT INTO "+ sap.darTablaProductos() + " (id, nombre, tamano, unidades, marca, precio_unitario, "
				+ "vol_empaque, peso_empaque, hexa, presentacion, precio_por_unidad, categoria, es_promocion, activa, descripcion)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		q.setParameters(id0, nombre0, tamano0, unidades0, marca0, precioUnitario0, volEmpaque0, pesoEmpaque0, hexa0, presentacion0, precioporUnidad0, categoria0, prom, activa, descripcion0);
		return (long) q.executeUnique();
	}
	
	public long adicionarPromocion(PersistenceManager pm,Long id0, String nombre0, Integer tamano0, String unidades0, String marca0, Integer precioUnitario0, Integer volEmpaque0,Integer pesoEmpaque0, String hexa0, String presentacion0, Integer precioporUnidad0, String categoria0, int prom, int activa, String descripcion0) {
		Query q = pm.newQuery(SQL,"INSERT INTO "+ sap.darTablaProductos() + " (id, nombre, tamano, unidades, marca, precio_unitario, "
				+ "vol_empaque, peso_empaque, hexa, presentacion, precio_por_unidad, categoria, es_promocion, activa, descripcion)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		q.setParameters(id0, nombre0, tamano0, unidades0, marca0, precioUnitario0, volEmpaque0, pesoEmpaque0, hexa0, presentacion0, precioporUnidad0, categoria0, prom, activa, descripcion0);
		return (long) q.executeUnique();
	}
	
	public long terminarPromocion(PersistenceManager pm, Long idPromocion) {
		Query q = pm.newQuery(SQL, "UPDATE " + sap.darTablaProductos() + " SET activa = 0  WHERE id = ? AND es_promocion = 1");
		q.setParameters(idPromocion);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @param valorMenor
	 * @param valorMayor
	 * @param i 0: igual, i:1 rango, 2:menor, 3:mayor, -1 ninguna
	 * @return
	 */
	public List<BigDecimal> productosQueCumplenCaracteristicaString(PersistenceManager pm,String caracteristica, String valorMenor, String valorMayor, int i, Long id){
		String sql = "SELECT id FROM " + sap.darTablaProductos() + " WHERE ";
		if(caracteristica.equals("PROVEEDOR")) {
			sql += " id in (SELECT id_producto FROM " + sap.darTablaProveedorProducto() + " WHERE id_proveedor = " + id.toString() + ")";
		}
		if(caracteristica.equals("SUCURSAL")) {
			sql += "id in (SELECT id_producto FROM " + sap.darTablaSucursalProducto() + " WHERE id_sucursal = " + id.toString() + ")";
		}
		if(caracteristica.equals("BODEGA")) {
			sql += "id in (SELECT id_producto FROM " + sap.darTablaBodegaProducto() + " WHERE id_bodega = " + id.toString() + ")"; 
		}
		if(caracteristica.equals("ESTANTE")) {
			sql += "id in (SELECT id_producto FROM " + sap.darTablaEstanteProducto() + " WHERE id_estante = " + id.toString() + ")";
		}
		if(caracteristica.equals("ORDEN_DE_COMPRA")) {
			sql += "id in (SELECT id_producto FROM " + sap.darTablaOrdenDeCompraProducto() + " WHERE id_orden_de_compra = " + id.toString() + ")";
		}
		if(caracteristica.equals("COMPRA")) {
			sql += "id in (SELECT id_producto FROM " + sap.darTablaProdcutoCompra() + "WHERE id_compra = " + id.toString() + ")";
		}
		if( i == 0) {
			sql += caracteristica + " = " + valorMenor;
		}
		if(i == 1) {
			sql += caracteristica + " > " + valorMenor.toString() + " AND " + caracteristica + " < " + valorMayor.toString();
		}
		if(i == 2) {
			sql += caracteristica + " < " + valorMenor.toString(); 
		}
		if(i == 3) {
			sql += caracteristica + " > " + valorMenor.toString(); 
		}
		System.out.println(sql);
		Query q = pm.newQuery(SQL, sql);
		return  (List<BigDecimal>) q.execute();
	}
	
	public List<Producto> darofertasPopulares(PersistenceManager pm )
	{
		String sql1 ="SELECT *";
		sql1 += "FROM "+ sap.darTablaProductos();
		sql1 += "JOIN " + sap.darTablaProdcutoCompra() + "ON ID = ID_PRODUCTO";
		sql1 += "WHERE ES_PROMOCION = 1 ";
		
		String sql ="SELECT COUNT(ID) CANTIDAD, ID";
		sql += "FROM ("+ sql1 +")";
		sql += "WHERE ROWNUM <=20";
		sql += " GROUP BY ID ";
		Query q =pm.newQuery(SQL, sql);
		return q.executeList();
	}
		
	public Producto obtenerProductoPorId(PersistenceManager pm, Long id) {
		Query q = pm.newQuery(SQL, 	"SELECT * FROM " + sap.darTablaProductos() + " WHERE ID = ?");
		q.setParameters(id);
		q.setResultClass(Producto.class);
		return (Producto) q.executeUnique();
	}
	
}
