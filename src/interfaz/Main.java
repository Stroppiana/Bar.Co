package interfaz;
import datos.Conexion;
import logica.Encargado;
import pantallas.login;

import java.sql.Connection;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		System.out.println("Creacion del proyecto Bar.Co");
		
		/*
		
		//probando si la coneccion a la base de datos funciona
		Conexion conexion = new Conexion ();
		Connection con = conexion.conectar(); 
		
		
		
		Encargado encargado = new Encargado ("", "", "", "", "", 0);
		PantallaEncargado pe = new PantallaEncargado ();
		
		pe.MenuEncargado(encargado);
		
		System.out.println("2DA PRUEBA");
	
		System.err.println("probandoooofdsa");
		System.out.println();
		
		JOptionPane.showMessageDialog(null, "probando rama");
		
		*/
		login login =new login();
		login.run();
	}

}
