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
import modelo.Jugador;

public class VtnEquipo extends JInternalFrame implements ActionListener {
	private GestionEquipo ge;

	private JTextField txtnombreEquipo;
	private JTextField txtcatindadJugador;
	private JComboBox comJugador;
	private JTextArea txtListado;

	public VtnEquipo(GestionEquipo ge) {

		this.ge = ge;
		setTitle("Equipo");
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);
		setSize(480, 400);

		getContentPane().setLayout(new GridLayout(2, 1));
		JPanel pnlTitulo = new JPanel(new FlowLayout());

		comJugador = new JComboBox();
		cargarVtnJugador();

		JLabel Jugador = new JLabel("Jugador: ");
		JLabel nombreEquipo = new JLabel("Nombre del Equipo: ");
		JLabel cantidadJugadores = new JLabel("Cantidad de Jugadores: ");

		txtnombreEquipo = new JTextField(15);
		txtcatindadJugador = new JTextField(25);
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
		panel1.setBorder(BorderFactory.createTitledBorder("Datos Del Equipo"));
		getContentPane().add(panel1);

		panel1.add(Jugador);
		panel1.add(comJugador);

		panel1.add(nombreEquipo);
		panel1.add(txtnombreEquipo);
		panel1.add(cantidadJugadores);
		panel1.add(txtcatindadJugador);

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
		txtListado.append(ge.leerEquipo());
		
	}

	private void salir() {
		int opcion = JOptionPane.showConfirmDialog(this, "Desea Salir?", "Confirmar", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		if (opcion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}

	private void borrar() {
		txtcatindadJugador.setText("");
		txtnombreEquipo.setText("");
		txtListado.setText("");
		JOptionPane.showMessageDialog(this, "Borrando Datos...", "Mensaje de información",
				JOptionPane.INFORMATION_MESSAGE);
	}

	private void guardar() {

		String nombreEquipo = txtnombreEquipo.getText();
		int cantidadJugador = Integer.parseInt(txtcatindadJugador.getText());
		Jugador jugador = (Jugador) comJugador.getSelectedItem();

		ge.agregarEquipo(jugador, nombreEquipo, cantidadJugador);
		JOptionPane.showMessageDialog(this, "Datos Guardados...", "Mensaje de información",
				JOptionPane.INFORMATION_MESSAGE);
		
		listar();

	}

	private void listar() {
		List<Equipo> equipos = ge.getEquipos();
		txtListado.setText("");
		for (int i = 0; i < equipos.size(); i++) {
			Equipo equipo = equipos.get(i);
			System.out.println("Nombre del Jugador: " + equipo.getJugador().getNombre() + "\n"
					+ "Apellido del jugador: " + equipo.getJugador().getApellido() + "\n" + "Nombre del Equipo: "
					+ equipo.getNombreEquipo() + "\n" + "Cantidad de Jugadores: " + equipo.getCantidadJugadores()
					+ "\n");

			txtListado.append("Nombre del Jugador: " + equipo.getJugador().getNombre() + "\n" + "Apellido del jugador: "
					+ equipo.getJugador().getApellido() + "\n" + "Nombre del Equipo: " + equipo.getNombreEquipo() + "\n"
					+ "Cantidad de Jugadores: " + equipo.getCantidadJugadores() + "\n");
		}

	}
	
	

}
