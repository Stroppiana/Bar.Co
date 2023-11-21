package pantallas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class registrarse extends JFrame {

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
				registrarse frame = new registrarse();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
/**
  * Create the frame.
 */
public registrarse() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 730, 519);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JTextArea txtrRegistrarse = new JTextArea();
	txtrRegistrarse.setFont(new Font("Ubuntu Medium", Font.PLAIN, 22));
	txtrRegistrarse.setText("Registrarse");
	txtrRegistrarse.setBounds(291, 7, 123, 36);
	contentPane.add(txtrRegistrarse);
	
	JLabel lblNewLabel = new JLabel("Ingrese nombre");
	lblNewLabel.setBackground(SystemColor.info);
	lblNewLabel.setBounds(291, 54, 104, 30);
	contentPane.add(lblNewLabel);
	
	JLabel lblIngreseApellido = new JLabel("Ingrese apellido");
	lblIngreseApellido.setBounds(291, 128, 104, 30);
	contentPane.add(lblIngreseApellido);
	
	JLabel lblIngreseNombreDe = new JLabel("Ingrese email");
	lblIngreseNombreDe.setBounds(291, 198, 104, 30);
	contentPane.add(lblIngreseNombreDe);
	
	JLabel lblIngreseContrasea = new JLabel("Ingrese contraseña");
	lblIngreseContrasea.setBounds(291, 272, 123, 30);
	contentPane.add(lblIngreseContrasea);
	
	JLabel lblRepitaContrasea = new JLabel("Repita contraseña");
	lblRepitaContrasea.setBounds(291, 342, 104, 30);
	contentPane.add(lblRepitaContrasea);
	
	JButton btnNewButton = new JButton("Registrarse");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			
			
			
		}
	});
	btnNewButton.setFont(new Font("Ubuntu Medium", Font.PLAIN, 18));
	btnNewButton.setBounds(170, 424, 158, 47);
	contentPane.add(btnNewButton);
	
	textField = new JTextField();
	textField.setBounds(291, 87, 123, 30);
	contentPane.add(textField);
	textField.setColumns(10);
	
	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(291, 161, 123, 30);
	contentPane.add(textField_1);
	
	textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(291, 235, 123, 30);
	contentPane.add(textField_2);
	
	JButton btnVolver = new JButton("Volver");
	btnVolver.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			login log = new login ();
			log.run();
			dispose();
		}
	});
	btnVolver.setFont(new Font("Ubuntu Medium", Font.PLAIN, 18));
	btnVolver.setBounds(381, 424, 158, 47);
	contentPane.add(btnVolver);
	
	passwordField_1 = new JPasswordField();
	passwordField_1.setBounds(291, 373, 123, 30);
	contentPane.add(passwordField_1);
	
	passwordField_2 = new JPasswordField();
	passwordField_2.setBounds(291, 301, 123, 30);
	contentPane.add(passwordField_2);
}
}
