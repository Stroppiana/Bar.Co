package pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class inciarsesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					inciarsesion frame = new inciarsesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		;
	

	/**
	 * Create the frame.
	 */
	public inciarsesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(218, 117, 117, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ingresar email");
		lblNewLabel.setBounds(230, 80, 93, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblIngresarContrasea = new JLabel("Ingresar contraseña");
		lblIngresarContrasea.setBounds(228, 155, 122, 27);
		contentPane.add(lblIngresarContrasea);
		
		JButton btnIniciarSesion = new JButton("Iniciar sesion");
		btnIniciarSesion.setFont(new Font("Ubuntu Medium", Font.PLAIN, 18));
		btnIniciarSesion.setBounds(95, 260, 158, 47);
		contentPane.add(btnIniciarSesion);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login log = new login ();
				log.run();
				dispose();
			}
		});
		btnVolver.setFont(new Font("Ubuntu Medium", Font.PLAIN, 18));
		btnVolver.setBounds(306, 260, 158, 47);
		contentPane.add(btnVolver);
		
		JTextArea txtrIniciarSesion = new JTextArea();
		txtrIniciarSesion.setText("Iniciar sesion");
		txtrIniciarSesion.setFont(new Font("Ubuntu Medium", Font.PLAIN, 22));
		txtrIniciarSesion.setBounds(213, 24, 137, 36);
		contentPane.add(txtrIniciarSesion);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(218, 188, 117, 27);
		contentPane.add(passwordField);
	}
}
