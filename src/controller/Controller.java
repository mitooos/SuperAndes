package controller;

import java.math.BigDecimal;
import java.util.List;

import negocio.Bodega;
import negocio.Cliente;
import negocio.Compra;
import negocio.Estante;
import negocio.OrdenDeCompra;
import negocio.OrdenDeCompra_Producto;
import negocio.Producto;
import negocio.Proveedor;
import negocio.Sucursal;
import negocio.VentasSucursalTotales;
import persistencia.SuperAndesPersistence;

public class Controller {
	

	public static Proveedor registrarProveedor(Long nit, String nombre, Integer calificacion) {
		SuperAndesPersistence sap = SuperAndesPersistence.getInstance();
		return sap.adicionarProveedor(nit, nombre, calificacion);
	}
	
	public static Producto registrarProdcuto(String nombre0, Integer tamano0, String unidades0, String marca0, Integer precioUnitario0, Integer volEmpaque0,Integer pesoEmpaque0, Integer hexa0, String presentacion0, Integer precioporUnidad0, String categoria0, String descripcion0, int prom, int activa) {
		SuperAndesPersistence sap = SuperAndesPersistence.getInstance();
		return sap.adicionarProducto(nombre0, tamano0, unidades0, marca0, precioUnitario0, volEmpaque0, pesoEmpaque0, hexa0, presentacion0, precioporUnidad0, categoria0, descripcion0, prom, activa);
	}
	
	public static Cliente registrarCliente(Long identificacion,String nombre,String correo, String direccion) {
		SuperAndesPersistence sap = SuperAndesPersistence.getInstance();
		return sap.adicionarCliente(identificacion, nombre, correo, direccion);
	}
	
	public static Sucursal registrarSucursal(String nombre, String ciudad, String direccion, String mercado) { 
		SuperAndesPersistence sap = SuperAndesPersistence.getInstance();
		return sap.adicionarSucursal(nombre, ciudad, direccion, mercado);
	}
	
	public static Bodega registrarUnaBodegaAUnaSucursal(Integer capacidadVol, Integer capacidadPeso, String categoria, Long idSucursal) {
		SuperAndesPersistence sap = SuperAndesPersistence.getInstance();
		return sap.adicionarBodega(capacidadVol, capacidadPeso, categoria, idSucursal);
	}
	
	public static Estante registrarUnEstanteAUnaSucursal(Integer capacidadVol, Integer capacidadPeso, String categoria, Integer posicion, Integer nivelAbastecimiento, Long idSucursal) {
		SuperAndesPersistence sap = SuperAndesPersistence.getInstance();
		return sap.adicionarEstante(capacidadVol, capacidadPeso, categoria, posicion, nivelAbastecimiento, idSucursal);
	}

	
	public static Producto registrarUnaPromocion(String nombre0, Integer tamano0, String unidades0, String marca0, Integer precioUnitario0, Integer volEmpaque0,Integer pesoEmpaque0, Integer hexa0, String presentacion0, Integer precioporUnidad0, String categoria0, String descripcion0) {
		SuperAndesPersistence sap = SuperAndesPersistence.getInstance();
		return sap.adicionarPromocionLong(nombre0, tamano0, unidades0, marca0, precioUnitario0, volEmpaque0, pesoEmpaque0, hexa0, presentacion0, precioporUnidad0, categoria0, descripcion0);
	}
	
	public static int finalizarUnaPromocion(Long idPromocion) {
		SuperAndesPersistence sap = SuperAndesPersistence.getInstance();
		return sap.finalizarPromocion(idPromocion);
	}
	
	public static OrdenDeCompra registrarUnPediddoDeUnProductoAUnaSucursal(long idProveedor,String fechaEstimadaEntrega, Long idProducto,Integer volumen ,Integer precioAcordado ,Long idSucursal) {
		SuperAndesPersistence sap = SuperAndesPersistence.getInstance();
		return sap.agregarOrdenProducto(idProveedor, fechaEstimadaEntrega, idProducto, volumen, precioAcordado, idSucursal);
		
	}
	
	public static int registrarLaLlegadaDeUnProductoAUnaSucursal(long id ,Integer calificacion,long idSucursal) {
		SuperAndesPersistence sap = SuperAndesPersistence.getInstance();
		return sap.recibirOrden(id, calificacion, idSucursal);
	}
	
	public static Compra registrarLaVentaDeUnProductoEnUnaSucursal(Long idCliente, Long idSucursal,String fecha, Long idProductos, Integer cantidadProductos) {
		SuperAndesPersistence sap = SuperAndesPersistence.getInstance();
		return sap.agregarCompra(idCliente, idSucursal,fecha, idProductos, cantidadProductos);
	}
	
	// faltan metodos de consulta
	
	public static List<VentasSucursalTotales> obtenerVentasTotalesEnUnPeriodoDeTiempo(String fechaInicial, String fechaFinal) {
		SuperAndesPersistence sap = SuperAndesPersistence.getInstance();
		return sap.darVentasSucursalesEnUnRango(fechaInicial, fechaFinal);
	}
	
	public static List<Producto> obtenerPromociones(){
		SuperAndesPersistence sap = SuperAndesPersistence.getInstance();
		return sap.darMejoresPromociones();
	}

	
	public static List<Producto> obtenerProductosQueCumplenCaracteristica(String caracteristica, String valorMenor, String valorMayor, int i, Long id){
		SuperAndesPersistence sap = SuperAndesPersistence.getInstance();
		return sap.darProductoQueCumpleCaracteristica(caracteristica, valorMenor, valorMayor, i, id);
	}
	
	// iteracion 2
	
	public static void devolverProductoDeUnCarritoDeCompras(long idProducto, long idCarrito, long idSucursal) {
		SuperAndesPersistence sap = SuperAndesPersistence.getInstance();
		sap.devolverProductoDelCarrito(idProducto, idCarrito, idSucursal);
	}
	

}
