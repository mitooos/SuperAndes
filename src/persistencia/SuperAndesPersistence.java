package persistencia;


import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;


import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import negocio.Bodega;
import negocio.Carrito;
import negocio.Carrito_Producto;
import negocio.Cliente;
import negocio.Compra;
import negocio.Estante;
import negocio.OrdenDeCompra;
import negocio.OrdenDeCompra_Producto;
import negocio.Producto;
import negocio.Promocion;
import negocio.Proveedor;
import negocio.Sucursal;
import negocio.VentasSucursalTotales;

public class SuperAndesPersistence {
	
	private static Logger log = Logger.getLogger("SuperAndes.log");

	public final static String SQL = "javax.jdo.query.SQL";

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
	private SQLCarrito sqlCarrito;
	private SQLPromocion sqlPromocion;

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
		tablas.add("PROMOCIONES");
		tablas.add("PROMOCION_PRODUCTO");
		tablas.add("CARRITOS");
		tablas.add("CARRITO_PRODUCTO");
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
		sqlCarrito = new SQLCarrito(this);
		sqlPromocion = new SQLPromocion(this);
		
		
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
	
	public String darTablaPromociones() {
		return tablas.get(16);
	}
	
	public String darTablaPromocionProducto() {
		return tablas.get(17);
	}
	
	public String darTablaCarritos() {
		return tablas.get(18);
	}
	
