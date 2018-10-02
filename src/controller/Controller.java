package controller;

import java.util.List;

import negocio.Compra;
import negocio.Producto;
import negocio.Proveedor;
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
	
	public static void registrarCliente() {
		
	}
	
	public static void registrarSucursal() {
		
	}
	
	public static void registrarUnaBodegaAUnaSucursal() {
		
	}
	
	public static void registrarUnEstanteAUnaSucursal() {
		
	}
	
	public static Producto registrarUnaPromocion(String nombre0, Integer tamano0, String unidades0, String marca0, Integer precioUnitario0, Integer volEmpaque0,Integer pesoEmpaque0, Integer hexa0, String presentacion0, Integer precioporUnidad0, String categoria0, String descripcion0) {
		SuperAndesPersistence sap = SuperAndesPersistence.getInstance();
		return sap.adicionarPromocionLong(nombre0, tamano0, unidades0, marca0, precioUnitario0, volEmpaque0, pesoEmpaque0, hexa0, presentacion0, precioporUnidad0, categoria0, descripcion0);
	}
	
	public static int finalizarUnaPromocion(Long idPromocion) {
		SuperAndesPersistence sap = SuperAndesPersistence.getInstance();
		return sap.finalizarPromocion(idPromocion);
	}
	
	public static void registrarUnPediddoDeUnProductoAUnaSucursal() {
		
	}
	
	public static void registrarLaLlegadaDeUnProductoAUnaSucursal() {
		
	}
	
	public static Compra registrarLaVentaDeUnProductoEnUnaSucursal(Long idCliente, Long idSucursal, Long idProductos, Integer cantidadProductos) {
		SuperAndesPersistence sap = SuperAndesPersistence.getInstance();
		return sap.agregarCompra(idCliente, idSucursal, idProductos, cantidadProductos);
	}
	
	// faltan metodos de consulta
	

}
