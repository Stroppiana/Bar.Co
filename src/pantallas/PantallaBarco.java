package pantallas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logica.Barco;
import logica.Divisa;
import logica.RutaMaritima;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class PantallaBarco extends JFrame {

	private JPanel contentPane;
	private JTextField InpCombustible;
	private JTextField Inpcapacidad;
	private int idRutaMaritima;


	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PantallaBarco frame = new PantallaBarco();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	/**
	 * Create the frame.
	 */
	public PantallaBarco() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		InpCombustible = new JTextField();
		InpCombustible.setBackground(new Color(124, 155, 173));
		InpCombustible.setBounds(37, 116, 187, 28);
		contentPane.add(InpCombustible);
		InpCombustible.setColumns(10);
		
		JLabel Textcombustible = new JLabel("INGRESAR COMBUSTIBLE");
		Textcombustible.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		Textcombustible.setForeground(new Color(0, 185, 185));
		Textcombustible.setBounds(37, 72, 217, 33);
		contentPane.add(Textcombustible);
		
		JLabel Textcapacidad = new JLabel("INGRESAR CAPACIDAD");
		Textcapacidad.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		Textcapacidad.setForeground(new Color(0, 185, 185));
		Textcapacidad.setBounds(37, 148, 217, 33);
		contentPane.add(Textcapacidad);
		
		Inpcapacidad = new JTextField();
		Inpcapacidad.setBackground(new Color(124, 155, 173));
		Inpcapacidad.setColumns(10);
		Inpcapacidad.setBounds(37, 192, 187, 28);
		contentPane.add(Inpcapacidad);
		
		

		JButton rutaSeleccion = new JButton("SELECCIONAR RUTA");
		rutaSeleccion.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		rutaSeleccion.setBackground(new Color(0, 179, 179));
		rutaSeleccion.setBounds(37, 231, 187, 38);
		contentPane.add(rutaSeleccion);
		
		rutaSeleccion.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        RutaMaritima ruta = new RutaMaritima();
		        LinkedList<RutaMaritima> rutas = ruta.mostrarRutas();

		        StringBuilder message = new StringBuilder("Seleccione una ruta marítima:\n");
		        
		        int i = 1;
		        
		        for (RutaMaritima r : rutas) {
		        
		            message.append("ID: ").append(i++).append(", Origen: ").append(r.getOrigen()).append(", Destino: ").append(r.getDestino()).append("\n");
		        }

		        int idIngresado = Integer.parseInt(JOptionPane.showInputDialog(null, message.toString(), "Ingresar ID de RUTA MARÍTIMA", JOptionPane.QUESTION_MESSAGE));
		        
		        idRutaMaritima = idIngresado;

		    }
		});
		
		JButton agregarBarco = new JButton("AGREGAR BARCO");
		agregarBarco.setBackground(new Color(0, 179, 179));
		agregarBarco.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		agregarBarco.setBounds(37, 339, 144, 38);
		contentPane.add(agregarBarco);
		agregarBarco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Barco barco = new Barco();
				
				int combustible = Integer.parseInt(InpCombustible.getText());
				int capacidad = Integer.parseInt(Inpcapacidad.getText());

				
				if (barco.crearBarco(combustible, capacidad,  idRutaMaritima, 1)) {
					JOptionPane.showMessageDialog(contentPane, "AGREGADO CON EXITO");
					
					InpCombustible.setText("");
					Inpcapacidad.setText("");
				}
			}
		});
		
		
		
		JButton Volver = new JButton("<- Menu");
		Volver.setBackground(new Color(0, 179, 179));
		Volver.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 PantallaEncargado menu = new PantallaEncargado();

					menu.run();
					dispose();
					
			}
		});
		Volver.setBounds(517, 74, 89, 28);
		contentPane.add(Volver);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PantallaBarco.class.getResource("/resources/barcocrear.png")));
		lblNewLabel.setBounds(0, 0, 639, 446);
		contentPane.add(lblNewLabel);
		
	}

}
