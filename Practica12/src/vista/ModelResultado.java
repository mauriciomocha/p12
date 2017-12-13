package vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.Atleta;
import modelo.Resultado;

public class ModelResultado extends AbstractTableModel{
	public String[] columnas = { "Puesto", "Atleta"};

	public Class[] columnasTipos = { String.class, String.class };

	private List<Resultado> datos;

	public ModelResultado() {
		super();
		datos = new ArrayList<Resultado>();
	}

	public ModelResultado(List<Resultado> datos) {
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
		Resultado dato = (Resultado) (datos.get(row));

		switch (col) {
		case 0:
			dato.setPuesto((String)value);
			break;
		case 1:
			dato.setAtleta((Atleta) value);
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
		Resultado dato = (Resultado) (datos.get(row));

		switch (col) {
		case 0:
			return dato.getPuesto();
		case 1:
			return dato.getAtleta();
		default:
			break;
		}
		return new String();
	}



}
