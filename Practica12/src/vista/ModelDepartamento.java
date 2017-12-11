package vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.Departamento;
import modelo.Empleado;

public class ModelDepartamento extends AbstractTableModel{
	public String[] columnas = { "Nombre", "Empleado"};

	public Class[] columnasTipos = { String.class, String.class };

	private List<Departamento> datos;

	public ModelDepartamento() {
		super();
		datos = new ArrayList<Departamento>();
	}

	public ModelDepartamento(List<Departamento> datos) {
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
		Departamento dato = (Departamento) (datos.get(row));

		switch (col) {
		case 0:
			dato.setNombreDepartamento((String)value);
			break;
		case 1:
			dato.setEmpleado((Empleado) value);
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
		Departamento dato = (Departamento) (datos.get(row));

		switch (col) {
		case 0:
			return dato.getNombreDepartamento();
		case 1:
			return dato.getEmpleado();
		default:
			break;
		}
		return new String();
	}

	

}
