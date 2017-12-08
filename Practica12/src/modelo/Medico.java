package modelo;

public class Medico extends Persona {

	private String titulo;
	private Consulta consulta;

	public Medico(String nombre, String apellido, String cedula, int edad, String titulo, Consulta consulta) {
		super(nombre, apellido, cedula, edad);
		this.titulo = titulo;
		this.consulta = consulta;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

}
