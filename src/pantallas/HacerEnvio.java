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
import logica.Cliente;
import logica.Divisa;
import logica.Envio;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class HacerEnvio extends JFrame {

	private JPanel contentPane;
	private int idBarco;
	private JTextField fecha;
    private Cliente clienteSeleccionado;
	
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
		setBounds(100, 100, 657, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton barco = new JButton("SELECCIONAR BARCO");
		barco.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		barco.setBackground(new Color(0, 185, 185));
		barco.setBounds(20, 75, 266, 43);
		contentPane.add(barco);
		
		barco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Barco barco = new Barco();

				LinkedList<Barco> barcos = barco.mostrarBarcos();
				String[] opcionesBarcos = new String[barcos.size()];

				for (int i = 0; i < barcos.size(); i++) {
					opcionesBarcos[i] = String.valueOf(barcos.get(i).getIdBarco());
				}
			

				String b1 = (String) JOptionPane.showInputDialog(contentPane, "Elija el ID del BARCO", "Ventana",
				        JOptionPane.DEFAULT_OPTION, null, opcionesBarcos, opcionesBarcos[0]);
				
				idBarco = Integer.parseInt(b1); 
				
				int idSeleccionado = barco.seleccionarBarco(idBarco);

				System.out.println(idSeleccionado);
				
			}
		});
		
		
		JLabel lblNewLabel_1 = new JLabel("INGRESAR FECHA ENVIO");
		lblNewLabel_1.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(0, 185, 185));
		lblNewLabel_1.setBounds(20, 157, 253, 14);
		contentPane.add(lblNewLabel_1);
		
		fecha = new JTextField();
		fecha.setBackground(new Color(124, 155, 173));
		fecha.setBounds(20, 198, 228, 34);
		contentPane.add(fecha);
		fecha.setColumns(10);
		
		
		JButton elegirCliente = new JButton("CLIENTE");
		elegirCliente.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		elegirCliente.setBackground(new Color(0, 179, 179));
		elegirCliente.setBounds(20, 264, 188, 31);
		contentPane.add(elegirCliente);
		

		elegirCliente.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Cliente cliente = new Cliente();
		        LinkedList<Cliente> clientes = cliente.mostrarClientes();

		        if (!clientes.isEmpty()) {
		            String[] opcionesCliente = new String[clientes.size()];

		            for (int i = 0; i < clientes.size(); i++) {
		            	opcionesCliente[i] = clientes.get(i).getNombre();
		            }

		            int seleccionada = JOptionPane.showOptionDialog(contentPane,
		                    "Selecciona un CLIENTE:",
		                    "Selección de CLIENTE",
		                    JOptionPane.DEFAULT_OPTION,
		                    JOptionPane.QUESTION_MESSAGE,
		                    null,
		                    opcionesCliente,
		                    opcionesCliente[0]);

		            if (seleccionada >= 0) {
		            	clienteSeleccionado = clientes.get(seleccionada);
		                JOptionPane.showMessageDialog(null,
		                        "Has seleccionado la divisa: " + opcionesCliente[seleccionada],
		                        "Divisa Seleccionada",
		                        JOptionPane.INFORMATION_MESSAGE);
		            }
		        } else {
		            JOptionPane.showMessageDialog(contentPane, "No hay divisas disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
		
		JButton aceptar = new JButton("ACEPTAR");
		aceptar.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		aceptar.setBackground(new Color(0, 185, 185));
		aceptar.setBounds(92, 330, 143, 34);
		contentPane.add(aceptar);
		
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int idCliente = 0;
				int idEncargado = 1;
				
				
				 String input = fecha.getText();

			      
			            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			            LocalDate fechaEntrega = LocalDate.parse(input, formatter);
			            
			            LocalDate fechaEnvio = LocalDate.now();
			            JOptionPane.showMessageDialog(contentPane, "Fecha ingresada: " + fechaEntrega.toString());
			            
			        	Envio envio = new Envio();
						
						if (envio.generarEnvio(fechaEnvio, fechaEntrega, idBarco, clienteSeleccionado, idEncargado)) {
							JOptionPane.showMessageDialog(contentPane, "ENVIO GENERADO");
						}else {
							JOptionPane.showMessageDialog(contentPane, "ERROR GENERAR ENVIO");
						}
			            
						fecha.setText("");
			        
				
			}
		});
		
		
		
		
		JButton menu = new JButton("<- Menu");
		menu.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		menu.setBackground(new Color(0, 185, 185));
		menu.setBounds(516, 75, 89, 23);
		contentPane.add(menu);
		
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    PantallaEncargado menu = new PantallaEncargado();

				menu.run();
				dispose();
				
			}
		});
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(HacerEnvio.class.getResource("/resources/envio.png")));
		lblNewLabel.setBounds(0, 0, 639, 458);
		contentPane.add(lblNewLabel);
	}

}
