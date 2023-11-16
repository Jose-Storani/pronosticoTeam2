package main;

import persona.Participante;

import utils.LectorArchivos;

public class Initializer {

	public static void main(String[] args) {
		LectorArchivos.leerArchivo("src/main/resources/resultadoPartidos.csv");
		LectorArchivos.leerArchivo("src/main/resources/pronostico.csv");
		Participante.detallarPuntajesPorJugador();
	}
}
