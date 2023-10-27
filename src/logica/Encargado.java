package logica;
import javax.swing.JOptionPane;

import datos.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;


public class Encargado extends Persona{
	private int idEncargado;
	private static final AtomicInteger indice = new AtomicInteger(0);

	private LinkedList <Encargado> encargados = new LinkedList <>();

	
	
		
	public Encargado(String nombre, String apellido, String mail, String clave, String rol, int idEncargado) {
		super(nombre, apellido, mail, clave);
		this.idEncargado = idEncargado;
		this.encargados = encargados;
	}



	public int getIdEncargado() {
		return idEncargado;
	}




	public void setIdEncargado(int idEncargado) {
		this.idEncargado = idEncargado;
	}


	public LinkedList<Encargado> getEncargados() {
		return encargados;
	}



	public void setEncargados(LinkedList<Encargado> encargados) {
		this.encargados = encargados;
	}




	public static AtomicInteger getIndice() {
		return indice;
	}


	@Override
	public String toString() {
		return "Encargado [idEncargado=" + idEncargado + ", encargados=" + encargados + "]";
	}


	Conexion conexion = new Conexion ();
	Connection con = conexion.conectar(); 
	PreparedStatement stmt;
	
	
	/*
	public void agregar () {
		Encargado encargado3 = new Encargado("juan", "Perez", "ivanbilkis", "123456789", "Encargado", 1);
		Encargado encargado2 = new Encargado("pedro", "Perez", "pedroperez", "123456789", "Encargado", 1);
		Encargado encargado1 = new Encargado("Horacio", "Perez", "juanperez", "123456789", "Encargado", 1);
		encargados.add(encargado1);
		encargados.add(encargado2);
		encargados.add(encargado3);

		
	}
	*/
	public boolean eliminarCliente (Cliente cliente) {
		String sql = "DELETE FROM `cliente` WHERE id_cliente=?";
		int cli;
		try {
			
			JOptionPane.showMessageDialog(null, "Va a eliminar un cliente a continuacion se le mostrara los clientes:\n"+this.MostrarClientes());
			cli= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID para eliminarlo"));
			cliente.setIdCliente(cli);

			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, cliente.getIdCliente());
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Cliente exitosamente eliminado");
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al guardar");
			return false;
		}

	
	}
	public boolean sesionExistente(Cliente cliente) {
		String sql = "SELECT * FROM `cliente` WHERE usuario=?";

		try {
			 stmt = con.prepareStatement(sql);
			 stmt.setString(1, cliente.getMail());
			
			  ResultSet resultados = stmt.executeQuery();

			 
			  if (resultados.next()) {
				  JOptionPane.showMessageDialog(null, "Nombre de usuario ya existente");
				return true;
				
			}else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
		
		}
	
	public Cliente crearCliente (String nombre, String apellido, String mail, String clave) {
		
		
		Cliente cliente = new Cliente (nombre, apellido, mail, clave);
		
		return cliente;
	}
	
	public double calcularRutaMaritima(Barco barco) {
		return 0;
	}
	
	
	Cliente cl = new Cliente ("", "", "", "");
	
	
	public LinkedList <Cliente> MostrarClientes (){
		
		String sql="SELECT * from `cliente` WHERE 1";
		String datos [] = new String [4];
		
		try {
			
			stmt = con.prepareStatement(sql);
			ResultSet resultados =	stmt.executeQuery();

			while (resultados.next()) {
				
				
				datos[0] = resultados.getString(1);
				datos[1] =  resultados.getString(2);
				datos [2] =   resultados.getString(3);
				datos[3] = resultados.getString(4); 
				

				cl.getClientes().add(new Cliente (datos[0], datos[1], datos[2], datos[3]));
			}
			
			if (cl.getClientes().isEmpty()) {
				
				
				String mensaje = "No hay clientes";
				System.out.println(mensaje);
				return null;
				
			}else {
				
				return cl.getClientes();
			}
		} catch (Exception e) {
			
			System.out.println("Error");
			return null;
}
		
		
	}
}
