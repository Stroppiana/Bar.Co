package pantallas;

import java.awt.EventQueue;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Barco;
import logica.Envio;

public class HacerEnvio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					HacerEnvio frame = new HacerEnvio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	/**
	 * Create the frame.
	 */
	public HacerEnvio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		/*			
			
			Barco barcoEnvio = new Barco();
			
				LinkedList<Barco> barcos = barcoEnvio.mostrarBarcos();
			
			if (!barcos.isEmpty()) {

				String[] opcionesBarcos = new String[barcos.size()];

				for (int i = 0; i < barcos.size(); i++) {
					opcionesBarcos[i] = String.valueOf(barcos.get(i).getIdBarco());
				}
				

				String barcoID = (String) JOptionPane.showInputDialog(null, "Elija el BARCO", "Ventana",
						JOptionPane.DEFAULT_OPTION, null, opcionesBarcos, opcionesBarcos[0]);
				
				System.out.println(barcoID);
				
				int idBarco = Integer.parseInt(barcoID);
				
				int idSeleccionado = barcoEnvio.seleccionarBarco(idBarco);
				
				
				int idCliente = 1;
				int idEncargado = 1;
				
				String seleccion = JOptionPane.showInputDialog("Desea seleccionar cliente? ");
				
				if (seleccion.equalsIgnoreCase("SI")) {
					idCliente = Integer.parseInt(JOptionPane.showInputDialog("ID CLIENTE"));
				}
				
				 String input = JOptionPane.showInputDialog("Ingrese una fecha (yyyy-MM-dd):");

			        try {
			            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			            LocalDate fechaEntrega = LocalDate.parse(input, formatter);
			            
			            LocalDate fechaEnvio = LocalDate.now();
			            JOptionPane.showMessageDialog(null, "Fecha ingresada: " + fechaEntrega.toString());
			            
			        	Envio envio = new Envio();
						
						if (envio.generarEnvio(fechaEnvio, fechaEntrega, idSeleccionado, idCliente, idEncargado)) {
							JOptionPane.showMessageDialog(null, "ENVIO GENERADO");
						}else {
							JOptionPane.showMessageDialog(null, "ERROR GENERAR ENVIO");
						}
			            
			        } catch (Exception e) {
			            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Utilice yyyy-MM-dd.");
			        }
								
			
				
			}else {
				JOptionPane.showMessageDialog(null, "LISTA VACIA");
			}
			*/
		
		

		setContentPane(contentPane);
	}

}
