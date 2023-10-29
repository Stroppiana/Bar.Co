package interfaz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import javax.swing.JOptionPane;

import datos.Conexion;
import logica.Cliente;
import logica.Divisa;
import logica.Envio;
import logica.HistorialEnvio;
import logica.InicioSesion;
import logica.Producto;

public class PantallaCliente implements InicioSesion {

	public void MenuCliente(Cliente cliente, HistorialEnvio envio) {

		JOptionPane.showMessageDialog(null, "ddd");
		

		String[] opCliente = { "Solicitar envio", "Ver informacion envios", "Salir" };
		
		Divisa divisa = new Divisa();
		
		System.out.println(divisa.mostrarDivisas());

		int opciones = JOptionPane.showOptionDialog(null, "Ingrese la opcion", null, 0, 0, null, opCliente,
				opCliente[0]);
		do {

			switch (opciones) {
			case 0:

				boolean fragil;
				String fragilidad = "fragil+";
				String nombre = "";
				int peso = 0;
				boolean ver = false;

				
				
				

				do {
					try {
						nombre = JOptionPane.showInputDialog("Ingresar nombre del producto");
						if (nombre.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Nombre no ingresado correctamente");
						} else {
							JOptionPane.showMessageDialog(null, "Nombre ingresado correctamente");
							ver = true;
						}
					} catch (NullPointerException e) {
						JOptionPane.showMessageDialog(null, "Error: No se proporcionó un nombre.");
					}
				} while (!ver);

				ver = false;

				do {
					try {
						peso = Integer.parseInt(JOptionPane.showInputDialog("Ingresar peso del producto"));
						if (peso < 1) {
							JOptionPane.showMessageDialog(null, "Peso no ingresado correctamente");
						} else {
							JOptionPane.showMessageDialog(null, "Peso ingresado correctamente");
							ver = true;
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido para el peso.");
					}
				} while (!ver);

				String[] op = { "Sí", "No" };

				int seleccion = JOptionPane.showOptionDialog(null, "¿Es este producto frágil?", "Pregunta",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);

				fragil = (seleccion == JOptionPane.YES_OPTION);

				/* validar info creacion producto */

				Producto productoNuevo = new Producto(nombre, fragilidad, peso);

				cliente.solicitarEnvio(productoNuevo);

				// cliente.solicitarEnvio(productoNuevo, divisaEligida);
			case 1:
				JOptionPane.showMessageDialog(null, "Informacion de los envios: ");
				break;
			default:
				break;
			}
		} while (opciones != 2);

	}

}
