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
	
	public void agregarFichaDeInscripcion(Jugador jugador, int dorsal, String nacionalidad) {
		FichaDeInscripcion f=new FichaDeInscripcion(jugador,dorsal,nacionalidad);
		f.setJugador(jugador);
		f.setDorsal(dorsal);
		f.setNacionalidad(nacionalidad);
		
		fichaDeInscripciones.add(f);
		
		
	}
	
	public List<FichaDeInscripcion> getFichaDeInscripciones(){
		return fichaDeInscripciones;
	}

	public void agregarJugador(String nombre, String apellido, String cedula, int edad) {
		Jugador j=new Jugador(nombre,apellido,cedula,edad);
		j.setNombre(nombre);
		j.setApellido(apellido);
		j.setCedula(cedula);
		j.setEdad(edad);
		
		jugadores.add(j);
		
		
	}
	
	public List<Jugador> getJugadores(){
		return jugadores;

		
	}
	
}
