package modelo;

import java.util.List;

public class Resultado {

	private String puesto;
	private Atleta atleta;

	public Resultado(String puesto, Atleta atleta) {

		this.puesto = puesto;
		this.atleta = atleta;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
	public static List<Resultado> getTodos() {

		return null;
	}

	public String toString() {
		return "- " + puesto + " " + atleta;
	}

}
