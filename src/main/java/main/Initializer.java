package main;

import java.sql.SQLException;

import dao.DataBaseConnection;
import dao.participante.ParticipanteManagerDB;
import dao.partido.PartidoManagerDB;
import persona.Participante;
import ronda.Ronda;
import utils.DataLoader;
import utils.LectorArchivos;
import utils.MenuInicial;

public class Initializer {

	public static void main(String[] args) {
		//LectorArchivos.leerArchivo ("src/main/resources/resultadoPartidos.csv");
		//LectorArchivos.leerArchivo("src/main/resources/pronostico.csv");
		//Participante.detallarPuntajesPorJugador();
		
		DataBaseConnection.establecerConexion();
//		DataLoader.cargarDatosDesdeDB();
//		Ronda.mostrarPartidosPorRonda(1);
		MenuInicial.mostrarMenuInicial();
		
		
		
}


}