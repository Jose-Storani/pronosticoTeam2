package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import equipo.Equipo;
import partido.Partido;
import persona.Participante;
import pronostico.Pronostico;
import ronda.Ronda;

public class LectorArchivos {
	public static void leerArchivo(String archivoParaLeer) {
		try (BufferedReader br = new BufferedReader(new FileReader(archivoParaLeer))) {

			String linea;
			// salto la primer linea de archivo csv que son los encabezados
			br.readLine();
			while ((linea = br.readLine()) != null) {
				String[] partes = linea.split(",");
				// salto la iteracion en caso de lineas vacias o con solo comas
				if (linea.trim().isEmpty() || linea.trim().equals(",")) {
					System.out.println("Linea vacia o solo comas: " + linea);
					continue;
				}
				
				
				//Verifico que la cantidad de campos a leer del archivo sea la correcta.
				if (partes.length >= 5) {
					if (archivoParaLeer.equals("src/main/resources/resultadoPartidos.csv")) {
						//
						// [0] Numero de Ronda
						// [1] Nombre del Equipo1
						// [2] GolesEquipo1
						// [3] Nombre del Equipo2
						// [4] GolesEquipo2

						Partido partido = new Partido(Equipo.buscarEquipoPorNombre(partes[1]),
								Integer.parseInt(partes[2]), Equipo.buscarEquipoPorNombre(partes[3]),
								Integer.parseInt(partes[4]));
						// Agrego el partido al listado general de partidos
						Partido.listadoPartidos.add(partido);

						// chequeo si existe el numero de ronda dentro de la lista, de lo contrario,
						// instanciaria cada vez que lea la columna de "RONDA".
						Ronda ronda = Ronda.getRondaPorNumero(Integer.parseInt(partes[0]));
						ronda.agregarPartidoRonda(partido);

					} else {

						// [0] Participante
						// [1] PartidoID
						// [2] Equipo1
						// [3] Resultado Propuesto
						// [4]Equipo2
						
						//si el participante ya existe dentro de la lista, no se instancia, solo se devuelve el ya instanciado previamente.
						Participante participante = Participante.agregarParticipante(partes[0]);
						
						
						Pronostico pronostico = new Pronostico(Integer.parseInt(partes[1]), partes[3],participante);
		
						
						//se agrega a la lista de cada participante, el pronostico correspondiente.
						participante.agregarPronosticoParticipante(pronostico);
						

					}
					

				} else {
					System.out.println("Linea mal formateada: " + linea);
				}

			}
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
