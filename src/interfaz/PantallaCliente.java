package interfaz;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import logica.Cliente;
import logica.Divisa;
import logica.Envio;
import logica.HistorialEnvio;
import logica.InicioSesion;
import logica.Producto;

public class PantallaCliente implements InicioSesion {

	public void MenuCliente(Cliente cliente, HistorialEnvio envio) {
		

		String[] opCliente = { "Solicitar envio", "Ver informacion envios", "Salir" };

	        int opciones;
	        
		do {

			opciones = JOptionPane.showOptionDialog(null, "Ingrese la opcion", null, 0, 0, null, opCliente,
					opCliente[0]);
			
			switch (opciones) {
			case 0:

				String fragilidad = "";
				String nombre = "";
				int peso = 0;
				boolean ver = false;
		

				do {
					try {
						nombre = JOptionPane.showInputDialog("Ingresar nombre del producto");
						if (nombre.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Nombre no ingresado correctamente");
						} else {
							//JOptionPane.showMessageDialog(null, "Nombre ingresado correctamente");
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
							//JOptionPane.showMessageDialog(null, "Peso ingresado correctamente");
							ver = true;
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido para el peso.");
					}
				} while (!ver);

				String[] op = { "FRAGIL", "NO FRAGIL" };

				int seleccion = JOptionPane.showOptionDialog(null, "¿Es este producto frágil?", "Pregunta",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);

				switch (seleccion) {
				case 0:
					fragilidad = "FRAGIL";
					break;
				case 1:
					fragilidad = "NO FRAGIL";
					break;
				default:
					break;
				}

				
				 Divisa divisa = new Divisa();
				 Divisa divisaSeleccionada = null;
				
				 System.out.println(divisa.mostrarDivisas());
			       LinkedList<Divisa> divisas = divisa.mostrarDivisas();

			        if (!divisas.isEmpty()) {
			        	String[] opcionesDivisa = new String[divisas.size()];

			            for (int i = 0; i < divisas.size(); i++) {
			            	opcionesDivisa[i] = divisas.get(i).getTipo();
			            }

			            int seleccionada = JOptionPane.showOptionDialog(null,
			                    "Selecciona una divisa:",
			                    "Selección de Divisa",
			                    JOptionPane.DEFAULT_OPTION,
			                    JOptionPane.QUESTION_MESSAGE,
			                    null,
			                    opcionesDivisa,
			                    opcionesDivisa[0]);

			            if (seleccionada >= 0) {
			                divisaSeleccionada = divisas.get(seleccionada);
			                JOptionPane.showMessageDialog(null,
			                        "Has seleccionado la divisa: " + divisaSeleccionada.getTipo() +
			                        "\nID: " + divisaSeleccionada.getId_divisa() +
			                        "\nCotización: " + divisaSeleccionada.getCotizacion(),
			                        "Divisa Seleccionada",
			                        JOptionPane.INFORMATION_MESSAGE);
			            }
			        } else {
			            JOptionPane.showMessageDialog(null, "No hay divisas disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
			        }
				

				Producto productoNuevo = new Producto(nombre, fragilidad, peso);
				
				System.out.println(divisaSeleccionada.getId_divisa());
				
				System.out.println(cliente.solicitarEnvio(productoNuevo, divisaSeleccionada));

				// cliente.solicitarEnvio(productoNuevo, divisaEligida);
				
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "Informacion de los envios: ");
				break;
			default:
				break;
			}
		} while (opciones != 2);

	}

}
