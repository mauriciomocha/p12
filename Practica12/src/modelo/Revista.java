package modelo;

public class Revista {

	private int numEdicion;
	private String nombre;
	private String idioma;
	private Articulo articulo;

	public Revista(int numEdicion, String nombre, String idioma, Articulo articulo) {
		super();
		this.numEdicion = numEdicion;
		this.nombre = nombre;
		this.idioma = idioma;
		this.articulo = articulo;
	}

	public int getNumEdicion() {
		return numEdicion;
	}

	public void setNumEdicion(int numEdicion) {
		this.numEdicion = numEdicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
}