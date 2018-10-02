package persistencia;


import java.util.LinkedList;
import java.util.List;
import java.util.Properties;


import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import negocio.Producto;

public class SuperAndesPersistence {

	public final static String SQL = "javax.jdo.query.SQL";
//	private static Logger log = Logger.getLogger(SuperAndesPersistence.class.getName());

	private static SuperAndesPersistence instance;
	private PersistenceManagerFactory pmf;
	private List<String> tablas;
	private SQLUtil sqlUtil;
	private SQLProducto sqlProducto;


	public SuperAndesPersistence() {
		Properties properties = new Properties();
		properties.setProperty("javax.jdo.PersistenceManagerFactoryClass", "org.datanucleus.api.jdo.JDOPersistenceManagerFactory");
		properties.setProperty("javax.jdo.option.ConnectionDriverName", "oracle.jdbc.driver.OracleDriver");
		properties.setProperty("javax.jdo.option.ConnectionURL","jdbc:oracle:thin:@fn3.oracle.virtual.uniandes.edu.co:1521:prod");
		properties.setProperty("javax.jdo.option.ConnectionUserName","ISIS2304C171820");
		properties.setProperty("javax.jdo.option.ConnectionPassword","PrVvggcFFg");
		properties.setProperty("javax.jdo.option.Mapping", "oracle");
		properties.setProperty("datanucleus.schema.autoCreateAll", "false");
		properties.setProperty("datanucleus.query.sql.allowAll", "true");
		pmf = JDOHelper.getPersistenceManagerFactory(properties);
		crearClaesSQL();

		tablas = new LinkedList<>();
		tablas.add("SUPER_ANDES_SEQUENCE");
		tablas.add("BODEGA_PRODUCTO");
		tablas.add("BODEGA");
		tablas.add("CLIENTE");
		tablas.add("COMPRA");
		tablas.add("COMPRA");
		tablas.add("ESTANTE_PRODUCTO");
		tablas.add("ESTANTE");
		tablas.add("FACTURA");
		tablas.add("ORDEN_DE_COMPRA_PRODUCTO");
		tablas.add("ORDEN_DE_COMPRA");
		tablas.add("PRODUCTO_COMPRA");
		tablas.add("PRODUCTOS");
		tablas.add("PROVEEDOR_PRODUCTO");
		tablas.add("PROVEEDOR");
		tablas.add("SUCURSAL_PRODUCTO");
		tablas.add("SUCURSAL");
	}

	public static SuperAndesPersistence getInstance() {
		if(instance == null) {
			instance = new SuperAndesPersistence();
		}
		return instance;
	}

	public void cerrarUnidadPersistencia() {
		pmf.close();
		instance = null;
	}

	private void crearClaesSQL() {

		sqlUtil = new SQLUtil(this);
		sqlProducto = new SQLProducto(this);
	}

	public String darSeq()
	{
		return tablas.get(0);
	}

	public String darTablaProductos() {
		return tablas.get(12);
	}

	private Long nextval() {
		return sqlUtil.nextval(pmf.getPersistenceManager());
	}

	private String darDetalleException(Exception e) {
		if(e.getClass().getName().equals("javax.jdo.JDODataStoreException")) {
			JDODataStoreException je = (JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return "";
	}

	public Producto adicionarPromocionLong (String nombre0, Integer tamano0, String unidades0, String marca0, Integer precioUnitario0, Integer volEmpaque0,Integer pesoEmpaque0, Integer hexa0, String presentacion0, Integer precioporUnidad0, String categoria0, String descripcion0) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Long id = nextval();
			int prom = 1;
			int activa = 1;
			String hex = hexa0.toString();
			sqlProducto.adicionarPromocion(pmf.getPersistenceManager(), id, nombre0, tamano0, unidades0, marca0, precioUnitario0, volEmpaque0, pesoEmpaque0, hex, presentacion0, precioporUnidad0, categoria0, prom, activa, descripcion0);
			tx.commit();

			Producto rta = new Producto(id, nombre0, tamano0, unidades0, marca0, precioUnitario0, volEmpaque0, pesoEmpaque0, hexa0, presentacion0, precioporUnidad0, categoria0, true, true, descripcion0);
			System.out.println(rta + "dfg");
			return rta;
		}
		catch(Exception e) {
			System.out.println("Exception: " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

}
