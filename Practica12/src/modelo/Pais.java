package modelo;

public class Pais {

	private String nombrePais;
	private Provincia provincia;
	private int problacion;

	public Pais(String nombrePais, Provincia provincia, int problacion) {

		this.nombrePais = nombrePais;
		this.provincia = provincia;
		this.problacion = problacion;
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
		return problacion;
	}

	public void setProblacion(int problacion) {
		this.problacion = problacion;
	}

}
