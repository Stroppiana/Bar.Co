package pantallas;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Loginn extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					Loginn frame = new Loginn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	/**
	 * Create the frame.
	 */
	public Loginn() {
		setBackground(new Color(51, 102, 153));
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Loginn.class.getResource("/resources/loggo.png")));

		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button iniciarSesionBoton = new Button("INICIAR SESION");
		iniciarSesionBoton.setBackground(new Color(124, 155, 173));
		iniciarSesionBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IniciarSesion is= new IniciarSesion();
				is.run();
				dispose();
				
			}
		});
		
		iniciarSesionBoton.setFont(new Font("Franklin Gothic Book", Font.BOLD, 16));
		iniciarSesionBoton.setBounds(414, 368, 161, 47);
		contentPane.add(iniciarSesionBoton);
		
		Button registrarseBoton = new Button("REGISTRARSE");
		registrarseBoton.setBackground(new Color(124, 155, 173));
		registrarseBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registrarse reg = new Registrarse();
				reg.run();
				dispose();
				
			}
		});
		registrarseBoton.setFont(new Font("Franklin Gothic Book", Font.BOLD, 16));
		registrarseBoton.setBounds(91, 368, 161, 47);
		contentPane.add(registrarseBoton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Loginn.class.getResource("/resources/loggo.png")));
		lblNewLabel_1.setBounds(195, 54, 265, 308);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Loginn.class.getResource("/resources/fondo.png")));
		lblNewLabel.setBounds(0, -14, 639, 473);
		contentPane.add(lblNewLabel);
	}
}
