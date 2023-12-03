import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import dao.DataBaseConnection;

public class DatabaseConnectionTest {
	@Before
    public void setUp() {
        DataBaseConnection.establecerConexion();
    }

    @After
    public void closeConnection() {
        DataBaseConnection.cerrarConexion();
    }

	 @Test
	    public void testConexionNoNula() {
	        DataBaseConnection.establecerConexion();
	        Connection connection = DataBaseConnection.conexionDB;
	        assertNotNull(connection);
	        assertFalse(connectionIsClosed(connection));
	    }

	    private boolean connectionIsClosed(Connection connection) {
	        try {
	            return connection == null || connection.isClosed();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return true;
	        }
	    }
	    
	    @Test
	    public void testConsultaParticipantesPorId() {
	        
	        String consulta = "SELECT * FROM Participante where email = ?";
	        
	        try (Connection connection = DataBaseConnection.establecerConexion();
	             PreparedStatement preparedStatement = connection.prepareStatement(consulta)) {

	            // Configurar parámetros según tu consulta real
	            preparedStatement.setString(1, "locura.87@gmail.com");

	            // Ejecutar la consulta
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                // Verificar que haya al menos una fila en el resultado
	                assertTrue(resultSet.next());

	                // Obtener el valor del campo
	                String valorCampo = resultSet.getString("nombre");

	                // Verificar que el valor del campo sea el esperado
	                assertEquals("Miguel Ohara", valorCampo);

	                // Verificar que no haya más filas en el resultado
	                assertFalse(resultSet.next());
	            }
	        } catch (SQLException e) {
	            fail("Error al ejecutar la consulta: " + e.getMessage());
	        }
	    }

}
