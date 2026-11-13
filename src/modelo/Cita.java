package modelo;

public class Cita {
	private String codigo;
    private Paciente paciente;
    private Medico medico;
    private String fecha;
    private String hora;
    private String motivo;
    private String receta = "Pendiente de atención médica.";
    public Cita(String codigo, Paciente paciente, Medico medico,
                String fecha, String hora, String motivo) {

        this.codigo = codigo;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
    }

    public String getCodigo() {
        return codigo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }
    public String getMotivo() {
        return motivo;
     
    }

    @Override
    public String toString() {
        return "Código de cita: " + codigo
                + "\nPaciente: " + paciente.getNombre()
                + "\nEspecialidad: " + medico.getEspecialidad()
                + "\nMédico: " + medico.getNombre()
                + "\nFecha: " + fecha
                + "\nHora: " + hora
                + "\nMotivo: " + motivo;
    }
    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }
}

