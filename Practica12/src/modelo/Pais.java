package modelo;

public class Pais {

	private String nombrePais;
	private Provincia provincia;
	private int poblacion;

	public Pais(String nombrePais, int poblacion, Provincia provincia) {

		this.nombrePais = nombrePais;
		this.provincia = provincia;
		this.poblacion = poblacion;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public int getProblacion() {
		return poblacion;
	}

	public void setProblacion(int problacion) {
		this.poblacion = problacion;
	}

}
