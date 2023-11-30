package utils;

import java.sql.SQLException;


import equipo.Equipo;
import partido.Partido;
import persona.Participante;
import pronostico.Pronostico;
import ronda.Ronda;

public class DataLoader {
	public static void cargarDatosDesdeDB() {
		//ingresa al codigo la data de la DB
		try {
			Participante.cargarParticipantes();
			Equipo.cargarEquipos();
			Partido.cargarPartidos();
			Pronostico.cargarPronosticos();
			Ronda.cargarRondas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void mostrarInformacionDeTabla() {
		Partido.mostrarPartidosConsola();
		Participante.mostrarParticipantes();
		//Pronostico.mostrarPronosticos();
		//Equipo.mostrarEquipos();
	}
	
	
}
