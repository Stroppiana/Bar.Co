package interfaz;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import logica.Cliente;
import logica.Divisa;
import logica.Encargado;
import logica.InicioSesion;
import logica.Puerto;

public class PantallaEncargado implements InicioSesion{
	
	public void MenuEncargado(Encargado encargado) {
	    Cliente cli = new Cliente("", "", "", "");

	    String[] opEncargado = {"Asignar carga contenedor", "Generar RUTA MARITIMA", "Asignar Contenedor a barco", "Generar envíos", "Ver Envíos", "Eliminar clientes", "Ingresar nueva divisa", "Salir"};

	    int opciones = JOptionPane.showOptionDialog(null, "Ingrese la opción", null, 0, 0, null, opEncargado, opEncargado[0]);

	    switch (opciones) {
	        case 0:
	            JOptionPane.showMessageDialog(null, "Asignar CARGA-CONTENEDOR");
	            break;
	        case 1:
	            JOptionPane.showMessageDialog(null, "Generar RUTA MARITIMA");
	            
	            
	            Puerto puerto = new Puerto();
	            Puerto puertoSeleccionada = null;
				
				 System.out.println(puerto.mostrarPuertos());
			       LinkedList<Puerto> puertos = puerto.mostrarPuertos();

			        if (!puertos.isEmpty()) {
			        	String[] opcionesPuerto = new String[puertos.size()];

			            for (int i = 0; i < puertos.size(); i++) {
			            	opcionesPuerto[i] = puertos.get(i).getNombrePuerto();
			            }

			            int seleccionada = JOptionPane.showOptionDialog(null,
			                    "Selecciona PUERTO ORIGEN:",
			                    "Selección de ORIGEN",
			                    JOptionPane.DEFAULT_OPTION,
			                    JOptionPane.QUESTION_MESSAGE,
			                    null,
			                    opcionesPuerto,
			                    opcionesPuerto[0]);

			            if (seleccionada >= 0) {
			            	puertoSeleccionada = puertos.get(seleccionada);
			                JOptionPane.showMessageDialog(null,
			                        "Has seleccionado PUERTO ORIGEN: " + puertoSeleccionada.getNombrePuerto() +
			                        "\nID: " + puertoSeleccionada.getIdPuerto() +
			                        "\nLATITUD: " + puertoSeleccionada.getLatitud() +
			                        "\nLONGITUD: " + puertoSeleccionada.getLongitud() ,
			                        "PUERTO ORIGEN",
			                        JOptionPane.INFORMATION_MESSAGE);
			            }
			        } else {
			            JOptionPane.showMessageDialog(null, "No hay puertos disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
			        }
	            
	            
	            break;
	        case 2:
	            JOptionPane.showMessageDialog(null, "Asignar CONTENEDOR-BARCO");
	            // Aquí puedes agregar el código para asignar contenedores a barcos.
	            break;
	        case 3:
	            JOptionPane.showMessageDialog(null, "Generar envíos");
	            // Aquí puedes agregar el código para generar envíos.
	            break;
	        case 4:
	            JOptionPane.showMessageDialog(null, "Ver Envíos");
	            // Aquí puedes agregar el código para ver los envíos.
	            break;
	        case 5:
	            encargado.eliminarCliente(cli);
	            break;
	        case 6:
	            String tipo = JOptionPane.showInputDialog("Ingrese tipo divisa");
	            double coti = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cotización"));

	            Divisa divisa = new Divisa(tipo, coti);

	            divisa.ingresarDivisa(divisa);
	            break;
	        case 7:
	            JOptionPane.showMessageDialog(null, "Saliendo");
	            break;
	        default:
	            JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
	            break;
	    }
	}


}
