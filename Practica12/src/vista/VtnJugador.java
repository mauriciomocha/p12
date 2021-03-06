package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
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
import modelo.Jugador;

public class VtnJugador extends JInternalFrame implements ActionListener {

	private GestionEquipo ge;

	private JTextField txtnombre;
	private JTextField txtapellido;
	private JTextField txtcedula;
	private JTextField txtedad;
	private JTextArea txtListado;

	public VtnJugador(GestionEquipo ge) {

		this.ge = ge;
		setTitle("Datos del Jugador");
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);
		setSize(480, 400);

		getContentPane().setLayout(new GridLayout(2, 1));
		JPanel pnlTitulo = new JPanel(new FlowLayout());

		JLabel nombre = new JLabel("Nombre: ");
		JLabel apellido = new JLabel("Apellido: ");
		JLabel cedula = new JLabel("Cedula: ");
		JLabel edad = new JLabel("Edad: ");

		txtnombre = new JTextField(15);
		txtapellido = new JTextField(14);
		txtcedula = new JTextField(15);
		txtedad = new JTextField(15);
		txtListado = new JTextArea(7, 40);

		JScrollPane txtBaja = new JScrollPane(txtListado);

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
		panel1.setBorder(BorderFactory.createTitledBorder("Datos del Jugador"));
		getContentPane().add(panel1);

		panel1.add(nombre);
		panel1.add(txtnombre);
		panel1.add(apellido);
		panel1.add(txtapellido);
		panel1.add(cedula);
		panel1.add(txtcedula);
		panel1.add(edad);
		panel1.add(txtedad);

		panel1.add(guardar, BorderLayout.SOUTH);
		panel1.add(borrar, BorderLayout.SOUTH);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.setBorder(BorderFactory.createTitledBorder("Listado"));
		getContentPane().add(panel2);

		panel2.add(txtBaja);
		panel2.add(leer,BorderLayout.SOUTH);
		panel2.add(salir, BorderLayout.SOUTH);

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
		txtListado.append(ge.leerJugador());
		
	}

	private void salir() {
		int opcion = JOptionPane.showConfirmDialog(this, "Desea Salir?", "Confirmar", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		if (opcion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}

	private void borrar() {
		txtnombre.setText("");
		txtapellido.setText("");
		txtcedula.setText("");
		txtedad.setText("");
		txtListado.setText("");
		JOptionPane.showMessageDialog(this, "Borrando Datos...", "Mensaje de información",
				JOptionPane.INFORMATION_MESSAGE);

	}

	private void guardar() {

		String nombre = txtnombre.getText();
		String apellido = txtapellido.getText();
		String cedula = txtcedula.getText();
		int edad = Integer.parseInt(txtedad.getText());

		
		try {
			if(ge.isCedulaValida(cedula)) {
		ge.agregarJugador(nombre, apellido, cedula, edad);
		JOptionPane.showMessageDialog(this, "Datos Guardados...", "Mensaje de información",
				JOptionPane.INFORMATION_MESSAGE);
		listar();
			}

		}catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(),
					"Mensaje de error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	private void listar() {
		List<Jugador> jugadores = ge.getJugadores();
		txtListado.setText("");
		for (int i = 0; i < jugadores.size(); i++) {
			Jugador jugador = jugadores.get(i);
			System.out.println("Nombre: " + jugador.getNombre() + "\n" + "Apellido: " + jugador.getApellido() + "\n"
					+ "Cedula: " + jugador.getCedula() + "\n" + "Edad: " + jugador.getEdad() + "\n");

			txtListado.append("Nombre: " + jugador.getNombre() + "\n" + "Apellido: " + jugador.getApellido() + "\n"
					+ "Cedula: " + jugador.getCedula() + "\n" + "Edad: " + jugador.getEdad() + "\n");
		}

	}

}
