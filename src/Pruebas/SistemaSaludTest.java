package Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import modelo.Cita;
import modelo.Medico;
import modelo.Paciente;
import servicio.ProcesadorPacientes;
import servicio.SistemaSalud;

/* Pruebas JUnit 5 de las reglas del servicio. Cada prueba usa códigos y DNI propios para no interferir por el Singleton. */
class SistemaSaludTest {

    // registrar y buscar un paciente por código
    @Test
    void registraYBuscaPacientePorCodigo() {
        SistemaSalud sistema = SistemaSalud.getInstancia();

        Paciente paciente = new Paciente(
                "TEST-JUNIT-01",
                "12345678",
                "Paciente de prueba",
                20,
                "999999999"
        );

        sistema.agregarPaciente(paciente);

        assertSame(paciente, sistema.buscarPaciente("TEST-JUNIT-01"));
    }

    //  buscar un paciente que no existe devuelve null
    @Test
    void testBuscarPacienteInexistente() {
        SistemaSalud sistema = SistemaSalud.getInstancia();

        assertSame(null, sistema.buscarPaciente("NO-EXISTE"));
    }

    // el patrón Singleton devuelve siempre la misma instancia 
    @Test
    void testSingleton() {
        SistemaSalud sistema1 = SistemaSalud.getInstancia();
        SistemaSalud sistema2 = SistemaSalud.getInstancia();

        assertSame(sistema1, sistema2);
    }

    // un horario queda ocupado después de registrar la cita
    @Test
    void horarioOcupadoDespuesDeAgendarCita() {
        SistemaSalud sistema = SistemaSalud.getInstancia();
        Paciente paciente = new Paciente("TEST-JUNIT-04", "20000004",
                "Paciente Cuatro", 30, "900000004");
        Medico medico = new Medico("TEST-M-04", "Dr. Prueba", "Pediatría");
        sistema.agregarPaciente(paciente);
        sistema.agregarMedico(medico);

        sistema.agregarCita(new Cita("C-TEST-04", paciente, medico,
                "01/01/2030", "09:00", "Control"));

        assertTrue(sistema.horarioOcupado(medico, "01/01/2030", "09:00"));
        assertFalse(sistema.horarioOcupado(medico, "01/01/2030", "10:00"));
    }

    // las citas se recuperan con el DNI del paciente 
    @Test
    void buscarCitasPorDniDevuelveLaCitaDelPaciente() {
        SistemaSalud sistema = SistemaSalud.getInstancia();
        Paciente paciente = new Paciente("TEST-JUNIT-05", "20000005",
                "Paciente Cinco", 40, "900000005");
        Medico medico = new Medico("TEST-M-05", "Dra. Prueba", "Cardiología");
        Cita cita = new Cita("C-TEST-05", paciente, medico,
                "02/01/2030", "08:00", "Chequeo");
        sistema.agregarPaciente(paciente);
        sistema.agregarMedico(medico);
        sistema.agregarCita(cita);

        List<Cita> encontradas = sistema.buscarCitasPorDni("20000005");

        assertEquals(1, encontradas.size());
        assertSame(cita, encontradas.get(0));
    }

    //  eliminar un paciente borra también sus citas
    @Test
    void eliminarPacienteBorraSusCitas() {
        SistemaSalud sistema = SistemaSalud.getInstancia();
        Paciente paciente = new Paciente("TEST-JUNIT-06", "20000006",
                "Paciente Seis", 25, "900000006");
        Medico medico = new Medico("TEST-M-06", "Dr. Seis", "Nutrición");
        sistema.agregarPaciente(paciente);
        sistema.agregarMedico(medico);
        sistema.agregarCita(new Cita("C-TEST-06", paciente, medico,
                "03/01/2030", "11:00", "Dieta"));

        assertTrue(sistema.eliminarPaciente("TEST-JUNIT-06"));

        assertNull(sistema.buscarPaciente("TEST-JUNIT-06"));
        assertTrue(sistema.buscarCitasPorDni("20000006").isEmpty());
    }

    // un médico con citas no se puede eliminar
    @Test
    void medicoConCitasNoSePuedeEliminar() {
        SistemaSalud sistema = SistemaSalud.getInstancia();
        Paciente paciente = new Paciente("TEST-JUNIT-07", "20000007",
                "Paciente Siete", 50, "900000007");
        Medico medico = new Medico("TEST-M-07", "Dra. Siete", "Dermatología");
        sistema.agregarPaciente(paciente);
        sistema.agregarMedico(medico);
        sistema.agregarCita(new Cita("C-TEST-07", paciente, medico,
                "04/01/2030", "14:00", "Revisión"));

        assertFalse(sistema.eliminarMedico("TEST-M-07"));

        // Al borrar al paciente se borran sus citas y ya se puede eliminar.
        sistema.eliminarPaciente("TEST-JUNIT-07");
        assertTrue(sistema.eliminarMedico("TEST-M-07"));
    }

    // el reporte aplica filter, map y reduce sobre los pacientes
    @Test
    void reporteAplicaFilterMapYReduce() {
        List<Paciente> lista = List.of(
                new Paciente("R1", "30000001", "Ana", 10, "900000001"),
                new Paciente("R2", "30000002", "Luis", 20, "900000002"),
                new Paciente("R3", "30000003", "Rosa", 30, "900000003"));

        assertEquals(2, ProcesadorPacientes.filtrarMayoresDeEdad(lista).size());
        assertEquals(3, ProcesadorPacientes.obtenerNombres(lista).size());
        assertEquals(60, ProcesadorPacientes.sumarEdades(lista));
        assertTrue(ProcesadorPacientes.generarReporte(lista)
        		.contains("Total de pacientes: 3"));
    }
}