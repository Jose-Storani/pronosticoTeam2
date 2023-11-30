package equipo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.equipo.EquipoManagerDB;

public class Equipo {
	private static EquipoManagerDB manager = new EquipoManagerDB("equipo");
	private static List<Equipo> listaEquipos = new ArrayList<>();
	private String nombre;
	private int id;
	public Equipo(String nombre,int id) {
		this.nombre = nombre;
		this.id = id;
	}
	
	
	
	public static void cargarEquipos() throws SQLException {
		ResultSet equipos = manager.getAll();
		
			while(equipos.next()) {
				int id = equipos.getInt("equipo_id");
				String nombre = equipos.getString("nombre");
				instanciarEquipo(nombre, id);
			}
			if(!listaEquipos.isEmpty()) {
				System.out.println("Carga de Equipos Exitosa");
			}
			
		else System.err.println("Fallo en la carga desde la BD de Equipos");
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public static Equipo instanciarEquipo(String nombreEquipo,int id) {
		//Solo instanciar en caso de que no exista ya un equipo en la lista
		for(Equipo equipo: listaEquipos) {
			//Cambio la primer letra para que siempre sea mayuscula
			if(equipo.getId() == id) return equipo;
	}
		Equipo nuevoEquipo = new Equipo(nombreEquipo, id);
		listaEquipos.add(nuevoEquipo);
		return nuevoEquipo;
	 
	
}
	public static Equipo buscarEquipoPorId(int id) {
		for(Equipo equipo: listaEquipos) {
			//Cambio la primer letra para que siempre sea mayuscula
			if(equipo.getId() == id) return equipo;
	}
		return null;
	}
};
