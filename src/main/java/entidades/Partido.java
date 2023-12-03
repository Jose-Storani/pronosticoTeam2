package entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.partido.PartidoManagerDB;
import utils.posiblesResultados;

public class Partido {
	
	private static PartidoManagerDB manager = new PartidoManagerDB("partido");
	private Equipo equipo1;
	private Equipo equipo2;
	private int golesEquipo1;
	private int golesEquipo2;
	private int partidoId;
	private posiblesResultados resultado;
	public static List<Partido> listadoPartidos = new ArrayList<>();
	
	public Partido(int id, Equipo equipo1,int golesEquipo1,Equipo equipo2, int golesEquipo2) {
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.golesEquipo1 = golesEquipo1;
		this.golesEquipo2 = golesEquipo2;
		this.partidoId = id;
		this.establecerResultadoPartido(this.partidoId);
	}
	
	public static void cargarPartidos() throws SQLException {
		try(ResultSet partidos = manager.getAll()){
			while(partidos.next()) {
				int partidoId = partidos.getInt("partido_id");
				int golesEquipo1 = partidos.getInt("goles_equipo_1");
				int golesEquipo2 = partidos.getInt("goles_equipo_2");
				Equipo equipo1 = Equipo.buscarEquipoPorId(partidos.getInt("equipo1_id"));
				Equipo equipo2 = Equipo.buscarEquipoPorId(partidos.getInt("equipo2_id"));
				instanciarPartido(partidoId, equipo1, golesEquipo1, equipo2, golesEquipo2);
				
				
			}
			manager.cerrarConsulta();
			if(!listadoPartidos.isEmpty()) {
				System.out.println("Carga de Partidos exitosa");
			}
			else {
				System.err.println("Falla en la carga de equipos desde DB");
			}
			
		}
		;
		
			
			
	}
	
	public static Partido buscarPartidoPorId(int partidoId) {
		for(Partido partido: listadoPartidos) {
			if(partido.getPartidoId() == partidoId) {
				
				return partido;
			}
			
		}
		return null;
	}
	
	public static Partido instanciarPartido(int id, Equipo equipo1,int golesEquipo1,Equipo equipo2, int golesEquipo2) {
		for(Partido partido : listadoPartidos) {
			if(partido.partidoId == id) return partido;
		}
		Partido nuevoPartido = new Partido(id,equipo1,golesEquipo1,equipo2,golesEquipo2);
		listadoPartidos.add(nuevoPartido);
		return nuevoPartido;
	}
	
	
	public posiblesResultados establecerResultadoPartido(int partidoId) {
		if(this.golesEquipo1 > this.golesEquipo2) {
			this.resultado = posiblesResultados.GANA1;
			//System.out.println(this.equipo1.getNombre() + " venció a " + this.equipo2.getNombre() + " " + this.golesEquipo1 + " a " + this.golesEquipo2);
			return resultado;
		}
		else if(this.golesEquipo1 < this.golesEquipo2) {
			this.resultado = posiblesResultados.GANA2;
			//System.out.println(this.equipo2.getNombre() + " venció a " + this.equipo1.getNombre() + " " + this.golesEquipo2 + " a " + this.golesEquipo1);
			return resultado;
		}
		else {
			this.resultado = posiblesResultados.EMPATE;
			//System.out.println("El partido entre " + this.equipo1.getNombre() + " y " + this.equipo2.getNombre() + " resultó en empate");
			return resultado;
		}
	}

	public static void mostrarPartidosConsola() {
		for(Partido partido: listadoPartidos) {
			System.out.println("Equipos: " + partido.getEquipo1().getNombre() + " vs " + partido.getEquipo2().getNombre() );
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
