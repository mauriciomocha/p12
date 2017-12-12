package modelo;

public class Canton {

	private String nombreCanton;
	private int codigoPostal;

	public Canton(String nombreCanton, int codigoPostal) {
		super();
		this.nombreCanton = nombreCanton;
		this.codigoPostal = codigoPostal;
	}

	public String getNombreCanton() {
		return nombreCanton;
	}

	public void setNombreCanton(String nombreCanton) {
		this.nombreCanton = nombreCanton;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String toString() {
		return nombreCanton;

	}

}
