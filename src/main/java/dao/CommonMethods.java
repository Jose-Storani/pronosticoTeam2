package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonMethods {
	private String nombreTabla;
	protected java.sql.Statement consulta;
	public CommonMethods(String nombreTabla) {
		this.nombreTabla = nombreTabla;
		try {
			this.consulta = DataBaseConnection.conexionDB.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet getAll() throws SQLException {
		String sql = "SELECT * FROM " + this.nombreTabla.trim().toUpperCase();
		ResultSet resultado = consulta.executeQuery(sql);
		return resultado;
	}
	
	
}
