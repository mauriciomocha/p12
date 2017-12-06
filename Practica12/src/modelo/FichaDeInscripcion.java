package modelo;

public class FichaDeInscripcion {

	private Jugador jugador;
	private int dorsal;
	private String nacionalidad;

	public FichaDeInscripcion(Jugador jugador, int dorsal, String nacionalidad) {

		this.jugador = jugador;
		this.dorsal = dorsal;
		this.nacionalidad = nacionalidad;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

}
