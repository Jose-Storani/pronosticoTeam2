package partido;

import java.util.ArrayList;
import java.util.List;

import equipo.Equipo;
import utils.posiblesResultados;

public class Partido {
	private static int contadorId =0;
	private Equipo equipo1;
	private Equipo equipo2;
	private int golesEquipo1;
	private int golesEquipo2;
	private int partidoId;
	private posiblesResultados resultado;
	public static List<Partido> listadoPartidos = new ArrayList<>();
	
	
	
	public Partido(Equipo equipo1,int golesEquipo1,Equipo equipo2, int golesEquipo2) {
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.golesEquipo1 = golesEquipo1;
		this.golesEquipo2 = golesEquipo2;
		this.partidoId = ++contadorId;
		this.establecerResultadoPartido(this.partidoId);
		
	}
	
	public static Partido buscarPartidoPorId(int partidoId) {
		for(Partido partido: listadoPartidos) {
			if(partido.getPartidoId() == partidoId) {
				return partido;
			}
			
		}
		return null;
	}
	
	
	public posiblesResultados establecerResultadoPartido(int partidoId) {
		if(this.golesEquipo1 > this.golesEquipo2) {
			this.resultado = posiblesResultados.GANA_EQUIPO_1;
			//System.out.println(this.equipo1.getNombre() + " venció a " + this.equipo2.getNombre() + " " + this.golesEquipo1 + " a " + this.golesEquipo2);
			return resultado;
		}
		else if(this.golesEquipo1 < this.golesEquipo2) {
			this.resultado = posiblesResultados.GANA_EQUIPO_2;
			//System.out.println(this.equipo2.getNombre() + " venció a " + this.equipo1.getNombre() + " " + this.golesEquipo2 + " a " + this.golesEquipo1);
			return resultado;
		}
		else {
			this.resultado = posiblesResultados.EMPATE;
			//System.out.println("El partido entre " + this.equipo1.getNombre() + " y " + this.equipo2.getNombre() + " resultó en empate");
			return resultado;
		}
	}

	

	public Equipo getEquipo1() {
		return this.equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	
	public Equipo getEquipo2() {
		return this.equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	
	public int getGolesEquipo1() {
		return golesEquipo1;
	}

	public void setGolesEquipo1(int golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}

	public int getGolesEquipo2() {
		return golesEquipo2;
	}

	public void setGolesEquipo2(int golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}


	public int getPartidoId() {
		return partidoId;
	}


	public void setPartidoId(int partidoId) {
		this.partidoId = partidoId;
	}


	public posiblesResultados getResultado() {
		return resultado;
	}


	
	
	
	
	
}
