package modelo;

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

}
