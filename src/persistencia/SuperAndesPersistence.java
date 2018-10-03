package persistencia;


import java.util.LinkedList;
import java.util.List;
import java.util.Properties;


import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import negocio.Bodega;
import negocio.Cliente;
import negocio.Compra;
import negocio.Estante;
import negocio.OrdenDeCompra;
import negocio.OrdenDeCompra_Producto;
import negocio.Producto;
import negocio.Proveedor;
import negocio.Sucursal;

public class SuperAndesPersistence {

	public final static String SQL = "javax.jdo.query.SQL";
	//	private static Logger log = Logger.getLogger(SuperAndesPersistence.class.getName());

	private static SuperAndesPersistence instance;
	private PersistenceManagerFactory pmf;
	private List<String> tablas;
	private SQLUtil sqlUtil;
	private SQLCompraProducto sqlCompraProducto;
	private SQLProducto sqlProducto;
	private SQLOrdenDeCompra sqlOrdenDeCompra;
	private SQLOrdenDeCompra_Producto sqlOrdenDeCompraProducto;
	private SQLCompra sqlCompra;
	private SQLProveedor sqlProveedor;
	private SQLCliente sqlCliente;
	private SQLSucursal sqlSucursal;
	private SQLBodega sqlBodega;
	private SQLEstante sqlEstante;


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
		sqlCompraProducto = new SQLCompraProducto(this);
		sqlCompra = new SQLCompra(this);
		sqlOrdenDeCompra= new SQLOrdenDeCompra(this);
		sqlProveedor = new SQLProveedor(this);
		sqlOrdenDeCompra = new SQLOrdenDeCompra(this);
		sqlOrdenDeCompraProducto = new SQLOrdenDeCompra_Producto(this);
		sqlCliente = new SQLCliente(this);
		sqlSucursal = new SQLSucursal(this);
		sqlBodega = new SQLBodega(this);
		sqlEstante = new SQLEstante(this);
	}

	public String darSeq()
	{
		return tablas.get(0);
	}
	public String darTablaBodegaProducto()
	{
		return tablas.get(1);	
	}
	public String darTablaBodega()
	{
		return tablas.get(2);	
	}
	public String darTablaCliente() {
		return tablas.get(3);
	}
	public String darTablaCompra() {
		return tablas.get(4);
	}

	public String darTablaEstanteProducto() {
		return tablas.get(5);
	}

	public String darTablaEstante() {
		return tablas.get(6);
	}
	public String darTablaFactura() {
		return tablas.get(7);
	}
	public String darTablaOrdenDeCompraProducto()
	{
		return tablas.get(8);	
	}
	public String darTablaOrdenDeCompra()
	{
		return tablas.get(9);	
	}
	public String darTablaProdcutoCompra() {
		return tablas.get(10);
	}
	public String darTablaProductos() {
		return tablas.get(11);
	}
	public String darTablaProveedorProducto() {
		return tablas.get(12);
	}
	public String darTablaProveedores() {
		return tablas.get(13);
	}
	public String darTablaSucursalProducto(){
		return tablas.get(14);
	}
	public String darTablaSucursal() {
		return tablas.get(15);
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



	public Proveedor adicionarProveedor(Long nit, String nombre, Integer calificacion) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			sqlProveedor.adicionarProveedor(pmf.getPersistenceManager(),nit, nombre, calificacion);
			return new Proveedor(nit, nombre, calificacion);
		}
		catch(Exception e){
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

	public Producto adicionarProducto(String nombre0, Integer tamano0, String unidades0, String marca0, Integer precioUnitario0, Integer volEmpaque0,Integer pesoEmpaque0, Integer hexa0, String presentacion0, Integer precioporUnidad0, String categoria0, String descripcion0, int prom, int activa) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Long id = nextval();
			String hex = hexa0.toString();
			sqlProducto.adicionarPromocion(pmf.getPersistenceManager(), id, nombre0, tamano0, unidades0, marca0, precioUnitario0, volEmpaque0, pesoEmpaque0, hex, presentacion0, precioporUnidad0, categoria0, prom, activa, descripcion0);
			tx.commit();

			return new Producto(id, nombre0, tamano0, unidades0, marca0, precioUnitario0, volEmpaque0, pesoEmpaque0, hexa0, presentacion0, precioporUnidad0, categoria0, true, true, descripcion0);

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

	public Cliente adicionarCliente(String tipoIdentificacion,Long identificacion, String nombre, String correo, String direccion) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Long id = nextval();
			sqlCliente.adicionarCliente(pmf.getPersistenceManager(), id, tipoIdentificacion,identificacion, nombre, correo, direccion);
			return new Cliente(id, tipoIdentificacion,identificacion, nombre, correo, direccion);
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

	public Sucursal adicionarSucursal(String nombre, String ciudad, String direccion, String mercado)
	{
		PersistenceManager pm =pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try
		{
			tx.begin();
			Long id = nextval();
			sqlSucursal.adicionarSucursal(pmf.getPersistenceManager(), id, nombre, ciudad, direccion, mercado);
			return new Sucursal(id,nombre,ciudad,direccion,mercado);
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

	public Bodega adicionarBodega(Integer capacidadVol, Integer capacidadPeso, String categoria, Long idSucursal)
	{
		PersistenceManager pm =pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try
		{
			tx.begin();
			Long id = nextval();
			sqlBodega.adicionarBodega(pmf.getPersistenceManager(), id, capacidadVol, capacidadPeso, categoria, idSucursal);
			return new Bodega(id, capacidadVol, capacidadPeso, categoria, idSucursal);
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
	
	public Estante adicionarEstante(Integer capacidadVol, Integer capacidadPeso, String categoria, Integer posicion, Integer nivelAbastecimiento, Long idSucursal)
	{
		PersistenceManager pm =pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try
		{
			tx.begin();
			Long id = nextval();
			sqlEstante.adicionarEstante(pmf.getPersistenceManager(), id, capacidadVol, capacidadPeso, categoria, posicion, nivelAbastecimiento, idSucursal);
			return new Estante(id, capacidadVol, capacidadPeso, categoria, idSucursal, nivelAbastecimiento, posicion);
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

			return new Producto(id, nombre0, tamano0, unidades0, marca0, precioUnitario0, volEmpaque0, pesoEmpaque0, hexa0, presentacion0, precioporUnidad0, categoria0, true, true, descripcion0);

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

	public int finalizarPromocion(Long idPromocion) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			sqlProducto.terminarPromocion(pmf.getPersistenceManager(), idPromocion);
			tx.commit();
			return 1;
		}
		catch(Exception e) {
			System.out.println("Exception: " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}




	public Compra agregarCompra(long idCliente, long idSucursal, Long idProducto, Integer cantidadProducto) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			Long id = nextval();
			Integer costo = sqlCompra.calcularPrecioCompra(pmf.getPersistenceManager(), idProducto, cantidadProducto, idSucursal);
			sqlCompra.agregarCompra(pmf.getPersistenceManager(), id, costo, 1, idCliente, idSucursal);
			sqlCompraProducto.registrarProdcutoEnCompra(pmf.getPersistenceManager(), id, idProducto, cantidadProducto);

			sqlCompra.actualizarInventariosDespuesDeCompra(pmf.getPersistenceManager(), idProducto, cantidadProducto, idSucursal);
			return new Compra(id, costo, true, idCliente, idSucursal);

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
	
	public List<Producto> darMejoresPromociones()
	{
		PersistenceManager pm =pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			return sqlProducto.darofertasPopulares(pmf.getPersistenceManager());
		}
		catch(Exception e){
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
	
//	public Integer darIndiceEstante(Long idSucursal, Long idEstante)
//	{
//		PersistenceManager pm =pmf.getPersistenceManager();
//		Transaction tx = pm.currentTransaction();
//		try {
//			return sqlEstante.darIndiceOcupacion(pmf.getPersistenceManager(), idSucursal, idEstante);
//		}
//		catch(Exception e){
//			System.out.println("Exception: " + e.getMessage() + "\n" + darDetalleException(e));
//			return null;
//		}
//		finally {
//			if(tx.isActive()) {
//				tx.rollback();
//			}
//			pm.close();
//		}
//	}
//	
	public Integer darIndiceOcupacion(Long idSucursal,Long idBodega ,Long idEstante)
	{
		PersistenceManager pm =pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Integer resultado = 0;
		try {
			resultado = sqlBodega.darIndiceOcupacion(pmf.getPersistenceManager(), idSucursal, idBodega) + sqlEstante.darIndiceOcupacion(pmf.getPersistenceManager(), idSucursal, idEstante);
			return resultado;
		}
		catch(Exception e){
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
	
	public List<Producto> darProductoQueCumpleCaracteristica(String caracteristica, String valorMenor, String valorMayor, int i, Long id){
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			return sqlProducto.productosQueCumplenCaracteristicaString(pmf.getPersistenceManager(), caracteristica, valorMenor, valorMayor, i, id);
		}
		catch(Exception e){
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


	public OrdenDeCompra_Producto agregarOrdenProducto(long idProveedor,String fechaEstimadaEntrega, Long idProducto,Integer volumen ,Integer precioAcordado ,Long idSucursal)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try
		{
			Long id =nextval();
			OrdenDeCompra temporal = sqlOrdenDeCompra.darOrdenSinEntregarProveedor(pmf.getPersistenceManager(), idProveedor);
			if(temporal == null)
			{
				temporal = sqlOrdenDeCompra.crearOrden(pmf.getPersistenceManager(), id, fechaEstimadaEntrega, false , 0, "", idProveedor,idSucursal);
			}

			return sqlOrdenDeCompraProducto.crearOrdenProducto(pmf.getPersistenceManager(), temporal.getId(), idProducto, precioAcordado, volumen);
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

	public OrdenDeCompra recibirOrden(long id ,Integer calificacion)
	{
		PersistenceManager pm =pmf.getPersistenceManager();
		Transaction tx= pm.currentTransaction();

		try
		{
			OrdenDeCompra temporal= sqlOrdenDeCompra.darOrdenPorId(pmf.getPersistenceManager(), id);
			if(temporal.isEntregado()==false)
			{
				sqlOrdenDeCompra.registrarLLegadaOrden(pmf.getPersistenceManager(), id, calificacion);
				for (OrdenDeCompra_Producto orden : sqlOrdenDeCompraProducto.darOrdenesDeCompraProductos(pmf.getPersistenceManager(), id))
				{
					sqlOrdenDeCompra.actualizarInventarioDespuesDeOrden(pmf.getPersistenceManager(),orden.getIdProcducto(), orden.getVolumen(), temporal.getIdSucursal());
				}
			}
			return temporal;
		}

		catch (Exception e)
		{
			System.out.println("Exception " + e.getMessage()+"\n"+ darDetalleException(e));
			return null;
		}
		finally
		{
			if(tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}



}
