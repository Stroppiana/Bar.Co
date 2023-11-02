package logica;

public class Persona {
	
	private String nombre;
	private String apellido;
	private String mail;
	private String clave;
	
	public Persona(String nombre, String apellido, String mail, String clave) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.clave = clave;

	}
	
	public Persona() {
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", clave=" + clave + ", rol="
			 + "]";
	}
	

}
