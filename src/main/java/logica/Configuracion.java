package logica;

import java.util.Scanner;

public class Configuracion {
	//Metodos de configuracion de puntaje;
		public static void configurarAciertos(Scanner scanner) {
			System.out.println("Ingrese el valor del acierto que desea establecer");
			int valor = validacionValorAcierto(scanner);
			CalculadoraPuntos.setValorAcierto(valor);
			System.out.println("Se ha establecido el valor de acierto en: " + valor);
			
		}
		
		public static void configurarPuntajeExtra(Scanner scanner) {
			
		};
		
		private static int validacionValorAcierto(Scanner scanner) {
			int numeroAcierto;
			do {
				while(!scanner.hasNextInt()) {
					System.err.println("Entrada inválida. Ingrese un numero entero positivo");
					scanner.next();
				}
				numeroAcierto = scanner.nextInt();
				if(numeroAcierto <= 0) {
					System.err.println("Entrada inválida. Ingrese un numero entero positivo");
				}
				
			}
			while(numeroAcierto <=0);
			return numeroAcierto;
		}
		
		
	};
