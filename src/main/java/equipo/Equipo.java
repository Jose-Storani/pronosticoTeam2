package equipo;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
	private static List<Equipo> listaEquipos = new ArrayList<>();
	private String nombre;
	private String id;
	public Equipo(String nombre) {
		this.nombre = nombre;
		
	}
	
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public static Equipo buscarEquipoPorNombre(String nombreEquipo) {
		//Solo instanciar en caso de que no exista ya un equipo en la lista
		for(Equipo equipo: listaEquipos) {
			//Cambio la primer letra para que siempre sea mayuscula
			if(equipo.getNombre() == nombreEquipo.substring(0,1).toUpperCase()+ nombreEquipo.substring(1)) return equipo;
	}
		return new Equipo(nombreEquipo);
	 
	
}
};
