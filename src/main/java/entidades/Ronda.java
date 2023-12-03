package entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ronda.RondaManagerDB;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ronda {
	private static RondaManagerDB manager = new RondaManagerDB("ronda");
	private int numeroRonda;
	private static List<Ronda> listadoRondas = new ArrayList<>();
	private List<Partido> partidosEnLaRonda = new ArrayList<>();

	public Ronda(int numeroRonda) {
		this.numeroRonda = numeroRonda;
	}

	public static void cargarRondas() throws SQLException {
		try (ResultSet rondas = manager.getAll()) {
			while (rondas.next()) {
				int numeroRonda = rondas.getInt("numero_ronda");
				int partidoId = rondas.getInt("partido_id");
				instanciarRonda(numeroRonda, partidoId);
			}
			manager.cerrarConsulta();

			if (!listadoRondas.isEmpty()) {
				//System.out.println("Carga de Rondas exitosa");
			} else {
				System.err.println("Fallo en la carga de rondas desde DB");
			}
		}

	}
	
	public static void mostrarRondas() {
		for (Ronda ronda: listadoRondas) {
			System.out.println(ronda.numeroRonda);
		}
	}

	public static void mostrarPartidosPorRonda(int numeroRonda) {
		String dataConsola;
		if (numeroRonda != 0) {
			dataConsola = "Resultados de los partidos de la ronda: " + numeroRonda + "\n";
			for (Ronda ronda : listadoRondas) {
				if (ronda.getNumeroRonda() == numeroRonda) {
					for (Partido partido : ronda.partidosEnLaRonda) {
						dataConsola += partido.getEquipo1().getNombre() + " vs " + partido.getEquipo2().getNombre()
								+ ": " + partido.getGolesEquipo1() + " a " + partido.getGolesEquipo2() + "\n";
					}
				}
			}
			System.out.println(dataConsola);
		}
	}

	public static void mostrarTodasLasRondas() {
		for (Ronda ronda : listadoRondas) {
			mostrarPartidosPorRonda(ronda.numeroRonda);
		}
	}

	public static void instanciarRonda(int numeroRonda, int partidoId) {
		boolean existeRonda = false;
	    for (Ronda ronda : listadoRondas) {
	        if (ronda.getNumeroRonda() == numeroRonda) {
	            existeRonda = true;
	            ronda.agregarPartidoRonda(Partido.buscarPartidoPorId(partidoId));
	            break; 
	        }
	    }
	    if (!existeRonda) {
	        Ronda nuevaRonda = new Ronda(numeroRonda);
	        nuevaRonda.agregarPartidoRonda(Partido.buscarPartidoPorId(partidoId));
	        listadoRondas.add(nuevaRonda);
	    }
	}

	public void agregarPartidoRonda(Partido partido) {
		partidosEnLaRonda.add(partido);
	}

}
