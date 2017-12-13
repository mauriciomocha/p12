package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Atleta;
import modelo.Competencia;
import modelo.Resultado;


public class GestionCompetencia {
	private List<Competencia> competencias;
	private List<Resultado> resultados;
	private List<Atleta> atletas;
	
	

	public GestionCompetencia() {
		
		competencias = new ArrayList<Competencia>();
		resultados = new ArrayList<Resultado>();
		atletas = new ArrayList<Atleta>();
	

	}
	public void agregarCompetencia(String nombre, String tipoCompetencia, Resultado resultado) {
		Competencia c=new Competencia(nombre, resultado, tipoCompetencia);
		c.setNombre(nombre);
		c.setTipoCompetencia(tipoCompetencia);
		c.setResultado(resultado);
		competencias.add(c);
		
		
	}
	
	
	
	public List<Competencia> getCompetencias(){
		return competencias;
	}
	
	public void agregarResultado(String puesto, Atleta atleta) {
		Resultado r=new Resultado(puesto, atleta);
		r.setPuesto(puesto);
		r.setAtleta(atleta);
		resultados.add(r);
	}
	public List<Resultado> getResultados(){
		return resultados;
	}
	
	
	public void agregarAtleta(String nombre, String apellido, String cedula, int edad) {
		Atleta a=new Atleta(nombre,apellido,cedula,edad);
		a.setNombre(nombre);
		a.setApellido(apellido);
		a.setCedula(cedula);
		a.setEdad(edad);
		atletas.add(a);
		
	}
	
	
	public List<Atleta> getAtletas(){
		return atletas;
	}
	
	public boolean isCedulaValida(String cedula) throws Exception {

		try {
			int a= Integer.parseInt(cedula);
			}catch(NumberFormatException e){
				throw new Exception("Formato incorecto, cedula contiene caracteres");
		}
		if(cedula.length()!=10)
			throw new Exception("La cedula debe de tener 10 digitos");
			
		
		return true;
		

	}


}
