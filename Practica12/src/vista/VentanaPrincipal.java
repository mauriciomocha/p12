package vista;

import java.awt.BorderLayout;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controlador.GestionEquipo;
import controlador.GestionPaciente;



public class VentanaPrincipal extends JFrame implements ActionListener {

	private JDesktopPane escritorio;
	private GestionEquipo ge;
	private GestionPaciente gp;
	
	
	

	public VentanaPrincipal() {
		initComponets();
		ge = new GestionEquipo();

	}

	private void initComponets() {

		

		setSize(2050, 2050);
		setLocationRelativeTo(null);
		setTitle("Ventana Principal");
		getContentPane().setLayout(new BorderLayout());
		escritorio = new JDesktopPane();
		getContentPane().add(escritorio, BorderLayout.CENTER);

		JMenuBar barra = new JMenuBar();

		
		
		JMenu menuEquipo = new JMenu("Equipo");
		JMenu menuPaciente = new JMenu("Paciente");
		JMenu menuSalir = new JMenu("Salir");
		
		
		
		
		JMenuItem jugadores = new JMenuItem("Datos del Jugador");
		jugadores.addActionListener(this);
		jugadores.setActionCommand("Jugador");
		menuEquipo.add(jugadores);
				
		JMenuItem equipos = new JMenuItem("Datos del Equipo");
		equipos.addActionListener(this);
		equipos.setActionCommand("Equipo");
		menuEquipo.add(equipos);

		JMenuItem fichaInscripcion  = new JMenuItem("Datos de la Inscripcion");
		fichaInscripcion.addActionListener(this);
		fichaInscripcion.setActionCommand("Inscripcion");
		menuEquipo.add(fichaInscripcion);

		//aqui viene las tablas de JMenuItem del equipo..... 
		
		
		JMenuItem pacientes = new JMenuItem("Datos del Paciente");
		pacientes.addActionListener(this);
		pacientes.setActionCommand("Paciente");
		menuPaciente.add(pacientes);

		JMenuItem consultas = new JMenuItem("Datos de la Consulta");
		consultas.addActionListener(this);
		consultas.setActionCommand("Consulta");
		menuPaciente.add(consultas);

		JMenuItem medicos = new JMenuItem("Dastos del Medico");
		medicos.addActionListener(this);
		medicos.setActionCommand("Medico");
		menuPaciente.add(medicos);
		//aki falta las tablas de JMenuItem de pacientes....
		
		
		
		/*tblRect = new JMenuItem(lang.getString("TblRectores"));
		tblRect.addActionListener(this);
		tblRect.setActionCommand("tblRectores");
		Ventana1.add(tblRect);*/

		

		
		JMenuItem salir = new JMenuItem("Salir");
		salir.addActionListener(this);
		salir.setActionCommand("Salir");
		menuSalir.add(salir);

		barra.add(menuEquipo);
		barra.add(menuPaciente);
		barra.add(menuSalir);
		setJMenuBar(barra);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();
		System.out.println("Eventos menu " + comando);

		switch (comando) {
		case "Jugador":
			jugadores();
			break;
		case "Equipo":
			equipos();
			break;
		case "Inscripcion":
			fichaInscripcion();
			break;
		case "Paciente":
			pacientes();
			break;

		case "Consulta":
			consultas();
			break;
		case "Medico":
			medicos();
			break;
		case "Salir":
			salir();
			break;
		default:
			break;
		}

	}
	

	


	private void jugadores() {
		VtnJugador vtn1 = new VtnJugador(this.ge);
		vtn1.setVisible(true);
		escritorio.add(vtn1);

		try {
			vtn1.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private void equipos() {
		VtnEquipo vtn2 = new VtnEquipo(this.ge);
		vtn2.setVisible(true);
		escritorio.add(vtn2);

		try {
			vtn2.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void fichaInscripcion() {
		VtnFichaInscripcion vtn3 = new VtnFichaInscripcion(this.ge);
		vtn3.setVisible(true);
		escritorio.add(vtn3);

		try {
			vtn3.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void pacientes() {
		VtnPaciente vtn4 = new VtnPaciente(this.gp);
		vtn4.setVisible(true);
		escritorio.add(vtn4);

		try {
			vtn4.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	private void consultas() {
		VtnConsulta vtn5 = new VtnConsulta(this.gp);
		vtn5.setVisible(true);
		escritorio.add(vtn5);

		try {
			vtn5.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void medicos() {
		VtnMedico vtn6 = new VtnMedico(this.gp);
		vtn6.setVisible(true);
		escritorio.add(vtn6);

		try {
			vtn6.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	

	public void salir() {
		System.exit(0);
	}

}
