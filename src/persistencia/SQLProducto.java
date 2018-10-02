package persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLProducto {

	private final static String SQL = SuperAndesPersistence.SQL;
	
	private SuperAndesPersistence sap;
	
	public SQLProducto(SuperAndesPersistence sap) {
		this.sap = sap;
	}
	
	public long adicionarPromocion(PersistenceManager pm,Long id0, String nombre0, Integer tamano0, String unidades0, String marca0, Integer precioUnitario0, Integer volEmpaque0,Integer pesoEmpaque0, String hexa0, String presentacion0, Integer precioporUnidad0, String categoria0, int prom, int activa, String descripcion0) {
		Query q = pm.newQuery("INSERT INTO "+ sap.darTablaProductos() + "(id, nombre, tamano, unidades, marca, precio_unitario, "
				+ "vol_empaque, peso_empaque, hexa, presentacion, precio_por_unidad, categoria, es_promocion, activa, descripcion)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
		q.setParameters(id0, nombre0, tamano0, unidades0, marca0, precioUnitario0, volEmpaque0, pesoEmpaque0, hexa0, presentacion0, precioporUnidad0, categoria0, prom, activa, descripcion0);
		return (long) q.executeUnique();
	}
}
