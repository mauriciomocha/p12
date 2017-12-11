package modelo;

import java.util.List;

public class Equipo {

	private Jugador jugador;
	private String nombreEquipo;
	private int cantidadJugadores;

	public Equipo(Jugador jugador, String nombreEquipo, int cantidadJugadores) {
		this.jugador = jugador;
		this.nombreEquipo = nombreEquipo;
		this.cantidadJugadores = cantidadJugadores;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
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

	public static List<Equipo> getTodos() {

		return null;
	}

	public String toString() {
		return "- " + nombreEquipo + " " + cantidadJugadores;
	}

}
