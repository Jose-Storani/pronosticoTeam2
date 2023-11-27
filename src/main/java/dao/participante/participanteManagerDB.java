package dao.participante;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.CommonMethods;
import dao.DataBaseConnection;

public class participanteManagerDB extends CommonMethods {
	
	
	public participanteManagerDB(String nombreTabla){
		super(nombreTabla);
	}

	@Override
	public ResultSet getById(int id) throws SQLException {
		String sql = "SELECT * FROM " + this.getNombreTabla().trim().toUpperCase() + " where " + "id = " + id ;
		ResultSet resultado;
		resultado = consulta.executeQuery(sql);
		return resultado;
		
		
		
	}

	@Override
	public ResultSet getByName(String name) throws SQLException {
		String sql = "SELECT * FROM " + this.getNombreTabla().trim().toUpperCase() + " where " + "nombre = " + name ;
		ResultSet resultado;
		resultado = consulta.executeQuery(sql);
		return resultado;
	}
	
	
	
	
	
	
}
