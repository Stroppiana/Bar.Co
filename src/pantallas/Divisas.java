package pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.Font;
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
		
		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		btnNewButton.setBounds(148, 345, 101, 34);
		contentPane.add(btnNewButton);
		
		JTextField nombreDivisa = new JTextField();
		nombreDivisa.setBounds(22, 153, 215, 34);
		contentPane.add(nombreDivisa);
		nombreDivisa.setColumns(10);
		
		cotizacion = new JTextField();
		cotizacion.setColumns(10);
		cotizacion.setBounds(22, 259, 215, 34);
		contentPane.add(cotizacion);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Divisas.class.getResource("/resources/divisas.png")));
		lblNewLabel.setBounds(0, 0, 639, 456);
		contentPane.add(lblNewLabel);
	}
}
