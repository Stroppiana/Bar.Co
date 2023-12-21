package pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class PantallaEncargado extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PantallaEncargado frame = new PantallaEncargado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	/**
	 * Create the frame.
	 */
	public PantallaEncargado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton productoContenedor = new JButton("CARGA-CONT");
		productoContenedor.setForeground(new Color(0, 0, 0));
		productoContenedor.setBackground(new Color(0, 179, 179));
		productoContenedor.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		productoContenedor.setBounds(54, 125, 137, 41);
		contentPane.add(productoContenedor);
		productoContenedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargaContenedor carga = new CargaContenedor();
				carga.run();
			}
		});
		
		JButton rutasMartimas = new JButton("RUTAS MARITIMAS");
		rutasMartimas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Puertos puerto = new Puertos();
				puerto.run();
			}
		});
		rutasMartimas.setBackground(new Color(0, 179, 179));
		rutasMartimas.setFont(new Font("OCR A Extended", Font.PLAIN, 10));
		rutasMartimas.setBounds(54, 213, 137, 41);
		contentPane.add(rutasMartimas);
		
		JButton barco = new JButton("BARCO");
		barco.setBackground(new Color(0, 179, 179));
		barco.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		barco.setBounds(54, 299, 137, 41);
		contentPane.add(barco);
		
		barco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaBarco barco = new PantallaBarco();
				barco.run();
			}
		});
		
		JButton barcoContenedor = new JButton("BARCO-CONT");
		barcoContenedor.setBackground(new Color(0, 179, 179));
		barcoContenedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BarcoContenedor barCont = new BarcoContenedor();
				
				barCont.run();
				
			}
		});
		barcoContenedor.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		barcoContenedor.setBounds(449, 125, 137, 41);
		contentPane.add(barcoContenedor);
		
		JButton divisas = new JButton("DIVISAS");
		divisas.setBackground(new Color(0, 179, 179));
		divisas.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		divisas.setBounds(449, 213, 137, 41);
		contentPane.add(divisas);
		
		divisas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Divisas div = new Divisas();
				div.run();
				dispose();
				
			}
		});
		
		JButton envios = new JButton("ENVIOS");
		envios.setBackground(new Color(0, 179, 179));
		envios.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		envios.setBounds(449, 299, 137, 41);
		contentPane.add(envios);
		
		envios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaMostrarEnvios env = new PantallaMostrarEnvios();
				env.run();
				dispose();
				
			}
		});
		
		JButton salir = new JButton("SALIR");
		salir.setBackground(new Color(0, 179, 179));
		salir.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		salir.setBounds(501, 61, 85, 32);
		contentPane.add(salir);
		
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Loginn log = new Loginn();
				log.run();
				dispose();
				
			}
		});
		
		JButton hacerEnvio = new JButton("HACER ENVIO");
		hacerEnvio.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		hacerEnvio.setBackground(new Color(0, 179, 179));
		hacerEnvio.setBounds(259, 392, 137, 41);
		contentPane.add(hacerEnvio);
		
		hacerEnvio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HacerEnvio env = new HacerEnvio();
				env.run();
				dispose();
				
			}
		});
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PantallaEncargado.class.getResource("/resources/encargadomenu.png")));
		lblNewLabel.setBounds(0, 0, 637, 463);
		contentPane.add(lblNewLabel);
	}
}
