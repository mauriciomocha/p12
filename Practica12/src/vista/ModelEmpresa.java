package vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.Departamento;
import modelo.Empresa;

public class ModelEmpresa extends AbstractTableModel {
	public String[] columnas = { "Nombre", "Direccion", "Departamento"};

	public Class[] columnasTipos = { String.class, String.class,Integer.class };

	private List<Empresa> datos;

	public ModelEmpresa() {
		super();
		datos = new ArrayList<Empresa>();
	}

	public ModelEmpresa(List<Empresa> datos) {
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
		Empresa dato = (Empresa) (datos.get(row));

		switch (col) {
		case 0:
			dato.setNombre((String)value);
			break;
		case 1:
			dato.setDireccion((String) value);
			break;
		case 2:
			dato.setDepartamento((Departamento)value);
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
		Empresa dato = (Empresa) (datos.get(row));

		switch (col) {
		case 0:
			return dato.getNombre();
		case 1:
			return dato.getDireccion();
		case 2:
			return dato.getDepartamento();
		default:
			break;
		}
		return new String();
	}

}
