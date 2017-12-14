package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Consulta;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Medico;
import modelo.Paciente;



public class GestionPaciente {
	private List<Medico> medicos;
	private List<Consulta> consultas;
	private List<Paciente> pacientes;
	
		
	private String pathPacientes = "src/archivos/Pacientes.txt";
	private String pathMedicos = "src/archivos/Medicos.txt";
	private String pathConsultas = "src/archivos/Concultas.txt";
	

	public GestionPaciente() {
		
		medicos = new ArrayList<Medico>();
		consultas = new ArrayList<Consulta>();
		pacientes = new ArrayList<Paciente>();
	

	}
	/*
	public void agregarMedico(String nombre, String apellido, String cedula, int edad, String titulo, Consulta consulta) {
		Medico m=new Medico(nombre,apellido,cedula,edad,titulo,consulta);
		m.setNombre(nombre);
		m.setApellido(apellido);
		m.setCedula(cedula);
		m.setEdad(edad);
		m.setTitulo(titulo);
		m.setConsulta(consulta);
		medicos.add(m);
		
		
	}
	*/
	
	
	public void agregarMedico(String nombre, String apellido, String cedula, int edad, String titulo, Consulta consulta) {
		
		
		try {
			Medico m=new Medico(nombre,apellido,cedula,edad,titulo,consulta);
			m.setNombre(nombre);
			m.setApellido(apellido);
			m.setCedula(cedula);
			m.setEdad(edad);
			m.setTitulo(titulo);
			m.setConsulta(consulta);
		
			
			
			FileWriter archivo = new FileWriter(pathMedicos, true);
			BufferedWriter escribir = new BufferedWriter(archivo);
			String registro =
				
			"Nombre Medico: " + m.getNombre() + "\n"
			+ "Apellido Medico: " + m.getApellido()+ "\n"
			+ "Cedula del Medico: " + m.getCedula() +"\n"
			+ "Titulo del Medico: " + m.getTitulo() +"\n"
			+ "Hora de la Consulta: " + m.getConsulta().getHora() +"\n"
			+ "Costo de la Consulta: " + m.getConsulta().getCostoConsulta() +"\n"
			+ " Edad del Medico " + m.getEdad() + "\n";
			escribir.append(registro + "\n");
			escribir.append("DATOS DEL Medico" + "\n");
			escribir.close();
			archivo.close();
			medicos.add(m);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public String leerMedico() throws IOException {
		String aux = " ";
		try {
			FileReader e = new FileReader(pathMedicos);
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
	
	
	
	public List<Medico> getMedicos(){
		return medicos;
	}
	
	/*public void agregarConsulta(int hora, int numconsulta, int costoConsulta, Paciente paciente) {
		Consulta c=new Consulta(hora,numconsulta,costoConsulta,paciente);
		c.setHora(hora);
		c.setNumconsulta(numconsulta);
		c.setCostoConsulta(costoConsulta);
		c.setPaciente(paciente);
		
		consultas.add(c);
	}*/
	
	
	
	
	public void agregarConsulta(int hora, int numconsulta, int costoConsulta, Paciente paciente)  {
		
		
		try {
			Consulta c=new Consulta(hora,numconsulta,costoConsulta,paciente);
			c.setHora(hora);
			c.setNumconsulta(numconsulta);
			c.setCostoConsulta(costoConsulta);
			c.setPaciente(paciente);
			
			
			FileWriter archivo = new FileWriter(pathConsultas, true);
			BufferedWriter escribir = new BufferedWriter(archivo);
			String registro =
				
			"Hora de la consulta: " + c.getHora() + "\n"
			+ "numConsulta: " + c.getNumconsulta()+ "\n"
			+ "Costo de la consulta: " + c.getCostoConsulta() +"\n"
			+ "Nombre del Paciente: " + c.getPaciente().getNombre() +"\n"
			+ "Apellido del Paciente: " + c.getPaciente().getApellido() +"\n"
			+ "Cedula del Paciente: " + c.getPaciente().getCedula()+"\n";
			escribir.append(registro + "\n");
			escribir.append("DATOS DE LA CONSULTA" + "\n");
			escribir.close();
			archivo.close();
			consultas.add(c);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public String leerConsulta() throws IOException {
		String aux = " ";
		try {
			FileReader e = new FileReader(pathConsultas);
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
	
	
	
	
	
	public List<Consulta> getConsultas(){
		return consultas;
	}
	
	
	/*
	
	public void agregarPaciente(String nombre, String apellido, String cedula, int edad) {
		Paciente p=new Paciente(nombre,apellido,cedula,edad);
		p.setNombre(nombre);
		p.setApellido(apellido);
		p.setCedula(cedula);
		p.setEdad(edad);
		pacientes.add(p);
		
	}*/
	
	
	
	public void agregarPaciente(String nombre, String apellido, String cedula, int edad)   {
		
		
		try {
			Paciente p=new Paciente(nombre,apellido,cedula,edad);
			p.setNombre(nombre);
			p.setApellido(apellido);
			p.setCedula(cedula);
			p.setEdad(edad);
			
			
			
			FileWriter archivo = new FileWriter(pathPacientes, true);
			BufferedWriter escribir = new BufferedWriter(archivo);
			String registro =
				
			"Nombre del Paciente: " + p.getNombre() + "\n"
			+ "Apellido del Paciente: " + p.getApellido()+ "\n"
			+ "Cedula del Paciente: " + p.getCedula() +"\n"
			+ "Edad del Paciente: " + p.getEdad() +"\n";
			escribir.append(registro + "\n");
			escribir.append("DATOS DEL PACIENTE" + "\n");
			escribir.close();
			archivo.close();
			pacientes.add(p);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public String leerPaciente() throws IOException {
		String aux = " ";
		try {
			FileReader e = new FileReader(pathPacientes);
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
	public List<Paciente> getPacientes(){
		return pacientes;
	}
	
}
