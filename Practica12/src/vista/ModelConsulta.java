package vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.Consulta;
import modelo.Paciente;



public class ModelConsulta extends AbstractTableModel {



	public String[] columnas = { "Hora", "numConsulta", "Costo Consulta","Paciente"};

	public Class[] columnasTipos = { Integer.class, Integer.class,Integer.class,String.class };

	private List<Consulta> datos;

	public  ModelConsulta() {
		super();
		datos = new ArrayList<Consulta>();
	}

	public  ModelConsulta(List<Consulta> datos) {
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
		Consulta dato = (Consulta) (datos.get(row));

		switch (col) {
		case 0:
			dato.setHora((Integer)value);
			break;
		case 1:
			dato.setNumconsulta((Integer) value);
			break;
		case 2:
			dato.setCostoConsulta((Integer)value);
			break;
		case 3:
			dato.setPaciente((Paciente)value);
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
		Consulta dato = (Consulta) (datos.get(row));

		switch (col) {
		case 0:
			return dato.getHora();
		case 1:
			return dato.getNumconsulta();
		case 2:
			return dato.getCostoConsulta();
		case 3:
			return dato.getPaciente();
		default:
			break;
		}
		return new String();
	}
	


}
