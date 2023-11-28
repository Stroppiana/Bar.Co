package pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BarcoContenedor extends JFrame {

	private JPanel contentPane;

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
		

		JButton barco = new JButton("SELECCIONAR BARCO");
		barco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		barco.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		barco.setBackground(new Color(0, 185, 185));
		barco.setBounds(23, 154, 266, 43);
		contentPane.add(barco);
		
		JButton contenedor = new JButton("SELECCIONAR CONTENEDOR");
		contenedor.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		contenedor.setBackground(new Color(0, 185, 185));
		contenedor.setBounds(23, 69, 266, 43);
		contentPane.add(contenedor);
		
		JButton aceptar = new JButton("ACEPTAR");
		aceptar.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		aceptar.setBackground(new Color(0, 185, 185));
		aceptar.setBounds(23, 232, 143, 34);
		contentPane.add(aceptar);
		
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
