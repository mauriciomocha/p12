package modelo;

import java.util.List;

public class FichaDeInscripcion {

	private Jugador jugador;
	private Equipo equipo;
	private int dorsal;
	private String nacionalidad;

	public FichaDeInscripcion(Jugador jugador, Equipo equipo, int dorsal, String nacionalidad) {
		super();
		this.jugador = jugador;
		this.equipo = equipo;
		this.dorsal = dorsal;
		this.nacionalidad = nacionalidad;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
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
