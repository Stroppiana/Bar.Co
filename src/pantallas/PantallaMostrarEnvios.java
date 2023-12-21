package pantallas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import logica.Barco;
import logica.Cliente;
import logica.Envio;
import logica.Producto;

import java.awt.Color;
import java.awt.Font;

public class PantallaMostrarEnvios extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JLabel seleccionado;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PantallaMostrarEnvios frame = new PantallaMostrarEnvios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	/**
	 * Create the frame.
	 */
	public PantallaMostrarEnvios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBackground(new Color(0, 0, 0));
		table.setForeground(new Color(0, 255, 255));
		table.setBounds(20, 108, 579, 94);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("ENVIOS");
		lblNewLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setBounds(20, 83, 244, 14);
		contentPane.add(lblNewLabel);
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("ID ENVIO");
		modelo.addColumn("FECHA ENVIO");
		modelo.addColumn("FECHA ENTREGA");
		modelo.addColumn("BARCO");
		modelo.addColumn("CLIENTE");
		table.setModel(modelo);
		
		btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaUsuario pantalla=  new PantallaUsuario();
				pantalla.run();
				dispose();
			}
		});
		btnNewButton.setBounds(510, 414, 89, 23);
		contentPane.add(btnNewButton);
		
		seleccionado = new JLabel("SELECCIONADO ENVIO");
		seleccionado.setForeground(new Color(0, 255, 255));
		seleccionado.setBounds(30, 311, 556, 73);
		contentPane.add(seleccionado);
		
		
		//Cliente cliente = new Cliente();
			
		
		
		Envio info = new Envio();
        for (Envio envio: info.todosLosEnvios()) {
        	modelo.addRow(new Object[]{envio.getIdEnvio(),envio.getFechaEnvio(),envio.getFechaEntrega(),envio.getIdBarco(),envio.getIdCliente()});
        }
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				
				int filaseleccionada = table.getSelectedRow();
				if(filaseleccionada>=0) {
					int idEnvio = (int)modelo.getValueAt(filaseleccionada, 0);
					LocalDate fechaEnvio = (LocalDate)modelo.getValueAt(filaseleccionada, 1);
					LocalDate fechaEntrega = (LocalDate)modelo.getValueAt(filaseleccionada, 2);
					int idBarco = (int)modelo.getValueAt(filaseleccionada, 3);
					int idCliente = (int)modelo.getValueAt(filaseleccionada, 4);

					
					Cliente cliente = new Cliente();
					Cliente buscado = cliente.obtenerCliente(idCliente);
		
				//	Producto prod = new Producto();
				//	Producto producto = prod.obtenerProducto(idProducto);
					
		            String mensaje = "<html><b>ENVIO :</b> " + idEnvio + "<br/>" +
                            "<b>Fecha Envío:</b> " + fechaEnvio + "<br/>" +
                            "<b>Fecha Entrega:</b> " + fechaEntrega + "<br/>" +
                            "<b>Barco:</b> " + idBarco + "<br/>" +
                            "<b>Cliente:</b> " + buscado.getNombre()
                            
                            
                            + "</html>";
		            
		            seleccionado.setText(mensaje);

					//seleccionado.setText("ENVIO :" + idEnvio + "\n Fecha Envio: " +fechaEnvio+"\n Fecha Entrega: " + fechaEntrega + " \nBarco: "+idBarco + " \nCliente: "+idCliente);

				}
			}
        	
        });
        
    	

		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(PantallaMostrarEnvios.class.getResource("/resources/fondo2.png")));
		lblNewLabel_2.setBounds(0, 0, 632, 465);
		contentPane.add(lblNewLabel_2);
        
        
		
	}
}
