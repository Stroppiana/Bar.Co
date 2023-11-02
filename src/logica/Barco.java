package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import datos.Conexion;

public class Barco {
	
	private int idBarco;
	private int combustible;
	private int capacidadToneladas;
	
	public Barco(int combustible, int capacidadToneladas) {
		super();
		this.combustible = combustible;
		this.capacidadToneladas = capacidadToneladas;
	}
	
	public Barco() {
		
	}
	

	public int getIdBarco() {
		return idBarco;
	}
	public void setIdBarco(int idBarco) {
		this.idBarco = idBarco;
	}
	
	public int getCapacidadToneladas() {
		return capacidadToneladas;
	}
	public void setCapacidadToneladas(int capacidadToneladas) {
		this.capacidadToneladas = capacidadToneladas;
	}

	public int getCombustible() {
		return combustible;
	}

	public void setCombustible(int combustible) {
		this.combustible = combustible;
	}

	@Override
	public String toString() {
		return "Barco [idBarco=" + idBarco + ", combustible=" + combustible + ", capacidadToneladas="
				+ capacidadToneladas + "]";
	}
	
	
	Conexion conexion = new Conexion ();
	Connection con = conexion.conectar(); 
	PreparedStatement stmt;
	
	public boolean crearBarco (int combustible, int capacidad, int id_ruta, int id_capitan) {
		
		String sql = "INSERT INTO `barco`(`combustible`, `capacidad_toneladas`, `id_ruta_maritima`, `id_capitan`)  VALUES (?,?,?,?)";
		
		System.out.println(sql);
		System.out.println(stmt);
		
		try {
			
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, combustible);
			stmt.setInt(2, capacidad);
			stmt.setInt(3, id_ruta);
			stmt.setInt(4, id_capitan);
			stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
		
	}
	
	public LinkedList<Barco> mostrarBarcos() {
		String sql = "SELECT * FROM barco";
		
		LinkedList<Barco> barcos = new LinkedList<>();
	    
	    try {
	        PreparedStatement stmt = con.prepareStatement(sql);

	        ResultSet resultados = stmt.executeQuery();
	        
	        while (resultados.next()) {
	            int id_barco = resultados.getInt("id_barco");
	            int	combustible = resultados.getInt("combustible");
				int capacidad = resultados.getInt("capacidad_toneladas");
				int id_ruta = resultados.getInt("id_ruta_maritima");
				int id_capitan = resultados.getInt("id_capitan");

	            Barco barco = new Barco(combustible, capacidad);
	            
	            barcos.add(barco);

	            System.out.println("ID: " + id_barco + ", COMBUSTIBLE: " + combustible + " RUTA: " + id_ruta + " capitan: " + id_capitan);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error");
	    }
	    
	    return barcos;
	
	} 
	
	/*
	
	public int seleccionContenedor(int id) {
		
		int idContenedor = -1;

		String sql = "SELECT `id_contenedor` FROM `contenedor` WHERE  `id_contenedor` = ?";
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet resultado = stmt.executeQuery();
			
			if (resultado.next()) {
				
				idContenedor = resultado.getInt("id_contenedor");
			}
			
		}catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error");
		}
		
		
		return idContenedor;
	}
	*/
	
	
	
	
	
}
