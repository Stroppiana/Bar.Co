package pantallas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Puerto;
import logica.RutaMaritima;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Puertos extends JFrame {

	private JPanel contentPane;
    private ButtonGroup buttonGroup;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					Puertos frame = new Puertos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	/**
	 * Create the frame.
	 */
	public Puertos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton puertoUshuaia = new JRadioButton("puerto Ushuaia");
		puertoUshuaia.setForeground(new Color(128, 255, 255));
		puertoUshuaia.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		puertoUshuaia.setOpaque(false);
		puertoUshuaia.setBounds(264, 375, 123, 23);
		contentPane.add(puertoUshuaia);
		
		JRadioButton puertoMadryn = new JRadioButton("puerto Madryn");
		puertoMadryn.setOpaque(false);
		puertoMadryn.setForeground(new Color(128, 255, 255));
		puertoMadryn.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		puertoMadryn.setBounds(282, 327, 123, 23);
		contentPane.add(puertoMadryn);
		
		JRadioButton puertoChubut = new JRadioButton("puerto Chubut");
		puertoChubut.setOpaque(false);
		puertoChubut.setForeground(new Color(128, 255, 255));
		puertoChubut.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		puertoChubut.setBounds(292, 286, 123, 23);
		contentPane.add(puertoChubut);
		
		JRadioButton puertoBelgrano = new JRadioButton("puerto Belgrano");
		puertoBelgrano.setOpaque(false);
		puertoBelgrano.setForeground(new Color(128, 255, 255));
		puertoBelgrano.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		puertoBelgrano.setBounds(324, 242, 131, 23);
		contentPane.add(puertoBelgrano);
		
		JRadioButton puertoBsAs = new JRadioButton("puerto BsAs");
		puertoBsAs.setOpaque(false);
		puertoBsAs.setForeground(new Color(128, 255, 255));
		puertoBsAs.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		puertoBsAs.setBounds(370, 189, 123, 23);
		contentPane.add(puertoBsAs);
		
		JRadioButton puertoParana = new JRadioButton("puerto Parana");
		puertoParana.setOpaque(false);
		puertoParana.setForeground(new Color(128, 255, 255));
		puertoParana.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		puertoParana.setBounds(359, 153, 123, 23);
		contentPane.add(puertoParana);
		
		buttonGroup = new ButtonGroup();
		
		JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica después de hacer clic en Aceptar
                int origen, destino;
                
                Puerto puerto = new Puerto();

                // Verifica si se seleccionaron dos puertos
                if (buttonGroup.getSelection() != null && buttonGroup.getSelection().getActionCommand() != null) {
                    String[] seleccionPuertos = buttonGroup.getSelection().getActionCommand().split(",");
                    String seleccion1 = seleccionPuertos[0];
                    String seleccion2 = seleccionPuertos[1];

                    origen = puerto.seleccionPuerto(seleccion1);
                    destino = puerto.seleccionPuerto(seleccion2);

                    double distancia = 0;

                    String tiempoViaje = JOptionPane.showInputDialog("INGRESE CANTIDAD DIAS DE VIAJE");

                    RutaMaritima rutaNueva = new RutaMaritima(origen, destino, distancia, tiempoViaje);

                    // Resto de tu lógica aquí...
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Debe seleccionar dos puertos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnAceptar.setBounds(53, 371, 100, 30);
        contentPane.add(btnAceptar);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Puertos.class.getResource("/resources/selectorPuertos.png")));
        lblNewLabel.setBounds(0, 0, 639, 461);
        contentPane.add(lblNewLabel);
		
     

	}
	
	

}
