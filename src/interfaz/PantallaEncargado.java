package interfaz;

import javax.swing.JOptionPane;

import logica.Cliente;
import logica.Divisa;
import logica.Encargado;
import logica.InicioSesion;

public class PantallaEncargado implements InicioSesion{
	
	public void MenuEncargado(Encargado encargado) {
		Cliente cli = new Cliente ("", "", "", "");
		
		
		String[] opEncargado = {"Asignar Contenedor","Generar envios","Ver Envios", "Eliminar clientes","Ingresar nueva divisa" ,"Salir"};
		
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
		case 3:
			encargado.eliminarCliente(cli);
			break;
		case 4:
			
		
			String tipo = JOptionPane.showInputDialog("Ingrese tipo divisa");
			double coti = Double.parseDouble(JOptionPane.showInputDialog("iNGRESE COTIZACIOND"));
			
			Divisa divisa =  new Divisa(tipo, coti);
			
			divisa.ingresarDivisa(divisa);
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Saliendo");
			break;
		}
		
		
	}

}
