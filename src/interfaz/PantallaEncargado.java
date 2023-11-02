package interfaz;

import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import logica.Barco;
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
		Cliente cli = new Cliente();

		String[] opEncargado = { "CARGA-CONTENEDOR", "RUTA MARITIMA", "BARCO" ,"CONTENEDOR-BARCO",
				"GENERAR ENVIO", "Ver Envíos", "Eliminar clientes", "Mostrar clientes", "Ingresar nueva divisa",
				"Salir" };
		
		int opciones;
		
		Barco barco = new Barco();

		
		do {
			

			opciones = JOptionPane.showOptionDialog(null, "Ingrese la opción", null, 0, 0, null, opEncargado,
				opEncargado[0]);

		switch (opciones) {
		case 0:
			
			JOptionPane.showMessageDialog(null, "Asignar CARGA-CONTENEDOR");

			Producto producto = new Producto();
			
			LinkedList<Producto> productos = producto.mostrarProductos();
			
			if (!productos.isEmpty()) {

				String[] opcionesProductos = new String[productos.size()];

				for (int i = 0; i < productos.size(); i++) {
					opcionesProductos[i] = productos.get(i).getNombre();
				}

				String p1 = (String) JOptionPane.showInputDialog(null, "Elija el PRODUCTO", "Ventana",
						JOptionPane.DEFAULT_OPTION, null, opcionesProductos, opcionesProductos[0]);
				
				System.out.println(p1);
				
				int idProducto = producto.seleccionProducto(p1);
								
				Contenedor contenedor = new Contenedor();

				LinkedList<Contenedor> contenedores = contenedor.mostrarContenedores();
				String[] opcionesContenedor = new String[contenedores.size()];

				for (int i = 0; i < contenedores.size(); i++) {
					opcionesContenedor[i] = String.valueOf(contenedores.get(i).getIdContenedor());
				}

				String contenedorID = (String) JOptionPane.showInputDialog(null, "Elija el ID del CONTENEDOR", "Ventana",
				        JOptionPane.DEFAULT_OPTION, null, opcionesContenedor, opcionesContenedor[0]);

				// Ahora, seleccion1 contendrá el ID del puerto seleccionado como una cadena de texto
				int idContenedor = Integer.parseInt(contenedorID); // Convierte la cadena en un entero

				
		
				
				if (contenedor.asignarProducto(idContenedor, idProducto) == true) {
					JOptionPane.showMessageDialog(null, "CONTENEDOR Y PRODUCTO ALMACENADO");
				}
				
				
			}else {
				JOptionPane.showMessageDialog(null, "LISTA PRODUCTOS VACIA");
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
			
			String tiempoViaje = JOptionPane.showInputDialog("INGRESE CANTIDAD DIAS DE VIAJE");

			RutaMaritima rutaNueva = new RutaMaritima(origen, destino, distancia, tiempoViaje);

			
			if (rutaNueva.guardarDistanciaRuta(origen, destino)) {

				distancia = rutaNueva.calcularDistancia(origen, origen, destino, destino);
			}

			System.out.println("RUTA MARITIMA " + rutaNueva.generarRutaMaritima());


			break;
		case 2:
			
			JOptionPane.showMessageDialog(null, "BARCO A REALIZAR ENVIO");		
			
			try {
				

				int combustible = Integer.parseInt(JOptionPane.showInputDialog("INGRESE EL COMBUSTIBLE DEL BARCO"));
				
				int capacidad = Integer.parseInt(JOptionPane.showInputDialog("INGRESE LA CAPACIDAD DEL BARCO"));
				
				if (barco.crearBarco(combustible, capacidad, 1, 2)) {
					System.out.println("BARCO CREADO");
				}
				
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR DE INGRESO");
			}
			
		
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "Asignar CONTENEDOR-BARCO");
			
			
			Contenedor contenedor = new Contenedor();
			
			LinkedList<Contenedor> contenedores = contenedor.mostrarContenedores();
			
			if (!contenedores.isEmpty()) {

				String[] opcionContenedores = new String[contenedores.size()];

				for (int i = 0; i < contenedores.size(); i++) {
					opcionContenedores[i] =String.valueOf(contenedores.get(i).getIdContenedor());
				}

				String c1 = (String) JOptionPane.showInputDialog(null, "Elija el CONTENEDOR", "Ventana",
						JOptionPane.DEFAULT_OPTION, null, opcionContenedores, opcionContenedores[0]);
				
				System.out.println(c1);
				
				int idContenedor = Integer.parseInt(c1);
				
				contenedor.seleccionContenedor(idContenedor);
								

				LinkedList<Barco> barcos = barco.mostrarBarcos();
				String[] opcionesBarcos = new String[barcos.size()];

				for (int i = 0; i < contenedores.size(); i++) {
					opcionesBarcos[i] = String.valueOf(contenedores.get(i).getIdContenedor()); // Cambiamos el nombre por el ID
				}

				String b1 = (String) JOptionPane.showInputDialog(null, "Elija el ID del BARCO", "Ventana",
				        JOptionPane.DEFAULT_OPTION, null, opcionesBarcos, opcionesBarcos[0]);

				// Ahora, seleccion1 contendrá el ID del puerto seleccionado como una cadena de texto
				int idBarco = Integer.parseInt(b1); // Convierte la cadena en un entero
				
		
				/*
				if (barco.asignarContenedor(idContenedor, idBarco) == true) {
					JOptionPane.showMessageDialog(null, "BARCO Y CONTENEDOR ALMACENADO");
				}
				*/
				
			}else {
				JOptionPane.showMessageDialog(null, "LISTA VACIA");
			}
			
			
			
			break;
		case 4:
			JOptionPane.showMessageDialog(null, "Generar envíos");
			
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Ver Envíos");
		
			break;

		case 6:
			encargado.eliminarCliente(cli);
			
			break;
		case 7:
			
			JOptionPane.showMessageDialog(null, "LISTA CLIENTES \n " + 	encargado.MostrarClientes());
			break;
		case 8:
			String tipo = JOptionPane.showInputDialog("Ingrese tipo divisa");
			double coti = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cotización"));

			Divisa divisa = new Divisa(tipo, coti);

			divisa.ingresarDivisa(divisa);
			break;
		case 9:
			JOptionPane.showMessageDialog(null, "Saliendo");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
			break;
		}
		
		} while (opciones != 9);
		
	}

}
