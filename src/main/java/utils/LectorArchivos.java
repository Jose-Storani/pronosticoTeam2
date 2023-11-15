package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import equipo.Equipo;
import partido.Partido;
import pronostico.Pronostico;
import ronda.Ronda;

public class LectorArchivos {
	public static void leerArchivo(String archivoParaLeer) {
		try (BufferedReader br = new BufferedReader(new FileReader(archivoParaLeer))) {

			String linea;
			while ((linea = br.readLine()) != null) {
				String[] partes = linea.split(" ");

				if (archivoParaLeer.equals("src/main/resources/partidos.txt")) {
					//
					// [0] Numero de Ronda
					// [1] Equipo1
					// [2] GolesEquipo1
					// [3] Equipo2
					// [4] GolesEquipo2

					Partido partido = new Partido(Equipo.buscarEquipoPorNombre(partes[1]), Integer.parseInt(partes[2]),
							Equipo.buscarEquipoPorNombre(partes[3]), Integer.parseInt(partes[4]));
					//Agrego el partido al listado general de partidos
					Partido.listadoPartidos.add(partido);

					// chequeo si existe el numero de ronda dentro de la lista, de lo contrario,
					// instanciaria cada vez que lea la columna de "RONDA".
					Ronda ronda = Ronda.getRondaPorNumero(Integer.parseInt(partes[0]));
					ronda.agregarPartidoRonda(partido);
				}

				else {
					//[0] PartidoID
					//[1] Equipo1
					//[2] Resultado Propuesto
					//[3] Equipo2
					
					Pronostico pronostico = new Pronostico(Integer.parseInt(partes[0]), partes[2]);
					
					
					
					
					

				}
			}
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
