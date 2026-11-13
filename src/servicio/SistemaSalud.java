package servicio;
import java.util.ArrayList;
import java.util.List;

import modelo.Paciente;

import modelo.Atención;
import modelo.Cita;
import modelo.Medico;
import modelo.Paciente;

public class SistemaSalud {

    private static SistemaSalud instancia;

    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<Cita> citas;
    private List<Atención> atenciones;

    private SistemaSalud() {

        pacientes = new ArrayList<>();
        medicos = new ArrayList<>();
        citas = new ArrayList<>();
        atenciones = new ArrayList<>();
    }

    public static SistemaSalud getInstancia() {

        if (instancia == null) {
            instancia = new SistemaSalud();
        }

        return instancia;
    }

    // PACIENTES

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public Paciente buscarPaciente(String codigo) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCodigo().equalsIgnoreCase(codigo)) {
                return paciente;
            }
        }
        return null;
    }

    public Paciente buscarPacientePorDni(String dni) {
        return pacientes.stream()
                .filter(p -> p.getDni().equals(dni))
                .findFirst()
                .orElse(null);
    }
        	
    public List<Paciente> getPacientes() {
    	
        return pacientes;
    }

    // MÉDICOS

    public void agregarMedico(Medico medico) {
        medicos.add(medico);
    }

    public Medico buscarMedico(String codigo) {

        for (Medico medico : medicos) {

            if (medico.getCodigo().equalsIgnoreCase(codigo)) {
                return medico;
            }
        }

        return null;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    // CITAS

    public void agregarCita(Cita cita) {
        citas.add(cita);
    }

    public List<Cita> getCitas() {
        return citas;
    }

    // ATENCIONES

    public void agregarAtencion(Atención atencion) {
        atenciones.add(atencion);
    }

    public List<Atención> getAtenciones() {
        return atenciones;
    }
    public List<Cita> buscarCitasPorDni(String dni) {
        return citas.stream()
                .filter(c -> c.getPaciente().getDni().equals(dni))
                .toList();
    }

    public boolean horarioOcupado(Medico medico, String fecha, String hora) {
        return citas.stream().anyMatch(c ->
                c.getMedico().getCodigo().equals(medico.getCodigo())
                && c.getFecha().equals(fecha)
                && c.getHora().equals(hora));
    }
    public boolean eliminarPaciente(String codigo) {
        Paciente paciente = buscarPaciente(codigo);

        if (paciente == null) {
            return false;
        }

        citas.removeIf(c -> c.getPaciente() == paciente);
        atenciones.removeIf(a -> a.getPaciente() == paciente);

        return pacientes.remove(paciente);
    }

    public boolean eliminarMedico(String codigo) {
        Medico medico = buscarMedico(codigo);

        if (medico == null) {
            return false;
        }

        boolean tieneCitas = citas.stream()
                .anyMatch(c -> c.getMedico() == medico);

        if (tieneCitas) {
            return false;
        }

        return medicos.remove(medico);
    }
    }
