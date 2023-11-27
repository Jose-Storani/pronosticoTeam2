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
	
	public static void establecerConexion() {
		System.out.println("Conectando a la base de datos...");
		try {
			DataBaseConnection.conexionDB = DriverManager.getConnection(DataBaseConnection.DB_URL,DataBaseConnection.USER,DataBaseConnection.PASSWORD);
			System.out.println("Conexión Exitosa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
