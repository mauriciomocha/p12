package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Departamento;
import modelo.Empleado;
import modelo.Empresa;



public class GestionEmpresa {
	private List<Empresa> empresas;
	private List<Departamento> departamentos;
	private List<Empleado> empleados;
	
	

	public GestionEmpresa() {
		
		empresas = new ArrayList<Empresa>();
		departamentos = new ArrayList<Departamento>();
		empleados = new ArrayList<Empleado>();
	

	}
	public void agregarEmpresa(String nombre, String direccion, Departamento departamento) {
		Empresa e=new Empresa(departamento, nombre, direccion);
		e.setNombre(nombre);
		e.setDireccion(direccion);
		e.setDepartamento(departamento);
		empresas.add(e);
		
		
	}
	
	
	
	public List<Empresa> getEmpresas(){
		return empresas;
	}
	
	public void agregarDepartamento(String nombreDepartamento,Empleado empleado) {
		Departamento d=new Departamento(empleado, nombreDepartamento);
		d.setNombreDepartamento(nombreDepartamento);
		d.setEmpleado(empleado);
		departamentos.add(d);
	}
	public List<Departamento> getDepartamentos(){
		return departamentos;
	}
	
	
	public void agregarEmpleado(String nombre, String apellido, String cedula, int edad) {
		Empleado em=new Empleado(nombre,apellido,cedula,edad);
		em.setNombre(nombre);
		em.setApellido(apellido);
		em.setCedula(cedula);
		em.setEdad(edad);
		empleados.add(em);
		
	}
	
	
	public List<Empleado> getEmpleados(){
		return empleados;
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
