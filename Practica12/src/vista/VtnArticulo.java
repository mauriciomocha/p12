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
import modelo.Autor;
import modelo.Revista;

public class VtnArticulo extends JInternalFrame implements ActionListener {
	private JTextField txtTitulo;
	private JTextField txtpgInicio;
	private JTextField txtpgFin;
	private JTextField txtAutor;
	private JTextArea txtListado;
	private Autor autor;
	private JComboBox comboAutores;

	private GestionRevista ga;

	private void initComponets() {
		setTitle("Ventana Revista");
		setSize(300, 400);
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);

	}

	public VtnArticulo(GestionRevista ga) {
		this.ga = ga;
		initComponets();
		setSize(369, 335);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(2, 1));

		JLabel etiqueta1 = new JLabel("Titulo: ");
		JLabel etiqueta2 = new JLabel("Pg Inicio: ");
		JLabel etiqueta3 = new JLabel("Pg Fin: ");
		JLabel etiqueta4 = new JLabel("Autor: ");

		txtpgFin = new JTextField(20);
		txtTitulo = new JTextField(20);
		comboAutores = new JComboBox();
		cargarAutores();
		txtAutor = new JTextField(20);
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
		panel1.add(txtpgFin);
		panel1.add(etiqueta2);
		panel1.add(txtAutor);
		panel1.add(etiqueta3);
		panel1.add(txtTitulo);
		panel1.add(etiqueta4);
		panel1.add(comboAutores);

		panel1.add(boton1, BorderLayout.SOUTH);
		panel1.add(boton2, BorderLayout.SOUTH);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.setBorder(BorderFactory.createTitledBorder("Listado"));
		getContentPane().add(panel2);
		JScrollPane txtBaja = new JScrollPane(txtListado);
		panel2.add(txtBaja);
		panel2.add(boton3, BorderLayout.CENTER);

		ga = new GestionRevista();

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
			// cargar();
			break;
		case "btnBorrar":
			vaciar();
			break;
		default:
			break;
		}

	}

	public void cargar() {
		String titulo = txtTitulo.getText();
		int pgInicio = Integer.parseInt(txtpgInicio.getText());
		int pgFin = Integer.parseInt(txtpgFin.getText());
		Autor autor = (Autor) comboAutores.getSelectedItem();

		ga.agregarArticulo(titulo, pgInicio, pgFin, autor);
		JOptionPane.showMessageDialog(this, "Datos guardados", "Mensaje de información", JOptionPane.ERROR_MESSAGE);
		listar();
	}

	public void listar() {
		List<Articulo> articulos = ga.getArticulos();
		txtListado.setText("");
		for (int i = 0; i < articulos.size(); i++) {
			Articulo articulo = articulos.get(i);
			System.out.println(
					articulo.getTitulo() + articulo.getPaginaInicio() + articulo.getPaginaFin() + articulo.getAutor());
			txtListado.append(articulo.getTitulo() + " " + articulo.getPaginaInicio() + "\n" + articulo.getPaginaFin()
					+ "\n" + articulo.getAutor());
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
		txtTitulo.setText("");
		txtpgInicio.setText("");
		txtpgFin.setText("");

	}

	private void cargarAutores() {
		Vector model = new Vector();
		List<Autor> autores = ga.getAutores();

		for (int i = 0; i < autores.size(); i++) {
			Autor autor = autores.get(i);
			model.addElement(autor);
		}

		comboAutores = new JComboBox(model);

	}
}
