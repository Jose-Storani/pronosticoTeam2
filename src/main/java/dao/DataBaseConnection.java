package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnection {
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	//la url del servidor
	private static final String DB_URL = "jdbc:mysql://localhost:3306/pronosticosdb";
	
	//credenciales
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	//instancia de la conexion
	public static Connection conexionDB;
	
	public static Connection establecerConexion() {
		try {
			DataBaseConnection.conexionDB = DriverManager.getConnection(DataBaseConnection.DB_URL,DataBaseConnection.USER,DataBaseConnection.PASSWORD);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexionDB;
	}
	
	public static void cerrarConexion() {
	    try {
	        if (conexionDB != null && !conexionDB.isClosed()) {
	            conexionDB.close();
	            //System.out.println("Conexión cerrada");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
