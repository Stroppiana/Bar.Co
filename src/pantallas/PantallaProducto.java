package pantallas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logica.Cliente;
import logica.DatosProducto;
import logica.Divisa;
import logica.Producto;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;


public class PantallaProducto extends JFrame implements DatosProducto{

	private JPanel contentPane;
    private Divisa divisaSeleccionada;
    private String opcionSeleccionada;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PantallaProducto frame = new PantallaProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	/**
	 * Create the frame.
	 */
	
	public PantallaProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton elegirDivisa = new JButton("ELEGIR DIVISA");
		elegirDivisa.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		elegirDivisa.setBackground(new Color(0, 179, 179));
		elegirDivisa.setBounds(211, 315, 188, 31);
		contentPane.add(elegirDivisa);
		

		elegirDivisa.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Divisa divisa = new Divisa();
		        LinkedList<Divisa> divisas = divisa.mostrarDivisas();

		        if (!divisas.isEmpty()) {
		            String[] opcionesDivisa = new String[divisas.size()];

		            for (int i = 0; i < divisas.size(); i++) {
		                opcionesDivisa[i] = divisas.get(i).getTipo();
		            }

		            int seleccionada = JOptionPane.showOptionDialog(null,
		                    "Selecciona una divisa:",
		                    "Selección de Divisa",
		                    JOptionPane.DEFAULT_OPTION,
		                    JOptionPane.QUESTION_MESSAGE,
		                    null,
		                    opcionesDivisa,
		                    opcionesDivisa[0]);

		            if (seleccionada >= 0) {
		                divisaSeleccionada = divisas.get(seleccionada);
		                JOptionPane.showMessageDialog(null,
		                        "Has seleccionado la divisa: " + opcionesDivisa[seleccionada],
		                        "Divisa Seleccionada",
		                        JOptionPane.INFORMATION_MESSAGE);
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "No hay divisas disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
		
		JTextField nombreProducto = new JTextField();
		nombreProducto.setBackground(new Color(124, 155, 173));
		nombreProducto.setBounds(211, 108, 188, 31);
		contentPane.add(nombreProducto);
		nombreProducto.setColumns(10);
		
		JTextField peso = new JTextField();
		peso.setBackground(new Color(124, 155, 173));
		peso.setColumns(10);
		peso.setBounds(211, 262, 188, 31);
		contentPane.add(peso);
		
		JLabel lblNewLabel = new JLabel("Nombre producto");
		lblNewLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(0, 185, 185));
		lblNewLabel.setBounds(211, 80, 208, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fragilidad");
		lblNewLabel_1.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(0, 185, 185));
		lblNewLabel_1.setBounds(211, 150, 124, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Peso producto");
		lblNewLabel_2.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(new Color(0, 185, 185));
		lblNewLabel_2.setBounds(211, 237, 166, 14);
		contentPane.add(lblNewLabel_2);
		
		
		
		JButton menu = new JButton("<- Menu");
		menu.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		menu.setBackground(new Color(0, 179, 179));
		menu.setBounds(515, 384, 89, 23);
		contentPane.add(menu);
		
		 menu.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            		PantallaUsuario usuario = new PantallaUsuario();
	            		usuario.run();
	                dispose();
	            }
	        });
		
		JRadioButton fragil = new JRadioButton("FRAGIL");
		fragil.setForeground(new Color(128, 255, 0));
		fragil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fragil.setOpaque(false);
		fragil.setBounds(211, 172, 140, 23);
		contentPane.add(fragil);
		
		JRadioButton noFragil = new JRadioButton("NO FRAGIL");
		noFragil.setForeground(new Color(128, 255, 0));
		noFragil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		noFragil.setOpaque(false);
		noFragil.setBounds(211, 208, 140, 23);
		contentPane.add(noFragil);
		
		 ButtonGroup buttonGroup = new ButtonGroup();
	        buttonGroup.add(fragil);
	        buttonGroup.add(noFragil);
	        


	        ActionListener actionListener = new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if (fragil.isSelected()) {
	                    opcionSeleccionada = "FRAGIL";
	                } else if (noFragil.isSelected()) {
	                    opcionSeleccionada = "NO FRAGIL";
	                }

	                System.out.println("Opción seleccionada: " + opcionSeleccionada);
	            }
	        };

	        // Agregar el ActionListener a ambos JRadioButton
	        fragil.addActionListener(actionListener);
	        noFragil.addActionListener(actionListener);

	        JButton agregarProducto = new JButton("Agregar");
	        agregarProducto.setBackground(new Color(0, 179, 179));
	        agregarProducto.setFont(new Font("OCR A Extended", Font.PLAIN, 14));

	        agregarProducto.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               // boolean agregado = false;

	                String producto = nombreProducto.getText();
	                int pesoProducto = Integer.parseInt(peso.getText());
	                
	                String fragilidad = opcionSeleccionada;


	                if ((nombrePorducto(producto) && pesoProducto(pesoProducto)) == true) {
	                    Producto productoNuevo = new Producto(producto, fragilidad, pesoProducto);
	                    Cliente cliente = new Cliente();
	          
	                
	                    cliente.solicitarEnvio(productoNuevo, divisaSeleccionada);
	                    
	                 
	                }
	                
		            JOptionPane.showMessageDialog(contentPane, "PRODUCTO INGRESADO", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	                
	                nombreProducto.setText("");
		            peso.setText("");
		            buttonGroup.clearSelection();

		          

	            }
	        });
			
			
			
			
			agregarProducto.setBounds(211, 379, 124, 31);
			contentPane.add(agregarProducto);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(PantallaProducto.class.getResource("/resources/fondo2.png")));
		lblNewLabel_3.setBounds(0, 0, 639, 463);
		contentPane.add(lblNewLabel_3);
		
	
	}

}




/*
JButton btnMostrar = new JButton("Mostrar");
btnMostrar.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		PantallaMostrarProductos pantalla = new   PantallaMostrarProductos();
		pantalla.run();
		dispose();
	}
});
btnMostrar.setBounds(129, 200, 89, 23);
contentPane.add(btnMostrar);

JButton foto = new JButton("Agregar foto");
foto.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		File imagen = mostrarSelectorDeArchivo();
		
		if(imagen!=null) {
			agregar=true;
			fotoselect = imagen;
			JOptionPane.showMessageDialog(null, "guardado correctamente");
		}else {
			JOptionPane.showMessageDialog(null, "Error");
		}
		
	}
});
foto.setBounds(264, 200, 136, 23);
contentPane.add(foto);*/
