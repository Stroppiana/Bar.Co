package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import datos.Conexion;

public class Envio {
	
	private int idEnvio;
	private LocalDate fechaEnvio;
	private LocalDate fechaEntrega;
	private int idBarco;
	private int idCliente;
	private int idEncargado;
	private Barco barco;
	private Cliente cliente;
	
	public Envio(int idEnvio, LocalDate fechaEnvio, LocalDate fechaEntrega) {
		super();
		this.idEnvio = idEnvio;
		this.fechaEnvio = fechaEnvio;
		this.fechaEntrega = fechaEntrega;
	}
	
	public Envio(int idEnvio, LocalDate fechaEnvio, LocalDate fechaEntrega, int idBarco, int idCliente, int idEncargado) {
		super();
		this.idEnvio = idEnvio;
		this.fechaEnvio = fechaEnvio;
		this.fechaEntrega = fechaEntrega;
		this.idBarco = idBarco;
		this.idCliente = idCliente;
		this.idEncargado = idEncargado;
	}
	
	public Envio(int idEnvio, LocalDate fechaEnvio, LocalDate fechaEntrega, int idBarco, Cliente cliente, int idEncargado) {
		super();
		this.idEnvio = idEnvio;
		this.fechaEnvio = fechaEnvio;
		this.fechaEntrega = fechaEntrega;
		this.idBarco = idBarco;
		this.cliente = cliente;
		this.idEncargado = idEncargado;
	}
	
	public Envio() {
		
	}
	
	
	public int getIdEnvio() {
		return idEnvio;
	}
	public void setIdEnvio(int idEnvio) {
		this.idEnvio = idEnvio;
	}

	public LocalDate getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(LocalDate fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public int getIdBarco() {
		return idBarco;
	}

	public void setIdBarco(int idBarco) {
		this.idBarco = idBarco;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdEncargado() {
		return idEncargado;
	}

	public void setIdEncargado(int idEncargado) {
		this.idEncargado = idEncargado;
	}
	
	
	
	
	public Barco getBarco() {
		return barco;
	}

	public void setBarco(Barco barco) {
		this.barco = barco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}




	Conexion conexion = new Conexion ();
	Connection con = conexion.conectar(); 
	PreparedStatement stmt;
	
	public boolean generarEnvio(LocalDate fechaEnvio, LocalDate fechaEntrega, int idBarco, int idCliente, int idEncargado){
		
		String sql = "INSERT INTO `envio`(`fecha_envio`, `fecha_entrega`, `id_barco`, `id_cliente`, `id_encargado`)  VALUES (?,?,?,?,?)";
		
		System.out.println(sql);
		System.out.println(stmt);
		
		try {
			
			String envio = fechaEnvio.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			String entrega = fechaEntrega.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Establece el valor del parámetro en la consulta
			
			stmt = con.prepareStatement(sql);
            stmt.setString(1, envio);
			stmt.setString(2, entrega);
			stmt.setInt(3, idBarco);
			stmt.setInt(4, idCliente);
			stmt.setInt(5, idEncargado);
			stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
		
		
	}
	
	
public boolean generarEnvio(LocalDate fechaEnvio, LocalDate fechaEntrega, int idBarco, Cliente cliente, int idEncargado){
		
		String sql = "INSERT INTO `envio`(`fecha_envio`, `fecha_entrega`, `id_barco`, `id_cliente`, `id_encargado`)  VALUES (?,?,?,?,?)";
		
		System.out.println(sql);
		System.out.println(stmt);
		
		try {
			
			String envio = fechaEnvio.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			String entrega = fechaEntrega.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Establece el valor del parámetro en la consulta
			
			stmt = con.prepareStatement(sql);
            stmt.setString(1, envio);
			stmt.setString(2, entrega);
			stmt.setInt(3, idBarco);
			stmt.setInt(4, cliente.getIdCliente());
			stmt.setInt(5, idEncargado);
			stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
		
		
	}
	
	
	public LinkedList<Envio> todosLosEnvios() {
		String sql = "SELECT * FROM envio";
		
		LinkedList<Envio> envios = new LinkedList<>();
	    
	    try {
	        PreparedStatement stmt = con.prepareStatement(sql);

	        ResultSet resultados = stmt.executeQuery();
	        
	        while (resultados.next()) {
	        	int id_envio = resultados.getInt("id_envio");
                LocalDate fechaEnvio = resultados.getDate("fecha_envio").toLocalDate();
                LocalDate fechaEntrega = resultados.getDate("fecha_entrega").toLocalDate();
                int id_barco = resultados.getInt("id_barco");
                int id_cliente = resultados.getInt("id_cliente");
                int id_encargado = resultados.getInt("id_encargado");

	            Envio envio = new Envio(id_envio, fechaEnvio, fechaEntrega, id_barco, id_cliente, id_encargado);
	            
	            envios.add(envio);

	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error");
	    }
	    
	    return envios;
	
	}
	
	public LinkedList<Envio> mostrarEnvioCliente() {
		String sql = "SELECT * FROM envio WHERE `id_cliente` = ?";
		
		LinkedList<Envio> envios = new LinkedList<>();
	    
	    try {
	        PreparedStatement stmt = con.prepareStatement(sql);

	        ResultSet resultados = stmt.executeQuery();
	        
	        while (resultados.next()) {
	        	int id_envio = resultados.getInt("id_envio");
                LocalDate fechaEnvio = resultados.getDate("fecha_envio").toLocalDate();
                LocalDate fechaEntrega = resultados.getDate("fecha_entrega").toLocalDate();
                int id_barco = resultados.getInt("id_barco");
                int id_cliente = resultados.getInt("id_cliente");
                int id_encargado = resultados.getInt("id_encargado");

	            Envio envio = new Envio(id_envio, fechaEnvio, fechaEntrega, id_barco, id_cliente, id_encargado);
	            
	            envios.add(envio);

	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error");
	    }
	    
	    return envios;
	
	}
	
	
	
	
	
	

	@Override
	public String toString() {
		return "Envio [idEnvio=" + idEnvio + ", fechaEnvio=" + fechaEnvio + ", fechaEntrega=" + fechaEntrega
				+ ", idBarco=" + idBarco + ", idCliente=" + idCliente + ", idEncargado=" + idEncargado + "]";
	} 
	
	
	
	
	
}

	
	
	
	
	

	

