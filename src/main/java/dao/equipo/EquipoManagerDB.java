package dao.equipo;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.CommonMethods;

public class EquipoManagerDB extends CommonMethods{

	public EquipoManagerDB(String nombreTabla) {
		super(nombreTabla);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultSet getById(int id) throws SQLException {
		String sql = "SELECT * FROM " + this.getNombreTabla().trim().toUpperCase() + " where " + "equipo_id = " + id ;
		ResultSet resultado;
		resultado = consulta.executeQuery(sql);
		return resultado;
	}

	@Override
	public ResultSet getByName(String name) throws SQLException {
		String sql = "SELECT * FROM " + this.getNombreTabla().trim().toUpperCase() + " where " + "nombre = " + name.substring(0,1).toUpperCase() + name.substring(1) ;
		ResultSet resultado;
		resultado = consulta.executeQuery(sql);
		return resultado;
	}

}
