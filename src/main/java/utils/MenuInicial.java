package utils;

import java.util.Scanner;

import persona.Participante;

public class MenuInicial {
	public static void mostrarMenuInicial() {
		 Scanner scanner = new Scanner(System.in);
	        boolean salir = false;
	        char respuesta;

	        while (!salir) {
	            System.out.println("Menu Principal:");
	            System.out.println("1) Cargar datos desde la base de datos");
	            System.out.println("2) Mostrar datos");
	            System.out.println("3) Salir");

	            int opcion = leerOpcion(scanner, 3);

	            switch (opcion) {
	                case 1:
	                    // Lógica para cargar datos desde la base de datos
	                    DataLoader.cargarDatosDesdeDB();
	                    
	                    // Preguntar si desea continuar
	                    do {
	                    	 System.out.println("¿Desea continuar? (S/N)");
	 	                    respuesta = scanner.next().charAt(0);
	 	                    if (respuesta != 'S' && respuesta != 's' && respuesta != 'N' && respuesta != 'n') {
	 	                        System.out.println("La opción ingresada no es correcta");
	 	                    }
	                    	
	                    } while (respuesta != 'S' && respuesta != 's' && respuesta != 'N' && respuesta != 'n');
	                    
	                   

	                    

	                    if (respuesta == 'N' || respuesta == 'n') {
	                        salir = true;
	                    }
	                    break;

	                case 2:
	                    mostrarMenuDatos(scanner);
	                    break;

	                case 3:
	                    salir = true;
	                    break;
	            }
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
	            System.out.println("d) Mostrar Resultados de Partidos");
	            System.out.println("e) Mostrar Puntajes de los Participantes y sus Aciertos");
	            System.out.println("f) Volver al Menú Principal");

	            char opcionDatos = leerOpcion(scanner, 'f');

	            switch (opcionDatos) {
	                case 'a':
	                    // Lógica para mostrar participantes
	                    Participante.mostrarParticipantes();
	                    break;

	                case 'b':
	                    // Lógica para mostrar pronósticos por participante
	                    System.out.println("Mostrando pronósticos por participante.");
	                    break;

	                case 'c':
	                    // Lógica para mostrar partidos por ronda
	                    System.out.println("Mostrando partidos por ronda.");
	                    break;

	                case 'd':
	                    // Lógica para mostrar resultados de partidos
	                    System.out.println("Mostrando resultados de partidos.");
	                    break;

	                case 'e':
	                    // Lógica para mostrar puntajes de participantes y sus aciertos
	                    System.out.println("Mostrando puntajes de participantes y sus aciertos.");
	                    break;

	                case 'f':
	                    volverMenuPrincipal = true;
	                    break;
	            }
	            System.out.println("¿Desea continuar? (S/N)");
                char respuesta = scanner.next().charAt(0);

                if (respuesta == 'N' || respuesta == 'n') {
                    volverMenuPrincipal= true;
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
}
