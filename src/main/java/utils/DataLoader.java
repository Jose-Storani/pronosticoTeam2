package utils;

import java.sql.SQLException;

import dao.DataBaseConnection;
import entidades.Equipo;
import entidades.Participante;
import entidades.Partido;
import entidades.Pronostico;
import entidades.Ronda;

public class DataLoader {
	public static void cargarDatosDesdeDB() {
		//ingresa al codigo la data de la DB
		try {
			Participante.cargarParticipantes();
			Equipo.cargarEquipos();
			Partido.cargarPartidos();
			Pronostico.cargarPronosticos();
			Ronda.cargarRondas();
			DataBaseConnection.cerrarConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

};

