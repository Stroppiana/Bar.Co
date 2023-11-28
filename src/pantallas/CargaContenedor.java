package pantallas;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Contenedor;
import logica.Divisa;
import logica.Producto;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CargaContenedor extends JFrame {

	private JPanel contentPane;
	private int idProducto;
	private int idContenedor;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					CargaContenedor frame = new CargaContenedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	/**
	 * Create the frame.
	 */
	public CargaContenedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton producto = new JButton("SELECCIONAR PRODUCTO");
		producto.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		producto.setBackground(new Color(0, 185, 185));
		producto.setBounds(22, 90, 266, 43);
		contentPane.add(producto);
		
		producto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			   
				Producto producto = new Producto();
				
				LinkedList<Producto> productos = producto.mostrarProductos();
				
				if (!productos.isEmpty()) {

					String[] opcionesProductos = new String[productos.size()];

					for (int i = 0; i < productos.size(); i++) {
						opcionesProductos[i] = productos.get(i).getNombre();
					}
					
					String productoNombre = (String) JOptionPane.showInputDialog(contentPane, "Elija el PRODUCTO", "Ventana",
							JOptionPane.DEFAULT_OPTION, null, opcionesProductos, opcionesProductos[0]);
		
					System.out.println(productoNombre);
					
					idProducto = producto.seleccionProducto(productoNombre);
				}
				
			}
			
			
			

		});
		
		
		
		
		
		JButton contenedor = new JButton("SELECCIONAR CONTENEDOR");
		contenedor.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		contenedor.setBackground(new Color(0, 185, 185));
		contenedor.setBounds(22, 168, 266, 43);
		contentPane.add(contenedor);
		
		
		contenedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Contenedor contenedor = new Contenedor();

				LinkedList<Contenedor> contenedores = contenedor.mostrarContenedores();
				String[] opcionesContenedor = new String[contenedores.size()];

				for (int i = 0; i < contenedores.size(); i++) {
					opcionesContenedor[i] = String.valueOf(contenedores.get(i).getIdContenedor());
				}

				String contenedorID = (String) JOptionPane.showInputDialog(contentPane, "Elija el ID del CONTENEDOR", "Ventana",
				        JOptionPane.DEFAULT_OPTION, null, opcionesContenedor, opcionesContenedor[0]);

				 idContenedor = Integer.parseInt(contenedorID); 

				
			}
		
		});

		
		
		JButton aceptar = new JButton("ACEPTAR");
		aceptar.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		aceptar.setBackground(new Color(0, 185, 185));
		aceptar.setBounds(22, 245, 143, 34);
		contentPane.add(aceptar);
		
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Contenedor contenedor = new Contenedor();
				
				if (contenedor.asignarProducto(idContenedor, idProducto) == true) {
					JOptionPane.showMessageDialog(contentPane, "CONTENEDOR Y PRODUCTO ALMACENADO");
				}
			   
			}
		});
		
		
		JButton menu = new JButton("<- Menu");
		menu.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		menu.setBackground(new Color(0, 185, 185));
		menu.setBounds(518, 82, 89, 23);
		contentPane.add(menu);
		
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    PantallaEncargado menu = new PantallaEncargado();

				menu.run();
				dispose();
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CargaContenedor.class.getResource("/resources/CargaContenedor.png")));
		lblNewLabel.setBounds(0, 0, 639, 461);
		contentPane.add(lblNewLabel);
	}

}
