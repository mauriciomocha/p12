package modelo;

public class Empresa {
	private Departamento departamento;
	private String nombre;
	private String direccion;

	public Empresa(Departamento departamento, String nombre, String direccion) {
		this.departamento = departamento;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
