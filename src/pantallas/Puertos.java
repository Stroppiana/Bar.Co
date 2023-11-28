package pantallas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Divisa;
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
import java.util.LinkedList;
import javax.swing.JTextField;


public class Puertos extends JFrame {

	private JPanel contentPane;
    private ButtonGroup buttonGroup;
    private JTextField diasViaje;


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
		
	
		JRadioButton puertoUshuaia = new JRadioButton("Puerto de Ushuaia");
		puertoUshuaia.setForeground(new Color(128, 255, 255));
		puertoUshuaia.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		puertoUshuaia.setOpaque(false);
		puertoUshuaia.setBounds(264, 375, 155, 23);
		puertoUshuaia.setActionCommand("6"); 
		contentPane.add(puertoUshuaia);
		
		JRadioButton puertoMadryn = new JRadioButton("Puerto Madryn");
		puertoMadryn.setOpaque(false);
		puertoMadryn.setForeground(new Color(128, 255, 255));
		puertoMadryn.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		puertoMadryn.setBounds(282, 327, 123, 23);
		puertoMadryn.setActionCommand("5"); 
		contentPane.add(puertoMadryn);
		
		JRadioButton puertoChubut = new JRadioButton("Puerto Chubut");
		puertoChubut.setOpaque(false);
		puertoChubut.setForeground(new Color(128, 255, 255));
		puertoChubut.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		puertoChubut.setBounds(292, 286, 123, 23);
		puertoMadryn.setActionCommand("4"); 
		contentPane.add(puertoChubut);
		
		JRadioButton puertoBelgrano = new JRadioButton("Puerto Belgrano");
		puertoBelgrano.setOpaque(false);
		puertoBelgrano.setForeground(new Color(128, 255, 255));
		puertoBelgrano.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		puertoBelgrano.setBounds(324, 242, 131, 23);
		puertoMadryn.setActionCommand("3"); 
		contentPane.add(puertoBelgrano);
		

		JRadioButton puertoParana = new JRadioButton("Puerto Parana");
		puertoParana.setOpaque(false);
		puertoParana.setForeground(new Color(128, 255, 255));
		puertoParana.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		puertoParana.setBounds(359, 153, 123, 23);
		puertoMadryn.setActionCommand("2"); 
		contentPane.add(puertoParana);
		
		JRadioButton puertoBsAs = new JRadioButton("Puerto BsAs");
		puertoBsAs.setOpaque(false);
		puertoBsAs.setForeground(new Color(128, 255, 255));
		puertoBsAs.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		puertoBsAs.setBounds(370, 189, 123, 23);
		puertoMadryn.setActionCommand("1"); 
		contentPane.add(puertoBsAs);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(puertoUshuaia);
		buttonGroup.add(puertoMadryn);
		buttonGroup.add(puertoChubut);
		buttonGroup.add(puertoBelgrano);
		buttonGroup.add(puertoParana);
		buttonGroup.add(puertoBsAs);

        
        JLabel lblNewLabel_1 = new JLabel("Dias de Viaje");
        lblNewLabel_1.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
        lblNewLabel_1.setForeground(new Color(0, 179, 179));
        lblNewLabel_1.setBounds(25, 78, 111, 23);
        contentPane.add(lblNewLabel_1);
        
        diasViaje = new JTextField();
        diasViaje.setBackground(new Color(124, 155, 173));
        diasViaje.setBounds(25, 105, 155, 23);
        contentPane.add(diasViaje);
        diasViaje.setColumns(10);
        
        JButton aceptar = new JButton("AGREGAR RUTA");
        aceptar.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
        aceptar.setBackground(new Color(0, 179, 179));
        aceptar.setBounds(25, 153, 142, 47);
        contentPane.add(aceptar);
        
        aceptar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		    	Puerto puerto = new Puerto();

				LinkedList<Puerto> puertos = puerto.mostrarPuertos();

				String[] opcionesPuerto = new String[puertos.size()];

				for (int i = 0; i < puertos.size(); i++) {
					opcionesPuerto[i] = puertos.get(i).getNombrePuerto();
				}

				String seleccion1 = (String) JOptionPane.showInputDialog(null, "Elija el PUERTO ORIGEN", "Ventana",
						JOptionPane.DEFAULT_OPTION, null, opcionesPuerto, opcionesPuerto[0]);
				String seleccion2 = (String) JOptionPane.showInputDialog(null, "Elija el PUERTO DESTINO", "Ventana",
						JOptionPane.DEFAULT_OPTION, null, opcionesPuerto, opcionesPuerto[0]);

				System.out.println(seleccion1 + " - " + seleccion2);

				int origen, destino;
				double distancia = 0;

				origen = puerto.seleccionPuerto(seleccion1);
				destino = puerto.seleccionPuerto(seleccion2);

				String tiempoViaje = diasViaje.getText();

                
                RutaMaritima rutaNueva = new RutaMaritima(origen, destino, distancia, tiempoViaje);

                if (rutaNueva.guardarDistanciaRuta(origen, destino)) {
                    distancia = rutaNueva.calcularDistancia(origen, origen, destino, destino);
                }

                System.out.println("RUTA MARITIMA " + rutaNueva.generarRutaMaritima());
                
	            JOptionPane.showMessageDialog(contentPane, "RUTA MARITIMA CREADA CON EXITO", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	            
	            

                diasViaje.setText("");
	            buttonGroup.clearSelection();
		    	
		    }
		});
        
        JButton menu = new JButton("<- Menu");
        menu.setBackground(new Color(0, 185, 185));
        menu.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
        menu.setBounds(47, 411, 111, 23);
        contentPane.add(menu);
        
        menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    PantallaEncargado menu = new PantallaEncargado();

				menu.run();
				dispose();
				
			}
		});
        
        		

        
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Puertos.class.getResource("/resources/selectorPuertos.png")));
        lblNewLabel.setBounds(0, 0, 639, 461);
        contentPane.add(lblNewLabel);
		
     

	}
}
