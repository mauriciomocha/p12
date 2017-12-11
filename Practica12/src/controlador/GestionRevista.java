package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Articulo;
import modelo.Autor;
import modelo.Revista;

public class GestionRevista {

	private List<Revista> revistas;
	private List<Articulo> articulos;
	private List<Autor> autores;

	public GestionRevista() {

		revistas = new ArrayList<Revista>();
		articulos = new ArrayList<Articulo>();
		autores = new ArrayList<Autor>();

	}

	public void agregarRevista(int numeroEdicion, String nombre, String idioma, Articulo articulo) {
		Revista re = new Revista(numeroEdicion, nombre, idioma, articulo);
		re.setNumEdicion(numeroEdicion);
		re.setNombre(nombre);
		re.setIdioma(idioma);
		re.setArticulo(articulo);
		revistas.add(re);
	}

	public List<Revista> getRevistas() {
		return revistas;
	}

	public void agregarArticulo(String titulo, int paginaInicio, int paginaFin, Autor autor) {
		Articulo ar = new Articulo(titulo, paginaInicio, paginaFin, autor);
		ar.setTitulo(titulo);
		ar.setPaginaInicio(paginaInicio);
		ar.setPaginaFin(paginaFin);
		ar.setAutor(autor);
		articulos.add(ar);
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void agregarAutor(String nombre, String apellido, String cedula, int edad) {
		Autor au = new Autor(nombre, apellido, cedula, edad);
		au.setNombre(nombre);
		au.setApellido(apellido);
		au.setCedula(cedula);
		au.setEdad(edad);

	}

	public List<Autor> getAutores() {
		return autores;
	}

}
