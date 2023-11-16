package pronostico;

import partido.Partido;
import persona.Participante;
import utils.posiblesResultados;

public class Pronostico {
	static private int valorDelAcierto = 1;
	private Participante participante;
	//private static int puntos;
	private Partido partido;
	private posiblesResultados resultadoPropuesto;
	
	public Pronostico(int partidoId, String resultadoPropuesto, Participante participante) {
		this.partido = Partido.buscarPartidoPorId(partidoId);
		this.resultadoPropuesto = posiblesResultados.valueOf(resultadoPropuesto);
		this.participante = participante;
		this.determinarPuntos();
		
	}
	
	private void determinarPuntos() {
		if(this.partido.getResultado() == this.resultadoPropuesto) {
			participante.setPuntosDelParticipante(valorDelAcierto);
			participante.setCantidadAciertos(1);
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
	
	
	
	
	
	
}
