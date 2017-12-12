package modelo;

public class Provincia {
	private Canton canton;
	private String nombreProvincia;
	private String region;

	public Provincia(String nombreProvincia, String region, Canton canton) {
		this.canton = canton;
		this.nombreProvincia = nombreProvincia;
		this.region = region;
	}

	public Canton getCanton() {
		return canton;
	}

	public void setCanton(Canton canton) {
		this.canton = canton;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String toString() {
		return nombreProvincia;
	}

}
