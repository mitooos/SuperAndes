package view;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import controller.Controller;
import negocio.Bodega;
import negocio.Carrito;
import negocio.Carrito_Producto;
import negocio.Cliente;
import negocio.Compra;
import negocio.Estante;
import negocio.OrdenDeCompra;
import negocio.Producto;
import negocio.Promocion;
import negocio.Sucursal;
import negocio.VentasSucursalTotales;
import negocio.fechaSucursalCont;

public class View {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean fin = false;
		printMenu();

		while(!fin) {

			int option = scan.nextInt();

			switch(option) {
			case 1:
				System.out.println("Ingrese el nit del proveedor");
				Long nit = scan.nextLong();
				System.out.println("Ingrese el nombre del proveedor");
				String nombre = scan.next();
				System.out.println("ingrese la calificacion del proveedor");
				Integer calificacion = scan.nextInt();
				Controller.registrarProveedor(nit, nombre, calificacion);

				break;
			case 2:
				System.out.println("Ingrese el nombre del producto");
				String nombreP = scan.next();
				System.out.println("Ingrese el tamano del producto (solo el numero)");
				int tamano = scan.nextInt();
				System.out.println("ingrese las unidades del tamano (ej. gr)");
				String uni = scan.next();
				System.out.println("Ingrese la marca del producto");
				String marca = scan.next();
				System.out.println("inserte el precio unitario");
				int precioUni = scan.nextInt();
				System.out.println("ingrese el volumen del empaque");
				int vol = scan.nextInt();
				System.out.println("ingrese el peso del producto con empaque");
				int peso = scan.nextInt();
				System.out.println("ingrese el codigo hexadecimal del producto, sin el 0x al principio");
				Integer hex = scan.nextInt(16);
				System.out.println("ingrese la presentacion del producto (ej. 12 paquetes 5gr)7");
				String presentacion = scan.next();
				System.out.println("Ingrese el precio por unidad (solo el numero)");
				int precioPUni = scan.nextInt();
				System.out.println("ingrese la categoria del producto (Abarrote, Perecedero, No Perecedero");
				String cat = scan.next();
				System.out.println("ingrese si es una promocion(si:1, no:0)");
				int prom = scan.nextInt();
				String desc = "";
				if(prom == 1) {
					System.out.println("ingrese la descripcion de la promocion");
					desc = scan.nextLine();
				}
				Producto prod = Controller.registrarProdcuto(nombreP, tamano, uni, marca, precioUni, vol, peso, hex, presentacion, precioPUni, cat, desc, prom, prom);
				System.out.println("se ha creado el producto: \n" + prod);
				break;
			case 3:
				System.out.println("ingrese la identificacion del cliente");
				Long identificacion = scan.nextLong();
				System.out.println("Ingrese el nombre del cliente");
				String nombreC = scan.next();
				System.out.println("ingrese el correo del cliente");
				String correo = scan.next();
				System.out.println("ingrese la direccion del cliente");
				String direccion = scan.next();
				Cliente cli = Controller.registrarCliente( identificacion, nombreC, correo, direccion);
				System.out.println(cli);
				break;
			case 4:
				System.out.println("Ingrese el nombre de la sucursal");
				String nombreS = scan.next();
				System.out.println("ingrese la Ciudad de la sucursal");
				String ciudad = scan.next();
				System.out.println("Ingrese la direccion de la sucursal");
				String direccionS = scan.next();
				System.out.println("ingrese el segmento de mercado de la sucursal (Alto,Medio,Bajo)");
				String mercado = scan.next();
				Sucursal sucursal = Controller.registrarSucursal(nombreS, ciudad, direccionS, mercado);
				System.out.println(sucursal);

				break;
			case 5:
				System.out.println("Ingrese la capacidad volumetrica en cm^3");
				Integer capacidadVol = scan.nextInt();
				System.out.println("ingrese la capacidad en peso en kg");
				Integer capacidadPeso = scan.nextInt();
				System.out.println("Ingrese la categoria de la bodega");
				String categoria = scan.next();
				System.out.println("ingrese el id de la sucursal a la que pertenece");
				Long idSucursalB = scan.nextLong();
				Bodega bodega = Controller.registrarUnaBodegaAUnaSucursal(capacidadVol, capacidadPeso, categoria, idSucursalB);
				System.out.println(bodega);

				break;
			case 6:
				System.out.println("Ingrese la capacidad volumetrica en cm^3");
				Integer capacidadVol1 = scan.nextInt();
				System.out.println("ingrese la capacidad en peso en kg");
				Integer capacidadPeso1 = scan.nextInt();
				System.out.println("Ingrese la categoria de la estanteria");
				String categoria1 = scan.next();
				System.out.println("Ingrese en que posicion va el estante");
				Integer posicion = scan.nextInt();
				System.out.println("ingrese el  nivel de abastecimiento del estante");
				Integer nivelAbastecimiento = scan.nextInt();
				System.out.println("ingrese el id de la sucursal a la que pertenece");
				Long idSucursalE = scan.nextLong();
				Estante estante = Controller.registrarUnEstanteAUnaSucursal(capacidadVol1, capacidadPeso1, categoria1, posicion, nivelAbastecimiento, idSucursalE);
				System.out.println(estante);

				break;

			case 7:
				System.out.println("ingrese la descripcion de la promocion");
				String desc1 = scan.next();
				System.out.println("Ingrese la fecha inicial de la promocion");
				String fechaInic = scan.next();
				System.out.println("Ingrese la fecha final de la promocion");
				String fechaFin = scan.next();
				System.out.println("Ingrese el precio de la promocion");
				Integer precio7 = scan.nextInt();
				LinkedList<Long> prods = new LinkedList<>();
				System.out.println("Ingrese el id del producto asociado a la promocion");
				prods.add(scan.nextLong());
				Promocion prom1 = Controller.registrarUnaPromocion(desc1, fechaInic, fechaFin, precio7, prods);
				System.out.println("se ha creado la promocion: \n" + prom1);
				break;
			case 8:
				System.out.println("Ingrese el id de la promocion");
				Long idProm8 = scan.nextLong();
				System.out.println("Ingrese la fecha en la que desea dinalizar la promocion");
				String fechaFin8 = scan.next();
				Controller.finalizarUnaPromocion(idProm8,fechaFin8);
				System.out.println("Se ha finalizado la promocion con el id: " + idProm8);
				break;
			case 9:
				System.out.println("Ingrese el id del proveedor");
				Long idProveedorP = scan.nextLong();
				System.out.println("Ingrese la fecha inicial con el formato DD/MM/AAAA");
				String fechaEstimadaEntrega = scan.next();
				System.out.println("Ingrese el id del producto");
				Long idProductoP = scan.nextLong();
				System.out.println("Ingrese el volumen deseado");
				Integer volumen = scan.nextInt();
				System.out.println("Ingrese el precio Acordado");
				Integer precioAcordado = scan.nextInt();
				System.out.println("Ingrese el id de la sucursal");
				Long idSucursal1 = scan.nextLong();
				Controller.registrarUnPediddoDeUnProductoAUnaSucursal(idProveedorP, fechaEstimadaEntrega, idProductoP, volumen, precioAcordado, idSucursal1);
				break;
			case 10:
				System.out.println("Ingrese el id de la orden");
				Long idL = scan.nextLong();
				System.out.println("Ingrese la calificacion al proveedor");
				Integer calificacion1 = scan.nextInt();
				System.out.println("Ingrese la sucursal a la que llego");
				Long idSucursalP = scan.nextLong();
				Controller.registrarLaLlegadaDeUnProductoAUnaSucursal(idL, calificacion1,idSucursalP);

				break;

			case 11:
				System.out.println("ingrese el id de la sucursal");
				long idSucursal = scan.nextLong();
				System.out.println("Ingrese el id del cliente");
				long idCliente = scan.nextLong();
				System.out.println("Ingrese la fecha con el siguiente formato: dd/mm/yyyy");
				String fechaC = scan.next();
				System.out.println("Ingrese el id del producto");
				long idProducto = scan.nextLong();
				System.out.println("ingrese la cantidad del producto");
				int cantidadProductos = scan.nextInt();
				Compra com = Controller.registrarLaVentaDeUnProductoEnUnaSucursal(idSucursal, idCliente, fechaC, idProducto, cantidadProductos);
				System.out.println(com);
				break;
			case 12:
				System.out.println("Ingrese la fecha inicial con el formato DD/MM/AAAA");
				String fechaInicial = scan.next();
				System.out.println("ingrese la fecha final con el formato DD/MM/AAAA");
				String fechaFinal = scan.next();
				List<VentasSucursalTotales> rta = Controller.obtenerVentasTotalesEnUnPeriodoDeTiempo(fechaInicial, fechaFinal);
				for(VentasSucursalTotales vent : rta) {
					System.out.println(vent.toString());
				}
				break;
			case 13:
				System.out.println("Las promociones son");
				List<Producto> rta2 = Controller.obtenerPromociones();
				for(Producto pro:rta2)
				{
					System.out.println(pro.toString());
				}

				break;
			case 14:

				break;
			case 15:
				System.out.println("Ingrese que caracteristica desea en myusculas");
				String caracteristica = scan.next();
				System.out.println("ingrese el numero de la opcion de como desea compar");
				System.out.println("0: igual");
				System.out.println("1: rango");
				System.out.println("2. menor que el valor a imgresar despues");
				System.out.println("3: mayor al valor a ingresar despues");
				System.out.println("-1: si el producto se encuentra en algun lugar(orden de compra, compra, estante,...");
				int i = scan.nextInt();
				String valor = "";
				String valorMayor = "";
				long id = 0L;
				if (i >= 0 && i != 1) {
					System.out.println("Ingrese el valor");
					valor = scan.next();
				}
				else if(i == 1) {
					System.out.println("ingrese el valor menor");
					valor = scan.next();
					System.out.println("ingrese el valor mayor");
					valorMayor = scan.next();
				}
				else {
					System.out.println("ingrese el id de la caracteristica que busca");
					id = scan.nextLong();
				}
				List<Producto> lista = Controller.obtenerProductosQueCumplenCaracteristica(caracteristica, valor, valorMayor, i, id);
				for(Producto producto : lista) {
					System.out.println(producto.toString());
				}
				break;
			case 16:
				List<OrdenDeCompra> compras = Controller.darComprasAProveedores();
				for(OrdenDeCompra comp16: compras) {
					System.out.println(comp16.toString());
					List<Producto> prods16 = Controller.darProductosEnOrdenDeCompra(comp16.getId());
					for(Producto prod16 : prods16) {
						System.out.println("   " + prod16.toString());
					}
				}
				break;
			case 17:
				System.out.println("Ingrese el id del cliente");
				Long idCliente17 = scan.nextLong();
				System.out.println("Ingrese la fecha inicial");
				String fechaInic17 = scan.next();
				System.out.println("Ingrese la fecha final");
				String fechaFin17 = scan.next();
				List<Compra> ventas17 = Controller.darVentasACliente(idCliente17, fechaInic17, fechaFin17);
				for(Compra cmp : ventas17) {
					System.out.println(cmp.toString());
					List<Producto> prods17 = Controller.darProductosVenta(cmp.getId());
					for(Producto prd17 : prods17) {
						System.out.println("   " + prd17.toString());
					}
				}
				break;
			case 18:
				System.out.println("ingrese el id del cliente al cual se le asignara el carro");
				Long idCliente22 = scan.nextLong();
				System.out.println("Ingrese el id de la sucursal a la cual pertenece el carro");
				Long idSucursal22 = scan.nextLong();
				Carrito carrito = Controller.adicionarCarrito(idCliente22, idSucursal22);
				System.out.println(carrito);
				break;

			case 19:
				System.out.println("ingrese el id de la sucursal");
				long idSucursalca = scan.nextLong();
				System.out.println("Ingrese el id del cliente");
				long idCarritoca = scan.nextLong();
				System.out.println("Ingrese el id del producto");
				long idProductoca = scan.nextLong();
				System.out.println("ingrese la cantidad del producto");
				int cantidadca = scan.nextInt();
				Carrito_Producto caripro = Controller.adicionarProducto(idSucursalca, idCarritoca, idProductoca, cantidadca);
				System.out.println(caripro);	
			case 20:
				System.out.println("Ingrese el id del carrito");
				long idCarrito20 = scan.nextLong();
				System.out.println("Ingrese el id del prodcuto que va a devolver");
				long idProducto20 = scan.nextLong();
				Controller.devolverProductoDeUnCarritoDeCompras(idProducto20, idCarrito20);
				break;
			case 21:
				System.out.println("Ingrese el id del Carrito");
				Long idCarrito21 = scan.nextLong();
				System.out.println("Ingrese el id del cliente");
				Long idCliente21 = scan.nextLong();
				Controller.pagarCompra(idCarrito21, idCliente21);
				break;
			case 22:
				System.out.println("Ingrese el id del carrito");
				Long idCarrito22 = scan.nextLong();
				Controller.abandonarCarrito(idCarrito22);
				break;
			case 24:
				System.out.println("Ingrese la categoria");
				String cat24 = scan.next();
				List<fechaSucursalCont> lista241 = Controller.darFechaMenorDemanda(cat24);
				List<fechaSucursalCont> lista242 = Controller.darFechaMayorDemanda(cat24);
				List<fechaSucursalCont> lista243 = Controller.darFechaMenorIngresos(cat24);
				List<fechaSucursalCont> lista244 = Controller.darFechaMayorIngresos(cat24);
				for(fechaSucursalCont cnt : lista241) {
					System.out.println("Las fechas con menor demanda fueron:");
					System.out.println("   "+cnt.toString());
				}
				for(fechaSucursalCont cnt : lista242) {
					System.out.println("Las fechas con mayor demanda fueron:");
					System.out.println("   "+cnt.toString());
				}
				for(fechaSucursalCont cnt : lista243) {
					System.out.println("Las fechas con menor ingresos fueron:");
					System.out.println("   "+cnt.toString());
				}
				for(fechaSucursalCont cnt : lista244) {
					System.out.println("Las fechas con mayor ingresos fueron:");
					System.out.println("   "+cnt.toString());
				}
				break;
			case 100:
				fin = true;
				scan.close();
				break;
			}
		}
	}


	public static void printMenu() {
		System.out.println("--------------Sistemas Transaccionales 201820----------------");
		System.out.println("-------------Miguel Hoyos & Juan Sebastian Vaca--------------");
		System.out.println("1. Registrar proveedor");
		System.out.println("2. Registrar Producto");
		System.out.println("3. Registrar Cliente");
		System.out.println("4. Registrar una Sucursal");
		System.out.println("5. Registrar una bodega a una sucursal");
		System.out.println("6. Registrar un estante a una sucursal");
		System.out.println("7. Registrar una promocion");
		System.out.println("8. Finalizar Una Promocion");
		System.out.println("9. Registrar un Pedido de un Producto a una Sucursal");
		System.out.println("10. Registrar la llegada de un producto a una sucursal");
		System.out.println("11. Registrar la venta de un producto en una sucursal");
		System.out.println("12. Mostrar el dinero recolectado por ventas en cada sucursal en un periodo de tiempo");
		System.out.println("13. Mostrar las 20 promociones mas populares");
		System.out.println("14. Mostrar el indice de ocupamiento de todas las bodegas y estantes de una sucursal");
		System.out.println("15. Mostrar productos que cumplen cierta caracteristica");
		System.out.println("16. Dar compras a los proveedores");
		System.out.println("17. Dar ventas a un cliente");
		System.out.println("18. Registrar un carrito a un cliente");
		System.out.println("19. Agregar un producto a un caarrito");
		System.out.println("20. Devolver un producto del carrito de compras");
		System.out.println("21. Pagar Compra");
		System.out.println("22. Abandonar Carrito");
		//rf19 23
		System.out.println("24. Analizar operacion SuperAndes");

		System.out.println("100. Salir \n");
		System.out.println("Ingrese el numero de la opcion deseada y presione enter");
	}

}
