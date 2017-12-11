package vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.Equipo;
import modelo.FichaDeInscripcion;



public class ModelFichaInscripcion extends AbstractTableModel {



	public String[] columnas = { "Equipo", "Dorsal", "Nacionalidad"};

	public Class[] columnasTipos = { String.class, Integer.class,String.class };

	private List<FichaDeInscripcion> datos;

	public ModelFichaInscripcion() {
		super();
		datos = new ArrayList<FichaDeInscripcion>();
	}

	public ModelFichaInscripcion(List<FichaDeInscripcion> datos) {
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
		FichaDeInscripcion dato = (FichaDeInscripcion) (datos.get(row));

		switch (col) {
		case 0:
			dato.setEquipo((Equipo)value);
			break;
		case 1:
			dato.setDorsal((Integer) value);
			break;
		case 2:
			dato.setNacionalidad((String)value);
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
		FichaDeInscripcion dato = (FichaDeInscripcion) (datos.get(row));

		switch (col) {
		case 0:
			return dato.getEquipo();
		case 1:
			return dato.getDorsal();
		case 2:
			return dato.getNacionalidad();
		default:
			break;
		}
		return new String();
	}
	


}
