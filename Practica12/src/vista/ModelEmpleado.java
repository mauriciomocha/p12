package vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.Empleado;

public class ModelEmpleado extends AbstractTableModel{
	public String[] columnas = { "Nombre", "Apellido", "Cedula","Edad"};

	public Class[] columnasTipos = { String.class, String.class,String.class,Integer.class };

	private List<Empleado> datos;

	public ModelEmpleado() {
		super();
		datos = new ArrayList<Empleado>();
	}

	public ModelEmpleado(List<Empleado> datos) {
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
		Empleado dato = (Empleado) (datos.get(row));

		switch (col) {
		case 0:
			dato.setNombre((String)value);
			break;
		case 1:
			dato.setApellido((String) value);
			break;
		case 2:
			dato.setCedula((String)value);
			break;
		case 3:
			dato.setEdad((Integer)value);
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
		Empleado dato = (Empleado) (datos.get(row));

		switch (col) {
		case 0:
			return dato.getNombre();
		case 1:
			return dato.getApellido();
		case 2:
			return dato.getCedula();
		case 3:
			return dato.getEdad();
		default:
			break;
		}
		return new String();
	}


}
