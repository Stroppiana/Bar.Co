package pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Divisa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Divisas extends JFrame {

	private JPanel contentPane;
	private JTextField cotizacion;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					Divisas frame = new Divisas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	/**
	 * Create the frame.
	 */
	public Divisas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("INGRESE NOMBRE DIVISA");
		lblNewLabel_1.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(0, 198, 198));
		lblNewLabel_1.setBounds(22, 116, 227, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("INGRESE COTIZACION");
		lblNewLabel_1_1.setForeground(new Color(0, 198, 198));
		lblNewLabel_1_1.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(22, 219, 227, 14);
		contentPane.add(lblNewLabel_1_1);
				
		
		JTextField nombreDivisa = new JTextField();
		nombreDivisa.setBackground(new Color(124, 155, 173));
		nombreDivisa.setBounds(22, 153, 215, 34);
		contentPane.add(nombreDivisa);
		nombreDivisa.setColumns(10);
		
		cotizacion = new JTextField();
		cotizacion.setBackground(new Color(124, 155, 173));
		cotizacion.setColumns(10);
		cotizacion.setBounds(22, 259, 215, 34);
		contentPane.add(cotizacion);
		
		JButton aceptar = new JButton("ACEPTAR");
		aceptar.setBackground(new Color(0, 179, 179));
		aceptar.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		aceptar.setBounds(148, 345, 101, 34);
		contentPane.add(aceptar);
		
		
		aceptar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String tipo = nombreDivisa.getText();
		        try {
		            double coti = Double.parseDouble(cotizacion.getText());

		            Divisa divisa = new Divisa(tipo, coti);
		            divisa.ingresarDivisa(divisa);

		            JOptionPane.showMessageDialog(contentPane, "Divisa ingresada", "Éxito", JOptionPane.INFORMATION_MESSAGE);

		            nombreDivisa.setText("");
		            cotizacion.setText("");
		            
		            volverAlMenu();
		            dispose();

		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(contentPane, "Ingrese una cotización válida.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
		
		JButton volverMenu = new JButton("<- Menu");
		volverMenu.setBackground(new Color(0, 179, 179));
		volverMenu.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		volverMenu.setBounds(501, 58, 109, 28);
		contentPane.add(volverMenu);
		
		volverMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    PantallaEncargado menu = new PantallaEncargado();

				menu.run();
				dispose();
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Divisas.class.getResource("/resources/divisas.png")));
		lblNewLabel.setBounds(0, 0, 639, 456);
		contentPane.add(lblNewLabel);
	}
	
	private void volverAlMenu() {
	    PantallaEncargado menu = new PantallaEncargado();
	    setContentPane(menu.getContentPane());
	    revalidate();
	    repaint();
	}
}
