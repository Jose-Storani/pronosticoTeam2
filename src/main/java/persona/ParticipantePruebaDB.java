package persona;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.participante.participanteManagerDB;
public class ParticipantePruebaDB {
	private participanteManagerDB manager = new participanteManagerDB("Participante");
	
	public void mostrarParticipantes() throws SQLException {
		ResultSet participantes = manager.getAll();
		while(participantes.next()) {
			//obtener el valor de cada columna
			int idParticipante = participantes.getInt("id");
			String name = participantes.getString("nombre");
			String email = participantes.getString("email");
			
			System.out.println(idParticipante);
			System.out.println(name);
			System.out.println(email);
		
			System.out.println("--------------------------------------");
		}
	}
}
