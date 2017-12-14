package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Equipo;
import modelo.FichaDeInscripcion;
import modelo.Jugador;
import modelo.Persona;

public class GestionEquipo {

	
	private List<Equipo> equipos;
	private List<FichaDeInscripcion> fichaDeInscripciones;
	private List<Jugador>jugadores;
	
	
	private String pathEquipos= "src/archivos/Equipos.txt";
	private String pathFichaInscripcion="src/archivos/FichaInscripcion.txt";
	private String pathJugadores="src/archivos/Jugadores.txt";
	
	public GestionEquipo() {
		
		equipos = new ArrayList<Equipo>();
		fichaDeInscripciones = new ArrayList<FichaDeInscripcion>();
		jugadores = new ArrayList<Jugador>();
	

	}
	
	

	public void agregarEquipo(Jugador jugador,String nombreEquipo,int cantidadJugadores) {
		
		try {
			Equipo eq=new Equipo(jugador, nombreEquipo, cantidadJugadores);
			eq.setJugador(jugador);
			eq.setNombreEquipo(nombreEquipo);
			eq.setCantidadJugadores(cantidadJugadores);
			
			
			FileWriter archivo = new FileWriter(pathEquipos, true);
			BufferedWriter escribir = new BufferedWriter(archivo);
			String registro =
				
			"Nombre Jugador: " + eq.getJugador().getNombre()+";" + "\n"
			+ "Apellido Jugador: " + eq.getJugador().getApellido()+ "\n"
			+ "Nombre del Equipo: " + eq.getNombreEquipo() +"\n"
			+ " Cantidad de Jugadores: " + eq.getCantidadJugadores() + "\n";
			escribir.append(registro + "\n");
			escribir.append("DATOS DEL EQUIPO " + "\n");
			escribir.close();
			archivo.close();
			equipos.add(eq);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public String leerEquipo() throws IOException {
		String aux = " ";
		try {
			FileReader e = new FileReader(pathEquipos);
			BufferedReader equ = new BufferedReader(e);
			String linea = "";
			while (linea != null) {
				linea = equ.readLine();
				aux = aux + "" + linea + "\n";

			}
			equ.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return aux;
	}
	
	
	/*public void agregarEquipo(Jugador jugador,String nombreEquipo,int cantidadJugadores) {
		Equipo e = new Equipo(jugador, nombreEquipo, cantidadJugadores);
		e.setJugador(jugador);
		e.setNombreEquipo(nombreEquipo);
		e.setCantidadJugadores(cantidadJugadores);
		
		equipos.add(e);

	}
*/
	public List<Equipo> getEquipos() {
		return equipos;

	}
	
public void agregarFichaDeInscripcion(Jugador jugador, Equipo equipo, int dorsal, String nacionalidad) {
		
		try {
			FichaDeInscripcion f=new FichaDeInscripcion(jugador,equipo,dorsal,nacionalidad);
			f.setJugador(jugador);
			f.setEquipo(equipo);
			f.setDorsal(dorsal);
			f.setNacionalidad(nacionalidad);
			
			
			FileWriter archivo = new FileWriter(pathFichaInscripcion, true);
			BufferedWriter escribir = new BufferedWriter(archivo);
			String registro =
				
			"Nombre Jugador: " + f.getJugador().getNombre()+";" + "\n"
			+ "Apellido Jugador: " + f.getJugador().getApellido()+ "\n"
			+ "Nombre del Equipo: " + f.getEquipo().getNombreEquipo() +"\n"
			+ " Cantidad de Jugadores: " + f.getDorsal() + "\n"
			+ " Nacionalidad: " + f.getNacionalidad() + "\n";
			escribir.append(registro + "\n");
			escribir.append("DATOS DE LA FICHA DE INSCRIPCION " + "\n");
			escribir.close();
			archivo.close();
			fichaDeInscripciones.add(f);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public String leerFichaDeInscripcion() throws IOException {
		String aux = " ";
		try {
			FileReader e = new FileReader(pathFichaInscripcion);
			BufferedReader equ = new BufferedReader(e);
			String linea = "";
			while (linea != null) {
				linea = equ.readLine();
				aux = aux + "" + linea + "\n";

			}
			equ.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return aux;
	}
	
	
	/*public void agregarFichaDeInscripcion(Jugador jugador, Equipo equipo, int dorsal, String nacionalidad) {
		FichaDeInscripcion f=new FichaDeInscripcion(jugador,equipo,dorsal,nacionalidad);
		f.setJugador(jugador);
		f.setEquipo(equipo);
		f.setDorsal(dorsal);
		f.setNacionalidad(nacionalidad);
		
		fichaDeInscripciones.add(f);
		
		
	}*/
	
	public List<FichaDeInscripcion> getFichaDeInscripciones(){
		return fichaDeInscripciones;
	}

	
	
	
	
	
	
	/*
	public void agregarJugador(String nombre, String apellido, String cedula, int edad) {
		Jugador j=new Jugador(nombre,apellido,cedula,edad);
		j.setNombre(nombre);
		j.setApellido(apellido);
		j.setCedula(cedula);
		j.setEdad(edad);
		
		jugadores.add(j);
		
		
	}*/
	public void agregarJugador(String nombre, String apellido, String cedula, int edad) {
		
		try {
			Jugador j=new Jugador(nombre,apellido,cedula,edad);
			j.setNombre(nombre);
			j.setApellido(apellido);
			j.setCedula(cedula);
			
			
			FileWriter archivo = new FileWriter(pathJugadores, true);
			BufferedWriter escribir = new BufferedWriter(archivo);
			String registro =
				
			"Nombre Jugador: " + j.getNombre()+";" + "\n"
			+ "Apellido Jugador: " + j.getApellido()+ "\n"
			+ "Cedula del Jugador: " + j.getCedula()+ "\n"
			+ "Edad del Jugador: " + j.getEdad() + "\n";
			escribir.append(registro + "\n");
			escribir.append("DATOS DEL JUGADOR " + "\n");
			escribir.close();
			archivo.close();
			jugadores.add(j);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public String leerJugador() throws IOException {
		String aux = " ";
		try {
			FileReader e = new FileReader(pathJugadores);
			BufferedReader equ = new BufferedReader(e);
			String linea = "";
			while (linea != null) {
				linea = equ.readLine();
				aux = aux + "" + linea + "\n";

			}
			equ.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return aux;
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
