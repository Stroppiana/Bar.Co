package interfaz;

import javax.swing.JOptionPane;

import logica.Encargado;
import logica.InicioSesion;

public class PantallaEncargado implements InicioSesion{
	
	public void MenuEncargado(Encargado encargado) {
		
		
		
		String[] opEncargado = {"Asignar Contenedor","Generar envios","Ver Envios"};
		
		int opciones=JOptionPane.showOptionDialog(null,"Ingrese la opcion", null, 0, 0, null, opEncargado, opEncargado[0]);
		
		switch (opciones) {
		case 0:
			JOptionPane.showMessageDialog(null, "Elija que contenedores asignar a el barco: ");
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Generar envio: ");
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Lista de Envios: ");
			break;
		default:
			break;
		}
		
		
	}

}
