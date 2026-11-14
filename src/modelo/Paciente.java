package modelo;
/**
 * Entidad que representa a un paciente de la Clínica Mepso.
 * Aplica encapsulamiento: atributos privados, getters para todos y setters
 * solo para los datos modificables (el código no tiene setter, RF03).
 * Los datos usados son ficticios (RD06, Ley N.° 29733).
 */
public class Paciente {
	  private String codigo;
	    private String Dni;
	    private String nombre;
	    private int edad;
	    private String telefono;

	    public Paciente(String codigo, String dni, String nombre, int edad, String telefono) {
	        this.codigo = codigo;
	        this.Dni = dni;
	        this.nombre = nombre;
	        this.edad = edad;
	        this.telefono = telefono;
	    }

	    public String getCodigo() {
	        return codigo;
	    }

	    public String getDni() {
	        return Dni;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public int getEdad() {
	        return edad;
	    }

	    public String getTelefono() {
	        return telefono;
	    }
	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }
	    /** Actualiza el DNI. La validación del formato se hace antes, en la ventana V1. */
	    public void setDni(String dni) {
	        this.Dni = dni;
	    }
	    public void setEdad(int edad) {
	        this.edad = edad;
	    }

	    public void setTelefono(String telefono) {
	        this.telefono = telefono;
	    }
	}
	


