package modelo;

public class Consulta {
	private int hora;
	private int numconsulta;
	private int costoConsulta;
	private Paciente paciente;

	public Consulta(int hora, int numconsulta, int costoConsulta, Paciente paciente) {
		super();
		this.hora = hora;
		this.numconsulta = numconsulta;
		this.costoConsulta = costoConsulta;
		this.paciente = paciente;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getNumconsulta() {
		return numconsulta;
	}

	public void setNumconsulta(int numconsulta) {
		this.numconsulta = numconsulta;
	}

	public int getCostoConsulta() {
		return costoConsulta;
	}

	public void setCostoConsulta(int costoConsulta) {
		this.costoConsulta = costoConsulta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
