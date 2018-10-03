package persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLEstante {

private final static String SQL = SuperAndesPersistence.SQL;
	
	private SuperAndesPersistence sap;
	
	public SQLEstante(SuperAndesPersistence sap) {
		this.sap = sap;
	}
	
	public long adicionarEstante(PersistenceManager pm,Long id, Integer capacidadVol, Integer capacidadPeso, String categoria, Integer posicion, Integer nivelAbastecimiento, Long idSucursal) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + sap.darTablaEstante() + " (id,capacidad_vol,capacidad_peso,categoria, posicion, nivel_abastecimiento,id_sucursal) values(?,?,?,?,?,?,?)");
		q.setParameters(id, capacidadVol, capacidadPeso, categoria,posicion,nivelAbastecimiento, idSucursal);
		return (long) q.executeUnique();	
	}
	
	
	public  Integer  darIndiceOcupacion(PersistenceManager pm)
	{	
		String sql2 ="SELECT SUM(PESO_EMPAQUE) AS PESOACTUAL ,ID_BODEGA AS ID1";
		sql2 += " FROM "+ sap.darTablaEstanteProducto();
		sql2 += " JOIN " + sap.darTablaProductos() + "ON ID = ID_PRODUCTO";
		sql2 += " GROUP BY ID_ESTANTE";
		
		
		String sql1 ="SELECT PESOACTUAL/CAPACIDAD_PESO AS INDICE, ID AS ID";
		sql1 += " FROM (" + sql2 + ")f";
		sql1 += " JOIN " + sap.darTablaEstante();
		sql1 += " ON ID = ID";
		Query q = pm.newQuery(SQL, sql1);
		return (Integer) q.executeUnique();
	}
}