package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.GestionRevista;
import modelo.Articulo;
import modelo.Revista;

public class VtnRevista extends JInternalFrame implements ActionListener {

	private JTextField txtNumeroEdicion;
	private JTextField txtArticulo;
	private JTextField txtNombreRevista;
	private JTextField txtIdioma;
	private JTextArea txtListado;
	private Articulo articulo;
	private JComboBox comboArticulos;

	private GestionRevista ga;

	private void initComponets() {
		setTitle("Ventana Revista");
		setSize(300, 400);
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);

	}

	public VtnRevista(GestionRevista ga) {
		this.ga = ga;
		initComponets();
		setSize(369, 335);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(2, 1));

		JLabel etiqueta1 = new JLabel("Nombre Revista: ");
		JLabel etiqueta2 = new JLabel("Idioma: ");
		JLabel etiqueta3 = new JLabel("Numero (Edicion): ");
		JLabel etiqueta4 = new JLabel("Articulo: ");

		txtNombreRevista = new JTextField(20);
		txtNumeroEdicion = new JTextField(20);
		comboArticulos = new JComboBox();
		
		cargarArticulos();
		txtIdioma = new JTextField(20);
		txtListado = new JTextArea(5, 20);

		JButton boton1 = new JButton("Anadir");
		boton1.addActionListener(this);
		boton1.setActionCommand("btnAnadir");

		JButton boton2 = new JButton("Borrar");
		boton2.addActionListener(this);
		boton2.setActionCommand("btnBorrar");

		JButton boton3 = new JButton("Salir");
		boton3.addActionListener(this);
		boton3.setActionCommand("btnSalir");

		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.setBorder(BorderFactory.createTitledBorder("Datos Revista"));
		getContentPane().add(panel1);
		panel1.add(etiqueta1);
		panel1.add(txtNombreRevista);
		panel1.add(etiqueta2);
		panel1.add(txtIdioma);
		panel1.add(etiqueta3);
		panel1.add(txtNumeroEdicion);
		panel1.add(etiqueta4);
		panel1.add(comboArticulos);

		panel1.add(boton1, BorderLayout.SOUTH);
		panel1.add(boton2, BorderLayout.SOUTH);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.setBorder(BorderFactory.createTitledBorder("Listado"));
		getContentPane().add(panel2);
		JScrollPane txtBaja = new JScrollPane(txtListado);
		panel2.add(txtBaja);
		panel2.add(boton3, BorderLayout.CENTER);

	

		String nombre = JOptionPane.showInputDialog(this, "Introducir Nombre:");
		if (nombre != null) {
			System.out.println("Bienvenido " + nombre);
			JOptionPane.showMessageDialog(this, "Bienvenido " + nombre, "Introduccion",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "Permiso denegado. Nombre no introducido." + nombre, "MSJ",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

	}

	public void actionPerformed(ActionEvent evt) {
		// System.out.println("evento boton");

		String comando = evt.getActionCommand();

		System.out.println("Button insertado: " + comando);

		switch (comando) {
		case "btnSalir":
			terminar();
			break;
		case "btnAnadir":
			cargar();
			break;
		case "btnBorrar":
			vaciar();
			break;
		default:
			break;
		}

	}

	public void cargar() {
		int numeroEdicion = Integer.parseInt(txtNumeroEdicion.getText());
		String nombre = txtNombreRevista.getText();
		String idioma = txtIdioma.getText();
		Articulo articulo = (Articulo) comboArticulos.getSelectedItem();

		ga.agregarRevista(numeroEdicion, nombre, idioma, articulo);
		JOptionPane.showMessageDialog(this, "Datos guardados", "Mensaje de información", JOptionPane.ERROR_MESSAGE);
		listar();
	}

	public void listar() {
		List<Revista> revistas = ga.getRevistas();
		txtListado.setText("");
		for (int i = 0; i < revistas.size(); i++) {
			Revista revista = revistas.get(i);
			System.out.println(revista.getNombre() + "\n" + revista.getIdioma() + "\n" + revista.getNumEdicion() + "\n"
					+ revista.getArticulo() + "\n");
			txtListado.append(revista.getNombre() + " " + revista.getIdioma() + "\n" + revista.getNumEdicion() + "\n"
					+ revista.getArticulo() + "\n");
		}

	}

	public void terminar() {
		int opcion = JOptionPane.showConfirmDialog(this, "Desea dar por terminado el programa ?", "Mensaje",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (opcion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		if (opcion == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(this, "Siga trabajando", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void vaciar() {
		txtNumeroEdicion.setText("");
		//txtArticulo.setText("");
		txtNombreRevista.setText("");
		txtIdioma.setText("");

	}

	private void cargarArticulos() {
		Vector model = new Vector();
		List<Articulo> articulos = ga.getArticulos();

		for (int i = 0; i < articulos.size(); i++) {
			Articulo articulo = articulos.get(i);
			model.addElement(articulo);
		}

		comboArticulos = new JComboBox(model);
	}

}
