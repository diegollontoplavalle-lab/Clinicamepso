package gui;

import java.awt.BorderLayout;
import java.util.List;
import modelo.Cita;
import modelo.Medico;
import modelo.Paciente;
import servicio.SistemaSalud;
import servicio.ProcesadorPacientes;
import javax.swing.JOptionPane;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;


public class V1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static boolean medicosInicializados = false;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNombre;
	private JLabel lblEdad;
	private JLabel lblTelefono;
	private JTextField txtCod;
	private JTextField txtNom;
	private JTextField txtEdad;
	private JTextField txtTel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JMenuBar menuBar;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_3;
	private JMenu mnNewMenu_4;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_4;
	private JLabel lblNewLabel_1;
	private JTextField txtDni;
	private final String[] especialidades = {
		    "Medicina General", "Pediatría", "Ginecología", "Cardiología",
		    "Dermatología", "Odontología", "Psicología", "Nutrición",
		    "Traumatología"
		};

		private final String[] horarios = {
		    "08:00", "09:00", "10:00", "11:00",
		    "14:00", "15:00", "16:00"
		};
		private JLabel lblNewLabel_2;
		private JScrollPane scrollPane;
		private JTable table;
		private JMenu mnNewMenu;
		private JMenuItem mntmNewMenuItem_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ingreso frame = new Ingreso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public V1() {
		setTitle("MEPSO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 486);
		{
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
	
			{
				mnNewMenu_1 = new JMenu("Pacientes");
				menuBar.add(mnNewMenu_1);
				{
					mntmNewMenuItem = new JMenuItem("Registrar paciente");
					mnNewMenu_1.add(mntmNewMenuItem);
					mntmNewMenuItem.addActionListener(e -> {
					    mostrarFormularioPaciente(true);
					    mostrarMensaje("Complete los datos y pulse Registrar Paciente.");
					});
				}
				{
					mntmNewMenuItem_1 = new JMenuItem("Buscar Paciente");
					mnNewMenu_1.add(mntmNewMenuItem_1);
					mntmNewMenuItem_1.addActionListener(e -> buscarPacienteDesdeMenu());
					
					// Reporte: aplica filter, map y reduce (ProcesadorPacientes).
					JMenuItem mntmReporte = new JMenuItem("Generar reporte");
					mnNewMenu_1.add(mntmReporte);
					mntmReporte.addActionListener(e -> mostrarMensaje(
					        ProcesadorPacientes.generarReporte(
					                SistemaSalud.getInstancia().getPacientes())));
				}
			}
			{
				mnNewMenu_3 = new JMenu("Citas");
				menuBar.add(mnNewMenu_3);
				{
					mntmNewMenuItem_4 = new JMenuItem("Registrar cita");
					mnNewMenu_3.add(mntmNewMenuItem_4);
					mntmNewMenuItem_4.addActionListener(e -> registrarCitaDesdeMenu());
				}
			}
			 JMenu menuMedicos = new JMenu("Médicos");
			    menuBar.add(menuMedicos);

			    JMenuItem agregar = new JMenuItem("Agregar médico");
			    agregar.addActionListener(e -> registrarMedico());
			    menuMedicos.add(agregar);

			    JMenuItem eliminar = new JMenuItem("Eliminar médico");
			    eliminar.addActionListener(e -> eliminarMedico());
			    menuMedicos.add(eliminar);
			{
				
				mnNewMenu_4 = new JMenu("Ayuda");
				menuBar.add(mnNewMenu_4);
				JMenuItem contacto = new JMenuItem("Contacto");
				mnNewMenu_4.add(contacto);
				{
					
					
				}

				contacto.addActionListener(e ->
				    JOptionPane.showMessageDialog(this, "Teléfono: 972 120 100")
				);
			}
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Código");
			lblNewLabel.setBounds(18, 35, 60, 25);
			contentPane.add(lblNewLabel);
		}
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(21, 69, 60, 20);
			contentPane.add(lblNombre);
		}
		{
			lblEdad = new JLabel("Edad");
			lblEdad.setBounds(21, 99, 60, 21);
			contentPane.add(lblEdad);
		}
		{
			lblTelefono = new JLabel("Teléfono");
			lblTelefono.setBounds(21, 130, 60, 20);
			contentPane.add(lblTelefono);
		}
		{
			txtCod = new JTextField();
			txtCod.setBounds(72, 37, 96, 18);
			contentPane.add(txtCod);
			txtCod.setColumns(10);
		}
		{
			txtNom = new JTextField();
			txtNom.setBounds(72, 70, 96, 18);
			contentPane.add(txtNom);
			txtNom.setColumns(10);
		}
		{
			txtEdad = new JTextField();
			txtEdad.setBounds(72, 99, 96, 18);
			contentPane.add(txtEdad);
			txtEdad.setColumns(10);
		}
		{
			txtTel = new JTextField();
			txtTel.setBounds(72, 131, 96, 18);
			contentPane.add(txtTel);
			txtTel.setColumns(10);
		}
		{
			btnNewButton = new JButton("Registrar Paciente");
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(21, 190, 147, 25);
			contentPane.add(btnNewButton);
		}
		{
			btnNewButton_1 = new JButton("Buscar Paciente");
			btnNewButton_1.addActionListener(this);
			btnNewButton_1.setBounds(178, 192, 147, 20);
			contentPane.add(btnNewButton_1);
		}
		{
			lblNewLabel_1 = new JLabel("DNI");
			lblNewLabel_1.setBounds(193, 43, 64, 12);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtDni = new JTextField();
			txtDni.setBounds(221, 35, 86, 20);
			contentPane.add(txtDni);
			txtDni.setColumns(10);
		}
		{
			 lblNewLabel_2 = new JLabel("");

			    javax.swing.ImageIcon foto = new javax.swing.ImageIcon(
			            V1.class.getResource("/imagen/poli.png"));

			    java.awt.Image fotoPequena = foto.getImage()
			    		.getScaledInstance(252, 196, java.awt.Image.SCALE_SMOOTH);

			    lblNewLabel_2.setIcon(new javax.swing.ImageIcon(fotoPequena));
			    lblNewLabel_2.setHorizontalAlignment(JLabel.CENTER);
			    lblNewLabel_2.setBounds(350, 10, 251, 196);
			    contentPane.add(lblNewLabel_2);
			}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 231, 590, 145);
			contentPane.add(scrollPane);

			table = new JTable();
			table.setModel(new DefaultTableModel(
				    new Object[][] {},
				    new String[] {"Código", "DNI", "Nombre", "Edad", "Teléfono"}
				) {
				    @Override
				    public boolean isCellEditable(int row, int column) {
				        return false;
				    }
				});
			scrollPane.setViewportView(table);

		

		
			}
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(178, 190, 147, 25);
		btnModificar.addActionListener(e -> modificarPaciente());
		contentPane.add(btnModificar);
		JButton btnEliminar = new JButton("Eliminar paciente");
		btnEliminar.setBounds(178, 385, 160, 25);
		btnEliminar.addActionListener(e -> eliminarPaciente());
		contentPane.add(btnEliminar);
		cargarMedicosIniciales();
		mostrarFormularioPaciente(false);
		actualizarTablaPacientes();
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		String codigo = txtCod.getText().trim();
		    String dni = txtDni.getText().trim();
		    String nombre = txtNom.getText().trim();
		    String edadTexto = txtEdad.getText().trim();
		    String telefono = txtTel.getText().trim();

		    if (codigo.isEmpty() || dni.isEmpty() || nombre.isEmpty()
		            || edadTexto.isEmpty() || telefono.isEmpty()) {

		        JOptionPane.showMessageDialog(this, "Complete todos los campos.");
		        return;
		    }
		    if (!telefono.matches("9[0-9]{8}")) {
		        JOptionPane.showMessageDialog(this,
		                "Agrega un número de teléfono válido.");
		        return;
		    }
		    if (!nombre.matches("[\\p{L}\\p{M} ]+")) {
		        JOptionPane.showMessageDialog(this,
		                "El nombre solo debe contener letras y espacios.");
		        return;
		    }

		    if (!dni.matches("[0-9][0-9]{7}")) {
		        JOptionPane.showMessageDialog(this,
		                "El DNI debe tener 8 números.");
		        return;
		    }
		    if (!edadTexto.matches("\\d+")) {
		        JOptionPane.showMessageDialog(this,
		                "La edad debe contener solamente números.");
		        return;
		    }

		    int edad;

		    try {
		        edad = Integer.parseInt(edadTexto);
		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(this,
		                "Ingrese una edad entre 0 y 120.");
		        return;
		    }

		    if (edad < 0 || edad > 120) {
		        JOptionPane.showMessageDialog(this,
		                "La edad debe estar entre 0 y 120.");
		        return;
		    }

		    SistemaSalud sistema = SistemaSalud.getInstancia();

		    if (sistema.buscarPaciente(codigo) != null) {
		        JOptionPane.showMessageDialog(this,
		                "Ya existe un paciente con ese código.");
		        return;
		    }
		    if (sistema.buscarPacientePorDni(dni) != null) {
		        JOptionPane.showMessageDialog(this,
		                "Ya existe un paciente con ese DNI.");
		        return;
		    }
		    Paciente paciente = new Paciente(
		            codigo,
		            dni,
		            nombre,
		            edad,
		            telefono
		    );

		    sistema.agregarPaciente(paciente);
		    actualizarTablaPacientes();
		    JOptionPane.showMessageDialog(this,
		            "Paciente registrado correctamente.");

		    txtCod.setText("");
		    txtDni.setText("");
		    txtNom.setText("");
		    txtEdad.setText("");
		    txtTel.setText("");
		}
		

	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		String codigo = txtCod.getText().trim();
		String dni = txtDni.getText().trim();

		if (codigo.isEmpty() && dni.isEmpty()) {
		    JOptionPane.showMessageDialog(this, "Ingrese el código o el DNI.");
		    return;
		}

		SistemaSalud sistema = SistemaSalud.getInstancia();
		Paciente paciente;

		if (!codigo.isEmpty()) {
		    paciente = sistema.buscarPaciente(codigo);
		} else {
		    paciente = sistema.buscarPacientePorDni(dni);
		}

		if (paciente == null) {
		    JOptionPane.showMessageDialog(this, "Paciente no encontrado.");
		    mostrarMensaje("");
		    return;
		}

		txtCod.setText(paciente.getCodigo());
		txtDni.setText(paciente.getDni());
		txtNom.setText(paciente.getNombre());
		txtEdad.setText(String.valueOf(paciente.getEdad()));
		txtTel.setText(paciente.getTelefono());

		mostrarMensaje(
		        "PACIENTE ENCONTRADO\n\n"
		        + "Código: " + paciente.getCodigo() + "\n"
		        + "DNI: ****" + paciente.getDni().substring(4) + "\n"
		        + "Nombre: " + paciente.getNombre() + "\n"
		        + "Edad: " + paciente.getEdad()
		);
	}
	private void mostrarFormularioPaciente(boolean mostrar) {
	    lblNewLabel.setVisible(mostrar);   // Código
	    lblNewLabel_1.setVisible(mostrar); // DNI
	    lblNombre.setVisible(mostrar);
	    lblEdad.setVisible(mostrar);
	    lblTelefono.setVisible(mostrar);

	    txtCod.setVisible(mostrar);
	    txtDni.setVisible(mostrar);
	    txtNom.setVisible(mostrar);
	    txtEdad.setVisible(mostrar);
	    txtTel.setVisible(mostrar);

	    btnNewButton.setVisible(mostrar);   // Registrar Paciente
	    btnNewButton_1.setVisible(false);   // Ya buscaremos desde el menú
	}
	private void buscarPacienteDesdeMenu() {
	    String dato = JOptionPane.showInputDialog(
	        this, "Ingrese el código o DNI del paciente:"
	    );

	    if (dato == null) {
	        return;
	    }

	    dato = dato.trim();

	    if (dato.isEmpty()) {
	        JOptionPane.showMessageDialog(
	            this, "Ingrese un código o DNI."
	        );
	        return;
	    }

	    SistemaSalud sistema = SistemaSalud.getInstancia();

	    Paciente paciente = sistema.buscarPaciente(dato);

	    if (paciente == null) {
	        paciente = sistema.buscarPacientePorDni(dato);
	    }

	    if (paciente == null) {
	        JOptionPane.showMessageDialog(
	            this, "Paciente no encontrado."
	        );
	        return;
	    }

	    String dni = paciente.getDni();
	    String dniVisible = dni.length() == 8
	        ? "****" + dni.substring(4)
	        : "****";

	    StringBuilder resultado = new StringBuilder();

	    resultado.append("PACIENTE ENCONTRADO\n\n")
	        .append("Código: ").append(paciente.getCodigo())
	        .append("\nDNI: ").append(dniVisible)
	        .append("\nNombre: ").append(paciente.getNombre())
	        .append("\nEdad: ").append(paciente.getEdad())
	        .append("\nTeléfono: ").append(paciente.getTelefono())
	        .append("\n\nCITAS REGISTRADAS\n");

	    java.util.List<Cita> citas =
	        sistema.buscarCitasPorDni(dni);

	    if (citas.isEmpty()) {
	        resultado.append(
	            "\nEste paciente no tiene citas registradas."
	        );
	    } else {
	        int numero = 1;

	        for (Cita cita : citas) {
	            resultado.append("\nCita ").append(numero++)
	                .append("\nCódigo de cita: ")
	                .append(cita.getCodigo())
	                .append("\nEspecialidad: ")
	                .append(cita.getMedico().getEspecialidad())
	                .append("\nMédico: ")
	                .append(cita.getMedico().getNombre())
	                .append("\nFecha: ").append(cita.getFecha())
	                .append("\nHora: ").append(cita.getHora())
	                .append("\nMotivo: ").append(cita.getMotivo())
	                .append("\n------------------------------\n");
	        }
	    }

	    mostrarFormularioPaciente(false);
	    mostrarMensaje(resultado.toString());
	} 
	private Medico elegirMedico(String especialidad) {
	    List<Medico> disponibles = SistemaSalud.getInstancia()
	            .getMedicos().stream()
	            .filter(m -> m.getEspecialidad().equalsIgnoreCase(especialidad))
	            .toList();

	    if (disponibles.isEmpty()) {
	        JOptionPane.showMessageDialog(this,
	                "Todavía no hay médicos registrados en " + especialidad
	                + ". Registre uno desde el menú Médicos.");
	        return null;
	    }

	    String[] nombres = disponibles.stream()
	            .map(m -> m.getCodigo() + " - " + m.getNombre())
	            .toArray(String[]::new);

	    String elegido = (String) JOptionPane.showInputDialog(
	            this, "Seleccione el médico:", "Médico",
	            JOptionPane.QUESTION_MESSAGE, null, nombres, nombres[0]);

	    if (elegido == null) return null;

	    return disponibles.stream()
	            .filter(m -> elegido.startsWith(m.getCodigo() + " - "))
	            .findFirst()
	            .orElse(null);
	}

	private String elegirHorario(Medico medico, String fecha) {
	    SistemaSalud sistema = SistemaSalud.getInstancia();

	    String[] libres = java.util.Arrays.stream(horarios)
	            .filter(h -> !sistema.horarioOcupado(medico, fecha, h))
	            .toArray(String[]::new);

	    if (libres.length == 0) {
	        JOptionPane.showMessageDialog(this,
	                "No quedan horarios disponibles en esa fecha.");
	        return null;
	    }

	    return (String) JOptionPane.showInputDialog(
	            this, "Horarios disponibles:", "Elegir horario",
	            JOptionPane.QUESTION_MESSAGE, null, libres, libres[0]);
	}

	private void registrarCitaDesdeMenu() {
	    SistemaSalud sistema = SistemaSalud.getInstancia();

	    if (sistema.getPacientes().isEmpty()) {
	        JOptionPane.showMessageDialog(
	            this, "Primero registra un paciente."
	        );
	        return;
	    }

	    // Buscar al paciente.
	    Paciente paciente;

	    while (true) {
	        String dni = JOptionPane.showInputDialog(
	            this, "Ingresa el DNI del paciente:"
	        );

	        if (dni == null) {
	            return;
	        }

	        paciente = sistema.buscarPacientePorDni(dni.trim());

	        if (paciente != null) {
	            break;
	        }

	        JOptionPane.showMessageDialog(
	            this, "No se encontró un paciente con ese DNI."
	        );
	    }

	    // Seleccionar la especialidad.
	    String[] opcionesEspecialidad = {
	        "Medicina General",
	        "Pediatría",
	        "Ginecología",
	        "Cardiología",
	        "Dermatología",
	        "Odontología",
	        "Psicología",
	        "Nutrición",
	        "Traumatología"
	    };

	    String especialidad = (String) JOptionPane.showInputDialog(
	        this,
	        "Selecciona la especialidad:",
	        "Registrar cita",
	        JOptionPane.QUESTION_MESSAGE,
	        null,
	        opcionesEspecialidad,
	        opcionesEspecialidad[0]
	    );

	    if (especialidad == null) {
	        return;
	    }

	    // Obtener los médicos de la especialidad.
	    java.util.List<Medico> disponibles =
	        new java.util.ArrayList<>();

	    for (Medico medico : sistema.getMedicos()) {
	        if (medico.getEspecialidad()
	                .equalsIgnoreCase(especialidad)) {
	            disponibles.add(medico);
	        }
	    }

	    if (disponibles.isEmpty()) {
	        JOptionPane.showMessageDialog(
	            this,
	            "No hay médicos registrados en " + especialidad + "."
	        );
	        return;
	    }

	    String[] opcionesMedico = new String[disponibles.size()];

	    for (int i = 0; i < disponibles.size(); i++) {
	        Medico medico = disponibles.get(i);

	        opcionesMedico[i] =
	            medico.getCodigo() + " - " + medico.getNombre();
	    }

	    String elegido = (String) JOptionPane.showInputDialog(
	        this,
	        "Selecciona al médico:",
	        "Registrar cita",
	        JOptionPane.QUESTION_MESSAGE,
	        null,
	        opcionesMedico,
	        opcionesMedico[0]
	    );

	    if (elegido == null) {
	        return;
	    }

	    Medico medicoSeleccionado = null;

	    for (int i = 0; i < opcionesMedico.length; i++) {
	        if (opcionesMedico[i].equals(elegido)) {
	            medicoSeleccionado = disponibles.get(i);
	            break;
	        }
	    }

	    if (medicoSeleccionado == null) {
	        return;
	    }

	    // Ingresar el motivo sin reiniciar los pasos anteriores.
	    String motivo = "";

	    while (motivo.isEmpty()) {
	        String entrada = JOptionPane.showInputDialog(
	            this, "Ingresa el motivo de la cita:", motivo
	        );

	        if (entrada == null) {
	            return;
	        }

	        motivo = entrada.trim();

	        if (motivo.isEmpty()) {
	            JOptionPane.showMessageDialog(
	                this, "Debes ingresar el motivo de la cita."
	            );
	        }
	    }

	    String fecha = null;
	    String hora = null;

	    String[] horarios = {
	        "08:00", "09:00", "10:00", "11:00",
	        "14:00", "15:00", "16:00"
	    };

	    // Elegir fecha y horario.
	    while (true) {
	        if (fecha == null) {
	            fecha = seleccionarFechaCalendario();

	            if (fecha == null) {
	                return;
	            }
	        }

	        java.util.List<String> horasLibres =
	            new java.util.ArrayList<>();

	        for (String horario : horarios) {
	        	if (!sistema.horarioOcupado(
	        	        medicoSeleccionado,
	        	        fecha,
	        	        horario)) {
	        	    horasLibres.add(horario);
	        	}
	        }

	        if (horasLibres.isEmpty()) {
	            JOptionPane.showMessageDialog(
	                this,
	                "No hay horarios disponibles para esa fecha."
	                + "\nSelecciona otra fecha."
	            );

	            fecha = null;
	            continue;
	        }

	        String[] opcionesHora =
	            horasLibres.toArray(new String[0]);

	        hora = (String) JOptionPane.showInputDialog(
	            this,
	            "Selecciona el horario para el " + fecha + ":",
	            "Horario disponible",
	            JOptionPane.QUESTION_MESSAGE,
	            null,
	            opcionesHora,
	            opcionesHora[0]
	        );

	        if (hora == null) {
	            return;
	        }

	        Object[] botones = {
	            "Registrar", "Cambiar fecha", "Cambiar hora", "Cancelar"
	        };

	        int respuesta = JOptionPane.showOptionDialog(
	            this,
	            "Paciente: " + paciente.getNombre()
	            + "\nMédico: " + medicoSeleccionado.getNombre()
	            + "\nEspecialidad: " + especialidad
	            + "\nFecha: " + fecha
	            + "\nHora: " + hora
	            + "\nMotivo: " + motivo,
	            "Confirmar cita",
	            JOptionPane.DEFAULT_OPTION,
	            JOptionPane.QUESTION_MESSAGE,
	            null,
	            botones,
	            botones[0]
	        );

	        if (respuesta == 0) {
	            break;
	        }

	        if (respuesta == 1) {
	            fecha = null;
	            continue;
	        }

	        if (respuesta == 2) {
	            continue;
	        }

	        return;
	    }

	    // Registrar la cita.
	    String codigoCita =
	        "C-" + java.util.UUID.randomUUID().toString();

	    Cita cita = new Cita(
	        codigoCita,
	        paciente,
	        medicoSeleccionado,
	        fecha,
	        hora,
	        motivo
	    );

	    String receta = generarFichaDemostracion(
	        especialidad, motivo
	    );

	    cita.setReceta(receta);
	    sistema.agregarCita(cita);

	    mostrarMensaje(
	        "CITA REGISTRADA"
	        + "\n\nPaciente: " + paciente.getNombre()
	        + "\nMédico: " + medicoSeleccionado.getNombre()
	        + "\nEspecialidad: " + especialidad
	        + "\nFecha: " + fecha
	        + "\nHora: " + hora
	        + "\nMotivo: " + motivo
	        + "\n\n" + receta
	    );
	    
	}
	private String seleccionarFechaCalendario() {
	    com.toedter.calendar.JCalendar calendario =
	        new com.toedter.calendar.JCalendar();

	    calendario.setLocale(
	        java.util.Locale.forLanguageTag("es-PE")
	    );

	    calendario.setPreferredSize(
	        new java.awt.Dimension(380, 260)
	    );

	    calendario.setDate(new java.util.Date());

	    java.time.LocalDate hoy = java.time.LocalDate.now();

	    java.util.Date fechaMinima = java.util.Date.from(
	        hoy.atStartOfDay(java.time.ZoneId.systemDefault())
	           .toInstant()
	    );

	    calendario.setMinSelectableDate(fechaMinima);

	    while (true) {
	        int opcion = JOptionPane.showConfirmDialog(
	            this,
	            calendario,
	            "Selecciona la fecha de tu cita",
	            JOptionPane.OK_CANCEL_OPTION,
	            JOptionPane.PLAIN_MESSAGE
	        );

	        if (opcion != JOptionPane.OK_OPTION) {
	            return null;
	        }

	        java.util.Date seleccionada = calendario.getDate();

	        if (seleccionada == null) {
	            JOptionPane.showMessageDialog(
	                this, "Selecciona una fecha."
	            );
	            continue;
	        }

	        java.time.LocalDate fecha =
	            seleccionada.toInstant()
	                .atZone(java.time.ZoneId.systemDefault())
	                .toLocalDate();

	        if (fecha.isBefore(java.time.LocalDate.now())) {
	            JOptionPane.showMessageDialog(
	                this, "Selecciona hoy o una fecha futura."
	            );
	            continue;
	        }

	        return fecha.format(
	            java.time.format.DateTimeFormatter.ofPattern(
	                "dd/MM/uuuu"
	            )
	        );
	    }
	}
	private String generarFichaDemostracion(
	        String especialidad, String motivo) {

	    return "FICHA AUTOMÁTICA DE DEMOSTRACIÓN"
	        + "\nEspecialidad: " + especialidad
	        + "\nMotivo informado: " + motivo
	        + "\nAtención solicitada: evaluación por el médico de "
	        + especialidad + "."
	        + "\nDiagnóstico: pendiente de evaluación."
	        + "\nTratamiento y receta: pendientes de indicación médica."
	        + "\nUso académico; no constituye una receta médica.";
	}

	private void consultarCitaDesdeMenu() {
	    String dni = JOptionPane.showInputDialog(this, "Ingrese su DNI:");
	    if (dni == null) return;

	    List<Cita> encontradas = SistemaSalud.getInstancia()
	            .buscarCitasPorDni(dni.trim());

	    if (encontradas.isEmpty()) {
	        JOptionPane.showMessageDialog(this,
	                "No se encontraron citas para ese DNI.");
	        return;
	    }

	    StringBuilder resultado = new StringBuilder("CITAS ENCONTRADAS\n\n");

	    for (Cita cita : encontradas) {
	        resultado.append("Código: ").append(cita.getCodigo())
	                .append("\nEspecialidad: ")
	                .append(cita.getMedico().getEspecialidad())
	                .append("\nMédico: ").append(cita.getMedico().getNombre())
	                .append("\nFecha: ").append(cita.getFecha())
	                .append("\nHora: ").append(cita.getHora())
	                .append("\nMotivo: ").append(cita.getMotivo())
	                .append("\n\n");
	    }

	    mostrarFormularioPaciente(false);
	    mostrarMensaje(resultado.toString());
	}

	private void consultarHorariosDesdeMenu() {
	    String especialidad = (String) JOptionPane.showInputDialog(
	            this, "Seleccione la especialidad:", "Horarios disponibles",
	            JOptionPane.QUESTION_MESSAGE, null,
	            especialidades, especialidades[0]);
	    if (especialidad == null) return;

	    Medico medico = elegirMedico(especialidad);
	    if (medico == null) return;

	    String fecha = JOptionPane.showInputDialog(
	            this, "Fecha a consultar (dd/MM/yyyy):");
	    if (fecha == null) return;
	    fecha = fecha.trim();

	    try {
	        java.time.LocalDate.parse(
	                fecha,
	                java.time.format.DateTimeFormatter.ofPattern("dd/MM/uuuu")
	                        .withResolverStyle(java.time.format.ResolverStyle.STRICT));
	    } catch (java.time.format.DateTimeParseException ex) {
	        JOptionPane.showMessageDialog(this, "Use una fecha válida: dd/MM/yyyy.");
	        return;
	    }

	    StringBuilder resultado = new StringBuilder(
	            "HORARIOS DE " + medico.getNombre() + "\nFecha: " + fecha + "\n\n");

	    for (String hora : horarios) {
	        resultado.append(hora).append(" - ")
	                .append(SistemaSalud.getInstancia()
	                        .horarioOcupado(medico, fecha, hora)
	                        ? "Ocupado" : "Disponible")
	                .append("\n");
	    }

	    mostrarMensaje(resultado.toString());
	}
	private void registrarMedico() {
	    String codigo = JOptionPane.showInputDialog(this, "Código del médico:");
	    if (codigo == null) return;

	    String nombre = JOptionPane.showInputDialog(this, "Nombre ficticio del médico:");
	    if (nombre == null) return;

	    String[] opciones = {
	        "Medicina General", "Pediatría", "Ginecología", "Cardiología",
	        "Dermatología", "Odontología", "Psicología", "Nutrición",
	        "Traumatología"
	    };

	    String especialidad = (String) JOptionPane.showInputDialog(
	            this,
	            "Seleccione la especialidad:",
	            "Registrar médico",
	            JOptionPane.QUESTION_MESSAGE,
	            null,
	            opciones,
	            opciones[0]
	    );

	    if (especialidad == null) return;

	    codigo = codigo.trim();
	    nombre = nombre.trim();

	    if (codigo.isEmpty() || nombre.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Complete el código y el nombre.");
	        return;
	    }

	    SistemaSalud sistema = SistemaSalud.getInstancia();

	    if (sistema.buscarMedico(codigo) != null) {
	        JOptionPane.showMessageDialog(this, "Ese código de médico ya existe.");
	        return;
	    }

	    Medico medico = new Medico(codigo, nombre, especialidad);
	    sistema.agregarMedico(medico);

	    mostrarMensaje("MÉDICO REGISTRADO\n\n"
	            + "Código: " + medico.getCodigo()
	            + "\nNombre: " + medico.getNombre()
	            + "\nEspecialidad: " + medico.getEspecialidad());
	}
	private void cargarMedicosIniciales() {
	    if (medicosInicializados) {
	        return;
	    }

	    medicosInicializados = true;

	    SistemaSalud sistema = SistemaSalud.getInstancia();


	    agregarMedicoInicial(sistema, "M001", "Dr. Carlos Ramírez", "Medicina General");
	    agregarMedicoInicial(sistema, "M002", "Dra. Ana Torres", "Medicina General");

	    agregarMedicoInicial(sistema, "M003", "Dra. María López", "Pediatría");
	    agregarMedicoInicial(sistema, "M004", "Dr. José Castillo", "Pediatría");

	    agregarMedicoInicial(sistema, "M005", "Dra. Sofía Pérez", "Ginecología");
	    agregarMedicoInicial(sistema, "M006", "Dra. Carmen Ruiz", "Ginecología");

	    agregarMedicoInicial(sistema, "M007", "Dr. Pedro Sánchez", "Cardiología");
	    agregarMedicoInicial(sistema, "M008", "Dra. Elena Rojas", "Cardiología");

	    agregarMedicoInicial(sistema, "M009", "Dra. Patricia Díaz", "Dermatología");
	    agregarMedicoInicial(sistema, "M010", "Dr. Ricardo León", "Dermatología");

	    agregarMedicoInicial(sistema, "M011", "Dr. Fernando García", "Odontología");
	    agregarMedicoInicial(sistema, "M012", "Dra. Claudia Silva", "Odontología");

	    agregarMedicoInicial(sistema, "M013", "Lic. Andrea Flores", "Psicología");
	    agregarMedicoInicial(sistema, "M014", "Lic. Carlos Vega", "Psicología");

	    agregarMedicoInicial(sistema, "M015", "Lic. Carla Rojas", "Nutrición");
	    agregarMedicoInicial(sistema, "M016", "Lic. Daniela Pérez", "Nutrición");

	    agregarMedicoInicial(sistema, "M017", "Dr. José Pérez", "Traumatología");
	    agregarMedicoInicial(sistema, "M018", "Dr. Miguel Castro", "Traumatología");
	}

	private void agregarMedicoInicial(SistemaSalud sistema, String codigo,
	                                  String nombre, String especialidad) {
	    if (sistema.buscarMedico(codigo) == null) {
	        sistema.agregarMedico(new Medico(codigo, nombre, especialidad));
	    }
	}
	

	private void actualizarTablaPacientes() {
	    DefaultTableModel modelo =
	        (DefaultTableModel) table.getModel();

	    modelo.setRowCount(0);

	    for (Paciente paciente :
	            SistemaSalud.getInstancia().getPacientes()) {

	        modelo.addRow(new Object[] {
	            paciente.getCodigo(),
	            "****" + paciente.getDni().substring(4), 
	            paciente.getNombre(),
	            paciente.getEdad(),
	            paciente.getTelefono()
	        });
	    }
	}
	private void modificarPaciente() {
	    int fila = table.getSelectedRow();

	    if (fila == -1) {
	        JOptionPane.showMessageDialog(this,
	                "Seleccione un paciente en la tabla.");
	        return;
	    }

	    int filaModelo = table.convertRowIndexToModel(fila);
	    String codigo = table.getModel()
	            .getValueAt(filaModelo, 0).toString();

	    SistemaSalud sistema = SistemaSalud.getInstancia();
	    Paciente paciente = sistema.buscarPaciente(codigo);

	    if (paciente == null) {
	        JOptionPane.showMessageDialog(this,
	                "Paciente no encontrado.");
	        return;
	    }

	    JTextField campoNombre =
	            new JTextField(paciente.getNombre());
	    JTextField campoDni =
	            new JTextField(paciente.getDni());
	    JTextField campoEdad =
	            new JTextField(String.valueOf(paciente.getEdad()));
	    JTextField campoTelefono =
	            new JTextField(paciente.getTelefono());

	    Object[] campos = {
	        "Nombre:", campoNombre,
	        "DNI:", campoDni,
	        "Edad:", campoEdad,
	        "Teléfono:", campoTelefono
	    };

	    int opcion = JOptionPane.showConfirmDialog(
	            this,
	            campos,
	            "Modificar paciente",
	            JOptionPane.OK_CANCEL_OPTION,
	            JOptionPane.PLAIN_MESSAGE
	    );

	    if (opcion != JOptionPane.OK_OPTION) {
	        return;
	    }

	    String nombre = campoNombre.getText().trim();
	    String dni = campoDni.getText().trim();
	    String edadTexto = campoEdad.getText().trim();
	    String telefono = campoTelefono.getText().trim();

	    if (nombre.isEmpty() || dni.isEmpty()
	            || edadTexto.isEmpty() || telefono.isEmpty()) {
	        JOptionPane.showMessageDialog(this,
	                "Complete todos los campos.");
	        return;
	    }

	    if (!nombre.matches("[\\p{L}\\p{M} ]+")) {
	        JOptionPane.showMessageDialog(this,
	                "El nombre solo debe contener letras y espacios.");
	        return;
	    }

	    if (!dni.matches("[0-9][0-9]{7}")) {
	        JOptionPane.showMessageDialog(this,
	                "El DNI debe tener 8 números.");
	        return;
	    }

	    if (!edadTexto.matches("[0-9]+")) {
	        JOptionPane.showMessageDialog(this,
	                "La edad debe contener solamente números.");
	        return;
	    }

	    int edad;

	    try {
	        edad = Integer.parseInt(edadTexto);
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this,
	                "Ingrese una edad entre 0 y 120.");
	        return;
	    }

	    if (edad < 0 || edad > 120) {
	        JOptionPane.showMessageDialog(this,
	                "La edad debe estar entre 0 y 120.");
	        return;
	    }

	    for (Paciente otro : sistema.getPacientes()) {
	        if (otro != paciente && dni.equals(otro.getDni())) {
	            JOptionPane.showMessageDialog(this,
	                    "Ese DNI pertenece a otro paciente.");
	            return;
	        }
	    }

	    paciente.setNombre(nombre);
	    paciente.setDni(dni);
	    paciente.setEdad(edad);
	    paciente.setTelefono(telefono);

	    actualizarTablaPacientes();

	    mostrarMensaje("PACIENTE MODIFICADO\n"
	            + "Código: " + paciente.getCodigo()
	            + "\nNombre: " + nombre
	            + "\nDNI: ****" + dni.substring(4)
	            + "\nEdad: " + edad
	            + "\nTeléfono: " + telefono);

	    JOptionPane.showMessageDialog(this,
	            "Paciente modificado correctamente.");
	}
	private void mostrarMensaje(String mensaje) {
	    if (mensaje == null || mensaje.isBlank()) {
	        return;
	    }

	    JTextArea resultado = new JTextArea(mensaje);
	    resultado.setEditable(false);
	    resultado.setLineWrap(true);
	    resultado.setWrapStyleWord(true);
	    resultado.setCaretPosition(0);

	    JScrollPane scroll = new JScrollPane(resultado);
	    scroll.setPreferredSize(new java.awt.Dimension(430, 250));

	    JOptionPane.showMessageDialog(
	            this,
	            scroll,
	            "Información",
	            JOptionPane.INFORMATION_MESSAGE
	    );
	}
	private void eliminarPaciente() {
	    int fila = table.getSelectedRow();

	    if (fila == -1) {
	        JOptionPane.showMessageDialog(this,
	                "Seleccione un paciente en la tabla.");
	        return;
	    }

	    int filaModelo = table.convertRowIndexToModel(fila);
	    String codigo = table.getModel()
	            .getValueAt(filaModelo, 0).toString();

	    Paciente paciente = SistemaSalud.getInstancia()
	            .buscarPaciente(codigo);

	    if (paciente == null) {
	        return;
	    }

	    int opcion = JOptionPane.showConfirmDialog(
	            this,
	            "¿Eliminar a " + paciente.getNombre()
	            + " y sus citas y atenciones registradas?",
	            "Eliminar paciente",
	            JOptionPane.YES_NO_OPTION
	    );

	    if (opcion != JOptionPane.YES_OPTION) {
	        return;
	    }

	    SistemaSalud.getInstancia().eliminarPaciente(codigo);
	    actualizarTablaPacientes();

	    txtCod.setText("");
	    txtDni.setText("");
	    txtNom.setText("");
	    txtEdad.setText("");
	    txtTel.setText("");

	    JOptionPane.showMessageDialog(this,
	            "Paciente eliminado.");
	}
	private void eliminarMedico() {
	    SistemaSalud sistema = SistemaSalud.getInstancia();
	    List<Medico> medicos = sistema.getMedicos();

	    if (medicos.isEmpty()) {
	        JOptionPane.showMessageDialog(this,
	                "No hay médicos registrados.");
	        return;
	    }

	    String[] opciones = medicos.stream()
	            .map(m -> m.getCodigo() + " - " + m.getNombre()
	                    + " - " + m.getEspecialidad())
	            .toArray(String[]::new);

	    String elegido = (String) JOptionPane.showInputDialog(
	            this,
	            "Seleccione el médico:",
	            "Eliminar médico",
	            JOptionPane.QUESTION_MESSAGE,
	            null, opciones, opciones[0]
	    );

	    if (elegido == null) {
	        return;
	    }

	    int indice = java.util.Arrays.asList(opciones)
	            .indexOf(elegido);
	    Medico medico = medicos.get(indice);

	    int confirmar = JOptionPane.showConfirmDialog(
	            this,
	            "¿Eliminar a " + medico.getNombre() + "?",
	            "Confirmar",
	            JOptionPane.YES_NO_OPTION
	    );

	    if (confirmar != JOptionPane.YES_OPTION) {
	        return;
	    }

	    if (!sistema.eliminarMedico(medico.getCodigo())) {
	        JOptionPane.showMessageDialog(this,
	                "No se puede eliminar: tiene citas registradas.");
	        return;
	    }

	    JOptionPane.showMessageDialog(this, "Médico eliminado.");
	}
	
}