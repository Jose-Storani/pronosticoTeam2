package main;

import java.sql.SQLException;

import dao.DataBaseConnection;
import dao.participante.ParticipanteManagerDB;
import dao.partido.PartidoManagerDB;
import entidades.Participante;
import entidades.Ronda;
import utils.DataLoader;
import view.MenuInicial;

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