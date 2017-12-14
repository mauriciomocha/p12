package vista;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.GestionEquipo;
import modelo.Equipo;
import modelo.FichaDeInscripcion;
import modelo.Jugador;

public class VtnFichaInscripcion extends JInternalFrame implements ActionListener {
	private GestionEquipo ge;

	private JTextField txtdorsal;
	private JTextField txtnacionalidad;
	private JComboBox comJugador;
	private JComboBox comEquipo;
	private JTextArea txtListado;

	public VtnFichaInscripcion(GestionEquipo ge) {

		this.ge = ge;
		setTitle("Ficha de Inscripcion");
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);
		setSize(480, 400);

		getContentPane().setLayout(new GridLayout(2, 1));
		JPanel pnlTitulo = new JPanel(new FlowLayout());

		comJugador = new JComboBox();
		cargarVtnJugador();
		comEquipo = new JComboBox();
		cargarVtnEquipo();

		JLabel jugador = new JLabel("Datos del jugador: ");
		JLabel equipo = new JLabel("Datos del equipo");
		JLabel dorsal = new JLabel("Dorsal del jugador: ");
		JLabel nacionalidad = new JLabel("Nacionalidad del Equipo: ");

		txtdorsal = new JTextField(28);
		txtnacionalidad = new JTextField(27);
		txtListado = new JTextArea(7, 40);

		JScrollPane baja = new JScrollPane(txtListado);

		JButton guardar = new JButton("Guardar");
		guardar.addActionListener(this);
		guardar.setActionCommand("btnGuardar");

		JButton borrar = new JButton("Borrar");
		borrar.addActionListener(this);
		borrar.setActionCommand("btnBorrar");
		
		JButton leer =new JButton("Leer");
		leer.addActionListener(this);
		leer.setActionCommand("btnLeer");

		JButton salir = new JButton("Salir");
		salir.addActionListener(this);
		salir.setActionCommand("btnSalir");

		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.setBorder(BorderFactory.createTitledBorder("Datos de la Iscripcion"));
		getContentPane().add(panel1);

		panel1.add(jugador);
		panel1.add(comJugador);
		panel1.add(equipo);
		panel1.add(comEquipo);

		panel1.add(txtdorsal);
		panel1.add(dorsal);

		panel1.add(txtnacionalidad);
		panel1.add(nacionalidad);

		panel1.add(guardar, BorderLayout.SOUTH);
		panel1.add(borrar, BorderLayout.SOUTH);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.setBorder(BorderFactory.createTitledBorder("Listado"));
		getContentPane().add(panel2);

		panel2.add(baja);
		panel2.add(leer,BorderLayout.SOUTH);
		panel2.add(salir, BorderLayout.SOUTH);

	}

	private void cargarVtnJugador() {
		Vector model = new Vector();
		List<Jugador> jugadores = ge.getJugadores();

		for (int i = 0; i < jugadores.size(); i++) {
			Jugador Jugador = jugadores.get(i);
			model.addElement(Jugador);
		}
		comJugador = new JComboBox(model);

	}

	private void cargarVtnEquipo() {
		Vector model = new Vector();
		List<Equipo> equipos = ge.getEquipos();

		for (int i = 0; i < equipos.size(); i++) {
			Equipo Equipo = equipos.get(i);
			model.addElement(Equipo);
		}
		comEquipo = new JComboBox(model);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();

		System.out.println("Botn " + com);

		switch (com) {
		case "btnGuardar":
			guardar();
			break;
		case "btnBorrar":
			borrar();
			break;
		case "btnLeer":
			try {
				leer();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "btnSalir":
			salir();
			break;

		default:
			break;
		}

	}

	private void leer() throws IOException {
		txtListado.append(ge.leerFichaDeInscripcion());
		
	}

	private void salir() {
		int opcion = JOptionPane.showConfirmDialog(this, "Desea Salir?", "Confirmar", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		if (opcion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}

	private void borrar() {
		txtdorsal.setText("");
		txtnacionalidad.setText("");
		txtListado.setText("");
		JOptionPane.showMessageDialog(this, "Borrando Datos...", "Mensaje de información",
				JOptionPane.INFORMATION_MESSAGE);

	}

	private void guardar() {

		String nacionalidad = txtnacionalidad.getText();
		int dorsal = Integer.parseInt(txtdorsal.getText());
		Jugador jugador = (Jugador) comJugador.getSelectedItem();
		Equipo equipo = (Equipo) comEquipo.getSelectedItem();

		ge.agregarFichaDeInscripcion(jugador, equipo, dorsal, nacionalidad);
		JOptionPane.showMessageDialog(this, "Datos Guardados...", "Mensaje de información",
				JOptionPane.INFORMATION_MESSAGE);
		listar();

	}

	private void listar() {
		List<FichaDeInscripcion> fichaDeInscripciones = ge.getFichaDeInscripciones();
		txtListado.setText("");
		for (int i = 0; i < fichaDeInscripciones.size(); i++) {
			FichaDeInscripcion fichaDeInscripcion = fichaDeInscripciones.get(i);
			System.out.println("Nombre del Jugador: " + fichaDeInscripcion.getJugador().getNombre() + "\n"
					+ "Apellido del Jugador: " + fichaDeInscripcion.getJugador().getApellido() + "\n" + "Dorsal: "
					+ fichaDeInscripcion.getDorsal() + "\n" + "Nacionalidad: " + fichaDeInscripcion.getNacionalidad()
					+ "\n");

			txtListado.append("Nombre del Jugador: " + fichaDeInscripcion.getJugador().getNombre() + "\n"
					+ "Apellido del Jugador: " + fichaDeInscripcion.getJugador().getApellido() + "\n" + "Dorsal: "
					+ fichaDeInscripcion.getDorsal() + "\n" + "Nacionalidad: " + fichaDeInscripcion.getNacionalidad()
					+ "\n");
		}

	}

}
