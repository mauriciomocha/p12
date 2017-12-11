package vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.Competencia;

import modelo.Resultado;

public class ModelCompetencia extends AbstractTableModel {
	public String[] columnas = { "Nombre", "Tipo","Resultado"};

	public Class[] columnasTipos = { String.class, String.class,String.class };

	private List<Competencia> datos;

	public ModelCompetencia() {
		super();
		datos = new ArrayList<Competencia>();
	}

	public ModelCompetencia(List<Competencia> datos) {
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
		Competencia dato = (Competencia) (datos.get(row));

		switch (col) {
		case 0:
			dato.setNombre((String)value);
			break;
		case 1:
			dato.setTipoCompetencia((String) value);
			break;
		case 2:
			dato.setResultado((Resultado)value);
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
		Competencia dato = (Competencia) (datos.get(row));

		switch (col) {
		case 0:
			return dato.getNombre();
		case 1:
			return dato.getTipoCompetencia();
		case 2:
			return dato.getResultado();
		default:
			break;
		}
		return new String();
	}


}
