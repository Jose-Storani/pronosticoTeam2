package main;

import dao.DataBaseConnection;
import view.MenuInicial;

public class Initializer {

	public static void main(String[] args) {
		DataBaseConnection.establecerConexion();

		
		MenuInicial.mostrarMenuInicial();
		
		
		
}


}