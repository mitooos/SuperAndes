package view;

import java.util.Scanner;

import controller.Controller;
import negocio.Promocion;

public class View {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean fin = false;
		printMenu();
		
		while(!fin) {
			
			int option = scan.nextInt();
			
			switch(option) {
				case 1:
					
				break;
				case 2:
					
				break;
				case 3:
					
				break;
				case 4:
					
				break;
				case 5:
					
				break;
				case 6:
					
				break;
				case 7:
					Controller.registrarUnaPromocion();
				break;
				case 8:
					
				break;
				case 9:
					
				break;
				case 10:
					
				break;
				case 11:
					
				break;
				case 12:
					
				break;
				case 13:
					
				break;
				case 14:
					
				break;
				case 15:
					
				break;
				case 16:
					
				break;
				case 17:
					
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
		System.out.println("16. Mostrar compras de SuoerAndes");
		System.out.println("17. Mostar ventas a un Usuario dado en un rango de tiempo \n");
		
		System.out.println("100. Salir \n");
		System.out.println("Ingrese el numero de la opcion deseada y presione enter");
	}

}
