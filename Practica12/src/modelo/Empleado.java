package modelo;

import java.util.List;

public class Empleado extends Persona {

	public Empleado(String nombre, String apellido, String cedula, int edad) {
		super(nombre, apellido, cedula, edad);
		
		
		
	}
	public static List<Departamento> getTodos() {

		return null;
	}

	public String toString() {
		return "- " + nombre + " " + apellido;
	}
 

}
