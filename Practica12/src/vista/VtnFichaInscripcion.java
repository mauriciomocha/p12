package vista;

import java.awt.BorderLayout;


import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.GestionEquipo;
import modelo.FichaDeInscripcion;
import modelo.Jugador;

public class VtnFichaInscripcion extends JInternalFrame implements ActionListener {
	private GestionEquipo ge;

	private JTextField txtdorsal;
	private JTextField txtnacionalidad;
	private JComboBox comJugador;
	private JTextArea txtListado;

	public VtnFichaInscripcion(GestionEquipo ge) {

		this.ge = ge;
		setTitle("Ficha de Inscripcion");
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);
		setSize(500, 400);

		getContentPane().setLayout(new GridLayout(2, 1));
		JPanel pnlTitulo = new JPanel(new FlowLayout());

		comJugador = new JComboBox();
		cargarVtnJugador();

		JLabel jugador = new JLabel("Datos del jugador: ");
		JLabel dorsal = new JLabel("Dorsal del jugador: ");
		JLabel nacionalidad = new JLabel("Nacionalidad: ");

		txtdorsal = new JTextField(15);
		txtnacionalidad = new JTextField(15);
		txtListado = new JTextArea(14, 20);

		JButton guardar = new JButton("Guardar");
		guardar.addActionListener(this);
		guardar.setActionCommand("btnGuardar");

		JButton borrar = new JButton("Borrar");
		borrar.addActionListener(this);
		borrar.setActionCommand("btnBorrar");

		JButton salir = new JButton("Salir");
		salir.addActionListener(this);
		salir.setActionCommand("btnSalir");

		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.setBorder(BorderFactory.createTitledBorder("Datos de la Iscripcion"));
		getContentPane().add(panel1);

		panel1.add(jugador);
		panel1.add(comJugador);

		panel1.add(dorsal);
		panel1.add(txtdorsal);
		panel1.add(nacionalidad);
		panel1.add(txtnacionalidad);

		panel1.add(guardar, BorderLayout.SOUTH);
		panel1.add(borrar, BorderLayout.SOUTH);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.setBorder(BorderFactory.createTitledBorder("Listado"));
		getContentPane().add(panel2);

		panel2.add(txtListado);
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
		case "btnSalir":
			salir();
			break;

		default:
			break;
		}

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

	}

	private void guardar() {

		String nacionalidad = txtnacionalidad.getText();
		int dorsal = Integer.parseInt(txtdorsal.getText());
		Jugador jugador = (Jugador) comJugador.getSelectedItem();

		ge.agregarFichaDeInscripcion(jugador, dorsal, nacionalidad);
		listar();

	}

	private void listar() {
		List<FichaDeInscripcion> fichaDeInscripciones = ge.getFichaDeInscripciones();
		txtListado.setText("");
		for (int i = 0; i < fichaDeInscripciones.size(); i++) {
			FichaDeInscripcion fichaDeInscripcion = fichaDeInscripciones.get(i);
			System.out.println(
					"Jugador: " + fichaDeInscripcion.getJugador() + "\n" + "Dorsal: " + fichaDeInscripcion.getDorsal()
							+ "\n" + "Nacionalidad: " + fichaDeInscripcion.getNacionalidad() + "\n");

			txtListado.append(
					"Jugador: " + fichaDeInscripcion.getJugador() + "\n" + "Dorsal: " + fichaDeInscripcion.getDorsal()
							+ "\n" + "Nacionalidad: " + fichaDeInscripcion.getNacionalidad() + "\n");
		}

	}

}
