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
	private static int valorAcierto = 1;
	private static int valorPuntoExtra = 0;
	
	public static void calcularPuntos() {
		for(Pronostico pronostico: Pronostico.listadoPronosticos) {
			compararResultados(pronostico.getPartido().getResultado(), pronostico.getResultadoPropuesto(), pronostico.getParticipante());
		}
		System.out.println("Puntajes establecidos con exito");
	}
	
	public static void setValorAcierto(int nuevoValor) {
		valorAcierto = nuevoValor;
	}
	
	public static void setValorPuntoExtra (int nuevoValor) {
		valorPuntoExtra = nuevoValor;
	}

	public static void mostrarPuntosPorConsola() {
		for (Participante participante : Participante.listadoParticipantes) {
			System.out.println(
					"El usuario " + participante.getNombre() + " obtuvo: " + participante.getPuntosDelParticipante()
							+ " puntos" + " con un total de: " + participante.getCantidadAciertos() + " aciertos");
		}
	}
	
	private static void compararResultados(posiblesResultados resultadoPartido, posiblesResultados resultadoPronostico, Participante participante) {
		
		if(resultadoPartido != resultadoPronostico) participante.setContadorRacha(0);
		if(resultadoPartido == resultadoPronostico) {
			participante.setPuntosDelParticipante(valorAcierto);
			participante.setCantidadAciertos(1);
			participante.setContadorRacha(participante.getContadorRacha() + 1);
			if(participante.getContadorRacha() >= 3) {
				System.out.println(participante.getNombre() + " lleva una racha de " + participante.getContadorRacha() + " aciertos");
				participante.setPuntosDelParticipante(valorPuntoExtra);
			}
		}
	}
	
	
}
	
