package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Canton;
import modelo.Pais;
import modelo.Provincia;

public class GestionPais {

	private List<Pais> paices;
	private List<Provincia> provincias;
	private List<Canton> cantones;

	public GestionPais() {

		paices = new ArrayList<Pais>();
		provincias = new ArrayList<Provincia>();
		cantones = new ArrayList<Canton>();

	}

	public void agregarPais(String nombrePais, int poblacion, Provincia provincia) {
		Pais p = new Pais(nombrePais, poblacion, provincia);
		p.setNombrePais(nombrePais);
		p.setProblacion(poblacion);
		p.setProvincia(provincia);
		paices.add(p);
	}

	public List<Pais> getPaices() {
		return paices;
	}

	public void agregarProvincia(String nombreProvincia, String region, Canton canton) {
		Provincia po = new Provincia(nombreProvincia, region, canton);
		po.setNombreProvincia(nombreProvincia);
		po.setRegion(region);
		po.setCanton(canton);
		provincias.add(po);

	}

	public List<Provincia> getProvincias() {
		return provincias;
	}

	public void agregarCanton(String nombreCanton, int codigoPostal) {
		Canton cnt = new Canton(nombreCanton, codigoPostal);
		cnt.setNombreCanton(nombreCanton);
		cnt.setCodigoPostal(codigoPostal);
		cantones.add(cnt);
	}

	public List<Canton> getCantones() {
		return cantones;
	}

}
