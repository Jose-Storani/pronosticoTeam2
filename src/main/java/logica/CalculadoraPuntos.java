package logica;

import java.util.Scanner;

import entidades.Participante;
import entidades.Partido;
import entidades.Pronostico;
import lombok.Getter;
import lombok.Setter;
import utils.posiblesResultados;
@Getter
@Setter
public class CalculadoraPuntos {
	//valor por defecto si no se configura
	private static int valorAcierto;
	
	public static void calcularPuntos() {
		for(Pronostico pronostico: Pronostico.listadoPronosticos) {
			compararResultados(pronostico.getPartido().getResultado(), pronostico.getResultadoPropuesto(), pronostico.getParticipante());
		}
		System.out.println("Puntajes establecidos con exito");
	}
	
	public static void setValorAcierto(int nuevoValor) {
		valorAcierto = nuevoValor;
	}

	public static void mostrarPuntosPorConsola() {
		
	}
	
	private static void compararResultados(posiblesResultados resultadoPartido, posiblesResultados resultadoPronostico, Participante participante) {
		if(resultadoPartido == resultadoPronostico) {
			participante.setPuntosDelParticipante(valorAcierto);
			participante.setCantidadAciertos(1);
		}
	}
	
	
}
	
