package view;

import java.util.Scanner;

import controller.Controller;

public class View {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean fin = false;
		printMenu();
		
		while(!fin) {
			
			int option = scan.nextInt();
			
			switch(option) {
				case 1:
					System.out.println(Controller.metodo1());
				break;
			case 10:
				fin = true;
				scan.close();
			break;
			}
		}
	}
	
	
	public static void printMenu() {
		System.out.println("--------------Sistemas Transaccionales 201820----------------");
		System.out.println("-------------Miguel Hoyos & Juan Sebastian Vaca--------------");
		System.out.println("1. Prueba ");
		
		System.out.println("10. Salir");
		System.out.println("Ingrese el numero de la opcion deseada y presione enter");
	}

}
