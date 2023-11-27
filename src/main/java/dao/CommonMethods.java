package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class CommonMethods {
	private String nombreTabla;
	protected java.sql.Statement consulta;
	public CommonMethods(String nombreTabla) {
		this.setNombreTabla(nombreTabla);
		try {
			this.consulta = DataBaseConnection.conexionDB.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet getAll() throws SQLException {
		String sql = "SELECT * FROM " + this.getNombreTabla().trim().toUpperCase();
		ResultSet resultado = consulta.executeQuery(sql);
		return resultado;
	}
	
	public abstract ResultSet getById(int id) throws SQLException;
		
	public abstract ResultSet getByName(String name) throws SQLException;

	public String getNombreTabla() {
		return nombreTabla;
	}

	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}
	
		
	
	
	
}
