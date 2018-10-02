package controller;

import negocio.Producto;
import persistencia.SuperAndesPersistence;

public class Controller {
	

	public static void registrarProveedor() {
		
	}
	
	public static void registrarProdcuto() {
		
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
	
	public static void finalizarUnaPromocion() {
		
	}
	
	public static void registrarUnPediddoDeUnProductoAUnaSucursal() {
		
	}
	
	public static void registrarLaLlegadaDeUnProductoAUnaSucursal() {
		
	}
	
	public static void registrarLaVentaDeUnProductoEnUnaSucursal() {
		
	}
	
	// faltan metodos de consulta
	

}
