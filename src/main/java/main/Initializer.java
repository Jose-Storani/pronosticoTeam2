package main;

import java.sql.SQLException;

import dao.DataBaseConnection;
import persona.Participante;
import persona.ParticipantePruebaDB;
import utils.LectorArchivos;

public class Initializer {

	public static void main(String[] args) {
		//LectorArchivos.leerArchivo ("src/main/resources/resultadoPartidos.csv");
		//LectorArchivos.leerArchivo("src/main/resources/pronostico.csv");
		//Participante.detallarPuntajesPorJugador();
		
		DataBaseConnection.establecerConexion();
		ParticipantePruebaDB participantes = new ParticipantePruebaDB();
		try {
			participantes.mostrarParticipantes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


