package entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.participante.ParticipanteManagerDB;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Participante {
	private static ParticipanteManagerDB manager = new ParticipanteManagerDB("participante");
	private String nombre;
	private int participanteId;
	private String email;
	private int puntosDelParticipante = 0;
	private int cantidadAciertos = 0;
	public static List<Participante> listadoParticipantes = new ArrayList<>();
	private List<Pronostico> listadoDePronosticosParticipante = new ArrayList<>();

	public Participante(int id, String nombre, String email) {
		this.nombre = nombre;
		this.participanteId = id;
		this.email = email;

	}

	// carga de participantes
	public static void cargarParticipantes() throws SQLException {
		try (ResultSet participantes = manager.getAll()) {
			while (participantes.next()) {
				int id = participantes.getInt("id");
				String nombre = participantes.getString("nombre");
				String email = participantes.getString("email");
				agregarParticipante(id, nombre, email);

			}
			manager.cerrarConsulta();

			if (!listadoParticipantes.isEmpty()) {
				System.out.println("Carga de Participantes Exitosa");

			} else {
				System.err.println("Fallo en la carga de Participantes de la BD");
			}
		}
	}

	public static Participante agregarParticipante(int id, String nombre, String email) {
		for (Participante participante : listadoParticipantes) {
			if (participante.participanteId == id) {
				return participante;
			}
		}
		Participante nuevoParticipante = new Participante(id, nombre, email);
		listadoParticipantes.add(nuevoParticipante);

		return nuevoParticipante;
	}

	// busca participante por id dentro del listado
	public static Participante buscarParticipantePorId(int idParticipante) {
		for (Participante participante : listadoParticipantes) {
			if (participante.getParticipanteId() == idParticipante) {
				return participante;
			}
		}
		return null;
	}

	public static void mostrarParticipantes() {
		for (Participante participante : listadoParticipantes) {
			System.out.println("ID: " + participante.getParticipanteId());
			System.out.println("Nombre: " + participante.getNombre());
			System.out.println("Email: " + participante.getEmail());
			System.out.println("---------------------------------");
		}
	}

	public static void mostrarPronosticosPorParticipante() {
		for (Participante participante : listadoParticipantes) {
			System.out.println(participante);
		}
	}

	public void agregarPronosticoParticipante(Pronostico pronostico) {
		listadoDePronosticosParticipante.add(pronostico);
	}

	public String getListaPronosticosDeParticipante() {

		String detallePronostico = "";
		for (Pronostico pronosticoPorParticipante : listadoDePronosticosParticipante) {
			detallePronostico += pronosticoPorParticipante.toString() + "\n";
		}
		return detallePronostico;
	}

	public static void detallarPuntajesPorJugador() {
		for (Participante participante : listadoParticipantes) {
			System.out.println(
					"El usuario " + participante.getNombre() + " obtuvo: " + participante.getPuntosDelParticipante()
							+ " puntos" + " con un total de: " + participante.getCantidadAciertos() + " aciertos");
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
		return "Listado de pronostico del usuario " + this.nombre + ":" + "\n" + getListaPronosticosDeParticipante();
	}

}
