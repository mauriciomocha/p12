package modelo;

import java.util.List;

public class Atleta extends Persona {

	public Atleta(String nombre, String apellido, String cedula, int edad) {
		super(nombre, apellido, cedula, edad);
	}

	public static List<Resultado> getTodos() {

		return null;
	}

	public String toString() {
		return "- " + nombre + " " + apellido;
	}
}
