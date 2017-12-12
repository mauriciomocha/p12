package modelo;

public class Articulo {

	private String titulo;
	private int paginaInicio;
	private int paginaFin;
	private Autor autor;

	public Articulo(String titulo, int paginaInicio, int paginaFin, Autor autor) {
		this.titulo = titulo;
		this.paginaInicio = paginaInicio;
		this.paginaFin = paginaFin;
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getPaginaInicio() {
		return paginaInicio;
	}

	public void setPaginaInicio(int paginaInicio) {
		this.paginaInicio = paginaInicio;
	}

	public int getPaginaFin() {
		return paginaFin;
	}

	public void setPaginaFin(int paginaFin) {
		this.paginaFin = paginaFin;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	public String toString() {
		return titulo;
	}
	
	
	
	
}
