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

import controlador.GestionEmpresa;

public class VtnTblEmpresa extends JInternalFrame implements ActionListener {
	private GestionEmpresa ge;
	private JTable tblEmpresa;

	public VtnTblEmpresa(GestionEmpresa ge) {

	

		this.ge = ge;
		
		setTitle("Tabla Empresa");
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);
		setSize(480, 400);
		getContentPane().setLayout(new BorderLayout());
		JPanel pnlTitulo = new JPanel(new FlowLayout());

		JLabel lblTitulo = new JLabel("Datos de la Empresa");
		pnlTitulo.add(lblTitulo);

		tblEmpresa = new JTable();
		tblEmpresa.setModel(new ModelEmpresa());

		JScrollPane scrollPaneTabla = new JScrollPane(tblEmpresa);

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
		tblEmpresa.setModel(new ModelEmpresa(ge.getEmpresas()));
	}

	public void salir() {
		int opcion = JOptionPane.showConfirmDialog(this, "Desea Salir?", "Confirmar", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		if (opcion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}


}
