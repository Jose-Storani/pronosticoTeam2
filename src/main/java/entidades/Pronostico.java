package entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.pronostico.PronosticoManagerDB;
import lombok.Getter;
import lombok.Setter;
import utils.posiblesResultados;
@Getter
@Setter
public class Pronostico {
	private static PronosticoManagerDB manager = new PronosticoManagerDB("pronostico");
	//static private int valorDelAcierto = 1; //consultarlo en la BD
	private Participante participante;
	private Partido partido;
	private int pronosticoId;
	private posiblesResultados resultadoPropuesto;
	public static List<Pronostico> listadoPronosticos = new ArrayList<>();
	
	public Pronostico(int partidoId, String resultadoPropuesto, Participante participante,int pronosticoId) {
		this.partido = Partido.buscarPartidoPorId(partidoId);
		this.resultadoPropuesto = posiblesResultados.valueOf(resultadoPropuesto);
		this.participante = participante;
		this.pronosticoId = pronosticoId;
		//this.determinarPuntos();
		
	}
	

	public static void cargarPronosticos() throws SQLException {
		ResultSet pronosticos = manager.getAll();
			while(pronosticos.next()) {
				int pronosticoId = pronosticos.getInt("id");
				int partidoId = pronosticos.getInt("partido_id");
				int participanteId = pronosticos.getInt("Participante_id");
				String resultadoPropuesto  = pronosticos.getString("resultado_propuesto");
				instanciarPronosticos(partidoId, resultadoPropuesto, Participante.buscarParticipantePorId(participanteId), pronosticoId);
				
			}
			manager.cerrarConsulta();
			if(!listadoPronosticos.isEmpty()) {
				System.out.println("Carga de Pronosticos Exitosa");
			}
		else {
			System.err.println("Fallo en la carga desde la BD de Pronosticos");
		}
		}
		
	
	@Override
	public String toString() {
		return this.resultadoPropuesto + " en el partido de " + this.partido.getEquipo1().getNombre() + " vs " + this.partido.getEquipo2().getNombre();
	}
	public int getPuntos() {
		System.out.println("Tu puntaje es de: " + participante.getPuntosDelParticipante() );
		return participante.getPuntosDelParticipante();
	}
	
	
	private static Pronostico instanciarPronosticos(int partidoId, String resultadoPropuesto, Participante participante, int pronosticoId ) {
		for(Pronostico pronostico: listadoPronosticos) {
			if(pronostico.pronosticoId == pronosticoId) {
				return pronostico;
			}
		}
		Pronostico nuevoPronostico = new Pronostico(partidoId,resultadoPropuesto,participante,pronosticoId);
		listadoPronosticos.add(nuevoPronostico);
		participante.agregarPronosticoParticipante(nuevoPronostico);
		return nuevoPronostico;
	}
	
	
	
}
