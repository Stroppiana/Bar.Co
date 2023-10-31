package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import datos.Conexion;

public class Puerto {
	
	private int idPuerto;
	private String nombrePuerto;
	private double latitud;
	private double longitud;

	
	public Puerto(int idPuerto, String nombrePuerto, double latitud, double longitud) {
		super();
		this.idPuerto = idPuerto;
		this.nombrePuerto = nombrePuerto;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public Puerto() {
		super();
	}

	public String getNombrePuerto() {
		return nombrePuerto;
	}

	public void setNombrePuerto(String nombrePuerto) {
		this.nombrePuerto = nombrePuerto;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	
	public int getIdPuerto() {
		return idPuerto;
	}

	public void setIdPuerto(int idPuerto) {
		this.idPuerto = idPuerto;
	}


	Conexion conexion = new Conexion ();
	Connection con = conexion.conectar(); 
	PreparedStatement stmt;
	

	public LinkedList<Puerto> mostrarPuertos() {
		String sql = "SELECT * FROM puerto";
		
		LinkedList<Puerto> puertos = new LinkedList<>();
	    
	    try {
	        PreparedStatement stmt = con.prepareStatement(sql);

	        ResultSet resultados = stmt.executeQuery();
	        
	        while (resultados.next()) {
	            int id_puerto = resultados.getInt("id_puerto");
	            String	nombre_puerto = resultados.getString("nombre_puerto");
	            double ubicacion_latitud = resultados.getDouble("ubicacion_latitud");
	           	double ubicacion_longitud = resultados.getDouble("ubicacion_longitud");

	            Puerto puerto = new Puerto(id_puerto, nombre_puerto, ubicacion_latitud, ubicacion_longitud);
	            
	            puertos.add(puerto);

	            System.out.println("ID: " + id_puerto + ", PUERTO: " + nombre_puerto + ", UBICACION: " + ubicacion_latitud + " " + ubicacion_longitud);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error");
	    }
	    
	    return puertos;
	
	} 
	
	
	public int seleccionPuerto(String nombrePuerto) {
		
		int idPuerto = -1;

		String sql = "SELECT `id_puerto` FROM `puerto` WHERE  `nombre_puerto` = ?";
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, nombrePuerto);
			
			ResultSet resultado = stmt.executeQuery();
			
			if (resultado.next()) {
				
				idPuerto = resultado.getInt("id_puerto");
			}
			
		}catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error");
		}
		
		
		return idPuerto;
	}
	
	
	
}
