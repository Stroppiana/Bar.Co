package interfaz;

import java.util.LinkedList;

import javax.swing.ImageIcon;
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
	            Puerto origen = null;
	            Puerto destino = null;

	            System.out.println(puerto.mostrarPuertos());
	            LinkedList<Puerto> puertos = puerto.mostrarPuertos();

	            if (!puertos.isEmpty()) {
	                String[] opcionesPuerto = new String[puertos.size()];

	                for (int i = 0; i < puertos.size(); i++) {
	                    opcionesPuerto[i] = puertos.get(i).getNombrePuerto();
	                }

	                int seleccionadaOrigen = JOptionPane.showOptionDialog(null,
	                        "Selecciona PUERTO DE ORIGEN:",
	                        "Selección de ORIGEN",
	                        JOptionPane.DEFAULT_OPTION,
	                        JOptionPane.QUESTION_MESSAGE,
	                        null,
	                        opcionesPuerto,
	                        opcionesPuerto[0]);

	                if (seleccionadaOrigen >= 0) {
	                    origen = puertos.get(seleccionadaOrigen);

	                    int seleccionadaDestino = JOptionPane.showOptionDialog(null,
	                            "Selecciona PUERTO DE DESTINO:",
	                            "Selección de DESTINO",
	                            JOptionPane.DEFAULT_OPTION,
	                            JOptionPane.QUESTION_MESSAGE,
	                            null,
	                            opcionesPuerto,
	                            opcionesPuerto[0]);

	                    if (seleccionadaDestino >= 0) {
	                        destino = puertos.get(seleccionadaDestino);

	                        JOptionPane.showMessageDialog(null,
	                                "Has seleccionado PUERTO DE ORIGEN: " + origen.getNombrePuerto() +
	                                "\nID: " + origen.getIdPuerto() +
	                                "\nLATITUD: " + origen.getLatitud() +
	                                "\nLONGITUD: " + origen.getLongitud() +
	                                "\n\nHas seleccionado PUERTO DE DESTINO: " + destino.getNombrePuerto() +
	                                "\nID: " + destino.getIdPuerto() +
	                                "\nLATITUD: " + destino.getLatitud() +
	                                "\nLONGITUD: " + destino.getLongitud(),
	                                "RUTA MARITIMA",
	                                JOptionPane.INFORMATION_MESSAGE);
	                    } else {
	                        JOptionPane.showMessageDialog(null, "No has seleccionado un puerto de destino válido.", "Error", JOptionPane.ERROR_MESSAGE);
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "No has seleccionado un puerto de origen válido.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "No hay puertos disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	            
	            
                String[] opcionesPuerto = new String[puertos.size()];


	                for (int i = 0; i < puertos.size(); i++) {
	                    opcionesPuerto[i] = puertos.get(i).getNombrePuerto();
	                }

							String seleccion1 = (String) JOptionPane.showInputDialog(null, "Elija el PUERTO ORIGEN",
									"Ventana", JOptionPane.DEFAULT_OPTION,
									null, opcionesPuerto,
									opcionesPuerto[0]);
							String seleccion2 = (String) JOptionPane.showInputDialog(null, "Elija el PUERTO DESTINO",
									"Ventana", JOptionPane.DEFAULT_OPTION,
									null, opcionesPuerto,
									opcionesPuerto[0]);
							
							System.out.println(seleccion1 +  " - " + seleccion2);

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
