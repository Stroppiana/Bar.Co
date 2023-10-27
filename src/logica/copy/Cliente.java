package logica.copy;

import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import interfaz.PantallaCliente;

public class Cliente extends Persona {
	
	private int idCliente;
	private LinkedList <Cliente> clientes = new LinkedList <>();
	

	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public LinkedList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(LinkedList<Cliente> clientes) {
		this.clientes = clientes;
	}



	public Cliente(String nombre, String apellido, String mail, String clave, String rol, int idCliente) {
		super(nombre, apellido, mail, clave, rol);
		this.idCliente = idCliente;
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", clientes=" + clientes + "]";
	} 

	
	
	public boolean solicitarEnvio(LinkedList <Envio> envios ) {
	    boolean ver = false;
	    boolean fragil;
	    String nombre="";
	    double peso=0;
	    String tamaño;

	    do {
	        try {
	            nombre = JOptionPane.showInputDialog("Ingresar nombre del producto");
	            if (nombre.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "Nombre no ingresado correctamente");
	            } else {
	                JOptionPane.showMessageDialog(null, "Nombre ingresado correctamente");
	                ver = true;
	            }
	        } catch (NullPointerException e) {
	            JOptionPane.showMessageDialog(null, "Error: No se proporcionó un nombre.");
	        }
	    } while (!ver);

	    ver = false;
	
	    do {
	        try {
	            peso = Double.parseDouble(JOptionPane.showInputDialog("Ingresar peso del producto"));
	            if (peso < 1) {
	                JOptionPane.showMessageDialog(null, "Peso no ingresado correctamente");
	            } else {
	                JOptionPane.showMessageDialog(null, "Peso ingresado correctamente");
	                ver = true; 
	            }
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido para el peso.");
	        }
	    } while (!ver);

	    do {
	       tamaño=JOptionPane.showInputDialog("ingresar tamaño del producto");
	        if (tamaño.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Tamaño no ingresada correctamente");
	        } else {
	            JOptionPane.showMessageDialog(null, "Tamaño ingresada correctamente");
	            ver = true; 
	        }
	    } while (!ver); 

	    String[] opciones = {"Sí", "No"};

	    int seleccion = JOptionPane.showOptionDialog(null, "¿Es este producto frágil?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
	            null, opciones, opciones[0]);

	    fragil = (seleccion == JOptionPane.YES_OPTION);

	   
	    
	    
	    Producto producto=new Producto(1, nombre, peso, tamaño, fragil);
	    LocalDate fechaActual = LocalDate.now();
	    Envio envioos= new Envio(1, fechaActual, producto);
	    
	    envios.add(envioos);
	
	    
	    
	    
	    return true;
	}

	
	public void infoEnvio(LinkedList<Envio> envios) {
		if (envios.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay envios para mostrar");
		}
		for (Envio envio : envios) {
			JOptionPane.showMessageDialog(null, envios +"\n");
		}
		
	}

	
	
}
