package vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import modelo.Articulo;
import modelo.Revista;

public class ModelRevista extends AbstractTableModel {
	
	public String[] columnas = { "NombreRevista", "Idioma", "#Edicion","Articulo"};

	public Class[] columnasTipos = { String.class, String.class,Integer.class,String.class };

	private List<Revista>datos;

	public ModelRevista() {
		super();
		datos = new ArrayList<Revista>();
	}

	public ModelRevista(List<Revista> datos) {
		super();
		this.datos = datos;
	}

	public int getColumnCount() {
		return columnas.length;
	}

	public int getRowCount() {
		return datos.size();
	}
	
	public void setValueAt(Object value, int row, int col) {
		Revista dato = (Revista) (datos.get(row));

		switch (col) {
		case 0:
			dato.setNombre((String)value);
			break;
		case 1:
			dato.setIdioma((String)value);
			break;
		case 2:
			dato.setNumEdicion((Integer)value);
			break;
		case 3:
			dato.setArticulo((Articulo)value);
			break;
		default:
			break;
		}
	}

	public String getColumnName(int col) {
		return columnas[col];
	}

	public Class getColumnClass(int col) {
		return columnasTipos[col];
	}

	public Object getValueAt(int row, int col) {
		Revista dato = (Revista) (datos.get(row));

		switch (col) {
		case 0:
			return dato.getNombre();
		case 1:
			return dato.getIdioma();
		case 2:
			return dato.getNumEdicion();
		case 3:
			return dato.getArticulo();
		default:
			break;
		}
		return new String();
}
}
