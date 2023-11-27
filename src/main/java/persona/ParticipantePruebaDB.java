package persona;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.participante.participanteManagerDB;
public class ParticipantePruebaDB {
	private participanteManagerDB manager = new participanteManagerDB("participante");
	
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
	
	public void mostrarParticipantePorID(int id) throws SQLException {
		ResultSet participante = manager.getById(id);
		while(participante.next()) {
			String name = participante.getString("nombre");
			String email = participante.getString("email");
			
			System.out.println(name);
			System.out.println(email);
		}
		
		
	}
}
