package ronda;

import java.util.ArrayList;
import java.util.List;

import partido.Partido;

public class Ronda {
	private int numeroRonda;;
	private static List<Ronda> listadoRondas = new ArrayList<>(); 
	private List<Partido> partidosEnLaRonda = new ArrayList<>();
	
	public Ronda(int numeroRonda) {
		this.numeroRonda = numeroRonda;
	}
	
	
	
	public int getNumeroRonda() {
		return numeroRonda;
	}

	public void setNumeroRonda(int numeroRonda) {
		this.numeroRonda = numeroRonda;
	}


	
	public static List<Ronda> getListadoRondas() {
		return listadoRondas;
	}
	
	
	
	public static Ronda getRondaPorNumero(int numeroRonda) {
		for(Ronda ronda: listadoRondas) {
			if(ronda.getNumeroRonda() == numeroRonda) return ronda;
		}
		return new Ronda(numeroRonda); //si no encuentra la ronda especifica
		
	}
	
	public void agregarPartidoRonda(Partido partido) {
		partidosEnLaRonda.add(partido);
		System.out.println("El partido de: " + partido.getEquipo1().getNombre() + " vs " + partido.getEquipo2().getNombre() + " a sido agregado a la ronda " + this.numeroRonda);
	}
	
	
	
	
	
	
	
	
	
}
