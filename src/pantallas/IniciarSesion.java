package pantallas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logica.Capitan;
import logica.Cliente;
import logica.Encargado;
import logica.InicioSesion;

import javax.swing.ImageIcon;
import java.awt.Color;

public class IniciarSesion extends JFrame  implements InicioSesion{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					IniciarSesion frame = new IniciarSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		;
	

	/**
	 * Create the frame.
	 */
	public IniciarSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(new Color(124, 155, 173));
		textField.setBounds(124, 152, 275, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("INGRESAR EMAIL");
		lblNewLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(0, 185, 185));
		lblNewLabel.setBounds(126, 114, 182, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblIngresarContrasea = new JLabel("INGRESAR CLAVE");
		lblIngresarContrasea.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		lblIngresarContrasea.setForeground(new Color(0, 185, 185));
		lblIngresarContrasea.setBounds(124, 207, 167, 27);
		contentPane.add(lblIngresarContrasea);
		
		JButton btnIniciarSesion = new JButton("INICIAR SESION");
		btnIniciarSesion.setBackground(new Color(0, 179, 179));
		btnIniciarSesion.setForeground(new Color(0, 0, 0));
		btnIniciarSesion.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		btnIniciarSesion.setBounds(134, 309, 192, 44);
		contentPane.add(btnIniciarSesion);
		
        btnIniciarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = textField.getText();
                String clave = new String(passwordField.getPassword());

                
                
            //	usuario=JOptionPane.showInputDialog("ingrese su nombre de usuario");
    			//clave=JOptionPane.showInputDialog("ingrese su clave");
    			Cliente cliente = new Cliente();
                Encargado encargado = new Encargado();
                Capitan capitan = new Capitan();
    			cliente.setMail(usuario);
    			cliente.setClave(clave);
    			
    			encargado.setMail(usuario);
    			encargado.setClave(clave);
    			
    			capitan.setMail(usuario);
    			capitan.setClave(clave);
    			
    			IniciarSesion valida = new IniciarSesion();
    			
    			if (valida.iniciarSesionClave(usuario, clave) && valida.validarMail(usuario) && encargado.inicioSesionEncargado() || (valida.iniciarSesionClave(usuario, clave) && valida.validarMail(usuario) && cliente.inicioSsesionCliente()) ||(valida.iniciarSesionClave(usuario, clave) && valida.validarMail(usuario) && capitan.inicioSesionCapitan())) {
    				
    				System.out.println("ENTRE");
    				
    				
    			}else {
    				System.out.println("NO ENTRE");
    			}
                
                // Realizar la autenticación

         
            }
        });
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(0, 179, 179));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loginn log = new Loginn ();
				log.run();
				dispose();
			}
		});
		btnVolver.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		btnVolver.setBounds(494, 69, 109, 38);
		contentPane.add(btnVolver);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(124, 155, 173));
		passwordField.setBounds(124, 245, 277, 44);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(IniciarSesion.class.getResource("/resources/fondo.png")));
		lblNewLabel_1.setBounds(0, 0, 639, 451);
		contentPane.add(lblNewLabel_1);
	}
	

}
