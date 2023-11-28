package interfaz;
import datos.Conexion;
import logica.Encargado;
import logica.RutaMaritima;
import pantallas.PantallaBarco;
import pantallas.BarcoContenedor;
import pantallas.CargaContenedor;
import pantallas.Divisas;
import pantallas.HacerEnvio;
import pantallas.Loginn;
import pantallas.PantallaProducto;
import pantallas.Puertos;

import java.sql.Connection;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

	System.out.println("Creacion del proyecto Bar.Co");
		
			
		
	
		Conexion conexion = new Conexion ();
		Connection con = conexion.conectar(); 
	/*	
		
		
		Encargado encargado = new Encargado ("", "", "", "", "", 0);
		PantallaEncargado pe = new PantallaEncargado ();
		
		pe.MenuEncargado(encargado);
		
		System.out.println("2DA PRUEBA");
	
		System.err.println("probandoooofdsa");
		System.out.println();
		
		JOptionPane.showMessageDialog(null, "probando rama");
		
			*/
	
		Loginn log = new Loginn();
		log.run();
		
	
		
	
	
	}

}
