package modelo;
/* Registro del diagnóstico de una atención médica de un paciente. */
public class Atención {
	 private String diagnostico;
	    private String fecha;
	    private Paciente paciente;

	    public Atención(String diagnostico, String fecha, Paciente paciente) {
	        this.diagnostico = diagnostico;
	        this.fecha = fecha;
	        this.paciente = paciente;
	    }

	    public String getDiagnostico() {
	        return diagnostico;
	    }

	    public String getFecha() {
	        return fecha;
	    }

	    public Paciente getPaciente() {
	        return paciente;
	    }

	    @Override
	    public String toString() {
	        return "Paciente: " + paciente.getNombre()
	                + "\nDiagnóstico: " + diagnostico
	                + "\nFecha: " + fecha;
	    }
	}



