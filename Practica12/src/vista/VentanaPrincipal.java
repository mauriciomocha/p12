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

		// aqui ponga el menu segun su orden......yo por ejemplo soy el ultimo y puse
		// vtn 25 en
		// adelante xq son 12 ventanas por cabeza ...agan cuenta con las ventanas de las
		// tablas....
		JMenu menuEquipo = new JMenu("Equipo");
		JMenu menuPaciente = new JMenu("Paciente");
		JMenu menuSalir = new JMenu("Salir");

		// aki ponga su subventanas...en el mismo menu ponga las ventans de las
		// tablas...
		JMenuItem jugadores = new JMenuItem("Datos del Jugador");
		jugadores.addActionListener(this);
		jugadores.setActionCommand("Jugador");
		menuEquipo.add(jugadores);

		JMenuItem equipos = new JMenuItem("Datos del Equipo");
		equipos.addActionListener(this);
		equipos.setActionCommand("Equipo");
		menuEquipo.add(equipos);

		JMenuItem fichaInscripcion = new JMenuItem("Datos de la Inscripcion");
		fichaInscripcion.addActionListener(this);
		fichaInscripcion.setActionCommand("Inscripcion");
		menuEquipo.add(fichaInscripcion);

		// tablas....equipo

		JMenuItem tblJugador = new JMenuItem("Tabla del Jugador");
		tblJugador.addActionListener(this);
		tblJugador.setActionCommand("tblJugador");
		menuEquipo.add(tblJugador);

		JMenuItem tblEquipo = new JMenuItem("Tabla del Equipo");
		tblEquipo.addActionListener(this);
		tblEquipo.setActionCommand("tblEquipo");
		menuEquipo.add(tblEquipo);

		JMenuItem tblFichaInscripcion = new JMenuItem("Tabla de la Ficha de Inscripcin");
		tblFichaInscripcion.addActionListener(this);
		tblFichaInscripcion.setActionCommand("tblFichaInscripcion");
		menuEquipo.add(tblFichaInscripcion);

		// fin tablas

		JMenuItem pacientes = new JMenuItem("Datos del Paciente");
		pacientes.addActionListener(this);
		pacientes.setActionCommand("Paciente");
		menuPaciente.add(pacientes);

		JMenuItem consultas = new JMenuItem("Datos de la Consulta");
		consultas.addActionListener(this);
		consultas.setActionCommand("Consultas");
		menuPaciente.add(consultas);

		JMenuItem medicos = new JMenuItem("Dastos del Medico");
		medicos.addActionListener(this);
		medicos.setActionCommand("Medico");
		menuPaciente.add(medicos);
		
		// aki falta las tablas de JMenuItem de pacientes....

		JMenuItem tblPaciente = new JMenuItem("Tabla Paciente");
		tblPaciente.addActionListener(this);
		tblPaciente.setActionCommand("tblPaciente");
		menuPaciente.add(tblPaciente);

		JMenuItem tblConsulta = new JMenuItem("Tabla de Consultas");
		tblConsulta.addActionListener(this);
		tblConsulta.setActionCommand("tblConsulta");
		menuPaciente.add(tblConsulta);

		JMenuItem tblMedico = new JMenuItem("Tabla Medico");
		tblMedico.addActionListener(this);
		tblMedico.setActionCommand("tblMedico");
		menuPaciente.add(tblMedico);

		// fin tablas...

		/*
		 * tblRect = new JMenuItem(lang.getString("TblRectores"));
		 * tblRect.addActionListener(this); tblRect.setActionCommand("tblRectores");
		 * Ventana1.add(tblRect);
		 */

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
		case "tblJugador":
			tblJugador();
			break;
		case "tblEquipo":
			tblEquipo();
			break;
		case "tblFichaInscripcion":
			tblFichaInscripcion();
			break;

		case "Paciente":
			pacientes();
			break;

		case "Consultas":
			consultas();
			break;

		case "Medico":
			medicos();
			break;

		case "tblPaciente":
			tblPaciente();
			break;

		case "tblConsulta":
			tblConsulta();
			break;

		case "tblMedico":
			tblMedico();
			break;

		case "Salir":
			salir();
			break;
		default:
			break;
		}

	}

	private void jugadores() {
		VtnJugador vtn25 = new VtnJugador(this.ge);
		vtn25.setVisible(true);
		escritorio.add(vtn25);

		try {
			vtn25.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void equipos() {
		VtnEquipo vtn26 = new VtnEquipo(this.ge);
		vtn26.setVisible(true);
		escritorio.add(vtn26);

		try {
			vtn26.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void fichaInscripcion() {
		VtnFichaInscripcion vtn27 = new VtnFichaInscripcion(this.ge);
		vtn27.setVisible(true);
		escritorio.add(vtn27);

		try {
			vtn27.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void tblJugador() {
		VtnTblJugador vtn28 = new VtnTblJugador(this.ge);
		vtn28.setVisible(true);
		escritorio.add(vtn28);

		try {
			vtn28.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void tblEquipo() {
		VtnTblEquipo vtn29 = new VtnTblEquipo(this.ge);
		vtn29.setVisible(true);
		escritorio.add(vtn29);

		try {
			vtn29.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void tblFichaInscripcion() {
		VtbTblFichaInscripcion vtn30 = new VtbTblFichaInscripcion(this.ge);
		vtn30.setVisible(true);
		escritorio.add(vtn30);

		try {
			vtn30.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void pacientes() {
		VtnPaciente vtn31 = new VtnPaciente(this.gp);
		vtn31.setVisible(true);
		escritorio.add(vtn31);

		try {
			vtn31.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void consultas() {
		VtnConsulta vtn32 = new VtnConsulta(this.gp);
		vtn32.setVisible(true);
		escritorio.add(vtn32);

		try {
			vtn32.setSelected(true);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private void medicos() {
		VtnMedico vtn33 = new VtnMedico(this.gp);
		vtn33.setVisible(true);
		escritorio.add(vtn33);

		try {
			vtn33.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void tblPaciente() {
		VtnTblPaciente vtn34 = new VtnTblPaciente(this.gp);
		vtn34.setVisible(true);
		escritorio.add(vtn34);

		try {
			vtn34.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void tblConsulta() {
		VtnTblConsulta vtn35 = new VtnTblConsulta(this.gp);
		vtn35.setVisible(true);
		escritorio.add(vtn35);

		try {
			vtn35.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void tblMedico() {
		VtnTblMedico vtn36 = new VtnTblMedico(this.gp);
		vtn36.setVisible(true);
		escritorio.add(vtn36);

		try {
			vtn36.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void salir() {
		System.exit(0);
	}

}
