package pantallas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaUsuario extends JFrame {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JButton btnSolicitarEnvio;
    private JButton btnVerInformacionEnvios;
    private JButton btnSalir;
    
    

    public void run() {
        try {
            PantallaUsuario frame = new PantallaUsuario();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PantallaUsuario() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 655, 499);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        int idCliente= 0;
        String nombreCliente = "";
        
        lblNewLabel = new JLabel("Bienvenido! " + nombreCliente);
        lblNewLabel.setForeground(new Color(0, 185, 185));
        lblNewLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
        lblNewLabel.setToolTipText("");
        lblNewLabel.setBounds(54, 95, 307, 33);
        contentPane.add(lblNewLabel);

        btnSolicitarEnvio = new JButton("SOLICITAR PRODUCTO");
        btnSolicitarEnvio.setBackground(new Color(0, 179, 179));
        btnSolicitarEnvio.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
        btnSolicitarEnvio.setBounds(54, 156, 201, 36);
        contentPane.add(btnSolicitarEnvio);
        btnSolicitarEnvio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	PantallaProducto producto = new PantallaProducto();
            	producto.run();
            }
        });

        btnVerInformacionEnvios = new JButton("Ver información envíos");
        btnVerInformacionEnvios.setBackground(new Color(0, 179, 179));
        btnVerInformacionEnvios.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
        btnVerInformacionEnvios.setBounds(54, 203, 239, 36);
        contentPane.add(btnVerInformacionEnvios);
        btnVerInformacionEnvios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes manejar la lógica para "Ver información de envíos"
                // Por ejemplo, puedes mostrar u ocultar componentes en la misma ventana
                lblNewLabel.setText("Información de envíos aquí");
            }
        });

        btnSalir = new JButton("Salir");
        btnSalir.setBackground(new Color(0, 179, 179));
        btnSalir.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
        btnSalir.setBounds(54, 250, 133, 33);
        contentPane.add(btnSalir);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(PantallaUsuario.class.getResource("/resources/clientemenu.png")));
        lblNewLabel_1.setBounds(0, 0, 639, 460);
        contentPane.add(lblNewLabel_1);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            		Loginn log = new Loginn();
            		log.run();
                dispose();
            }
        });
    }


        
}
