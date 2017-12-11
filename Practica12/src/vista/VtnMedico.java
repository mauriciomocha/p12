package vista;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.GestionPaciente;
import modelo.Consulta;
import modelo.Jugador;
import modelo.Medico;
import modelo.Paciente;

public class VtnMedico extends JInternalFrame implements ActionListener {

	private GestionPaciente gp;

	private JTextField txtnombre;
	private JTextField txtapellido;
	private JTextField txttitulo;
	private JComboBox comConsulta;
	private JTextField txtcedula;
	private JTextField txtedad;
	private JTextArea txtListado;

	public VtnMedico(GestionPaciente gp) {

		this.gp = gp;
		setTitle("Datos del Medico");
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);
		setSize(500, 400);

		getContentPane().setLayout(new GridLayout(2, 1));
		JPanel pnlTitulo = new JPanel(new FlowLayout());
		
		comConsulta = new JComboBox();
		cargarVtnConsulta();
		

		JLabel nombre = new JLabel("Nombre: ");
		JLabel apellido = new JLabel("Apellido: ");
		JLabel titulo=new JLabel("Titulo: ");
		JLabel consulta=new JLabel("Consulta: ");
		JLabel cedula = new JLabel("Cedula: ");
		JLabel edad = new JLabel("Edad: ");

		txtnombre = new JTextField(15);
		txtapellido = new JTextField(15);
		txttitulo=new JTextField(15);
		txtcedula = new JTextField(15);
		txtedad = new JTextField(15);
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
		panel1.setBorder(BorderFactory.createTitledBorder("Datos del Medico"));
		getContentPane().add(panel1);

		panel1.add(nombre);
		panel1.add(txtnombre);
		panel1.add(apellido);
		panel1.add(txtapellido);
		panel1.add(titulo);
		panel1.add(txttitulo);
		panel1.add(consulta);
		panel1.add(comConsulta);
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

		panel2.add(txtListado);
		panel2.add(salir, BorderLayout.SOUTH);

	}
	private void cargarVtnConsulta() {
		Vector model = new Vector();
		List<Consulta> consultas = gp.getConsultas();

		for (int i = 0; i < consultas.size(); i++) {
			Consulta Consulta = consultas.get(i);
			model.addElement(Consulta);
		}
		comConsulta = new JComboBox(model);

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
		txtnombre.setText("");
		txtapellido.setText("");
		txttitulo.setText("");
		txtcedula.setText("");
		txtedad.setText("");

	}

	private void guardar() {

		String nombre = txtnombre.getText();
		String apellido = txtapellido.getText();
		String titulo=txttitulo.getText();
		String cedula = txtcedula.getText();
		Consulta consulta=(Consulta)comConsulta.getSelectedItem();
		int edad = Integer.parseInt(txtedad.getText());

		gp.agregarMedico(nombre, apellido, cedula, edad,  titulo,  consulta);
		listar();

	}

	private void listar() {
		List<Medico> medicos = gp.getMedicos();
		txtListado.setText("");
		for (int i = 0; i < medicos.size(); i++) {
			Medico medico = medicos.get(i);
			System.out.println("Nombre: " + medico.getNombre() + "\n" + "Apellido: " + medico.getApellido() + "\n"
					+ "Titulo: " + medico.getTitulo() + "\n"+ "Consulta: " + medico.getConsulta() + "\n" +
					"Cedula: " + medico.getCedula() + "\n" + "Edad: " + medico.getEdad() + "\n");

			txtListado.append("Nombre: " + medico.getNombre() + "\n" + "Apellido: " + medico.getApellido() + "\n"
					+ "Titulo: " + medico.getTitulo() + "\n"+ "Consulta: " + medico.getConsulta() + "\n" +
					"Cedula: " + medico.getCedula() + "\n" + "Edad: " + medico.getEdad() + "\n");
		}

	} 

}
