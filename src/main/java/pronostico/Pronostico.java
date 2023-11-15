package pronostico;

import partido.Partido;
import utils.posiblesResultados;

public class Pronostico {
	private static int puntos;
	private Partido partido;
	private posiblesResultados resultadoPropuesto;
	
	public Pronostico(int partidoId, String resultadoPropuesto) {
		this.partido = Partido.buscarPartidoPorId(partidoId);
		this.resultadoPropuesto = posiblesResultados.valueOf(resultadoPropuesto);
		this.determinarPuntos();
		
	}
	
	private void determinarPuntos() {
		if(this.partido.getResultado() == this.resultadoPropuesto) {
			puntos++;
			
		}

	}
	
	public static int getPuntos() {
		System.out.println("Tu puntaje es de: " + puntos);
		return puntos;
	}
	
	
}
