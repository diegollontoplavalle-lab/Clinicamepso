package servicio;
import java.util.List;
import java.util.stream.Collectors;

import modelo.Paciente;


public class ProcesadorPacientes {
	   // FILTER
    public static List<Paciente> filtrarMayoresDeEdad(
            List<Paciente> pacientes) {

        return pacientes.stream()
                .filter(p -> p.getEdad() >= 18)
                .collect(Collectors.toList());
    }

    // MAP
    public static List<String> obtenerNombres(
            List<Paciente> pacientes) {

        return pacientes.stream()
                .map(Paciente::getNombre)
                .collect(Collectors.toList());
    }

    // REDUCE 
    public static int sumarEdades(
            List<Paciente> pacientes) {

        return pacientes.stream()
                .map(Paciente::getEdad)
                .reduce(0, Integer::sum);
    }

    // REPORTE
    public static String generarReporte(
            List<Paciente> pacientes) {

        List<Paciente> mayores =
                filtrarMayoresDeEdad(pacientes);

        List<String> nombres =
                obtenerNombres(pacientes);

        int sumaEdades =
                sumarEdades(pacientes);

        double promedio = 0;

        if (!pacientes.isEmpty()) {
            promedio =
                    (double) sumaEdades / pacientes.size();
        }

        StringBuilder reporte =
                new StringBuilder();

        reporte.append("===== REPORTE DE PACIENTES =====\n\n");

        reporte.append("Total de pacientes: ")
               .append(pacientes.size())
               .append("\n");

        reporte.append("Mayores de edad: ")
               .append(mayores.size())
               .append("\n");

        reporte.append("Suma de edades: ")
               .append(sumaEdades)
               .append("\n");

        reporte.append("Promedio de edades: ")
               .append(String.format("%.2f", promedio))
               .append("\n\n");

        reporte.append("Pacientes registrados:\n");

        for (String nombre : nombres) {

            reporte.append("- ")
                   .append(nombre)
                   .append("\n");
        }

        return reporte.toString();
    }
}

	
