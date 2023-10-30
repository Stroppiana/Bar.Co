package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import datos.Conexion;

public class Divisa {
	
	private int id_divisa;
	private String tipo;
	private double cotizacion;
	
	public Divisa(int id_divisa, String tipo, double cotizacion) {
		super();
		this.id_divisa = id_divisa;
		this.tipo = tipo;
		this.cotizacion = cotizacion;
	}
	
	public Divisa() {

	}
	
	public Divisa(String tipo, double cotizacion) {
		super();
		this.tipo = tipo;
		this.cotizacion = cotizacion;
	}
	
	@Override
	public String toString() {
		return "Divisa [tipo=" + tipo + ", idDivisa=" + id_divisa + "]";
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getId_divisa() {
		return id_divisa;
	}

	public void setId_divisa(int id_divisa) {
		this.id_divisa = id_divisa;
	}

	public double getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(double cotizacion) {
		this.cotizacion = cotizacion;
	}


	Conexion conexion = new Conexion ();
	Connection con = conexion.conectar(); 
	PreparedStatement stmt;
	
	
	
	public boolean ingresarDivisa(Divisa divisa) {
		    String sql = "INSERT INTO `divisa` (`tipo_divisa`, `cotizacion`) VALUES (?,?)";

		    try {
		        stmt = con.prepareStatement(sql);
		        stmt.setString(1, divisa.getTipo());
		        stmt.setDouble(2, divisa.getCotizacion());
		        System.out.println(sql);
		        System.out.println(stmt);
		        stmt.execute();
		        return true;
		    } catch (Exception e) {
		        return false;
		    }

	}
	
/*	public void divisa(String tipo_divisa) {
		
		String sql = "SELECT * FROM `divisa` WHERE usuario=? AND clave=?";


	    stmt = con.prepareStatement(sql);
	    stmt.setString(1, this.getTipo());
	    stmt.setString(2, this.getClave());
	    
	    
	    ResultSet resultados = stmt.executeQuery();
		
	}
	
*/	
	public LinkedList<Divisa> mostrarDivisas() {
		String sql = "SELECT * FROM divisa";
		
		LinkedList<Divisa> divisas = new LinkedList<>();
	    
	    try {
	        PreparedStatement stmt = con.prepareStatement(sql);

	        ResultSet resultados = stmt.executeQuery();
	        
	        while (resultados.next()) {
	            int id_divisa = resultados.getInt("id_divisa");
	            String tipo_divisa = resultados.getString("tipo_divisa");
	            double cotizacion = resultados.getDouble("cotizacion");
	            
	            Divisa divisa = new Divisa(id_divisa, tipo_divisa, cotizacion);
	            
	            divisas.add(divisa);

	            System.out.println("ID: " + id_divisa + ", Divisa: " + tipo_divisa + ", Cotización: " + cotizacion);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error");
	    }
	    
	    return divisas;
	
	}
	


	
}
