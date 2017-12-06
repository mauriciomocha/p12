package modelo;

public class Departamento {
	
	private Empleado empleado;
	private String nombreDepartamento;

	public Departamento(Empleado empleado, String nombreDepartamento) {

		this.empleado = empleado;
		this.nombreDepartamento = nombreDepartamento;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

}
