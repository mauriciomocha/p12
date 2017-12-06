package modelo;

public class Equipo {

	private FichaDeInscripcion fichaDeInscripcion;
	private String nombreEquipo;
	private int cantidadJugadores;

	public Equipo(FichaDeInscripcion fichaDeInscripcion, String nombreEquipo, int cantidadJugadores) {
		this.fichaDeInscripcion = fichaDeInscripcion;
		this.nombreEquipo = nombreEquipo;
		this.cantidadJugadores = cantidadJugadores;
	}

	public FichaDeInscripcion getFichaDeInscripcion() {
		return fichaDeInscripcion;
	}

	public void setFichaDeInscripcion(FichaDeInscripcion fichaDeInscripcion) {
		this.fichaDeInscripcion = fichaDeInscripcion;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public int getCantidadJugadores() {
		return cantidadJugadores;
	}

	public void setCantidadJugadores(int cantidadJugadores) {
		this.cantidadJugadores = cantidadJugadores;
	}

}
