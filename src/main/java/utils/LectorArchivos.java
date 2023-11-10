package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import equipo.Equipo;
import partido.Partido;
import ronda.Ronda;

public class LectorArchivos {
public static void leerArchivo(String archivoParaLeer) {
	try(BufferedReader br = new BufferedReader(new FileReader(archivoParaLeer))){
		if(archivoParaLeer.equals("src/main/resources/partidos.txt")) {
			String linea;
			while((linea = br.readLine()) != null) {
				String[] partes = linea.split(" ");
				//
				//[0] Numero de Ronda
				//[1] Equipo1
				//[2] GolesEquipo1
				//[3] Equipo2
				//[4] GolesEquipo2
				
				Partido partido = new Partido(Equipo.buscarEquipoPorNombre(partes[1]),Integer.parseInt(partes[2]),Equipo.buscarEquipoPorNombre(partes[3]),Integer.parseInt(partes[4]));
				
				//chequeo si existe el numero de ronda dentro de la lista, de lo contrario, instanciaria cada vez que lea la columna de "RONDA".
				Ronda ronda = Ronda.getRondaPorNumero(Integer.parseInt(partes[0]));
				ronda.agregarPartidoRonda(partido);
				
			}
		}
		
	} 
	 catch (IOException e) {
		e.printStackTrace();
	}
}
}
