package pantallas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Registrarse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	  * Launch the application.
	 */

			public void run() {
				try {
					Registrarse frame = new Registrarse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	/**
	  * Create the frame.
	 */
	public Registrarse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INGRESE NOMBRE");
		lblNewLabel.setForeground(new Color(0, 179, 179));
		lblNewLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		lblNewLabel.setBackground(SystemColor.info);
		lblNewLabel.setBounds(84, 85, 158, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblIngreseApellido = new JLabel("INGRESE APELLIDO");
		lblIngreseApellido.setForeground(new Color(0, 179, 179));
		lblIngreseApellido.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		lblIngreseApellido.setBounds(84, 126, 167, 30);
		contentPane.add(lblIngreseApellido);
		
		JLabel lblIngreseNombreDe = new JLabel("INGRESE EMAIL");
		lblIngreseNombreDe.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		lblIngreseNombreDe.setForeground(new Color(0, 179, 179));
		lblIngreseNombreDe.setBounds(84, 167, 139, 30);
		contentPane.add(lblIngreseNombreDe);
		
		JLabel lblIngreseContrasea = new JLabel("INGRESE CLAVE");
		lblIngreseContrasea.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		lblIngreseContrasea.setForeground(new Color(0, 179, 179));
		lblIngreseContrasea.setBounds(84, 208, 139, 30);
		contentPane.add(lblIngreseContrasea);
		
		JLabel lblRepitaContrasea = new JLabel("REPITA CLAVE");
		lblRepitaContrasea.setForeground(new Color(0, 179, 179));
		lblRepitaContrasea.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		lblRepitaContrasea.setBounds(84, 249, 140, 30);
		contentPane.add(lblRepitaContrasea);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.setBackground(new Color(0, 187, 187));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Ubuntu Medium", Font.PLAIN, 18));
		btnNewButton.setBounds(120, 310, 158, 47);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBackground(new Color(124, 155, 174));
		textField.setBounds(261, 87, 239, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(124, 155, 174));
		textField_1.setColumns(10);
		textField_1.setBounds(261, 126, 239, 30);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(124, 155, 174));
		textField_2.setColumns(10);
		textField_2.setBounds(261, 167, 239, 30);
		contentPane.add(textField_2);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(0, 187, 187));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loginn log = new Loginn ();
				log.run();
				dispose();
			}
		});
		btnVolver.setFont(new Font("Ubuntu Medium", Font.PLAIN, 18));
		btnVolver.setBounds(387, 310, 158, 47);
		contentPane.add(btnVolver);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBackground(new Color(124, 155, 174));
		passwordField_1.setBounds(261, 249, 239, 30);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBackground(new Color(124, 155, 174));
		passwordField_2.setBounds(261, 208, 239, 30);
		contentPane.add(passwordField_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Registrarse.class.getResource("/resources/fondo.png")));
		lblNewLabel_1.setBounds(0, 0, 639, 451);
		contentPane.add(lblNewLabel_1);
	}
	}

