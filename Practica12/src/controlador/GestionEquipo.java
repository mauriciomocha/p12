package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Equipo;
import modelo.FichaDeInscripcion;
import modelo.Jugador;

public class GestionEquipo {

	
	private List<Equipo> equipos;
	private List<FichaDeInscripcion> fichaDeInscripciones;
	private List<Jugador>jugadores;
	
	

	public GestionEquipo() {
		
		equipos = new ArrayList<Equipo>();
		fichaDeInscripciones = new ArrayList<FichaDeInscripcion>();
		jugadores = new ArrayList<Jugador>();
	

	}

	public void agregarEquipo(Jugador jugador,String nombreEquipo,int cantidadJugadores) {
		Equipo e = new Equipo(jugador, nombreEquipo, cantidadJugadores);
		e.setJugador(jugador);
		e.setNombreEquipo(nombreEquipo);
		e.setCantidadJugadores(cantidadJugadores);
		
		equipos.add(e);

	}

	public List<Equipo> getEquipos() {
		return equipos;

	}
	
	public void agregarFichaDeInscripcion(Jugador jugador, Equipo equipo, int dorsal, String nacionalidad) {
		FichaDeInscripcion f=new FichaDeInscripcion(jugador,equipo,dorsal,nacionalidad);
		f.setJugador(jugador);
		f.setEquipo(equipo);
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
	public boolean isCedulaValida(String cedula) throws Exception {

		try {
			int a= Integer.parseInt(cedula);
			}catch(NumberFormatException e){
				throw new Exception("Formato incorecto, cedula contiene caracteres");
		}
		if(cedula.length()!=10)
			throw new Exception("La cedula debe de tener 10 digitos");
			
		
		return true;
		

	}
	public List<Jugador> getJugadores(){
		return jugadores;

		
	}
	
}
