package pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Barco;
import logica.Contenedor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class BarcoContenedor extends JFrame {

	private JPanel contentPane;
	private int idContenedor;
	private int idBarco;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					BarcoContenedor frame = new BarcoContenedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	

	/**
	 * Create the frame.
	 */
	public BarcoContenedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton contenedor = new JButton("SELECCIONAR CONTENEDOR");
		contenedor.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		contenedor.setBackground(new Color(0, 185, 185));
		contenedor.setBounds(23, 69, 266, 43);
		contentPane.add(contenedor);
		contenedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Contenedor contenedor = new Contenedor();

				LinkedList<Contenedor> contenedores = contenedor.mostrarContenedores();
				String[] opcionesContenedor = new String[contenedores.size()];

				for (int i = 0; i < contenedores.size(); i++) {
					opcionesContenedor[i] = String.valueOf(contenedores.get(i).getIdContenedor());
				}

				String contenedorID = (String) JOptionPane.showInputDialog(contentPane, "Elija el ID del CONTENEDOR", "Ventana",
				        JOptionPane.DEFAULT_OPTION, null, opcionesContenedor, opcionesContenedor[0]);

				 idContenedor = Integer.parseInt(contenedorID); 
				 
				 contenedor.seleccionContenedor(idContenedor);
			}
		});

		JButton barco = new JButton("SELECCIONAR BARCO");
		barco.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		barco.setBackground(new Color(0, 185, 185));
		barco.setBounds(23, 154, 266, 43);
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
			
				
			}
		});
		

		
		JButton aceptar = new JButton("ACEPTAR");
		aceptar.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		aceptar.setBackground(new Color(0, 185, 185));
		aceptar.setBounds(23, 232, 143, 34);
		contentPane.add(aceptar);
		
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Barco barco = new Barco();
				
				if (barco.asignarContenedor(idBarco, idContenedor) == true) {
					JOptionPane.showMessageDialog(contentPane, "BARCO Y CONTENEDOR ALMACENADO");
				}else {
					JOptionPane.showMessageDialog(contentPane,"NO FUNCA");
				}
			   
			}
		});
		
		JButton menu = new JButton("<- Menu");
		menu.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		menu.setBackground(new Color(0, 185, 185));
		menu.setBounds(519, 69, 89, 23);
		contentPane.add(menu);
		
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    PantallaEncargado menu = new PantallaEncargado();

				menu.run();
				dispose();
				
			}
		});
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BarcoContenedor.class.getResource("/resources/BarcoContenedor.png")));
		lblNewLabel.setBounds(0, 0, 639, 453);
		contentPane.add(lblNewLabel);
	}

}
