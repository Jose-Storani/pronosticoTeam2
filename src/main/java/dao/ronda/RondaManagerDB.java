package dao.ronda;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.CommonMethods;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RondaManagerDB extends CommonMethods {

	public RondaManagerDB(String nombreTabla) {
		super(nombreTabla);
		
	}

	@Override
	public ResultSet getById(int id) throws SQLException {
		return consulta.executeQuery("SELECT * FROM " + this.getNombreTabla().trim().toUpperCase() + " where numero_ronda = " + id) ;
	}

	@Override
	public ResultSet getByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
