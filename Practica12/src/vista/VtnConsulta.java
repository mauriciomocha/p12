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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.GestionPaciente;
import modelo.Consulta;
import modelo.Paciente;



public class VtnConsulta extends JInternalFrame implements ActionListener {
	private GestionPaciente gp;

	private JTextField txthora;
	private JTextField txtnumConsulta;
	private JTextField txtcostoConsulta;
	private JComboBox comPaciente;
	private JTextArea txtListado;

	public VtnConsulta(GestionPaciente gp) {

		this.gp = gp;
		setTitle("Consulta");
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);
		setSize(500, 400);

		getContentPane().setLayout(new GridLayout(2, 1));
		JPanel pnlTitulo = new JPanel(new FlowLayout());

		comPaciente= new JComboBox();
		cargarVtnPaciente();

		JLabel hora = new JLabel("Hora: ");
		JLabel numConsulta = new JLabel("Numero de Consulta: ");
		JLabel CostoConsulta = new JLabel("Consto de la Consulta: ");
		JLabel paciente=new JLabel("Paciente: ");

		txthora = new JTextField(15);
		txtnumConsulta= new JTextField(15);
		txtcostoConsulta= new JTextField(15);
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
		panel1.setBorder(BorderFactory.createTitledBorder("Datos de la Consulta"));
		getContentPane().add(panel1);

		panel1.add(hora);
		panel1.add(txthora);
		panel1.add(numConsulta);
		panel1.add(txtnumConsulta);

		panel1.add(CostoConsulta);
		panel1.add(txtcostoConsulta);
		panel1.add(paciente);
		panel1.add(comPaciente);

		panel1.add(guardar, BorderLayout.SOUTH);
		panel1.add(borrar, BorderLayout.SOUTH);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.setBorder(BorderFactory.createTitledBorder("Listado"));
		getContentPane().add(panel2);

		panel2.add(txtListado);
		panel2.add(salir, BorderLayout.SOUTH);

	}

	private void cargarVtnPaciente() {
		Vector model = new Vector();
		List<Paciente> pacientes= gp.getPacientes();

		for (int i = 0; i < pacientes.size(); i++) {
			Paciente Paciente = pacientes.get(i);
			model.addElement(Paciente);
		}
		comPaciente= new JComboBox(model);

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
		txthora.setText("");
		txtcostoConsulta.setText("");
		txtnumConsulta.setText("");
	}

	private void guardar() {

		int hora = Integer.parseInt(txthora.getText());
		int numconsulta= Integer.parseInt(txtnumConsulta.getText());
		int costoConsulta=Integer.parseInt(txtcostoConsulta.getText());
		Paciente paciente = (Paciente) comPaciente.getSelectedItem();

		gp.agregarConsulta(hora,  numconsulta,  costoConsulta, paciente);
		listar();

	}

	private void listar() {
		List<Consulta> consultas = gp.getConsultas();
		txtListado.setText("");
		for (int i = 0; i < consultas.size(); i++) {
			Consulta consulta = consultas.get(i);
			System.out.println(
					"Hora: " + consulta.getHora() + "\n" + "Numero de la Consulta: " + consulta.getNumconsulta()
							+ "\n" + "Costo de la Consulta: " + consulta.getCostoConsulta() + "\n"
							+ "\n" + "Paciente: " + consulta.getPaciente() + "\n");

			txtListado.append(
					"Hora: " + consulta.getHora() + "\n" + "Numero de la Consulta: " + consulta.getNumconsulta()
					+ "\n" + "Costo de la Consulta: " + consulta.getCostoConsulta() + "\n"
					+ "\n" + "Paciente: " + consulta.getPaciente() + "\n");
		}

	}

}