	public String darTablaCarritoProductos() {
		return tablas.get(19);
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
			long tuplas = sqlProveedor.adicionarProveedor(pmf.getPersistenceManager(),nit, nombre, calificacion);
			log.info("Se cambiaron " + tuplas + " tuplas");
			return new Proveedor(nit, nombre, calificacion);
		}
		catch(Exception e){
			System.out.println("Exception: " + e.getMessage() + "\n" + darDetalleException(e));
			log.error("Exception: " + e.getMessage() + "\n" + darDetalleException(e));
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
			Long id = nextval() + 12;
			String hex = hexa0.toString();
			long tuplas = sqlProducto.adicionarProducto(pmf.getPersistenceManager(), id, nombre0, tamano0, unidades0, marca0, precioUnitario0, volEmpaque0, pesoEmpaque0, hex, presentacion0, precioporUnidad0, categoria0, prom, activa, descripcion0);
			tx.commit();
			log.info("Se cambiaron " + tuplas + " tuplas");

			return new Producto(id, nombre0, tamano0, unidades0, marca0, precioUnitario0, volEmpaque0, pesoEmpaque0, hexa0, presentacion0, precioporUnidad0, categoria0, prom, activa, descripcion0);

		}
		catch(Exception e) {
			System.out.println("Exception: " + e.getMessage() + "\n" + darDetalleException(e));
			log.error("Exception: " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	public Cliente adicionarCliente(Long identificacion, String nombre, String correo, String direccion) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			log.trace("prueba");
			tx.begin();
			Long id = nextval() + 1000;
			sqlCliente.adicionarCliente(pmf.getPersistenceManager(), id,identificacion, nombre, correo, direccion);
			tx.commit();
			return new Cliente(id, identificacion, nombre, correo, direccion);
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
	
	public Carrito  adicionarCarrito(Long id,Long idCliente, Long idSucursal)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			//log.trace("prueba");
			tx.begin();
			sqlCarrito.adicionarCarrito(pmf.getPersistenceManager(), id,idCliente,idSucursal);
			tx.commit();
			return new Carrito(id, idCliente, idSucursal);
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
			Long id = nextval()+1;
			long tuplas = sqlSucursal.adicionarSucursal(pmf.getPersistenceManager(), id, nombre, ciudad, direccion, mercado);
			tx.commit();
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
			Long id = nextval()+100;
			long tuplas = sqlBodega.adicionarBodega(pmf.getPersistenceManager(), id, capacidadVol, capacidadPeso, categoria, idSucursal);
			tx.commit();
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
			Long id = nextval()+100;
			long tuplas = sqlEstante.adicionarEstante(pmf.getPersistenceManager(), id, capacidadVol, capacidadPeso, categoria, posicion, nivelAbastecimiento, idSucursal);
			tx.commit();
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

	public Promocion adicionarPromocionLong (String descripcion, String fechaInic, String fechaFin, Integer precio, List<Long> idsProductos) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Long id = nextval() + 20;
			sqlPromocion.agregarPromcocion(pmf.getPersistenceManager(), id, descripcion, fechaInic, fechaFin, precio);
			for(Long ln: idsProductos) {
				sqlPromocion.agregarProductoAPromocion(pmf.getPersistenceManager(), id, ln);
			}
			tx.commit();
			return new Promocion(id, descripcion, fechaInic, fechaFin, precio);
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

	public int finalizarPromocion(Long idPromocion, String fechaFin) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			sqlPromocion.finalizarPromocion(pmf.getPersistenceManager(), idPromocion, fechaFin);
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




	public Compra agregarCompra(long idCliente, long idSucursal, String fecha,Long idProducto, Integer cantidadProducto) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Long id = nextval()+10;
			Integer costo = sqlCompra.calcularPrecioCompra(pmf.getPersistenceManager(), idProducto, cantidadProducto, idSucursal);
			long tuplas = sqlCompra.agregarCompra(pmf.getPersistenceManager(), id, costo, 1, idCliente, idSucursal);
			sqlCompraProducto.registrarProdcutoEnCompra(pmf.getPersistenceManager(), id, idProducto, cantidadProducto);
			sqlCompra.actualizarEstantesDespuesDeCompra(pmf.getPersistenceManager(), idProducto, cantidadProducto, idSucursal);
			tx.commit();
			return new Compra(id, costo, true, fecha,idCliente, idSucursal);

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
	
	public Carrito_Producto agregarProducto(long idSucursal, long idCarrito, long idProducto, Integer cantidad) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			sqlCarrito.registrarProductoEnCarro(pmf.getPersistenceManager(), idCarrito, idProducto, cantidad);
			sqlCarrito.actualizarEstantesDespuesDeCarro(pmf.getPersistenceManager(), idProducto, cantidad, idSucursal);
			tx.commit();
			return new Carrito_Producto(idCarrito, idProducto, cantidad);

		}
		catch(Exception e) {
			System.out.println("Exception: " + e.getMessage() + "\n" + darDetalleException(e));
//			log.error("Exception: " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public List<VentasSucursalTotales> darVentasSucursalesEnUnRango(String fechaInicial, String fechaFinal){
		List<BigDecimal> listaIds = sqlCompra.darIdsSucursalesDondeHuboVentas(pmf.getPersistenceManager());
		List<VentasSucursalTotales> rta = new LinkedList<>();
		for(BigDecimal id: listaIds) {
			rta.add(sqlCompra.darVentasTotalesPorSucursalEnUnPeriodoDeTiempo(pmf.getPersistenceManager(), id, fechaInicial, fechaFinal));
		}
		return rta;
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
			log.error("Exception: " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
	}
	
	public void devolverProductoDelCarrito(long idProducto, long idCarrito) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			Long idSucursal = sqlCarrito.darSede(pmf.getPersistenceManager(), idCarrito);
			Integer cantidad = sqlCarrito.darCantidadProductoEnCarrito(pmf.getPersistenceManager(), idCarrito, idProducto);
			sqlEstante.adicionarProductosEstanterias(pmf.getPersistenceManager(), idProducto, idSucursal, cantidad);
			sqlCarrito.retirarProductosDeCarritos(pmf.getPersistenceManager(), idCarrito, idProducto);
			tx.commit();
		}
		catch(Exception e){
			System.out.println("Exception: " + e.getMessage() + "\n" + darDetalleException(e));
		}
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public void pagarCompra(Long idCarrito, Long idCliente) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			Long idCompra = nextval();
			Long idSede = sqlCarrito.darSede(pmf.getPersistenceManager(),idCarrito);
			sqlCompra.agregarCompra(pmf.getPersistenceManager(), idCompra, 0, 0, idCliente, idSede);
			List<Long> productos = sqlCarrito.darProductosEnCarrito(pmf.getPersistenceManager(), idCarrito);
			List<Integer> cantidades = sqlCarrito.darCantidadesEnCarrito(pmf.getPersistenceManager(), idCarrito);
			int i = 0;
			Integer precioCompra = 0;
			while(i<productos.size()) {
				precioCompra =+ sqlCompra.calcularPrecioCompra(pmf.getPersistenceManager(), productos.get(i), cantidades.get(i), idSede);
				sqlCompraProducto.registrarProdcutoEnCompra(pmf.getPersistenceManager(), idCompra, productos.get(i), cantidades.get(i));
				sqlCarrito.retirarProductosDeCarritos(pmf.getPersistenceManager(), idCarrito, productos.get(i));
			i++;
			}
			sqlCarrito.eliminarCliente(pmf.getPersistenceManager(), idCarrito);
			sqlCompra.pagarCompra(pmf.getPersistenceManager(), idCompra, precioCompra);
			tx.commit();
			
		}
		catch(Exception e) {
			System.out.println("Exception: " + e.getMessage() + "\n" + darDetalleException(e));
		}
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public void abandonarCarrito(Long idCarrito){
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			List<Long> productos = sqlCarrito.darProductosEnCarrito(pmf.getPersistenceManager(), idCarrito);
			int i = 0;
			while (i<productos.size()) {
				devolverProductoDelCarrito(productos.get(i), idCarrito);
				i++;
			}
			sqlCarrito.eliminarCliente(pmf.getPersistenceManager(), idCarrito);
			tx.commit();
		}
		catch(Exception e) {
			System.out.println("Exception: " + e.getMessage() + "\n" + darDetalleException(e));
		}
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public List<OrdenDeCompra> darComprasAProveedores(){
		try{
			return sqlOrdenDeCompra.darOrdenesALosProveedores(pmf.getPersistenceManager());
		}
		catch(Exception e) {
			System.out.println("Exception: " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
	}
	
	public List<Producto> darProductosEnCompraAProveedor(Long idOrden){
		List<BigDecimal> prods = sqlOrdenDeCompra.darProductosEnOrdenCompra(pmf.getPersistenceManager(), idOrden);
		List<Producto> rta = new LinkedList<>();
		for(BigDecimal bg : prods) {
			rta.add(sqlProducto.obtenerProductoPorId(pmf.getPersistenceManager(), bg.longValue()));
		}
		return rta;
	}
	
	public List<Compra> darVentasACliente(Long idCliente, String fechaInic, String fechaFin){
		try {
			return sqlCompra.darVentasAUnCliente(pmf.getPersistenceManager(), idCliente, fechaInic, fechaFin);
		}
		catch(Exception e){
			System.out.println("Exception: " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
	}
	
	public List<Producto> darProductosEnVenta(Long idVenta){
		List<BigDecimal> prods = sqlCompra.darProductosEnVentas(pmf.getPersistenceManager(), idVenta);
		List<Producto> rta = new LinkedList<>();
		for(BigDecimal bg : prods) {
			rta.add(sqlProducto.obtenerProductoPorId(pmf.getPersistenceManager(), bg.longValue()));
		}
		return rta;
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
//	public List<Bodega> darIndiceOcupacion()
//	{
//		PersistenceManager pm =pmf.getPersistenceManager();
//		Transaction tx = pm.currentTransaction();
//		List<Bodega> resultado = 0;
//		try {
//			resultado = add(sqlBodega.darIndiceOcupacion(pmf.getPersistenceManager()));
//			return resultado;
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
	
	public List<Producto> darProductoQueCumpleCaracteristica(String caracteristica, String valorMenor, String valorMayor, int i, Long id){
		List<BigDecimal> lista = sqlProducto.productosQueCumplenCaracteristicaString(pmf.getPersistenceManager(), caracteristica, valorMenor, valorMayor, i, id);
		List<Producto> rta = new LinkedList<>();
		for(BigDecimal bg : lista) {
			rta.add(sqlProducto.obtenerProductoPorId(pmf.getPersistenceManager(), bg.longValue()));
		}
		return rta;
	}


	public OrdenDeCompra agregarOrdenProducto(long idProveedor,String fechaEstimadaEntrega, Long idProducto,Integer volumen ,Integer precioAcordado ,Long idSucursal)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try
		{
			tx.begin();
			Long id =nextval();

			long tuplas = sqlOrdenDeCompra.crearOrden(pmf.getPersistenceManager(), id, fechaEstimadaEntrega, 0 , 0, "", idProveedor,idSucursal);
			sqlOrdenDeCompraProducto.crearOrdenProducto(pmf.getPersistenceManager(), id, idProducto, precioAcordado, volumen);
			tx.commit();
			log.info("Se cambiaron " + tuplas + " tuplas");
			return new OrdenDeCompra(id, fechaEstimadaEntrega, 0, 0, "", idProveedor, idSucursal);
		}
		catch(Exception e) {
			System.out.println("Exception: " + e.getMessage() + "\n" + darDetalleException(e));
			log.error("Exception: " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}

	public int recibirOrden(long id ,Integer calificacion, long idSucursal)
	{
		PersistenceManager pm =pmf.getPersistenceManager();
		Transaction tx= pm.currentTransaction();

		try
		{
			long tuplas = sqlOrdenDeCompra.registrarLLegadaOrden(pmf.getPersistenceManager(), id, calificacion);
			OrdenDeCompra_Producto orden = sqlOrdenDeCompraProducto.darOrdenesDeCompraProductos(pmf.getPersistenceManager(), id);
			sqlOrdenDeCompra.actualizarInventarioDespuesDeOrden(pmf.getPersistenceManager(),orden.getIdProcducto(), orden.getVolumen(), idSucursal);
			log.info("Se cambiaron " + tuplas + " tuplas");
			return 1;
		}

		catch (Exception e)
		{
			System.out.println("Exception " + e.getMessage()+"\n"+ darDetalleException(e));
			log.error("Exception: " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
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
