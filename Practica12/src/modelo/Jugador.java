package modelo;

import java.util.List;

public class Jugador extends Persona {

	public Jugador(String nombre, String apellido, String cedula, int edad) {
		super(nombre, apellido, cedula, edad);

	}

	
	public static List<Jugador> getTodos() {

		return null;
	}

	public String toString() {
		return "- " + nombre + " " + apellido;
	}
	
}
