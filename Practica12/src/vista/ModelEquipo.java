package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;

import modelo.Equipo;
import modelo.Jugador;



public class ModelEquipo extends AbstractTableModel {



	public String[] columnas = { "Jugador", "Nombre Equipo", "Cantidad de Jugadores"};

	public Class[] columnasTipos = { String.class, String.class,Integer.class };

	private List<Equipo> datos;

	public ModelEquipo() {
		super();
		datos = new ArrayList<Equipo>();
	}

	public ModelEquipo(List<Equipo> datos) {
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
		Equipo dato = (Equipo) (datos.get(row));

		switch (col) {
		case 0:
			dato.setJugador((Jugador)value);
			break;
		case 1:
			dato.setNombreEquipo((String) value);
			break;
		case 2:
			dato.setCantidadJugadores((Integer)value);
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
		Equipo dato = (Equipo) (datos.get(row));

		switch (col) {
		case 0:
			return dato.getJugador();
		case 1:
			return dato.getNombreEquipo();
		case 2:
			return dato.getCantidadJugadores();
		default:
			break;
		}
		return new String();
	}
	

}
