package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;



public class GestionPaciente {
	private List<Medico> medicos;
	private List<Consulta> consultas;
	private List<Paciente> pacientes;
	
	

	public GestionPaciente() {
		
		medicos = new ArrayList<Medico>();
		consultas = new ArrayList<Consulta>();
		pacientes = new ArrayList<Paciente>();
	

	}
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
	
	
	
	public List<Medico> getMedicos(){
		return medicos;
	}
	
	public void agregarConsulta(int hora, int numconsulta, int costoConsulta, Paciente paciente) {
		Consulta c=new Consulta(hora,numconsulta,costoConsulta,paciente);
		c.setHora(hora);
		c.setNumconsulta(numconsulta);
		c.setCostoConsulta(costoConsulta);
		c.setPaciente(paciente);
		
		consultas.add(c);
	}
	public List<Consulta> getConsultas(){
		return consultas;
	}
	
	
	public void agregarPaciente(String nombre, String apellido, String cedula, int edad) {
		Paciente p=new Paciente(nombre,apellido,cedula,edad);
		p.setNombre(nombre);
		p.setApellido(apellido);
		p.setCedula(cedula);
		p.setEdad(edad);
		pacientes.add(p);
		
	}
	
	
	public List<Paciente> getPacientes(){
		return pacientes;
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

}
