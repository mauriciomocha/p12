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

import controlador.GestionPais;
import modelo.Canton;
import modelo.Provincia;

public class VtnProvincia extends JInternalFrame implements ActionListener {
	
	private JTextField txtnombreProvincia;
	private JTextField txtRegion;
	private JTextField txtCanton;
	private JTextArea txtListado;
	private Canton canton;
	private JComboBox comboCantones;

	private GestionPais gpai;

	private void initComponets() {
		setTitle("Ventana Revista");
		setSize(300, 400);
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);

	}

	public VtnProvincia(GestionPais gpai) {
		this.gpai = gpai;
		initComponets();
		setSize(369, 335);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(2, 1));

		JLabel etiqueta1 = new JLabel("Nombre Provincia: ");
		JLabel etiqueta2 = new JLabel("Region: ");
		JLabel etiqueta3 = new JLabel("Canton: ");

		txtnombreProvincia = new JTextField(20);
		txtRegion = new JTextField(20);
		comboCantones = new JComboBox();
		cargarProvincias();
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
		panel1.add(txtnombreProvincia);
		panel1.add(etiqueta2);
		panel1.add(txtRegion);
		panel1.add(etiqueta3);
		panel1.add(comboCantones);

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
		String nombre = txtnombreProvincia.getText();
		String region = txtRegion.getText();
		Canton canton = (Canton) comboCantones.getSelectedItem();
		gpai.agregarProvincia(nombre, region, canton);
		JOptionPane.showMessageDialog(this, "Datos guardados", "Mensaje de información", JOptionPane.ERROR_MESSAGE);
		listar();
	}

	public void listar() {
		List<Provincia> provincias = gpai.getProvincias();
		txtListado.setText("");
		for (int i = 0; i < provincias.size(); i++) {
			Provincia provincia = provincias.get(i);
			System.out.println(provincia.getNombreProvincia() + provincia.getRegion() + provincia.getCanton());
			txtListado.append(
					provincia.getNombreProvincia() + " " + provincia.getRegion() + "\n" + provincia.getCanton());
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
		txtnombreProvincia.setText("");
		txtRegion.setText(" ");

	}

	private void cargarProvincias() {
		Vector model = new Vector();
		List<Canton> cantones = gpai.getCantones();

		for (int i = 0; i < cantones.size(); i++) {
			Canton canton = cantones.get(i);
			model.addElement(canton);
		}

		comboCantones = new JComboBox(model);
	}

}
