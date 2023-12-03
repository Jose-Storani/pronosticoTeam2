package view;

import java.util.Scanner;

import entidades.Participante;
import entidades.Partido;
import entidades.Ronda;
import logica.CalculadoraPuntos;
import logica.Configuracion;
import utils.DataLoader;

public class MenuInicial {
	private static boolean dataCargada = false;

	public static void mostrarMenuInicial() {
		Scanner scanner = new Scanner(System.in);
		boolean salir = false;
		char respuesta;
		char seleccion;

		System.out.println(
				"Bienvenido al sistema de pronosticos, antes de comenzar, ¿desea establecer un valor determinado para los aciertos? S/N");
		do {
			seleccion = scanner.next().charAt(0);
			if (seleccion != 'S' && seleccion != 's' && seleccion != 'N' && seleccion != 'n') {
				System.out.println("La opción ingresada no es correcta");
			}

		} while (seleccion != 'S' && seleccion != 's' && seleccion != 'N' && seleccion != 'n');
		if (seleccion == 's' || seleccion == 'S') {
			mostrarMenuConfiguracion(scanner);
		}

		while (!salir) {
			System.out.println("Menu Principal:");
			if (!dataCargada) {
				System.out.println("1) Cargar datos desde la base de datos");
			}
			;
			System.out.println("2) Mostrar datos");
			System.out.println("3) Configurar sistema de aciertos");
			System.out.println("4) Calcular Puntajes");
			System.out.println("5) Salir");

			int opcion = leerOpcion(scanner, 5);

			switch (opcion) {
			case 1:
				if (!dataCargada) {
					// Lógica para cargar datos desde la base de datos
					DataLoader.cargarDatosDesdeDB();
					dataCargada = true;
					

				} else {
					System.out.println("¡Los datos ya han sido cargados!");
				}

				break;

			case 2:
				mostrarMenuDatos(scanner);
				
				break;

			case 3:
				mostrarMenuConfiguracion(scanner);
				
				break;

			case 4:
				CalculadoraPuntos.calcularPuntos();
				break;

			case 5:
				salir = true;
				break;
			}
			//salir = finalizarSeccion(scanner);
			
		}

		System.out.println("Programa terminado.");
		scanner.close();
	}

	private static void mostrarMenuDatos(Scanner scanner) {
		boolean volverMenuPrincipal = false;
		while (!volverMenuPrincipal) {
			System.out.println("Menu de Datos:");
			System.out.println("a) Mostrar Participantes");
			System.out.println("b) Mostrar Pronósticos por Participante");
			System.out.println("c) Mostrar Partidos por Ronda");
			System.out.println("d) Mostrar Puntajes de los Participantes y sus Aciertos");
			System.out.println("e) Volver al Menú Principal");

			char opcionDatos = leerOpcion(scanner, 'e');

			switch (opcionDatos) {
			case 'a':
				Participante.mostrarParticipantes();
				break;

			case 'b':
				Participante.mostrarPronosticosPorParticipante();

				break;

			case 'c':
				Ronda.mostrarTodasLasRondas();

				break;

			case 'd':
				Participante.detallarPuntajesPorJugador();
				break;

			case 'e':
				volverMenuPrincipal = true;
				break;
			}
			
	}
	}

	private static void mostrarMenuConfiguracion(Scanner scanner) {
		boolean volverMenuPrincipal = false;
		while (!volverMenuPrincipal) {
			System.out.println("Menu de configuracion: ");
			System.out.println("a) Establecer valor del acierto");
			System.out.println("b) Establecer valor del puntaje extra por racha");
			System.out.println("c) Volver al menu principal");
			char opcionConfiguracion = leerOpcion(scanner, 'c');

			switch (opcionConfiguracion) {
			case 'a':
				// logica para valor del acierto
				Configuracion.configurarAciertos(scanner);
				break;
			case 'b':
				// logica para valor puntaje extra por racha
				break;
			case 'c':
				volverMenuPrincipal = true;
				break;
			}

		}
	}

	private static int leerOpcion(Scanner scanner, int maxOpcion) {
		int opcion;

		do {
			System.out.print("Ingrese su opción: ");
			while (!scanner.hasNextInt()) {
				System.out.println("Por favor, ingrese un número válido.");
				scanner.next();
			}
			opcion = scanner.nextInt();

			if (opcion < 1 || opcion > maxOpcion) {
				System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
			}
		} while (opcion < 1 || opcion > maxOpcion);

		return opcion;
	}

	private static char leerOpcion(Scanner scanner, char maxOpcion) {

		char opcion;

		do {
			System.out.print("Ingrese su opción: ");
			opcion = scanner.next().charAt(0);

			if (opcion < 'a' || opcion > maxOpcion) {
				System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
			}
		} while (opcion < 'a' || opcion > maxOpcion);

		return opcion;
	}
	
private static boolean finalizarSeccion(Scanner scanner) {
	char respuesta;
	do {
		System.out.println("¿Desea continuar? (S/N)");
		respuesta = scanner.next().charAt(0);
		if (respuesta != 'S' && respuesta != 's' && respuesta != 'N' && respuesta != 'n') {
			System.out.println("La opción ingresada no es correcta");
		}

	} while (respuesta != 'S' && respuesta != 's' && respuesta != 'N' && respuesta != 'n');

	if (respuesta == 'N' || respuesta == 'n') {
		return true;
	}
	return false;

}
	};

	
