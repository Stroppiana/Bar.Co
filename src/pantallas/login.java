package pantallas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Button;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class login extends JFrame {

private static final long serialVersionUID = 1L;
private JPanel contentPane;

/**
  * Launch the application.
 */

		public void run() {
			try {
				login frame = new login();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	;


/**
  * Create the frame.
 */
public login() {
	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\logo.png"));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 701, 342);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JTextArea txtrBienvenidoABarco = new JTextArea();
	txtrBienvenidoABarco.setBackground(new Color(255, 255, 255));
	txtrBienvenidoABarco.setFont(new Font("Ubuntu Medium", Font.PLAIN, 22));
	txtrBienvenidoABarco.setText("Bienvenido a Bar.co");
	txtrBienvenidoABarco.setBounds(236, 35, 207, 37);
	contentPane.add(txtrBienvenidoABarco);
	
	Button iniciarBoton = new Button("Iniciar sesion");
	iniciarBoton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			inciarsesion is= new inciarsesion();
			is.run();
			dispose();
			
		}
	});
	
	iniciarBoton.setFont(new Font("Ubuntu Medium", Font.BOLD, 16));
	iniciarBoton.setBounds(421, 133, 161, 47);
	contentPane.add(iniciarBoton);
	
	Button registrarseBoton = new Button("Registrarse");
	registrarseBoton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			registrarse pantalla = new registrarse();
			pantalla.run();
			dispose();
			
		}
	});
	registrarseBoton.setFont(new Font("Ubuntu Medium", Font.BOLD, 16));
	registrarseBoton.setBounds(100, 133, 161, 47);
	contentPane.add(registrarseBoton);
	
	JLabel lblNewLabel = new JLabel("Needxcrfcrfw label");
	lblNewLabel.setBounds(87, 47, 103, 80);
	contentPane.add(lblNewLabel);
}
}
