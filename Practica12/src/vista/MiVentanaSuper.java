package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controlador.GestionAutor;



public class MiVentanaSuper extends JFrame implements ActionListener{
	
	private JDesktopPane escritorio;
	private GestionAutor ga;

	public MiVentanaSuper() {
		initComponets();
		ga = new GestionAutor();

	}

	private void initComponets() {
		setSize(2000, 700);
		setTitle("PracticaProgramacion");
		getContentPane().setLayout(new BorderLayout());
		escritorio = new JDesktopPane();
		getContentPane().add(escritorio, BorderLayout.CENTER);

		JMenuBar barra = new JMenuBar();

		JMenu mnuVentanas = new JMenu("Ventanas");
		JMenuItem mnuVentana0 = new JMenuItem("Revista");
		mnuVentana0.addActionListener(this);
		mnuVentana0.setActionCommand("vtnRevista");
		mnuVentanas.add(mnuVentana0);


		JMenuItem mnuSalir = new JMenuItem("Salir");
		mnuSalir.addActionListener(this);
		mnuSalir.setActionCommand("mnuSalir");
		mnuVentanas.add(mnuSalir);

		barra.add(mnuVentanas);

		// getContentPane().add(barra); error
		setJMenuBar(barra);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String comando = e.getActionCommand();
		System.out.println("Eventos menu " + comando);

		switch (comando) {
		case "vtnRevista":
			llamarVentana0();
			break;
		
		case "mnuSalir":
			salir();
			break;
		default:
			break;
		}

	}

	public void llamarVentana0() {
		VtnRevista va = new VtnRevista(this.ga);
		va.setVisible(true);
		escritorio.add(va);

		try {
			va.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	
	public void salir() {
		System.exit(0);
	}

}
