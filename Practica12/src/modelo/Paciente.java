package modelo;

import java.util.List;

public class Paciente extends Persona {

	public Paciente(String nombre, String apellido, String cedula, int edad) {
		super(nombre, apellido, cedula, edad);

	}

	public static List<Consulta> getTodos() {

		return null;
	}

	public String toString() {
		return "- " + nombre + " " + apellido;
	}

}
