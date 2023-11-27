package persona;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import pronostico.Pronostico;
@Getter
@Setter
public class Participante {
	private static int contadorId = 0;
	private String nombre;
	private int participanteId;
	private int puntosDelParticipante = 0;
	private int cantidadAciertos = 0;
	public static List<Participante> listadoParticipantes = new ArrayList<>();
	private List<Pronostico> listadoDePronosticosParticipante = new ArrayList<>();
	
	public Participante(String nombre) {
		this.nombre = nombre;
		this.participanteId = ++contadorId;
		
	}
	
	//el nombre de usuario va a ser UNICO.
	public static Participante agregarParticipante(String nombre) {
		for(Participante participante: listadoParticipantes) {
			if(participante.nombre.equals(nombre)) {
				return participante;
			}
			}
		Participante nuevoParticipante = new Participante(nombre);
		listadoParticipantes.add(nuevoParticipante);
		return nuevoParticipante;
	}
	
	public void agregarPronosticoParticipante(Pronostico pronostico) {
		listadoDePronosticosParticipante.add(pronostico);
	}
	
	public String getListaPronosticosDeParticipante(){
		String detallePronostico = "";
		for(Pronostico pronosticoPorParticipante: listadoDePronosticosParticipante) {
			detallePronostico += pronosticoPorParticipante.toString() + "\n";
		}
		return detallePronostico;
	}
	
	public static void detallarPuntajesPorJugador() {
		for(Participante participante: listadoParticipantes) {
			System.out.println("El usuario " + participante.getNombre() + " obtuvo: " + participante.getPuntosDelParticipante() + " puntos" + " con un total de: " + participante.getCantidadAciertos() + " aciertos");
		}
	}

	

	public void setPuntosDelParticipante(int puntosDelParticipante) {
		this.puntosDelParticipante += puntosDelParticipante;
	}
	
	public void setCantidadAciertos(int cantidadAciertos) {
		this.cantidadAciertos += cantidadAciertos;
	}

	@Override
	public String toString() {
		return "Listado de pronostico del usuario " + this.nombre + ":" + "\n" + getListaPronosticosDeParticipante() ; 
	}
	
	
}
