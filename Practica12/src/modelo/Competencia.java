package modelo;

public class Competencia {
	
	private String nombre;
	private Resultado resultado;
	private String tipoCompetencia;

	public Competencia(String nombre, Resultado resultado, String tipoCompetencia) {

		this.nombre = nombre;
		this.resultado = resultado;
		this.tipoCompetencia = tipoCompetencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	public String getTipoCompetencia() {
		return tipoCompetencia;
	}

	public void setTipoCompetencia(String tipoCompetencia) {
		this.tipoCompetencia = tipoCompetencia;
	}

}
