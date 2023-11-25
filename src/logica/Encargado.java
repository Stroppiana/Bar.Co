package logica;

import javax.swing.JOptionPane;

import datos.Conexion;
import interfaz.PantallaEncargado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class Encargado extends Persona {
	private int idEncargado;
	private static final AtomicInteger indice = new AtomicInteger(0);

	private LinkedList<Encargado> encargados = new LinkedList<>();

	public Encargado(String nombre, String apellido, String mail, String clave, String rol, int idEncargado) {
		super(nombre, apellido, mail, clave);
		this.idEncargado = idEncargado;
	}
	
	public Encargado() {
		
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

	Conexion conexion = new Conexion();
	Connection con = conexion.conectar();
	PreparedStatement stmt;

	public boolean inicioSesionEncargado() {
		PantallaEncargado pe = new PantallaEncargado();

		String sql = "SELECT * FROM `encargado` WHERE usuario=? AND clave=?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, this.getMail());
			stmt.setString(2, this.getClave());

			ResultSet resultados = stmt.executeQuery();

			if (resultados.next() == true) {
				pe.MenuEncargado(this);

				return true;

			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error en el inicio de sesión");
			return false;
		}

	}

	public boolean eliminarCliente(Cliente cliente) {
		String sql = "DELETE FROM `cliente` WHERE id_cliente=?";
		int cli;
		try {

			JOptionPane.showMessageDialog(null,
					"Va a eliminar un cliente a continuacion se le mostrara los clientes:\n" + this.MostrarClientes());
			cli = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID para eliminarlo"));
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

			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

	public Cliente crearCliente(String nombre, String apellido, String mail, String clave) {

		Cliente cliente = new Cliente(nombre, apellido, mail, clave);

		return cliente;
	}

	public double calcularRutaMaritima(Barco barco) {
		return 0;
	}

	Cliente cl = new Cliente();

	public LinkedList<Cliente> MostrarClientes() {
		
		LinkedList<Cliente> clientes = new LinkedList<>();

		String sql = "SELECT * from `cliente` WHERE 1";
		//String datos[] = new String[4];

		try {

			stmt = con.prepareStatement(sql);
			ResultSet resultados = stmt.executeQuery();

			while (resultados.next()) {

				/*datos[0] = resultados.getString(1);
				datos[1] = resultados.getString(2);
				datos[2] = resultados.getString(3);
				datos[3] = resultados.getString(4);
				*/
				
				int id = resultados.getInt(1);
				String nombre = resultados.getString(2);
				String apellido = resultados.getString(3);
				String usuario = resultados.getString(4);
				String clave = resultados.getString(5);

				clientes.add(new Cliente(id, nombre, apellido, usuario, clave));
				
			}

			if (clientes.isEmpty()) {

				String mensaje = "No hay clientes";
				System.out.println(mensaje);
				return null;

			} else {

				return clientes;
			}
		} catch (Exception e) {

			System.out.println("Error");
			return null;
		}

	}

	public void asignarContenedor(Producto producto, Contenedor contenedor) {
		
		

	}
	
	
}
