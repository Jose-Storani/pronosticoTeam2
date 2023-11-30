package dao.partido;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.CommonMethods;
import utils.posiblesResultados;


public class PartidoManagerDB extends CommonMethods {

	public PartidoManagerDB(String nombreTabla) {
		super(nombreTabla);
		
	}

	@Override
	public ResultSet getById(int id) throws SQLException {
		String sql = "SELECT * FROM " + this.getNombreTabla().trim().toUpperCase() + " where " + "partido_id = " + id ;
		ResultSet resultado;
		resultado = consulta.executeQuery(sql);
		return resultado;
	}

	@Override
	public ResultSet getByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public posiblesResultados obtenerResultadoPartido(int id) throws SQLException {
		
		ResultSet resultSet = this.getById(id);
		if(resultSet.next()) {
			String resultadoPartidoStr = resultSet.getString("resultado");
			posiblesResultados resultadoPartido = posiblesResultados.valueOf(resultadoPartidoStr);
			return resultadoPartido;
			
		}
		else{
			return null;
		}
	};
	
	public ResultSet obtenerDatosPartido(int id) throws SQLException {
		ResultSet resultSet = consulta.executeQuery("Select Partido.partido_id, Equipo1.nombre as nombre_equipo1, Equipo2.nombre as nombre_equipo2, Partido.goles_equipo_1, Partido.goles_equipo_2, Partido.resultado from Partido JOIN Equipo AS Equipo1 ON Partido.equipo1_id = Equipo1.equipo_id JOIN Equipo AS Equipo2 ON Partido.equipo2_id = Equipo2.equipo_id WHERE Partido.partido_id = " + id);
		
		if(resultSet.next()) {
			return resultSet;
			
		}
		return null;
	}

}
