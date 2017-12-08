package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Equipo;
import modelo.FichaDeInscripcion;
import modelo.Jugador;

public class GestionEquipo {

	
	private List<Equipo> equipos;
	private List<FichaDeInscripcion> fichaDeInscripciones;
	private List<Jugador> jugadores;
	
	

	public GestionEquipo() {
		
		equipos = new ArrayList<Equipo>();
		fichaDeInscripciones = new ArrayList<FichaDeInscripcion>();
		jugadores = new ArrayList<Jugador>();
	

	}

	public void agregarEquipo(FichaDeInscripcion fichaDeInscripcion,String nombreEquipo,int cantidadJugadores) {
		Equipo e = new Equipo(fichaDeInscripcion, nombreEquipo, cantidadJugadores);
		e.setFichaDeInscripcion(fichaDeInscripcion);
		e.setNombreEquipo(nombreEquipo);
		e.setCantidadJugadores(cantidadJugadores);
		
		equipos.add(e);

	}

	public List<Equipo> getEquipos() {
		return equipos;

	}

}
