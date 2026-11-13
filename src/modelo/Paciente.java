package modelo;

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
	


