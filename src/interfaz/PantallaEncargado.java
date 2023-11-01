package interfaz;

import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import logica.Cliente;
import logica.Contenedor;
import logica.Divisa;
import logica.Encargado;
import logica.InicioSesion;
import logica.Producto;
import logica.Puerto;
import logica.RutaMaritima;

public class PantallaEncargado implements InicioSesion {

	public void MenuEncargado(Encargado encargado) {
		Cliente cli = new Cliente("", "", "", "");

		String[] opEncargado = { "Asignar carga contenedor", "Generar RUTA MARITIMA", "Asignar Contenedor a barco",
				"Generar envíos", "Ver Envíos", "Eliminar clientes", "Mostrar clientes", "Ingresar nueva divisa",
				"Salir" };

		int opciones = JOptionPane.showOptionDialog(null, "Ingrese la opción", null, 0, 0, null, opEncargado,
				opEncargado[0]);

		switch (opciones) {
		case 0:
			JOptionPane.showMessageDialog(null, "Asignar CARGA-CONTENEDOR");

			Producto producto = null;
			Contenedor contenedor = new Contenedor(opciones, opciones, false);

			try {
				if (producto.getPeso() < contenedor.getCapacidad()) {
					JOptionPane.showMessageDialog(null, "El producto podrá ser trasladado dentro de un contenedor");

				} else if (producto.getFragil().equalsIgnoreCase("si")) {
					JOptionPane.showMessageDialog(null, "El producto deber tener protección");

				} else {
					JOptionPane.showMessageDialog(null,
							"El producto no entra en el contenedor. Debe reducir el peso del mismo");
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Generar RUTA MARITIMA");

			Puerto puerto = new Puerto();

			LinkedList<Puerto> puertos = puerto.mostrarPuertos();

			String[] opcionesPuerto = new String[puertos.size()];

			for (int i = 0; i < puertos.size(); i++) {
				opcionesPuerto[i] = puertos.get(i).getNombrePuerto();
			}

			String seleccion1 = (String) JOptionPane.showInputDialog(null, "Elija el PUERTO ORIGEN", "Ventana",
					JOptionPane.DEFAULT_OPTION, null, opcionesPuerto, opcionesPuerto[0]);
			String seleccion2 = (String) JOptionPane.showInputDialog(null, "Elija el PUERTO DESTINO", "Ventana",
					JOptionPane.DEFAULT_OPTION, null, opcionesPuerto, opcionesPuerto[0]);

			System.out.println(seleccion1 + " - " + seleccion2);

			int origen, destino;

			origen = puerto.seleccionPuerto(seleccion1);
			destino = puerto.seleccionPuerto(seleccion2);

			double distancia = 0;

			RutaMaritima rutaNueva = new RutaMaritima(origen, destino, distancia);

			if (rutaNueva.guardarDistanciaRuta(origen, destino)) {

				distancia = rutaNueva.calcularDistancia(origen, origen, destino, destino);
			}

			System.out.println("RUTA MARITIMA " + rutaNueva.generarRutaMaritima());

			// probando

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
			encargado.MostrarClientes();
			break;
		case 7:
			String tipo = JOptionPane.showInputDialog("Ingrese tipo divisa");
			double coti = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cotización"));

			Divisa divisa = new Divisa(tipo, coti);

			divisa.ingresarDivisa(divisa);
			break;
		case 8:
			JOptionPane.showMessageDialog(null, "Saliendo");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}

}
