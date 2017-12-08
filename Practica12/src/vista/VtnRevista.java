package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.GestionAutor;

public class VtnRevista extends JInternalFrame implements ActionListener {

	private JTextField txtNumeroEdicion;
	private JTextField txtArticulo;
	private JTextField txtNombreRevista;
	private JTextField txtIdioma;
	private JTextArea txtListado;

	private GestionAutor ga;

	private void initComponets() {
		setTitle("Ventana Revista");
		setSize(300, 400);
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);

	}

	public VtnRevista(GestionAutor ga) {
		this.ga = ga;
		initComponets();
		setSize(369, 335);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(2, 1));

		JLabel etiqueta1 = new JLabel("Nombre Revista: ");
		JLabel etiqueta2 = new JLabel("Idioma: ");
		JLabel etiqueta3 = new JLabel("Numero (Edicion): ");
		JLabel etiqueta4 = new JLabel("Articulo: ");
		
		
		
		
		txtNombreRevista=new JTextField(20);
		txtNumeroEdicion = new JTextField(20);
		txtArticulo = new JTextField(20);
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
		panel1.add(txtArticulo);

		panel1.add(boton1, BorderLayout.SOUTH);
		panel1.add(boton2, BorderLayout.SOUTH);
		

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.setBorder(BorderFactory.createTitledBorder("Listado"));
		getContentPane().add(panel2);
		JScrollPane txtBaja=new JScrollPane(txtListado);
		panel2.add(txtBaja);
		panel2.add(boton3, BorderLayout.CENTER);


		ga = new GestionAutor();

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
			//cargar();
			break;
		case "btnBorrar":
			vaciar();
			break;
		default:
			break;
		}

	}

	/*
	 * public void cargar() { String nombreCiudad = txtNumeroEdicion.getText();
	 * String habitantes = txtArticulo.getText();
	 * 
	 * gp.agregarCiudad(nombreCiudad, habitantes);
	 * JOptionPane.showMessageDialog(this, "Datos guardados",
	 * "Mensaje de información", JOptionPane.ERROR_MESSAGE); listar(); }
	 * 
	 * public void listar() { List<Ciudad> ciudades = gp.getCiudades();
	 * txtListado.setText(""); for (int i = 0; i < ciudades.size(); i++) { Ciudad
	 * ciudad = ciudades.get(i); System.out.println(ciudad.getNombreCiudad() + " " +
	 * ciudad.getHabitantes()); txtListado.append(ciudad.getNombreCiudad() + " " +
	 * ciudad.getHabitantes() + "\n"); }
	 * 
	 * }
	 */
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
		txtArticulo.setText("");
		txtNombreRevista.setText("");
		txtIdioma.setText("");

	}

}
