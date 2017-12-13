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


import controlador.GestionEmpresa;
import modelo.Consulta;
import modelo.Departamento;
import modelo.Empresa;
import modelo.Medico;
import modelo.Paciente;


public class VtnEmpresa extends JInternalFrame implements ActionListener {
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtDepartamento;
	private JComboBox comDepartamento;
	private JTextArea txtListado;

	private GestionEmpresa ge;

	private void initComponets() {
		setTitle("Ventana Empresa");
		setSize(300, 400);
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);

	}

	public VtnEmpresa(GestionEmpresa ge) {
		this.ge = ge;
		initComponets();
		setSize(369, 335);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(2, 1));
		
		comDepartamento = new JComboBox();
		cargarVtnDepartamento();
		

		JLabel etiqueta1 = new JLabel("Nombre Empresa: ");
		JLabel etiqueta2 = new JLabel("Direccion: ");
		JLabel etiqueta3 = new JLabel("Departamento: ");
		
		
		
		
		
		txtNombre=new JTextField(20);
		txtDireccion = new JTextField(20);
	
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
		panel1.setBorder(BorderFactory.createTitledBorder("Datos Empresa"));
		getContentPane().add(panel1);
		panel1.add(etiqueta1);
		panel1.add(txtNombre);
		panel1.add(etiqueta2);
		panel1.add(txtDireccion);
		panel1.add(etiqueta3);
		panel1.add(comDepartamento);
	

		panel1.add(boton1, BorderLayout.SOUTH);
		panel1.add(boton2, BorderLayout.SOUTH);
		

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.setBorder(BorderFactory.createTitledBorder("Listado"));
		getContentPane().add(panel2);
		JScrollPane txtBaja=new JScrollPane(txtListado);
		panel2.add(txtBaja);
		panel2.add(boton3, BorderLayout.CENTER);


		ge = new GestionEmpresa();

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
	private void cargarVtnDepartamento() {
		Vector model = new Vector();
		List<Departamento> departamentos = ge.getDepartamentos();

		for (int i = 0; i < departamentos.size(); i++) {
			Departamento Departamento = departamentos.get(i);
			model.addElement(Departamento);
		}
		comDepartamento = new JComboBox(model);

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
			guardar();
			break;
		case "btnBorrar":
			vaciar();
			break;
		default:
			break;
		}

	}
	

	
	private void guardar() {

		String nombre = txtNombre.getText();
		String direccion = txtDireccion.getText();
		Departamento departamento = (Departamento)comDepartamento.getSelectedItem();
		

			
		ge.agregarEmpresa(nombre, direccion, departamento);
		listar();
		
		
	}

	private void listar() {
		List<Empresa> empresas = ge.getEmpresas();
		txtListado.setText("");
		for (int i = 0; i < empresas.size(); i++) {
			Empresa empresa = empresas.get(i);
			System.out.println("Nombre: " + empresa.getNombre() + "\n" + "Direccion: " + empresa.getDireccion()+ "\n"
					+ "Departamento: " + empresa.getDepartamento()+ "\n" );

			txtListado.append("Nombre: " + empresa.getNombre() + "\n" + "Direccion: " + empresa.getDireccion() + "\n"
					+ "Departamento: " + empresa.getDepartamento() + "\n" );
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
		txtNombre.setText("");
		txtDireccion.setText("");
		txtDepartamento.setText("");
	

	}


}
