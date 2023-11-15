package main;

import pronostico.Pronostico;
import utils.LectorArchivos;

public class Initializer {

	public static void main(String[] args) {
		LectorArchivos.leerArchivo("src/main/resources/partidos.txt");
		LectorArchivos.leerArchivo("src/main/resources/pronostico.txt");
		Pronostico.getPuntos();
	}
}
