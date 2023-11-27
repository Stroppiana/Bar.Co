package pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaBarco extends JFrame {

	private JPanel contentPane;
	private JTextField InpCombustible;
	private JTextField Inpcapacidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaBarco frame = new PantallaBarco();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaBarco() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		InpCombustible = new JTextField();
		InpCombustible.setBounds(215, 115, 125, 28);
		contentPane.add(InpCombustible);
		InpCombustible.setColumns(10);
		
		JLabel Textcombustible = new JLabel("Ingresar Combustible");
		Textcombustible.setBounds(215, 71, 108, 33);
		contentPane.add(Textcombustible);
		
		JLabel Textcapacidad = new JLabel("Ingresar Capacidad");
		Textcapacidad.setBounds(215, 147, 108, 33);
		contentPane.add(Textcapacidad);
		
		Inpcapacidad = new JTextField();
		Inpcapacidad.setColumns(10);
		Inpcapacidad.setBounds(215, 191, 125, 28);
		contentPane.add(Inpcapacidad);
		
		JButton AgregarBarco = new JButton("Agregar Barco");
		AgregarBarco.setBounds(92, 277, 113, 38);
		contentPane.add(AgregarBarco);
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Volver.setBounds(337, 277, 113, 38);
		contentPane.add(Volver);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PantallaBarco.class.getResource("/resources/0000111863.jpg")));
		lblNewLabel.setBounds(0, 0, 577, 373);
		contentPane.add(lblNewLabel);
		
		
	}
}