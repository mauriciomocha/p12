package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controlador.GestionPaciente;



public class VtnTblPaciente extends JInternalFrame implements ActionListener {

	private GestionPaciente gp;
	private JTable tblPaciente;

	public VtnTblPaciente(GestionPaciente gp) {

	

		this.gp = gp;
		
		setTitle("Tabla Paciente");
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);
		setSize(480, 400);
		getContentPane().setLayout(new BorderLayout());
		JPanel pnlTitulo = new JPanel(new FlowLayout());

		JLabel lblTitulo = new JLabel("Datos del Paciente");
		pnlTitulo.add(lblTitulo);

		tblPaciente = new JTable();
		tblPaciente.setModel(new ModelPaciente());

		JScrollPane scrollPaneTabla = new JScrollPane(tblPaciente);

		JPanel pnlBotones = new JPanel(new FlowLayout());

		JButton btnCargar = new JButton("Cargar");
		btnCargar.setActionCommand("btnCargar");
		btnCargar.addActionListener(this);
		pnlBotones.add(btnCargar);

		JButton Salir = new JButton("Salir");
		Salir.setActionCommand("btnSalir");
		Salir.addActionListener(this);
		pnlBotones.add(Salir);

		getContentPane().add(pnlTitulo, BorderLayout.NORTH);
		getContentPane().add(scrollPaneTabla, BorderLayout.CENTER);
		getContentPane().add(pnlBotones, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		switch (comando) {
		case "btnCargar":
			cargarDatos();
			break;
		case "btnSalir":
			salir();
		default:
			break;
		}
	}

	public void cargarDatos() {
		tblPaciente.setModel(new ModelPaciente(gp.getPacientes()));
	}

	public void salir() {
		int opcion = JOptionPane.showConfirmDialog(this, "Desea Salir?", "Confirmar", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		if (opcion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}

}
