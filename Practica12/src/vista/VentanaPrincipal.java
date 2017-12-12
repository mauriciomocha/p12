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
import controlador.GestionPais;
import controlador.GestionRevista;

public class VentanaPrincipal extends JFrame implements ActionListener {

	private JDesktopPane escritorio;
	private GestionEquipo ge;
	private GestionPaciente gp;
	private GestionRevista ga;
	private GestionPais gpai;

	public VentanaPrincipal() {
		initComponets();
		ge = new GestionEquipo();
		ga = new GestionRevista();
		gpai = new GestionPais();

	}

	private void initComponets() {

		setSize(2050, 2050);
		setLocationRelativeTo(null);
		setTitle("Ventana Principal");
		getContentPane().setLayout(new BorderLayout());
		escritorio = new JDesktopPane();
		getContentPane().add(escritorio, BorderLayout.CENTER);

		JMenuBar barra = new JMenuBar();

		// aqui ponga el menu segun su orden......yo por ejemplo soy el ultimo y
		// puse vtn 25 en
		// adelante xq son 12 ventanas por cabeza ...agan cuenta con las
		// ventanas de las tablas....
		JMenu menuRevista = new JMenu("Revista");
		JMenu menuEquipo = new JMenu("Equipo");
		JMenu menuPaciente = new JMenu("Paciente");
		JMenu menuPais = new JMenu("Pais");
		JMenu menuSalir = new JMenu("Salir");

		// aki ponga su subventanas...en el mismo menu ponga las ventans de las
		// tablas...
		JMenuItem revistas = new JMenuItem("Datos de Revista");
		revistas.addActionListener(this);
		revistas.setActionCommand("Revista");
		menuRevista.add(revistas);

		JMenuItem articulos = new JMenuItem("Datos de Articulo");
		articulos.addActionListener(this);
		articulos.setActionCommand("Articulo");
		menuRevista.add(articulos);

		JMenuItem paices = new JMenuItem("Datos de pais");
		paices.addActionListener(this);
		paices.setActionCommand("Pais");
		menuPais.add(paices);

		JMenuItem provincias = new JMenuItem("Datos de provincia");
		provincias.addActionListener(this);
		provincias.setActionCommand("Provincia");
		menuPais.add(provincias);

		JMenuItem cantones = new JMenuItem("Datos de canton");
		cantones.addActionListener(this);
		cantones.setActionCommand("Canton");
		menuPais.add(cantones);

		JMenuItem autores = new JMenuItem("Datos de autor");
		autores.addActionListener(this);
		autores.setActionCommand("Autor");
		menuRevista.add(autores);

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

		// aqui viene las tablas de JMenuItem del equipo.....

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
		// aki falta las tablas de JMenuItem de pacientes....

		/*
		 * tblRect = new JMenuItem(lang.getString("TblRectores"));
		 * tblRect.addActionListener(this);
		 * tblRect.setActionCommand("tblRectores"); Ventana1.add(tblRect);
		 */

		JMenuItem salir = new JMenuItem("Salir");
		salir.addActionListener(this);
		salir.setActionCommand("Salir");
		menuSalir.add(salir);

		barra.add(menuRevista);
		barra.add(menuEquipo);
		barra.add(menuPaciente);
		barra.add(menuPais);
		barra.add(menuSalir);
		setJMenuBar(barra);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();
		System.out.println("Eventos menu " + comando);

		switch (comando) {
		case "Revista":
			revistas();
			break;
		case "Articulo":
			articulos();
			break;
		case "Autor":
			autores();
			break;
		case "Pais":
			paices();
			break;
		case "Provincia":
			provincias();
			break;
		case "Canton":
			cantones();
			break;
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

	private void revistas() {
		VtnRevista vtn1 = new VtnRevista(this.ga);
		vtn1.setVisible(true);
		escritorio.add(vtn1);

		try {
			vtn1.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void articulos() {
		VtnArticulo vtn2 = new VtnArticulo(this.ga);
		vtn2.setVisible(true);
		escritorio.add(vtn2);

		try {
			vtn2.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void autores() {
		VtnAutor vtn3 = new VtnAutor(this.ga);
		vtn3.setVisible(true);
		escritorio.add(vtn3);

		try {
			vtn3.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void paices() {
		VtnPais vtnpa = new VtnPais(this.gpai);
		vtnpa.setVisible(true);
		escritorio.add(vtnpa);

		try {
			vtnpa.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void provincias() {
		VtnProvincia vtnpro = new VtnProvincia(this.gpai);
		vtnpro.setVisible(true);
		escritorio.add(vtnpro);

		try {
			vtnpro.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void cantones() {
		VtnCanton vtnca = new VtnCanton(this.gpai);
		vtnca.setVisible(true);
		escritorio.add(vtnca);

		try {
			vtnca.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
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

	public void salir() {
		System.exit(0);
	}

}
