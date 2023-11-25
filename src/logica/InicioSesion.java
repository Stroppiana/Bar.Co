package logica;

import javax.swing.JOptionPane;

public interface InicioSesion {
	
	public default  boolean iniciarSesionNombre(String nombre) {
		
		if (nombre.isEmpty() || nombre.length() <= 2 || nombre.contains("@")|| nombre.contains(".") || nombre.contains("?")  || nombre.contains(",")) {
			
			JOptionPane.showMessageDialog(null, "Error en el nombre, vuelva a ingresarlo");
			return false;
		}else {
			
			return true;
		}
		
	}
	
	public default boolean iniciarSesionApellido (String apellido) {
		
		
			if (apellido.isEmpty() || apellido.length() <= 2 || apellido.contains("@")|| apellido.contains(".") || apellido.contains("?")  || apellido.contains(",")) {
			
				JOptionPane.showMessageDialog(null, "Error en el ingreso de apellido");
				return false;
		}else {
			
			return true;
		}
	}

	public default  boolean iniciarSesionClave(String clave, String claverepetida) {
	//cambiar a 8 digitos
		if (clave.isEmpty() || clave.length() < 2 ) {
			if (claverepetida.isEmpty() || claverepetida.length() <2 || clave != claverepetida) {
							
			}
			return false;

		}else {
			
			return true;
		}
	
	
	
	}
	public default boolean validarMail (String usuario) {
		
		if (usuario.contains("@") && usuario.contains(".com") && usuario.length()>2) {
			return true;
		}else {
			return false;
		}
		
	}

}
