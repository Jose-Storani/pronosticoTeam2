package dao.pronostico;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.CommonMethods;

public class PronosticoManagerDB extends CommonMethods {

	public PronosticoManagerDB(String nombreTabla) {
		super(nombreTabla);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultSet getById(int id) throws SQLException {
		String sql = "SELECT * FROM " + this.getNombreTabla().trim().toUpperCase() + " where " + "id = " + id ;
		
		return consulta.executeQuery(sql);
		
	}
	

	@Override
	public ResultSet getByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ResultSet getParticipantePronosticos(int idParticipante) throws SQLException {
		String sql = "SELECT resultado_propuesto, partido_id from pronostico WHERE Participante_id = " + idParticipante;
		return consulta.executeQuery(sql);
	}
	
	public ResultSet getPronosticosPorPartido(int idPartido) throws SQLException {
		String sql = "Select resultado_propuesto,Participante_id from pronostico WHERE partido_id = " + idPartido;
		return consulta.executeQuery(sql);
	}
	
	

}
