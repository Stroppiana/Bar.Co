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
		
		JButton rutasMartimas = new JButton("RUTAS MARITIMAS");
		rutasMartimas.setBackground(new Color(0, 179, 179));
		rutasMartimas.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		rutasMartimas.setBounds(54, 213, 137, 41);
		contentPane.add(rutasMartimas);
		
		JButton barco = new JButton("BARCO");
		barco.setBackground(new Color(0, 179, 179));
		barco.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		barco.setBounds(54, 299, 137, 41);
		contentPane.add(barco);
		
		JButton barcoContenedor = new JButton("BARCO-CONT");
		barcoContenedor.setBackground(new Color(0, 179, 179));
		barcoContenedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		JButton clientes = new JButton("CLIENTES");
		clientes.setBackground(new Color(0, 179, 179));
		clientes.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		clientes.setBounds(449, 299, 137, 41);
		contentPane.add(clientes);
		
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
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PantallaEncargado.class.getResource("/resources/encargadomenu.png")));
		lblNewLabel.setBounds(0, 0, 637, 463);
		contentPane.add(lblNewLabel);
	}
}
